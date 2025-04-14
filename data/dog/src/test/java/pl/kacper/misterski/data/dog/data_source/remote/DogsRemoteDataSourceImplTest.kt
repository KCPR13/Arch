package pl.kacper.misterski.data.dog.data_source.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class DogsRemoteDataSourceImplTest {

    private lateinit var httpClient: HttpClient
    private lateinit var dogsRemoteDataSourceImpl: DogsRemoteDataSourceImpl

    private val content = """{"dogs":["Labrador","Pug"]}"""

    @Before
    fun setup() {
        val mockEngine = MockEngine { request ->
            respond(
                content = content,
                status = HttpStatusCode.OK,
                headers = headersOf("Content-Type" to listOf("application/json"))
            )
        }

        httpClient = HttpClient(mockEngine)

        dogsRemoteDataSourceImpl = DogsRemoteDataSourceImpl(httpClient)
    }

    @Test
    fun `When fetchDogs is called, then return httpResponse`() = runBlocking {
        // WHEN
        val result = dogsRemoteDataSourceImpl.fetchDogs()

        //THEN
        assertEquals(result.status, HttpStatusCode.OK)

        assertEquals(content, result.body<String>())
    }
}