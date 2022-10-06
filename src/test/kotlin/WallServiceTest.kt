import org.junit.Test

import org.junit.Assert.*
import ru.netology.Post
import ru.netology.WallService
import ru.netology.WallService.add

class WallServiceTest {

    @Test
    fun addIfNotZero() {
        val postOne = Post()

        val result = add(postOne).id

        assertEquals(2, result)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(Post(2, 101, true, true, "New1", 1666222525))
        service.add(Post(3, 102, true, true, "New2", 1666222526))
        service.add(Post(4, 103, true, true, "New3", 1666222527))

        val update = Post(3, 102, true, true, "New2", 1666222526)

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(Post(2, 101, true, true, "New1", 1666222525))
        service.add(Post(3, 102, true, true, "New2", 1666222526))
        service.add(Post(4, 103, true, true, "New3", 1666222527))

        val update = Post(6, 102, true, true, "New2", 1666222526)

        val result = service.update(update)

        assertFalse(result)
    }
}