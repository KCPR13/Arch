package pl.kacper.misterski.data.dog.remote

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.data.dog.breed
import pl.kacper.misterski.data.dog.height
import pl.kacper.misterski.data.dog.weight
import pl.kacper.misterski.data.dog.model.remote.Breed
import pl.kacper.misterski.data.dog.model.remote.Height
import pl.kacper.misterski.data.dog.model.remote.Weight

class BreedTest {

    @Test
    @Throws(Exception::class)
    fun testGetHeight() {
        val result = breed.height
        Assert.assertEquals(Height("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetId() {
        val result = breed.id
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetLifeSpan() {
        val result = breed.lifeSpan
        Assert.assertEquals("lifeSpan", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetName() {
        val result = breed.name
        Assert.assertEquals("name", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetWeight() {
        val result = breed.weight
        Assert.assertEquals(Weight("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = breed.height
        Assert.assertEquals(Height("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = breed.id
        Assert.assertEquals(0, result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent3() {
        val result = breed.lifeSpan
        Assert.assertEquals("lifeSpan", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent4() {
        val result = breed.name
        Assert.assertEquals("name", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent5() {
        val result = breed.weight
        Assert.assertEquals(Weight("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = breed.copy(
            Height("imperial", "metric"),
            0,
            "lifeSpan",
            "name",
            Weight("imperial", "metric")
        )
        Assert.assertEquals(
            Breed(
                Height("imperial", "metric"),
                0,
                "lifeSpan",
                "name",
                Weight("imperial", "metric")
            ), result
        )
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        val result = breed.toString()
        Assert.assertEquals("Breed(height=Height(imperial=imperial, metric=metric), id=0, lifeSpan=lifeSpan, name=name, weight=Weight(imperial=imperial, metric=metric))", result)
    }

    @Test
    @Throws(Exception::class)
    fun testHashCode() {
        val result = breed.hashCode()
        Assert.assertEquals(1045196005, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result = breed == Breed(height, 0, "lifeSpan", "name", weight)
        Assert.assertEquals(true, result)
    }
} //Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme

