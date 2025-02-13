package pl.kacper.misterski.dog.domain.use_case

import kotlinx.coroutines.flow.flow
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.DogsRepository


class GetDogsUseCase(private val dogsRepository: DogsRepository) {

    operator fun invoke() = flow {

        when (val dogsResult = dogsRepository.fetchDogs()) {
            is Result.Failure -> emit(Result.Failure(dogsResult.error))
            is Result.Success -> {

                val mapped = dogsResult.data.mapIndexed { index, item ->
                    item.copy(name = index.toString().plus(" ${item.name}"))
                }

                emit(Result.Success(mapped))
            }
        }
    }
}