import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class LibraryLogger {
    private List<String> logs;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private List<String[]> logDetails;

    public LibraryLogger() {
        this.logs = new ArrayList<>();
        this.logDetails = new ArrayList<>();
    }

    public String logActivity(String activity) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(FORMATTER);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public void logBorrow(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logDetails.add(new String[]{timestamp, title, memberName, "-"});

        String itemType = "Item";
        logs.add(timestamp + " " + itemType + " '" + title + "' dipinjam oleh " + memberName);
    }

    public void logReturn(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(FORMATTER);

        for (String[] detail : logDetails) {
            if (detail[1].equals(title) && detail[2].equals(memberName) && detail[3].equals("-")) {
                detail[3] = timestamp;
                break;
            }
        }

        logs.add(timestamp + " Item '" + title + "' dikembalikan oleh " + memberName);
    }

    public String getLogs() {
        if (logDetails.isEmpty()) {
            return "Belum ada log aktivitas.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("+----------------------+--------------------------------+-----------------+----------------------+\n");
        sb.append(String.format("| %-20s | %-30s | %-15s | %-20s |\n",
            "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append("+----------------------+--------------------------------+-----------------+----------------------+\n");
        for (String[] detail : logDetails) {
            sb.append(String.format("| %-20s | %-30s | %-15s | %-20s |\n",
                detail[0], 
                detail[1], 
                detail[2], 
                detail[3]));
        }

        sb.append("+----------------------+--------------------------------+-----------------+----------------------+\n");
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
        logDetails.clear();
    }

    public List<String> getLogEntries() {
        return logs;
    }
}
