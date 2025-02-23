package pl.kacper.misterski.data.news

import pl.kacper.misterski.core.common.result.Result
import pl.kacper.misterski.data.news.model.NewsResponseItem

interface NewsRepository {
    suspend fun fetchNews(): Result<List<NewsResponseItem>>
}