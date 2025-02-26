package pl.kacper.misterski.domain.dog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.dog.use_case.GetDogsUseCase
import pl.kacper.misterski.domain.dog.DogsRepository

//TODO K kiedy jakie kompoenenty
@Module
@InstallIn(ViewModelComponent::class)
object DogsDomainModule {

    @Provides
    fun provideGetDogsUseCase(dogsRepository: DogsRepository,
                              formatDateUseCase: FormatDateUseCase) = GetDogsUseCase(dogsRepository,formatDateUseCase)

}

