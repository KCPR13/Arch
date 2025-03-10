package pl.kacper.misterski.domain.dog.model

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.domain.dog.dog

class DogTest {

    @Test
    @Throws(Exception::class)
    fun testGetId() {
        val result = dog.id
        Assert.assertEquals("id", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetUrl() {
        val result = dog.url
        Assert.assertEquals("url", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetName() {
        val result = dog.name
        Assert.assertEquals("name", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetHeight() {
        val result = dog.height
        Assert.assertEquals("height", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetLifeSpan() {
        val result = dog.lifeSpan
        Assert.assertEquals("lifeSpan", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetWeight() {
        val result = dog.weight
        Assert.assertEquals("weight", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = dog.id
        Assert.assertEquals("id", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = dog.url
        Assert.assertEquals("url", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent3() {
        val result = dog.name
        Assert.assertEquals("name", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent4() {
        val result = dog.height
        Assert.assertEquals("height", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent5() {
        val result = dog.lifeSpan
        Assert.assertEquals("lifeSpan", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent6() {
        val result = dog.weight
        Assert.assertEquals("weight", result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = dog.copy("id", "url", "name", "height", "lifeSpan", "weight")
        Assert.assertEquals(Dog("id", "url", "name", "height", "lifeSpan", "weight"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        val result = dog.toString()
        Assert.assertEquals("Dog(id=id, url=url, name=name, height=height, lifeSpan=lifeSpan, weight=weight)", result)
    }

    @Test
    @Throws(Exception::class)
    fun testHashCode() {
        val result = dog.hashCode()
        Assert.assertEquals(1118260610, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result = dog == Dog("id", "url", "name", "height", "lifeSpan", "weight")
        Assert.assertEquals(true, result)
    }
} //Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme

