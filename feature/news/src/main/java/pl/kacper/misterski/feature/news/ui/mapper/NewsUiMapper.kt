package pl.kacper.misterski.feature.news.ui.mapper

import pl.kacper.misterski.news.model.NewsDomainModel
import pl.kacper.misterski.news.ui.model.NewsUiModel

fun List<NewsDomainModel>.mapToNewsUiModels() = this.map { domainModel ->
    NewsUiModel(
        title = domainModel.title,
        body = domainModel.body
    )
}