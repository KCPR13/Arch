package pl.kacper.misterski.domain.dog.model

import junit.framework.TestCase.assertEquals
import org.junit.Test
import pl.kacper.misterski.domain.dog.dogsDomainModel1


internal class DogsDomainModelTest {

    @Test
    fun testGetId() {
        val result = dogsDomainModel1.id
        assertEquals("1", result)
    }

    @Test
    fun testGetUrl() {
        val result = dogsDomainModel1.url
        assertEquals("https://pieski/jamiczek.com", result)
    }

    @Test
    fun testGetName() {
        val result = dogsDomainModel1.name
        assertEquals("Jamniczek", result)
    }

    @Test
    fun testGetHeight() {
        val result = dogsDomainModel1.height
        assertEquals("40", result)
    }

    @Test
    fun testGetLifeSpan() {
        val result = dogsDomainModel1.lifeSpan
        assertEquals("15", result)
    }

    @Test
    fun testGetWeight() {
        val result = dogsDomainModel1.weight
        assertEquals("8kg", result)
    }

    @Test
    fun testComponent1() {
        val result = dogsDomainModel1.id
        assertEquals("1", result)
    }

    @Test
    fun testComponent2() {
        val result = dogsDomainModel1.url
        assertEquals("https://pieski/jamiczek.com", result)
    }

    @Test
    fun testComponent3() {
        val result = dogsDomainModel1.name
        assertEquals("Jamniczek", result)
    }

    @Test
    fun testComponent4() {
        val result = dogsDomainModel1.height
        assertEquals("40", result)
    }

    @Test
    fun testComponent5() {
        val result = dogsDomainModel1.lifeSpan
        assertEquals("15", result)
    }

    @Test
    fun testComponent6() {
        val result = dogsDomainModel1.weight
        assertEquals("8kg", result)
    }

    @Test
    fun testCopy() {
        val result = dogsDomainModel1.copy("id", "url", "name", "height", "lifeSpan", "weight")
        assertEquals(
            DogsDomainModel(
                "id",
                "url",
                "name",
                "height",
                "lifeSpan",
                "weight"
            ), result
        )
    }

    @Test
    fun testToString() {
        val result = dogsDomainModel1.toString()
        assertEquals("DogsDomainModel(id=1, url=https://pieski/jamiczek.com, name=Jamniczek, height=40, lifeSpan=15, weight=8kg)", result)
    }

    @Test
    fun testHashCode() {
        val result = dogsDomainModel1.hashCode()
        assertEquals(-709510869, result)
    }

    @Test
    fun testEquals() {
        val result = dogsDomainModel1 == DogsDomainModel(
            id = "1",
            url = "https://pieski/jamiczek.com",
            name = "Jamniczek",
            height = "40",
            lifeSpan = "15",
            weight = "8kg"
        )
        assertEquals(true, result)
    }
}

