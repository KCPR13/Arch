package pl.kacper.misterski.data.dog.repository

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.data.dog.data_source.local.DogsLocalDataSource
import pl.kacper.misterski.domain.dog.repository.DogRepository
import pl.kacper.misterski.data.dog.data_source.remote.DogsRemoteDataSource
import pl.kacper.misterski.data.dog.mapper.mapEntitiesToDogsDomainModels
import pl.kacper.misterski.data.dog.mapper.mapDomainToEntities
import pl.kacper.misterski.data.dog.mapper.mapResponseItemsToDogsDomainModels
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem
import javax.inject.Inject

internal class DogsRepositoryImpl @Inject constructor(
    private val dogsRemoteDataSource: DogsRemoteDataSource,
    private val dogsLocalDataSource: DogsLocalDataSource
) : DogRepository {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO)
    {
        val response = dogsRemoteDataSource.fetchDogs()

        if (response.status == HttpStatusCode.OK) {

            val responseDomainModels = response.body<ArrayList<DogsResponseItem>>().mapResponseItemsToDogsDomainModels()
            val databaseModels = dogsLocalDataSource.getDogs().mapEntitiesToDogsDomainModels()
            dogsLocalDataSource.saveDogs(responseDomainModels.mapDomainToEntities())

            val result = buildList {
                addAll(responseDomainModels)
                addAll(databaseModels)
            }
            Result.Success(result)
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}