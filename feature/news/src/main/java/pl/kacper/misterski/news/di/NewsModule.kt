package pl.kacper.misterski.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient
import pl.kacper.misterski.news.data.repository.NewsRepositoryImpl
import pl.kacper.misterski.news.domain.use_case.GetNewsUseCase

@Module
@InstallIn(ViewModelComponent::class)
object NewsModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepositoryImpl) = GetNewsUseCase(newsRepository)

    @Provides
    fun provideNewsRepositoryImpl(httpClient: HttpClient) = NewsRepositoryImpl(httpClient)

}