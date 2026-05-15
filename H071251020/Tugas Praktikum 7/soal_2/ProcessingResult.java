public class ProcessingResult {
    public final String fileName;
    public final String threadName;
    public final long durationMs;
    public final int wordCount;

    public ProcessingResult(String fileName, String threadName, long durationMs, int wordCount) {
        this.fileName = fileName;
        this.threadName = threadName;
        this.durationMs = durationMs;
        this.wordCount = wordCount;
    }
}