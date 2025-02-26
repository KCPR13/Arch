package pl.kacper.misterski.core.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase

@Module
@InstallIn(ViewModelComponent::class)
object CoreUseCaseModule {

    @Provides
    fun provideFormatDateUseCase() = FormatDateUseCase()

}
