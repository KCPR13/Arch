package pl.kacper.misterski.feature.data.dog.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import pl.kacper.misterski.feature.data.dog.DogsRemoteDataSource
import pl.kacper.misterski.feature.data.dog.DogsRepository
import pl.kacper.misterski.feature.data.dog.remote.DogsRemoteDataSourceImpl
import pl.kacper.misterski.feature.data.dog.repository.DogsRepositoryImpl

//TODO K wstrzykiwanie zależności, gdzie co i jak
@Module
@InstallIn(SingletonComponent::class)
abstract class DogsDataModule {

    @Binds
    internal abstract fun provideDogsRepository(
        dogsRepositoryImpl: DogsRepositoryImpl
    ): DogsRepository

    @Binds
    internal abstract fun provideDogsRemoteDataSource(dogsRemoteDataSource: DogsRemoteDataSourceImpl)
            : DogsRemoteDataSource
}

// TODO K co z usecase który jest uzywany w kilku ficzerach