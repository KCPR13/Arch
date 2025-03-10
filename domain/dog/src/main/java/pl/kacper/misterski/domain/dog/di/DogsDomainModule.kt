package pl.kacper.misterski.domain.dog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.dog.use_case.GetDogsUseCase
import pl.kacper.misterski.domain.dog.repository.DogRepository

//TODO K kiedy jakie kompoenenty
@Module
@InstallIn(ViewModelComponent::class)
object DogsDomainModule {

    @Provides
    fun provideGetDogsUseCase(dogRepository: DogRepository,
                              formatDateUseCase: FormatDateUseCase) = GetDogsUseCase(
        dogRepository = dogRepository,
        formatDateUseCase = formatDateUseCase
    )

}

