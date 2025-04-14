package pl.kacper.misterski.domain.dog.mapper

import pl.kacper.misterski.domain.dog.model.Dog
import pl.kacper.misterski.domain.dog.model.DogsDomainModel

internal fun List<DogsDomainModel>.mapToDogs(date: String?) = this.mapIndexed { index, domainModel ->
    Dog(
        id = domainModel.id,
        url = domainModel.url,
        name = index.plus(1).toString()
            .plus(". ")
            .plus(date)
            .plus(" ${domainModel.name}"),
        height = domainModel.height,
        lifeSpan = domainModel.lifeSpan,
        weight = domainModel.weight
    )
}