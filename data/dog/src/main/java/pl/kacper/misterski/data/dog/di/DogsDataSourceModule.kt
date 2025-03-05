package pl.kacper.misterski.data.dog.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.data.dog.data_source.remote.DogsRemoteDataSource
import pl.kacper.misterski.data.dog.data_source.remote.DogsRemoteDataSourceImpl


@Module
@InstallIn(SingletonComponent::class)
interface DogsDataSourceModule {

    @Binds
    fun bindDogsRemoteDataSource(
        dogsRemoteDataSourceImpl: DogsRemoteDataSourceImpl
    ): DogsRemoteDataSource


}