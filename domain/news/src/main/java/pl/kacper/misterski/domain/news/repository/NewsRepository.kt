package pl.kacper.misterski.domain.news.repository

import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.domain.news.model.NewsDomainModel

interface NewsRepository {
    suspend fun fetchNews(): Result<List<NewsDomainModel>>
}