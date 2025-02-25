package pl.kacper.misterski.feature.data.dog.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.common.result.Result
import pl.kacper.misterski.domain.dog.DogsRepository
import pl.kacper.misterski.feature.data.dog.DogsRemoteDataSource
import javax.inject.Inject

// TODO K @Inject constructor ok?
class DogsRepositoryImpl @Inject constructor(
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