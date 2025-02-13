package pl.kacper.misterski.core.database.dog

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.kacper.misterski.core.database.dog.DogEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String
) {

    companion object {
        const val TABLE_NAME = "news"
    }

}