package pl.kacper.misterski.dogs.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.dog.DogsRepository
import pl.kacper.misterski.dogs.mapper.mapToDogsDomainModels


class GetDogsUseCase(private val dogsRepository: DogsRepository) {

    operator fun invoke() = flow {

        when (val dogsResult = dogsRepository.fetchDogs()) {
            is Result.Failure -> emit(Result.Failure(dogsResult.error))
            is Result.Success -> {

                val mapped = dogsResult.data.mapToDogsDomainModels().mapIndexed { index, item ->
                    item.copy(name = index.plus(1).toString().plus(". ${item.name}"))
                }

                emit(Result.Success(mapped))
            }
        }
    }.flowOn(Dispatchers.IO)
}