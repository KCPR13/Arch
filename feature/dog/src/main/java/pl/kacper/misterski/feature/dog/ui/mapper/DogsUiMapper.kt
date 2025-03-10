package pl.kacper.misterski.feature.dog.ui.mapper

import pl.kacper.misterski.domain.dog.model.Dog
import pl.kacper.misterski.feature.dog.ui.model.DogsUiModel

fun List<Dog>.mapToDogsUiModels() = this.map { domainModel ->
    DogsUiModel(
        title = domainModel.name,
        url = domainModel.url
    )
}