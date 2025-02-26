package pl.kacper.misterski.domain.dog.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.common.result.getDataOrNull
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.dog.DogsRepository
import java.time.OffsetDateTime

class GetDogsUseCase(
    private val dogsRepository: DogsRepository,
    private val formatDateUseCase: FormatDateUseCase
) {

    operator fun invoke() = flow {

        when (val dogsResult = dogsRepository.fetchDogs()) {
            is Result.Failure -> emit(Result.Failure(dogsResult.error))
            is Result.Success -> {

                val now = OffsetDateTime.now()
                val date = formatDateUseCase(now).firstOrNull()?.getDataOrNull()
                val mapped = dogsResult.data.mapIndexed { index, item ->
                    item.copy(
                        name = index.plus(1).toString()
                            .plus(". ")
                            .plus(date)
                            .plus(" ${item.name}")
                    )
                }

                emit(Result.Success(mapped))
            }
        }
    }.flowOn(Dispatchers.IO)
}