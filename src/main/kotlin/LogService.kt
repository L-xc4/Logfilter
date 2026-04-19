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


    fun sortLogsByTimestamp(logs: List<LogEntry>): List<LogEntry> {
        val sortedLogs = logs.sortedBy { it.timestamp }
        return sortedLogs
    }

    fun searchLogs(logs: List<LogEntry>, keyword: String): List<LogEntry> {

        return logs.filter{ it.toString().contains(keyword, ignoreCase = true)}
    }

    fun saveReportToFile(report: String, filePath: String) {
        try {
            File(filePath).writeText(report)
        } catch (e: Exception) {
            println("Keine Schreibrechte im Ordner")
        }
    }
}