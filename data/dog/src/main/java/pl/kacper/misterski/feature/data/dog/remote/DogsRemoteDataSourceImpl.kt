package pl.kacper.misterski.feature.data.dog.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.core.common.result.Result
import pl.kacper.misterski.feature.data.dog.DogsRemoteDataSource
import pl.kacper.misterski.feature.data.dog.model.DogsResponseItem
import javax.inject.Inject

private const val API_KEY = "live_DDLKKfmfq5oVnxUPaBViYBTJ11bU6pcCC8EhFNV1R4uFCTTiMQcsNiSWyrCZA5fQ"

 internal class DogsRemoteDataSourceImpl @Inject constructor(private val httpClient: HttpClient) : DogsRemoteDataSource {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO) {
        val response =
            httpClient.get("https://api.thedogapi.com/v1/images/search?limit=15&api_key=$API_KEY")

        if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body<ArrayList<DogsResponseItem>>())
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}