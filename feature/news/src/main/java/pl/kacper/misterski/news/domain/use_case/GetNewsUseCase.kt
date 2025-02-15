package pl.kacper.misterski.news.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.news.data.NewsRepository


class GetNewsUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke() = flow {

        when (val result = newsRepository.fetchNews()) {
            is Result.Failure -> emit(Result.Failure(result.error))
            is Result.Success -> {
                emit(Result.Success(result.data))
            }
        }
    }.flowOn(Dispatchers.IO)
}