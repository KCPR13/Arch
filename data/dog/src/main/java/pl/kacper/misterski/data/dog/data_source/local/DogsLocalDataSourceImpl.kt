package pl.kacper.misterski.data.dog.data_source.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.kacper.misterski.core.database.dog.DogDao
import pl.kacper.misterski.core.database.dog.DogEntity
import javax.inject.Inject

internal class DogsLocalDataSourceImpl @Inject constructor(private val dogDao: DogDao) :
    DogsLocalDataSource {
    override suspend fun saveDogs(dogs: List<DogEntity>) = withContext(Dispatchers.IO) {
        dogDao.insert(*dogs.toTypedArray())
        return@withContext
    }

    override suspend fun getDogs() = withContext(Dispatchers.IO) {
        dogDao.getAllDogs()
    }
}