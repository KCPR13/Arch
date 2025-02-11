package pl.kacper.misterski.dog.data.mapper

import pl.kacper.misterski.dog.data.model.DogsDomainModel
import pl.kacper.misterski.dog.data.model.DogsResponse

fun DogsResponse.mapToDogsDomainModels() = this.mapNotNull {
    it.breeds.firstOrNull()?.let { breed ->
        DogsDomainModel(
            id = it.id,
            url = it.url,
            name = breed.name,
            height = breed.height.metric,
            lifeSpan = breed.life_span,
            origin = breed.origin,
            temperament = breed.origin,
            weight = breed.weight.metric
        )
    }

}