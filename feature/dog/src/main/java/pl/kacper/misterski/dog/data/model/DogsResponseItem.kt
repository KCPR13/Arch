package pl.kacper.misterski.dog.data.model

data class DogsResponseItem(
    val breeds: List<Breed>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)