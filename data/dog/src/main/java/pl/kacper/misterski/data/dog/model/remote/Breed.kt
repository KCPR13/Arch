package pl.kacper.misterski.data.dog.model.remote


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
internal data class Breed(
    @SerialName("height")
    val height: Height?,
    @SerialName("id")
    val id: Int?,
    @SerialName("life_span")
    val lifeSpan: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("weight")
    val weight: Weight?
)