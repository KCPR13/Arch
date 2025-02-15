package pl.kacper.misterski.dog.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Breed(
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