package pl.kacper.misterski.feature.data.dog

import pl.kacper.misterski.core.common.result.Result
import pl.kacper.misterski.feature.data.dog.model.DogsResponseItem

interface DogsRemoteDataSource {

   suspend fun fetchDogs(): Result<ArrayList<DogsResponseItem>>
}