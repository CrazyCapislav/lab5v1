package models
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import src.main.kotlin.commands.RemoveById
import src.main.kotlin.managers.CommandManager
import src.main.kotlin.models.Flat

class CommandTEST {
    @Test
    fun `test removeById`() {
        val flat1 = mockk<Flat>()
        val flat2 = mockk<Flat>()
        val flat3 = mockk<Flat>()
        every { flat1.id } returns 1L
        every { flat2.id } returns 2L
        every { flat3.id } returns 3L

        val hashSet = hashSetOf(flat1, flat2, flat3)
        val removeById = RemoveById()

        removeById.removeById(hashSet, 2L)

        assertEquals(2, hashSet.size)
        assertEquals(true, hashSet.contains(flat1))
        assertEquals(false, hashSet.contains(flat2))
        assertEquals(true, hashSet.contains(flat3))
    }
    @Test
    fun `start function should be called`() {
        val commandManager = mockk<CommandManager>(relaxed = true)
        commandManager.start("file.txt")
        verify { commandManager.start("file.txt") }
    }
}