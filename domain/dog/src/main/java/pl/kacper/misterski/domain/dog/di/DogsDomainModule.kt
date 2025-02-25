package pl.kacper.misterski.domain.dog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.domain.dog.use_case.GetDogsUseCase
import pl.kacper.misterski.domain.dog.DogsRepository

//TODO K kiedy jakie kompoenenty
@Module
@InstallIn(SingletonComponent::class)
object DogsDomainModule {

    @Provides
    fun provideGetDogsUseCase(dogsRepository: DogsRepository) = GetDogsUseCase(dogsRepository)

}

