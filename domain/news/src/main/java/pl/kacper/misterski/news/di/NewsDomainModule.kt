package pl.kacper.misterski.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient
import pl.kacper.misterski.news.repository.NewsRepositoryImpl
import pl.kacper.misterski.news.use_case.GetNewsUseCase

//TODO K GDZIE DI odpowiednich komponentów?
@Module
@InstallIn(ViewModelComponent::class)
object NewsDomainModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepositoryImpl) = GetNewsUseCase(newsRepository)

    @Provides
    fun provideNewsRepositoryImpl(httpClient: HttpClient) = NewsRepositoryImpl(httpClient)

}