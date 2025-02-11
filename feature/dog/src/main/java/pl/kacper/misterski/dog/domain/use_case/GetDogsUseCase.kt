package pl.kacper.misterski.dog.domain.use_case

import kotlinx.coroutines.flow.flow
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.DogsRepository


class GetDogsUseCase(private val dogsRepository: DogsRepository) {

    operator fun invoke() = flow{

        val dogsResult = dogsRepository.fetchDogs()

        when(dogsResult){
            is Result.Failure -> emit(Result.Failure(dogsResult.error))
            is Result.Success -> {
                dogsResult.data
            }
        }
    }
}