package pl.kacper.misterski.news.data

import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.news.data.model.NewsDomainModel

interface NewsRepository {

    suspend fun fetchNews() : Result<List<NewsDomainModel>>


}