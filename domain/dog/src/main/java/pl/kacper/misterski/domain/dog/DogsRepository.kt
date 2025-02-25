package pl.kacper.misterski.domain.dog

import pl.kacper.misterski.common.result.Result

interface DogsRepository {
    //TODO K WHERE MODELS?
    suspend fun fetchDogs(): Result<List<DogsResponseItem>>

}