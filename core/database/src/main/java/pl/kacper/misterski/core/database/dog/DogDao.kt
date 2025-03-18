package pl.kacper.misterski.core.database.dog

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg  dog: DogEntity)

    @Query("SELECT * FROM ${DogEntity.TABLE_NAME}")
    suspend fun getAllDogs(): List<DogEntity>
}