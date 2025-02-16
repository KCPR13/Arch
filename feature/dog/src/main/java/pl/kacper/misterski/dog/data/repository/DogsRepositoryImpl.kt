package pl.kacper.misterski.dog.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.core.data.Result
import pl.kacper.misterski.dog.data.DogsRemoteDataSource
import pl.kacper.misterski.dog.data.DogsRepository
import pl.kacper.misterski.dog.data.mapper.mapToDogsDomainModels


class DogsRepositoryImpl(
    private val dogsRemoteDataSource: DogsRemoteDataSource
) : DogsRepository {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO)
    {
        when (val result = dogsRemoteDataSource.fetchDogs()) {
            is Result.Failure -> result
            is Result.Success -> Result.Success(result.data.mapToDogsDomainModels())
        }
    }
}