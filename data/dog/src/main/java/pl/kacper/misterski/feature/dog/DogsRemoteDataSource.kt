package pl.kacper.misterski.dog

import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.dog.model.DogsResponseItem

interface DogsRemoteDataSource {

   suspend fun fetchDogs(): Result<ArrayList<DogsResponseItem>>
}