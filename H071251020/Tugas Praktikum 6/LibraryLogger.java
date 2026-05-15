import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;
    private List<LogEntry> borrowLogs; // Untuk menyimpan data peminjaman & pengembalian
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private class LogEntry {
        String borrowTime;
        String title;
        String memberName;
        String returnTime;

        LogEntry(String borrowTime, String title, String memberName) {
            this.borrowTime = borrowTime;
            this.title = title;
            this.memberName = memberName;
            this.returnTime = null;
        }

        void setReturnTime(String returnTime) {
            this.returnTime = returnTime;
        }
    }

    public LibraryLogger() {
        this.logs = new ArrayList<>();
        this.borrowLogs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    // Log peminjaman
    public String logBorrow(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        LogEntry entry = new LogEntry(timestamp, title, memberName);
        borrowLogs.add(entry);
        logActivity("[" + title + "] dipinjam oleh " + memberName);
        return timestamp + " [" + title + "] dipinjam oleh " + memberName;
    }

    // Log pengembalian
    public String logReturn(String title, String memberName) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        
        for (LogEntry entry : borrowLogs) {
            if (entry.title.equals(title) && entry.memberName.equals(memberName) && entry.returnTime == null) {
                entry.setReturnTime(timestamp);
                break;
            }
        }
        
        logActivity("[" + title + "] dikembalikan oleh " + memberName);
        return timestamp + " [" + title + "] dikembalikan oleh " + memberName;
    }

    public String getLogs() {
        if (borrowLogs.isEmpty()) {
            return "Belum ada log aktivitas.";
        }

        // Format tabel
        int colBorrow = 21;
        int colTitle = 25;
        int colMember = 13;
        int colReturn = 21;

        StringBuilder sb = new StringBuilder();
        sb.append("+").append("-".repeat(colBorrow + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colMember + 2)).append("+").append("-".repeat(colReturn + 2)).append("+\n");
        sb.append("| ").append(padRight("Dipinjam pada", colBorrow)).append("| ")
          .append(padRight("Judul", colTitle)).append("| ").append(padRight("Member", colMember))
          .append("| ").append(padRight("Dikembalikan pada", colReturn)).append(" |\n");
        sb.append("+").append("-".repeat(colBorrow + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colMember + 2)).append("+").append("-".repeat(colReturn + 2)).append("+\n");

        for (LogEntry entry : borrowLogs) {
            String returnTime = entry.returnTime != null ? entry.returnTime : "-";
            sb.append("| ").append(padRight(entry.borrowTime, colBorrow)).append("| ")
              .append(padRight(entry.title, colTitle)).append("| ").append(padRight(entry.memberName, colMember))
              .append("| ").append(padRight(returnTime, colReturn)).append(" |\n");
        }

        sb.append("+").append("-".repeat(colBorrow + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colMember + 2)).append("+").append("-".repeat(colReturn + 2)).append("+");
        
        return sb.toString();
    }

    private String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        return text + " ".repeat(length - text.length());
    }

    public void clearLogs() {
        logs.clear();
        borrowLogs.clear();
    }
}