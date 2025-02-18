package pl.kacper.misterski.news.mapper

import pl.kacper.misterski.news.model.NewsResponseItem

fun List<NewsResponseItem>.mapToNewsDomainModels() = this.mapNotNull { responseItem ->
    responseItem.id?.let { id ->
        pl.kacper.misterski.news.model.NewsDomainModel(
            id = id,
            title = responseItem.title.orEmpty(),
            body = responseItem.body.orEmpty(),
        )
    }
}
