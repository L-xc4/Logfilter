fun main() {

    val testLogs = LogService.loadLogsFromFile("log.txt")

    val sorteLogs = LogService.sortLogsByTimestamp(testLogs)


    val filteredLog = LogService.filterLogs(sorteLogs) { it.level == Config.filter}
    val report = LogService.createReport(filteredLog)

    print(report)

}