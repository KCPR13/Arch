package pl.kacper.misterski.domain.dog.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.common.util.result.getDataOrNull
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.dog.mapper.mapToDogs
import pl.kacper.misterski.domain.dog.repository.DogRepository
import java.time.OffsetDateTime

class GetDogsUseCase(
    private val dogRepository: DogRepository,
    private val formatDateUseCase: FormatDateUseCase
) {

    operator fun invoke() = flow {

        when (val dogsResult = dogRepository.fetchDogs()) {
            is Result.Failure -> emit(Result.Failure(dogsResult.error))
            is Result.Success -> {

                val now = OffsetDateTime.now()
                val date = formatDateUseCase(now).firstOrNull()?.getDataOrNull()
                val mapped = dogsResult.data.mapToDogs(date)

                emit(Result.Success(mapped))
            }
        }
    }.flowOn(Dispatchers.IO)
}