package pl.kacper.misterski.dog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient
import pl.kacper.misterski.dog.data.remote.DogsRemoteDataSourceImpl
import pl.kacper.misterski.dog.data.repository.DogsRepositoryImpl
import pl.kacper.misterski.dog.domain.use_case.GetDogsUseCase

@Module
@InstallIn(ViewModelComponent::class)
object DogsModule {

    @Provides
    fun provideGetDogsUseCase(dogsRepository: DogsRepositoryImpl) = GetDogsUseCase(dogsRepository)

    @Provides
    fun provideDogsRepository(dogsRemoteDataSourceImpl: DogsRemoteDataSourceImpl) = DogsRepositoryImpl(dogsRemoteDataSourceImpl)

    @Provides
    fun provideDogsRemoteDataSource(httpClient: HttpClient) = DogsRemoteDataSourceImpl(httpClient)
}