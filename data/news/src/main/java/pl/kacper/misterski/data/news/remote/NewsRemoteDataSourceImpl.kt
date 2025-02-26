package pl.kacper.misterski.data.news.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.data.news.NewsRemoteDataSource
import javax.inject.Inject


class NewsRemoteDataSourceImpl @Inject constructor(private val httpClient: HttpClient) :
    NewsRemoteDataSource {

    override suspend fun fetchNews() = withContext(Dispatchers.IO) {
        httpClient.get("https://jsonplaceholder.typicode.com/posts")


    }
}