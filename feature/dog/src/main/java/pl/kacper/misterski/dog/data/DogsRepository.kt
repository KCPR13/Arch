package pl.kacper.misterski.dog.data

import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.model.DogsDomainModel

interface DogsRepository {

    suspend fun fetchDogs() : Result<List<DogsDomainModel>>


}