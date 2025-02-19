package pl.kacper.misterski.news.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.news.NewsRepository
import pl.kacper.misterski.news.mapper.mapToNewsDomainModels


class GetNewsUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke() = flow {

        when (val result = newsRepository.fetchNews()) {
            is Result.Failure -> emit(Result.Failure(result.error))
            is Result.Success -> {
                emit(Result.Success(result.data.mapToNewsDomainModels()))
            }
        }
    }.flowOn(Dispatchers.IO)
}