import java.io.File

class FileLogSource(private val filePath: String) : LogSource  {
    override fun load(): List<LogEntry> {
        val file = File(filePath)
        if (!file.exists()) {
            println("Fehler: Datei $filePath nicht gefunden!")
            return emptyList()
        }

        return file.readLines().mapNotNull { line ->
            val parts = line.split(";")
            if (parts.size < 3) return@mapNotNull null

            val timestamp = parts[2].toLongOrNull() ?: return@mapNotNull null
            LogEntry(parts[0], parts[1], timestamp)
        }
    }
}