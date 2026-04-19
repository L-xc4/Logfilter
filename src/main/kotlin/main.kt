fun main() {

    val testLogs = listOf(
        LogEntry("INFO", "System erfolgreich gestartet", 1712345600000L),
        LogEntry("ERROR", "Datenbankverbindung fehlgeschlagen", 1712345660000L),
        LogEntry("INFO", "Benutzer 'Admin' hat sich eingeloggt", 1712345720000L),
        LogEntry("ERROR", "Speicherlimit erreicht", 1712345780000L),
        LogEntry("WARN", "Latenz der API ist zu hoch", 1712345840000L),
        LogEntry("ERROR", "Unerwarteter Null-Pointer in Modul B", 1712345900000L)
    )





    val filteredLog = LogService.filterLogs(testLogs) { it.level == Config.filter}
    val report = LogService.createReport(filteredLog)

    print(report)

}