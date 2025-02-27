package pl.kacper.misterski.feature.data.dog.repository

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.domain.dog.DogsRepository
import pl.kacper.misterski.feature.data.dog.data_source.remote.DogsRemoteDataSource
import pl.kacper.misterski.feature.data.dog.mapper.mapToDogsDomainModels
import pl.kacper.misterski.feature.data.dog.model.remote.DogsResponseItem
import javax.inject.Inject

// TODO K @Inject constructor ok?
class DogsRepositoryImpl @Inject constructor(
    private val dogsRemoteDataSource: DogsRemoteDataSource
) : DogsRepository {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO)
    {
        val response = dogsRemoteDataSource.fetchDogs()

        if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body<ArrayList<DogsResponseItem>>().mapToDogsDomainModels())
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}