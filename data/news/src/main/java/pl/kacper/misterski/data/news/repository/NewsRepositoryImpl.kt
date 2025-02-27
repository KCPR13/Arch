package pl.kacper.misterski.data.news.repository

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.data.news.data_source.remote.NewsRemoteDataSource
import pl.kacper.misterski.data.news.mapper.mapToNewsDomainModels
import pl.kacper.misterski.data.news.model.remote.NewsResponseItem
import pl.kacper.misterski.domain.news.NewsRepository
import pl.kacper.misterski.domain.news.model.NewsDomainModel
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun fetchNews(): Result<List<NewsDomainModel>> = withContext(Dispatchers.IO) {
        val response = newsRemoteDataSource.fetchNews()

        if (response.status == HttpStatusCode.OK) {
            Result.Success(response.body<List<NewsResponseItem>>().mapToNewsDomainModels())
        } else {
            Result.Failure(Exception(response.status.description))
        }
    }
}