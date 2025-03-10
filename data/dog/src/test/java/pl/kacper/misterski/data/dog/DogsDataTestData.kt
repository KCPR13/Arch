package pl.kacper.misterski.data.dog

import pl.kacper.misterski.data.dog.model.remote.Breed
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem
import pl.kacper.misterski.data.dog.model.remote.Height
import pl.kacper.misterski.data.dog.model.remote.Weight

//TODO K pakiety w feature:
// kontekstowo jak dog i dog_details
// podział na mapper, model, viewModel itp

val height = Height("imperial", "metric")

val weight = Weight("imperial", "metric")

val breed: Breed =
    Breed(height, 0, "lifeSpan", "name", weight)

val dogsResponseItem = DogsResponseItem(
    breeds = listOf(element = breed),
    height = 0,
    id = "id",
    url = "url",
    width = 0
)
