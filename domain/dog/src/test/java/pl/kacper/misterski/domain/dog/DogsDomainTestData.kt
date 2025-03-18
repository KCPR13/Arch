package pl.kacper.misterski.domain.dog

import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.domain.dog.model.Dog
import pl.kacper.misterski.domain.dog.model.DogsDomainModel
import pl.kacper.misterski.domain.dog.repository.DogRepository
import java.net.SocketException

//TODO K bazka jako osobny moduł
val dog: Dog = Dog("id", "url", "name", "height", "lifeSpan", "weight")


val dogsDomainModel1 = DogsDomainModel(
    id = "1",
    url = "https://pieski/jamiczek.com",
    name = "Jamniczek",
    height = "40",
    lifeSpan = "15",
    weight = "8kg"
)
private val dogsDomainModel2 = DogsDomainModel(
    id = "2",
    url = "https://pieski/bejing.com",
    name = "Pekinczyk",
    height = "30",
    lifeSpan = "13",
    weight = "3kg"
)
private val dogsDomainModel3 = DogsDomainModel(
    id = "3",
    url = "https://pieski/labrador.com",
    name = "Labrador",
    height = "90",
    lifeSpan = "11",
    weight = "35kg"
)
private val dogsDomainModel4 = DogsDomainModel(
    id = "4",
    url = "https://pieski/owczarek.com",
    name = "Owczarek niemiecki",
    height = "95",
    lifeSpan = "12",
    weight = "37kg"
)
private val dogsDomainModel5 = DogsDomainModel(
    id = "5",
    url = "https://pieski/pitbull.com",
    name = "Pitbull",
    height = "60",
    lifeSpan = "17",
    weight = "29kg"
)


class FakeSuccessDogRepository : DogRepository {

    override suspend fun fetchDogs(): Result<List<DogsDomainModel>> {
        return Result.Success(data = buildList {
            add(dogsDomainModel1)
            add(dogsDomainModel2)
            add(dogsDomainModel3)
            add(dogsDomainModel4)
            add(dogsDomainModel5)
        })
    }
}

class FakeFailureDogRepository : DogRepository {

    override suspend fun fetchDogs(): Result<List<DogsDomainModel>> {
        return Result.Failure(SocketException())
    }
}