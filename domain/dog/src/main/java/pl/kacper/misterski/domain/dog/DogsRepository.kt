package pl.kacper.misterski.domain.dog

import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.domain.dog.model.DogsDomainModel

interface DogsRepository {
    suspend fun fetchDogs(): Result<List<DogsDomainModel>>

}