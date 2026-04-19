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

    fun loadLogsFromFile(path: String): List<LogEntry> {

        var testLogs = mutableListOf<LogEntry>()

        val file = File(path)
        val lines = file.readLines()

        for (line in lines) {
            val log = line.split(";")
            testLogs.add(LogEntry(log[0],log[1],log[2].toLong()))
        }

        return testLogs
    }
}