import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class FileLogSourceTest {

    @Test
    fun `FileLogSourceTest part of  LogSource`() {
        // 1. Arrange (Daten vorbereiten)

        val source = FileLogSource("text.txt")

        assertEquals(true, source is LogSource)
    }

}