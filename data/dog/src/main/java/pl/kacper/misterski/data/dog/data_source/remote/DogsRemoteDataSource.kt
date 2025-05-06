package pl.kacper.misterski.data.dog.data_source.remote

import io.ktor.client.statement.HttpResponse

internal interface DogsRemoteDataSource {

    suspend fun fetchDogs(): HttpResponse
}