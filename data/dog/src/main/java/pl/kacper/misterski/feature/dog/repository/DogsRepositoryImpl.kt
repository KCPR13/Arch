package pl.kacper.misterski.dog.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.dog.DogsRemoteDataSource
import pl.kacper.misterski.dog.DogsRepository


class DogsRepositoryImpl(
    private val dogsRemoteDataSource: DogsRemoteDataSource
) : DogsRepository {

    override suspend fun fetchDogs() = withContext(Dispatchers.IO)
    {
        when (val result = dogsRemoteDataSource.fetchDogs()) {
            is Result.Failure -> result
            is Result.Success -> Result.Success(result.data)
        }
    }
}