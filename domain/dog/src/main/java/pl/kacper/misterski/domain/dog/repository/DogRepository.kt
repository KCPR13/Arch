package pl.kacper.misterski.domain.dog.repository

import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.domain.dog.model.DogsDomainModel

interface DogRepository {
    suspend fun fetchDogs(): Result<List<DogsDomainModel>>

}