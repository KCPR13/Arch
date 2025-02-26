package pl.kacper.misterski.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.data.news.NewsRemoteDataSource
import pl.kacper.misterski.domain.news.NewsRepository
import pl.kacper.misterski.data.news.remote.NewsRemoteDataSourceImpl
import pl.kacper.misterski.data.news.repository.NewsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface  NewsDataModule {

    @Binds
     fun provideNewsRepository(
        newsRepositoryImpl: NewsRepositoryImpl
    ): NewsRepository

    @Binds
    fun provideNewsRemoteDataSource(newsRemoteDataSource: NewsRemoteDataSourceImpl)
            : NewsRemoteDataSource
}

