fun main() {

    val testLogs = listOf(
        LogEntry("INFO", "System erfolgreich gestartet", 1712345600000L),
        LogEntry("ERROR", "Datenbankverbindung fehlgeschlagen", 1712345660000L),
        LogEntry("INFO", "Benutzer 'Admin' hat sich eingeloggt", 1712345720000L),
        LogEntry("ERROR", "Speicherlimit erreicht", 1712345780000L),
        LogEntry("WARN", "Latenz der API ist zu hoch", 1712345840000L),
        LogEntry("ERROR", "Unerwarteter Null-Pointer in Modul B", 1712345900000L)
    )


    fun filterLogs(logs: List<LogEntry>, condition: (LogEntry) -> Boolean): List<LogEntry> {
        val matchingList = mutableListOf<LogEntry>()
        for (element in logs) {
            if (condition(element)) {
                matchingList.add(element)
            }
        }
       return matchingList
     }

    fun createReport(matchingList: List<LogEntry>): String {
       val report = StringBuilder("${config.header}\n")
        for (element in matchingList) {
            report.append("[${element.level}] ${element.message}\n")
        }
        return report.toString()
    }



    val report = createReport(filterLogs(testLogs) { it.level == config.filter})


    print(report)

}