package pl.kacper.misterski.news.data.mapper

import pl.kacper.misterski.news.data.model.NewsDomainModel
import pl.kacper.misterski.news.data.model.NewsResponseItem

fun ArrayList<NewsResponseItem>.mapToNewsDomainModels() = this.mapNotNull { responseItem ->
    responseItem.id?.let { id ->
        NewsDomainModel(
            id = id,
            title = responseItem.title.orEmpty(),
            body = responseItem.body.orEmpty(),
        )
    }
}
