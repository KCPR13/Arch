package pl.kacper.misterski.data.dog.model.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Weight(
    @SerialName("imperial")
    val imperial: String?,
    @SerialName("metric")
    val metric: String?
)