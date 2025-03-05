package pl.kacper.misterski.data.dog.repository

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import pl.kacper.misterski.common.util.result.Result
import pl.kacper.misterski.data.dog.data_source.remote.DogsRemoteDataSource
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem

class DogsRepositoryImplTest {

    @MockK
    private lateinit var dogsRemoteDataSource: DogsRemoteDataSource

    private val httpResponse = mockk<HttpResponse>(relaxed = true)

    private lateinit var repository: DogsRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = DogsRepositoryImpl(dogsRemoteDataSource)
    }

    @Test
    fun `When dogsRemoteDataSource returns ok status, then dogRepository should return success result`() = runBlocking {
        // GIVEN
        coEvery { dogsRemoteDataSource.fetchDogs() } returns httpResponse
        coEvery { httpResponse.status } returns HttpStatusCode.OK
        coEvery { httpResponse.body<ArrayList<DogsResponseItem>>() } returns arrayListOf()


        //WHEN
        val result = repository.fetchDogs()

        //THEN
        assertTrue(result is Result.Success)
    }

    @Test
    fun `When dogsRemoteDataSource returns bad gateway status, then dogRepository should return failure result`() = runBlocking {
        // GIVEN
        coEvery { dogsRemoteDataSource.fetchDogs() } returns httpResponse
        coEvery { httpResponse.status } returns HttpStatusCode.BadGateway

        //WHEN
        val result = repository.fetchDogs()
        val exception = (result as? Result.Failure)?.error

        //THEN
        assertTrue(result is Result.Failure)
        assertTrue(exception !=null)

    }
}