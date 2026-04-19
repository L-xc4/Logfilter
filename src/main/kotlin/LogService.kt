import java.io.File

object LogService {

    fun filterLogs(logs: List<LogEntry>, condition: (LogEntry) -> Boolean): List<LogEntry> {
        val matchingList = mutableListOf<LogEntry>()
        for (element in logs) {
            if (condition(element)) {
                matchingList.add(element)
            }
        }
        return matchingList
    }

    // Diese Funktion macht NUR den Bericht-Job
    fun createReport(matchingList: List<LogEntry>): String {
        val report = StringBuilder("${Config.header}\n")
        for (element in matchingList) {
            report.append("[${element.level}] - ${element.timestamp}: ${element.message}\n")
        }
        return report.toString()
    }

    fun loadLogsFromFile(filePath: String): List<LogEntry> {
        val file = File(filePath)
        if (!file.exists()) {
            println("Fehler: Datei $filePath nicht gefunden!")
            return emptyList()
        }

        return file.readLines().mapNotNull { line ->
            val parts = line.split(";")

            // Fehlerfall 1: Zeile hat nicht genug Teile (Level;Nachricht;Zeitstempel)
            if (parts.size < 3) return@mapNotNull null

            val level = parts[0]
            val message = parts[1]

            // Fehlerfall 2: Zeitstempel ist keine gültige Zahl
            val timestamp = parts[2].toLongOrNull() ?: return@mapNotNull null

            LogEntry(level, message, timestamp)
        }
    }
}