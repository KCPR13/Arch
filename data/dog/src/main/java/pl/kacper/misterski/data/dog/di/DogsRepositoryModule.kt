package pl.kacper.misterski.data.dog.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.domain.dog.repository.DogRepository
import pl.kacper.misterski.data.dog.repository.DogsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DogsRepositoryModule {

    @Binds
    fun bindDogsRepository(
        dogsRepositoryImpl: DogsRepositoryImpl
    ): DogRepository

}