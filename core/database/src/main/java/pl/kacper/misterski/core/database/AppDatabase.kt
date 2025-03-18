package pl.kacper.misterski.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.kacper.misterski.core.database.dog.DogDao
import pl.kacper.misterski.core.database.dog.DogEntity

@Database(entities = [DogEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao

}
