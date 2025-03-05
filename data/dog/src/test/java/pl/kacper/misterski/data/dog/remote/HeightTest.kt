package pl.kacper.misterski.data.dog.remote

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.data.dog.height
import pl.kacper.misterski.data.dog.model.remote.Height

class HeightTest {

    @Test
    @Throws(Exception::class)
    fun testGetImperial() {
        val result = height.imperial
        Assert.assertEquals("imperial", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetMetric() {
        val result = height.metric
        Assert.assertEquals("metric", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = height.imperial
        Assert.assertEquals("imperial", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = height.metric
        Assert.assertEquals("metric", result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = height.copy("imperial", "metric")
        Assert.assertEquals(Height("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        val result = height.toString()
        Assert.assertEquals("Height(imperial=imperial, metric=metric)", result)
    }

    @Test
    @Throws(Exception::class)
    fun testHashCode() {
        val result = height.hashCode()
        Assert.assertEquals(-1572690219, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result = height == Height("imperial", "metric")
        Assert.assertEquals(true, result)
    }
} //Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme

