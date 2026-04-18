object LogService {

    fun filterLogs(logs: List<LogEntry>, condition: (LogEntry) -> Boolean): String {
        val matchingList = mutableListOf<LogEntry>()
        for (element in logs) {
            if (condition(element)) {
                matchingList.add(element)
            }
        }
        val report = createReport(matchingList)
       return report
    }

    fun createReport(matchingList: List<LogEntry>): String {
        val report = StringBuilder("${Config.header}\n")
        for (element in matchingList) {
            report.append("[${element.level}] - ${element.timestamp}: ${element.message}\n")
        }
        return report.toString()
    }

}