package pl.kacper.misterski.feature.data.dog

import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.feature.data.dog.model.remote.DogsResponseItem

interface DogsRemoteDataSource {

   suspend fun fetchDogs(): Result<ArrayList<DogsResponseItem>>
}