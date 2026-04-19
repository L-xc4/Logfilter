fun main(args: Array<String>) {

    val source: LogSource = FileLogSource(args.getOrNull(0) ?: "log.txt")

    val allLogs = source.load()

    val sortedLogs = LogService.sortLogsByTimestamp(allLogs)


    val filteredLog = LogService.filterLogs(sortedLogs) { it.level == Config.filter}
    val report = LogService.createReport(filteredLog)

    LogService.saveReportToFile(report, args.getOrNull(1) ?: "report.txt" )
    print(report)

}