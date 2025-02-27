package pl.kacper.misterski.domain.news.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.common.util.result.getDataOrNull
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.news.NewsRepository
import java.time.OffsetDateTime


class GetNewsUseCase(
    private val newsRepository: NewsRepository,
    private val formatDateUseCase: FormatDateUseCase
) {

    operator fun invoke() = flow {

        when (val result = newsRepository.fetchNews()) {
            is Result.Failure -> emit(Result.Failure(result.error))
            is Result.Success -> {
                val now = OffsetDateTime.now()
                val date = formatDateUseCase(now).firstOrNull()?.getDataOrNull()

                emit(Result.Success(result.data.map {
                    it.copy(title = date?.plus("\n").plus(it.title))
                }))
            }
        }
    }.flowOn(Dispatchers.IO)
}