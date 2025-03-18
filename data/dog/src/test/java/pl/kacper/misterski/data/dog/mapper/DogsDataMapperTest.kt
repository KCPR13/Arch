package pl.kacper.misterski.data.dog.mapper

import org.junit.Assert
import org.junit.Test
import pl.kacper.misterski.data.dog.dogsResponseItem

class DogsDataMapperTest {

    @Test
    fun `When breed is not null then mapToDogsDomainModels should return an item`() {
        //GIVEN
        val list = listOf(dogsResponseItem)

        //WHEN
        val result = list.mapResponseItemsToDogsDomainModels()
        val firstItem = result.first()

        Assert.assertEquals(1, result.size)
        Assert.assertEquals(dogsResponseItem.id, firstItem.id)
        Assert.assertEquals(dogsResponseItem.url, firstItem.url)
        Assert.assertEquals(dogsResponseItem.breeds?.firstOrNull()?.name, firstItem.name)
        Assert.assertEquals(
            dogsResponseItem.breeds?.firstOrNull()?.height?.metric,
            firstItem.height
        )
        Assert.assertEquals(
            dogsResponseItem.breeds?.firstOrNull()?.weight?.metric,
            firstItem.weight
        )
        Assert.assertEquals(dogsResponseItem.breeds?.firstOrNull()?.lifeSpan, firstItem.lifeSpan)
    }

    @Test
    fun `When breed is null then mapToDogsDomainModels should return no item`() {
        //GIVEN
        val list = listOf(dogsResponseItem.copy(breeds = null))

        //WHEN
        val result = list.mapResponseItemsToDogsDomainModels()

        Assert.assertEquals(0, result.size)
    }
}