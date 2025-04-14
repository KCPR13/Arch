package pl.kacper.misterski.data.dog.mapper

import pl.kacper.misterski.core.database.dog.DogEntity
import pl.kacper.misterski.domain.dog.model.DogsDomainModel
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem

internal fun  List<DogsResponseItem>.mapResponseItemsToDogsDomainModels() = this.mapNotNull {
    it.breeds?.mapNotNull{ breed ->
        DogsDomainModel(
            id = it.id.orEmpty(),
            url = it.url.orEmpty(),
            name = breed?.name.orEmpty(),
            height = breed?.height?.metric.orEmpty(),
            lifeSpan = breed?.lifeSpan.orEmpty(),
            weight = breed?.weight?.metric.orEmpty()
        )
    }
}.flatten()

internal fun List<DogsDomainModel>.mapDomainToEntities() = this.map { domainModel ->
    DogEntity(
        id = domainModel.id,
        name = domainModel.name,
        url = domainModel.url

    )
}

internal fun List<DogEntity>.mapEntitiesToDogsDomainModels() = this.map { entity ->
    DogsDomainModel(
        id = entity.id,
        url = entity.url,
        name = entity.name,
        height = "",
        lifeSpan = "",
        weight = ""
    )
}