package pl.kacper.misterski.domain.news.mapper

import pl.kacper.misterski.domain.news.model.News
import pl.kacper.misterski.domain.news.model.NewsDomainModel

fun List<NewsDomainModel>.mapToNews(date: String?) = this.map { domainModel ->
    News(
        id = domainModel.id,
        title = date?.plus("\n").plus(domainModel.title),
        body = domainModel.body
    )
}