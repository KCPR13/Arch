package pl.kacper.misterski.data.news.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.core.common.result.Result
import pl.kacper.misterski.data.news.NewsRemoteDataSource
import pl.kacper.misterski.data.news.model.NewsResponseItem
import javax.inject.Inject


internal class NewsRemoteDataSourceImpl @Inject constructor(private val httpClient: HttpClient) :
    NewsRemoteDataSource {

    override suspend fun fetchNews() = withContext(Dispatchers.IO) {
        val response =
            httpClient.get("https://jsonplaceholder.typicode.com/posts")

        if (response.status == HttpStatusCode.OK) {
            Result.Success(
                response.body<ArrayList<NewsResponseItem>>()
            )
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}