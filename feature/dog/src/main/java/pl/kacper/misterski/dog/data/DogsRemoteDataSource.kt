package pl.kacper.misterski.dog.data

import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.model.DogsResponseItem

interface DogsRemoteDataSource {

   suspend fun fetchDogs():  Result<ArrayList<DogsResponseItem>>
}