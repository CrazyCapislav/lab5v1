package models

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import src.main.kotlin.models.Coordinates
import src.main.kotlin.models.Flat
import src.main.kotlin.models.Furnish
import src.main.kotlin.models.House

class FlatTest {
    private val id = 1L
    private val name = "Flat1"
    private val coordinates = mockk<Coordinates>()
    private val area = 100
    private val numberOfRooms = 2
    private val livingSpace = 50.0
    private val timeToMetroOnFoot = 10
    private val furnish = Furnish.FINE
    private val house = mockk<House>()
    private val flat = Flat(id, name, coordinates, area, numberOfRooms, livingSpace, timeToMetroOnFoot, furnish, house)

    @Test
    fun `test toString`() {
        val expected = "Flat1, ${flat.creationDate}, $id, $coordinates, 100, 2, 50.0, 10, FINE, $house"
        assertEquals(expected, flat.toString())
    }

    @Test
    fun `test set and get area`() {
        val newArea = 200
        flat.area = newArea
        assertEquals(newArea, flat.area)
    }

    @Test
    fun `test set and get numberOfRooms`() {
        val newNumberOfRooms = 3
        flat.numberOfRooms = newNumberOfRooms
        assertEquals(newNumberOfRooms, flat.numberOfRooms)
    }
    @Test
    fun `test getID `() {
        val id = 123L
        val name = "test flat"
        val coordinates = mockk<Coordinates>()
        val area = 100
        val numberOfRooms = 3
        val livingSpace = 70.0
        val timeToMetroOnFoot = 10
        val furnish = mockk<Furnish>()
        val house = mockk<House>()
        val flat = Flat(id, name, coordinates, area, numberOfRooms, livingSpace, timeToMetroOnFoot, furnish, house)

        assertEquals(id, flat.id)
}
    @Test
    fun `test Coordinates`() {
        val x = 10L
        val y = 20L
        val coordinates = Coordinates(x, y)

        assertEquals("Coordinates(x=$x, y=$y)", coordinates.toString())
    }
    @Test
    fun `test FUR`() {
        val furnish = mockk<Furnish>()
        every { furnish.toString() } returns "FINE"
        assert(furnish.toString() == "FINE")
    }
    @Test
    fun testHouseCreation() {
        val houseName = "Test House"
        val houseYear = 2000L
        val houseNumberOfLifts = 2L
        val house = House(houseName, houseYear, houseNumberOfLifts)

        assertEquals(house.name, houseName)
        assertEquals(house.year, houseYear)
        assertEquals(house.numberOfLifts, houseNumberOfLifts)
    }

}
