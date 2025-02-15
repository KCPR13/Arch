package pl.kacper.misterski.dog.data.mapper

import pl.kacper.misterski.dog.data.model.DogsDomainModel
import pl.kacper.misterski.dog.data.model.DogsResponseItem

fun  ArrayList<DogsResponseItem>.mapToDogsDomainModels() = this.mapNotNull {
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