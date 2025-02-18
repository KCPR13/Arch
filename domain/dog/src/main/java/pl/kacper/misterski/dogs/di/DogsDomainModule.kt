package pl.kacper.misterski.dogs.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient
import pl.kacper.misterski.dogs.use_case.GetDogsUseCase

//TODO K kiedy jakie kompoenenty
@Module
@InstallIn(ViewModelComponent::class)
object DogsDomainModule {

    @Provides
    fun provideGetDogsUseCase(dogsRepository: pl.kacper.misterski.dog.repository.DogsRepositoryImpl) = GetDogsUseCase(dogsRepository)

    @Provides
    fun provideDogsRepository(dogsRemoteDataSourceImpl: pl.kacper.misterski.dog.remote.DogsRemoteDataSourceImpl) =
        pl.kacper.misterski.dog.repository.DogsRepositoryImpl(dogsRemoteDataSourceImpl)

    @Provides
    fun provideDogsRemoteDataSource(httpClient: HttpClient) =
        pl.kacper.misterski.dog.remote.DogsRemoteDataSourceImpl(httpClient)
}