package pl.kacper.misterski.news

import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.news.model.NewsResponseItem

interface NewsRepository {
    suspend fun fetchNews() : Result<List<NewsResponseItem>>
}