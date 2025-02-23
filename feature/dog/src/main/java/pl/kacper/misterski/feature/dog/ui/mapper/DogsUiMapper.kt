package pl.kacper.misterski.feature.dog.ui.mapper

import pl.kacper.misterski.feature.dog.ui.model.DogsUiModel
import pl.kacper.misterski.domain.dog.model.DogsDomainModel

fun List<DogsDomainModel>.mapToDogsUiModels() = this.map { domainModel ->
    DogsUiModel(
        title = domainModel.name,
        url = domainModel.url
    )
}