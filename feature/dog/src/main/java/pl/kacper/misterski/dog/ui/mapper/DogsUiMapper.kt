package pl.kacper.misterski.dog.ui.mapper

import pl.kacper.misterski.dog.data.model.DogsDomainModel
import pl.kacper.misterski.dog.ui.model.DogsUiModel

fun List<DogsDomainModel>.mapToDogsUiModels() = this.map { domainModel ->
    DogsUiModel(
        title = domainModel.name,
        url = domainModel.url
    )
}