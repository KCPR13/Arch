package pl.kacper.misterski.feature.news.ui.mapper

import pl.kacper.misterski.domain.news.model.News
import pl.kacper.misterski.feature.news.ui.model.NewsUiModel

fun List<News>.mapToNewsUiModels() = this.map { domainModel ->
    NewsUiModel(
        title = domainModel.title,
        body = domainModel.body
    )
}