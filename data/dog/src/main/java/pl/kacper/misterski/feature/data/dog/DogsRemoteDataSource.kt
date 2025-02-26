package pl.kacper.misterski.feature.data.dog

import io.ktor.client.statement.HttpResponse

interface DogsRemoteDataSource {

    suspend fun fetchDogs(): HttpResponse
}