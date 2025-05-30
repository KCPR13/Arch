package pl.kacper.misterski.data.dog.data_source.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val API_KEY = "live_DDLKKfmfq5oVnxUPaBViYBTJ11bU6pcCC8EhFNV1R4uFCTTiMQcsNiSWyrCZA5fQ"

internal class DogsRemoteDataSourceImpl @Inject constructor(private val httpClient: HttpClient) :
    DogsRemoteDataSource {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO) {
        httpClient.get("https://api.thedogapi.com/v1/images/search?limit=15&api_key=$API_KEY")
    }
}