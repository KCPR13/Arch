package pl.kacper.misterski.domain.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pl.kacper.misterski.data.news.NewsRepository
import pl.kacper.misterski.domain.news.use_case.GetNewsUseCase

//TODO K GDZIE DI odpowiednich komponentów?
@Module
@InstallIn(ViewModelComponent::class)
object NewsDomainModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository) = GetNewsUseCase(newsRepository)
}