package pl.kacper.misterski.news.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.news.NewsRepository
import pl.kacper.misterski.news.model.NewsResponseItem

class NewsRepositoryImpl(
    private val httpClient: HttpClient
) : NewsRepository {

    override suspend fun fetchNews(): Result<List<NewsResponseItem>> = withContext(Dispatchers.IO) {
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