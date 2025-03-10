package pl.kacper.misterski.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.data.news.repository.NewsRepositoryImpl
import pl.kacper.misterski.domain.news.repository.NewsRepository

@Module
@InstallIn(SingletonComponent::class)
interface NewsRepositoryModule {

    @Binds
    fun provideNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository

}

