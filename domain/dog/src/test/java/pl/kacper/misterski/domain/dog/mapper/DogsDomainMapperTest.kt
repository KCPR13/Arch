package pl.kacper.misterski.domain.dog.mapper

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.domain.dog.dogsDomainModel1

class DogsDomainMapperTest {

    private val date = "10.02.2025"

    @Test
    fun `When mapToDogs is called, then it should return equal number of items with mapped name`() {
        //GIVEN
        val list = listOf(dogsDomainModel1)

        //WHEN
        val result = list.mapToDogs(date)
        val firstItem = result.first()

        //THEN
        Assert.assertEquals(1, result.size)
        Assert.assertEquals(dogsDomainModel1.id, firstItem.id)
        Assert.assertEquals(dogsDomainModel1.url, firstItem.url)
        Assert.assertEquals("1. $date ${dogsDomainModel1.name}", firstItem.name)
        Assert.assertEquals(dogsDomainModel1.height, firstItem.height)
        Assert.assertEquals(dogsDomainModel1.weight, firstItem.weight)
        Assert.assertEquals(dogsDomainModel1.lifeSpan, firstItem.lifeSpan)
    }

}