package pl.kacper.misterski.dog.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.dog.data.DogsRepository
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.mapper.mapToDogsDomainModels
import pl.kacper.misterski.dog.data.model.DogsDomainModel
import pl.kacper.misterski.dog.data.model.DogsResponseItem

private const val API_KEY = "live_DDLKKfmfq5oVnxUPaBViYBTJ11bU6pcCC8EhFNV1R4uFCTTiMQcsNiSWyrCZA5fQ"

class DogsRepositoryImpl(
    private val httpClient: HttpClient
) : DogsRepository {

    override suspend fun fetchDogs(): Result<List<DogsDomainModel>> = withContext(Dispatchers.IO) {
        val response =
            httpClient.get("https://api.thedogapi.com/v1/images/search?limit=15&api_key=$API_KEY")

        if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body< ArrayList<DogsResponseItem>>().mapToDogsDomainModels())
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}