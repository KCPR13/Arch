package pl.kacper.misterski.feature.data.dog.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.domain.dog.DogsRepository
import pl.kacper.misterski.feature.data.dog.repository.DogsRepositoryImpl

//TODO K wstrzykiwanie zależności, gdzie co i jak
@Module
@InstallIn(SingletonComponent::class)
interface DogsRepositoryModule {

    @Binds
    fun bindDogsRepository(
        dogsRepositoryImpl: DogsRepositoryImpl
    ): DogsRepository

}