package pl.kacper.misterski.domain.dog.use_case

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.common.util.result.getDataOrNull
import pl.kacper.misterski.core.domain.use_case.FormatDateUseCase
import pl.kacper.misterski.domain.dog.FakeFailureDogRepository
import pl.kacper.misterski.domain.dog.FakeSuccessDogRepository
import pl.kacper.misterski.domain.dog.model.Dog
import pl.kacper.misterski.domain.dog.model.DogsDomainModel
import java.net.SocketException

class GetDogsUseCaseTest {

    private lateinit var getDogsUseCase: GetDogsUseCase
    private lateinit var fakeSuccessDogsRepository: FakeSuccessDogRepository
    private lateinit var fakeFailureDogsRepository: FakeFailureDogRepository

    @MockK
    lateinit var formatDateUseCase: FormatDateUseCase

    private val date = "2025.03.04"

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fakeSuccessDogsRepository = FakeSuccessDogRepository()
        fakeFailureDogsRepository = FakeFailureDogRepository()

        every { formatDateUseCase.invoke(any()) } returns flow {
            emit(Result.Success(date))
        }
    }

    @Test
    fun `When GetDogsUseCase is called then it should return successful result with 5 Dogs models`(): Unit = runBlocking {
        //GIVEN
        getDogsUseCase = GetDogsUseCase(
            dogRepository = fakeSuccessDogsRepository,
            formatDateUseCase = formatDateUseCase
        )
        val mappedFirstItem = Dog(
            id = "1",
            url = "https://pieski/jamiczek.com",
            name = "1. $date Jamniczek",
            height = "40",
            lifeSpan = "15",
            weight = "8kg"
        )

        //WHEN
        val dogsResult = getDogsUseCase().first()
        val data = dogsResult.getDataOrNull()

        //THEN
        assertTrue(dogsResult is Result.Success<List<Dog>>)
        assertEquals(5, data?.size ?: -1)
        assertEquals(mappedFirstItem, data?.firstOrNull())
    }

    @Test
    fun `When GetDogsUseCase is called then it should return failure result with SocketException`(): Unit = runBlocking {
       //GIVEN
        getDogsUseCase = GetDogsUseCase(
            dogRepository = fakeFailureDogsRepository,
            formatDateUseCase = formatDateUseCase
        )

        //WHEN
        val dogsResult = getDogsUseCase().first()
        val exception = (dogsResult as? Result.Failure)?.error


        //THEN
        assertTrue(dogsResult is Result.Failure)
        assertTrue(exception is SocketException)

    }

}