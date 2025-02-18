package pl.kacper.misterski.dog.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Height(
    @SerialName("imperial")
    val imperial: String?,
    @SerialName("metric")
    val metric: String?
)