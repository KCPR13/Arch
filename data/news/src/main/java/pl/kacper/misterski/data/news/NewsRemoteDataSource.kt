package pl.kacper.misterski.data.news

import io.ktor.client.statement.HttpResponse

interface NewsRemoteDataSource {
    suspend fun fetchNews(): HttpResponse

}