package pl.kacper.misterski.data.dog.remote

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.data.dog.weight
import pl.kacper.misterski.data.dog.model.remote.Weight

class WeightTest {

    @Test
    @Throws(Exception::class)
    fun testGetImperial() {
        val result = weight.imperial
        Assert.assertEquals("imperial", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetMetric() {
        val result = weight.metric
        Assert.assertEquals("metric", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = weight.imperial
        Assert.assertEquals("imperial", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = weight.metric
        Assert.assertEquals("metric", result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = weight.copy("imperial", "metric")
        Assert.assertEquals(Weight("imperial", "metric"), result)
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        val result = weight.toString()
        Assert.assertEquals("Weight(imperial=imperial, metric=metric)", result)
    }

    @Test
    @Throws(Exception::class)
    fun testHashCode() {
        val result = weight.hashCode()
        Assert.assertEquals(-1572690219, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result = weight == Weight("imperial", "metric")
        Assert.assertEquals(true, result)
    }
} //Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme

