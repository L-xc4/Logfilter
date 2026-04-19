import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test



class LogServiceTest {
    @Test
    fun `filterLogs should return only errors when condition matches`() {
        // 1. Arrange (Daten vorbereiten)
        val data = listOf(
            LogEntry("INFO", "Alles ok", 1L),
            LogEntry("ERROR", "Fehler!", 2L)
        )

        // 2. Act (Die Funktion aufrufen)
        val result = LogService.filterLogs(data) { it.level == "ERROR" }

        // 3. Assert (Prüfen: Erwarten wir 1 Ergebnis?)
        assertEquals(1, result.size)
    }

    @Test
    fun `filterLogs should return empty string with no  matching data`() {
        // 1. Arrange (Daten vorbereiten)
        val data = listOf(
            LogEntry("INF", "Alles ok", 1L),
            LogEntry("INFO", "Fehler!", 2L)
        )

        // 2. Act (Die Funktion aufrufen)
        val result = LogService.filterLogs(data) { it.level == "ERROR" }
        val report = LogService.createReport(result)

        // 3. Assert (Prüfen: Erwarten wir 1 Ergebnis?)
        assertEquals("Berichtanfang:\n", report)
    }

}