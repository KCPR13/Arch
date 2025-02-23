package pl.kacper.misterski.domain.news.mapper

import pl.kacper.misterski.data.news.model.NewsResponseItem
import pl.kacper.misterski.domain.news.model.NewsDomainModel

fun List<NewsResponseItem>.mapToNewsDomainModels() = this.mapNotNull { responseItem ->
    responseItem.id?.let { id ->
        NewsDomainModel(
            id = id,
            title = responseItem.title.orEmpty(),
            body = responseItem.body.orEmpty(),
        )
    }
}
