package pl.kacper.misterski.core.database.dog

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.kacper.misterski.core.database.dog.DogEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DogEntity(
    @PrimaryKey val id: String,
    val name: String,
    val url: String
) {

    companion object {
        const val TABLE_NAME = "dog"
    }

}