import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
     List<String[]> logs;
     static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String entry = timestamp + " " + activity;
        logs.add(new String[]{entry, null, null, null, null});
        return entry;
    }

    public void logBorrow(String timestamp, String title, String memberName) {
        logs.add(new String[]{"BORROW", timestamp, title, memberName, "-"});
    }

    public void logReturn(String title, String memberName, String returnTimestamp) {
        for (String[] log : logs) {
            if ("BORROW".equals(log[0]) && log[2].equals(title) && log[3].equals(memberName) && "-".equals(log[4])) {
                log[4] = returnTimestamp;
                return;
            }
        }
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log aktivitas.";
        int colDipinjam = 20, colJudul = 35, colMember = 15, colDikembalikan = 20;
        String sep = "+" + "-".repeat(colDipinjam + 2) + "+" + "-".repeat(colJudul + 2)
                + "+" + "-".repeat(colMember + 2) + "+" + "-".repeat(colDikembalikan + 2) + "+";
        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format("| %-" + colDipinjam + "s | %-" + colJudul + "s | %-" + colMember + "s | %-" + colDikembalikan + "s |%n",
                "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append(sep).append("\n");
        for (String[] log : logs) {
            if ("BORROW".equals(log[0])) {
                sb.append(String.format("| %-" + colDipinjam + "s | %-" + colJudul + "s | %-" + colMember + "s | %-" + colDikembalikan + "s |%n",
                        log[1], log[2], log[3], log[4]));
            }
        }
        sb.append(sep);
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}
