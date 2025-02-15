package pl.kacper.misterski.news.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.news.data.NewsRepository
import pl.kacper.misterski.news.data.mapper.mapToNewsDomainModels
import pl.kacper.misterski.news.data.model.NewsDomainModel
import pl.kacper.misterski.news.data.model.NewsResponseItem

class NewsRepositoryImpl(
    private val httpClient: HttpClient
) : NewsRepository {

    override suspend fun fetchNews(): Result<List<NewsDomainModel>> = withContext(Dispatchers.IO) {
        val response =
            httpClient.get("https://jsonplaceholder.typicode.com/posts")

        if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body< ArrayList<NewsResponseItem>>().mapToNewsDomainModels())
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}