fun main() {

    val testLogs = LogService.loadLogsFromFile("C:\\Users\\lpasc\\IdeaProjects\\Logfilter\\log.txt")




    val filteredLog = LogService.filterLogs(testLogs) { it.level == Config.filter}
    val report = LogService.createReport(filteredLog)

    print(report)

}