package pl.kacper.misterski.data.news.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.data.news.NewsRemoteDataSource
import pl.kacper.misterski.data.news.NewsRepository
import pl.kacper.misterski.data.news.model.NewsResponseItem
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    override suspend fun fetchNews(): Result<List<NewsResponseItem>> = withContext(Dispatchers.IO) {
        when (val result = newsRemoteDataSource.fetchNews()) {
            is Result.Failure -> result
            is Result.Success -> result
        }

    }
}