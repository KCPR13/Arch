package pl.kacper.misterski.data.news.mapper

import pl.kacper.misterski.data.news.model.remote.NewsResponseItem
import pl.kacper.misterski.domain.news.model.NewsDomainModel

internal fun List<NewsResponseItem>.mapToNewsDomainModels() = this.mapNotNull { responseItem ->
    responseItem.id?.let { id ->
        NewsDomainModel(
            id = id,
            title = responseItem.title.orEmpty(),
            body = responseItem.body.orEmpty(),
        )
    }
}
