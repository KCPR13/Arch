package pl.kacper.misterski.data.dog

import pl.kacper.misterski.data.dog.model.remote.Breed
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem
import pl.kacper.misterski.data.dog.model.remote.Height
import pl.kacper.misterski.data.dog.model.remote.Weight

internal val height = Height("imperial", "metric")

internal val weight = Weight("imperial", "metric")

internal val breed: Breed =
    Breed(height, 0, "lifeSpan", "name", weight)

internal val dogsResponseItem = DogsResponseItem(
    breeds = listOf(element = breed),
    height = 0,
    id = "id",
    url = "url",
    width = 0
)
