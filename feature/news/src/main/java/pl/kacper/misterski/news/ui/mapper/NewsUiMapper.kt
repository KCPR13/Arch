package pl.kacper.misterski.news.ui.mapper

import pl.kacper.misterski.news.data.model.NewsDomainModel
import pl.kacper.misterski.news.ui.model.NewsUiModel

fun List<NewsDomainModel>.mapToNewsUiModels() = this.map { domainModel ->
    NewsUiModel(
        title = domainModel.title,
        body = domainModel.body
    )
}