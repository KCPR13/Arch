package pl.kacper.misterski.data.news.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.data.news.data_source.remote.NewsRemoteDataSource
import pl.kacper.misterski.data.news.data_source.remote.NewsRemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface NewsDataSourceModule {

    @Binds
    fun provideNewsRemoteDataSource(newsRemoteDataSource: NewsRemoteDataSourceImpl)
            : NewsRemoteDataSource
}

