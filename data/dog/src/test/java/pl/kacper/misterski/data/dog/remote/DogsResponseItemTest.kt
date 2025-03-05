package pl.kacper.misterski.data.dog.remote

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.data.dog.breed
import pl.kacper.misterski.data.dog.dogsResponseItem
import pl.kacper.misterski.data.dog.model.remote.Breed
import pl.kacper.misterski.data.dog.model.remote.DogsResponseItem
import pl.kacper.misterski.data.dog.model.remote.Height
import pl.kacper.misterski.data.dog.model.remote.Weight

class DogsResponseItemTest {

    @Test
    @Throws(Exception::class)
    fun testGetBreeds() {
        val result = dogsResponseItem.breeds
        Assert.assertEquals(
            listOf(
                Breed(
                    Height("imperial", "metric"),
                    0,
                    "lifeSpan",
                    "name",
                    Weight("imperial", "metric")
                )
            ), result
        )
    }

    @Test
    @Throws(Exception::class)
    fun testGetHeight() {
        val result = dogsResponseItem.height
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetId() {
        val result = dogsResponseItem.id
        Assert.assertEquals("id", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetUrl() {
        val result = dogsResponseItem.url
        Assert.assertEquals("url", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetWidth() {
        val result = dogsResponseItem.width
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = dogsResponseItem.breeds
        Assert.assertEquals(
            listOf(
                Breed(
                    Height("imperial", "metric"),
                    0,
                    "lifeSpan",
                    "name",
                    Weight("imperial", "metric")
                )
            ), result
        )
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = dogsResponseItem.height
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent3() {
        val result = dogsResponseItem.id
        Assert.assertEquals("id", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent4() {
        val result = dogsResponseItem.url
        Assert.assertEquals("url", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent5() {
        val result = dogsResponseItem.width
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = dogsResponseItem.copy(
            listOf(
                Breed(
                    Height("imperial", "metric"),
                    0,
                    "lifeSpan",
                    "name",
                    Weight("imperial", "metric")
                )
            ), 0, "id", "url", 0
        )
        Assert.assertEquals(
            DogsResponseItem(
                listOf(
                    Breed(
                        Height("imperial", "metric"),
                        0,
                        "lifeSpan",
                        "name",
                        Weight("imperial", "metric")
                    )
                ), 0, "id", "url", 0
            ), result
        )
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        val result = dogsResponseItem.toString()
        Assert.assertEquals("DogsResponseItem(breeds=[Breed(height=Height(imperial=imperial, metric=metric), id=0, lifeSpan=lifeSpan, name=name, weight=Weight(imperial=imperial, metric=metric))], height=0, id=id, url=url, width=0)", result)
    }

    @Test
    @Throws(Exception::class)
    fun testHashCode() {
        val result = dogsResponseItem.hashCode()
        Assert.assertEquals(955147728, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result = dogsResponseItem == DogsResponseItem(
            breeds = listOf(element = breed),
            height = 0,
            id = "id",
            url = "url",
            width = 0
        )
        Assert.assertEquals(true, result)
    }
} //Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme
