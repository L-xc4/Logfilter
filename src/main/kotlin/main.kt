fun main(args: Array<String>) {

    val testLogs = LogService.loadLogsFromFile(args.getOrNull(0) ?: "log.txt")

    val sortedLogs = LogService.sortLogsByTimestamp(testLogs)


    val filteredLog = LogService.filterLogs(sortedLogs) { it.level == Config.filter}
    val report = LogService.createReport(filteredLog)

    print(report)

}