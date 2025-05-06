package pl.kacper.misterski.data.dog.data_source.local

import pl.kacper.misterski.core.database.dog.DogEntity

internal interface DogsLocalDataSource {

    suspend fun saveDogs(dogs: List<DogEntity>)

    suspend fun getDogs(): List<DogEntity>
}