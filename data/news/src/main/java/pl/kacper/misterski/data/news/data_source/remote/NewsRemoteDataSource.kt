package pl.kacper.misterski.data.news.data_source.remote

import io.ktor.client.statement.HttpResponse

interface NewsRemoteDataSource {
    suspend fun fetchNews(): HttpResponse

}