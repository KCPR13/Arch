package pl.kacper.misterski.feature.data.dog.data_source.remote

import io.ktor.client.statement.HttpResponse

interface DogsRemoteDataSource {

    suspend fun fetchDogs(): HttpResponse
}