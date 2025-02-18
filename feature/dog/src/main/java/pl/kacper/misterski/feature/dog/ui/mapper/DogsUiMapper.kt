package pl.kacper.misterski.feature.dog.ui.mapper

import pl.kacper.misterski.feature.dog.ui.model.DogsUiModel
import pl.kacper.misterski.dogs.model.DogsDomainModel

fun List<DogsDomainModel>.mapToDogsUiModels() = this.map { domainModel ->
    DogsUiModel(
        title = domainModel.name,
        url = domainModel.url
    )
}