package pl.kacper.misterski.dogs.mapper

import pl.kacper.misterski.dog.model.DogsResponseItem

fun  List<DogsResponseItem>.mapToDogsDomainModels() = this.mapNotNull {
    it.breeds?.mapNotNull{ breed ->
        pl.kacper.misterski.dogs.model.DogsDomainModel(
            id = it.id.orEmpty(),
            url = it.url.orEmpty(),
            name = breed?.name.orEmpty(),
            height = breed?.height?.metric.orEmpty(),
            lifeSpan = breed?.lifeSpan.orEmpty(),
            weight = breed?.weight?.metric.orEmpty()
        )
    }
}.flatten()