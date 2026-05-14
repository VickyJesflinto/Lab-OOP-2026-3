import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;
    private static final DateTimeFormatter FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Internal log entry for structured display
    private List<String[]> logEntries; // [timestamp, title, member, returnedAt]

    public LibraryLogger() {
        this.logs = new ArrayList<>();
        this.logEntries = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String log = timestamp + " " + activity;
        logs.add(log);
        return log;
    }

    public void logBorrow(String timestamp, String title, String memberName) {
        logEntries.add(new String[]{timestamp, title, memberName, "-"});
    }

    public void logReturn(String title, String memberName, String returnTimestamp) {
        for (String[] entry : logEntries) {
            if (entry[1].equals(title) && entry[2].equals(memberName) && entry[3].equals("-")) {
                entry[3] = returnTimestamp;
                break;
            }
        }
    }

    public String getLogs() {
        if (logEntries.isEmpty()) {
            return "Tidak ada log aktivitas.";
        }

        int col1 = "Dipinjam pada".length();
        int col2 = "Judul".length();
        int col3 = "Member".length();
        int col4 = "Dikembalikan pada".length();

        for (String[] e : logEntries) {
            col1 = Math.max(col1, e[0].length());
            col2 = Math.max(col2, e[1].length());
            col3 = Math.max(col3, e[2].length());
            col4 = Math.max(col4, e[3].length());
        }

        String sep = "+" + "-".repeat(col1 + 2) + "+" + "-".repeat(col2 + 2)
                   + "+" + "-".repeat(col3 + 2) + "+" + "-".repeat(col4 + 2) + "+";
        String fmt = "| %-" + col1 + "s | %-" + col2 + "s | %-" + col3 + "s | %-" + col4 + "s |";

        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format(fmt, "Dipinjam pada", "Judul", "Member", "Dikembalikan pada")).append("\n");
        sb.append(sep).append("\n");
        for (String[] e : logEntries) {
            sb.append(String.format(fmt, e[0], e[1], e[2], e[3])).append("\n");
        }
        sb.append(sep);
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
        logEntries.clear();
    }

    public List<String> getRawLogs() { return logs; }

    public static String getCurrentTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }
}