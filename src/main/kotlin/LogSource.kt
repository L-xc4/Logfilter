interface LogSource {
    fun load(): List<LogEntry>
}