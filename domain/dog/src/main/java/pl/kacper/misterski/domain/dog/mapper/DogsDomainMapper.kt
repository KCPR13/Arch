package pl.kacper.misterski.domain.dog.mapper

import pl.kacper.misterski.domain.dog.model.DogsDomainModel
import pl.kacper.misterski.feature.data.dog.model.remote.DogsResponseItem

fun  List<pl.kacper.misterski.feature.data.dog.model.remote.DogsResponseItem>.mapToDogsDomainModels() = this.mapNotNull {
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