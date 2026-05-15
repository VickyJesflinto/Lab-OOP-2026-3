import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public String getLibraryStatus() {
        int colId = 7;
        int colTitle = 20;
        int colStatus = 11;

        StringBuilder sb = new StringBuilder();
        sb.append("=== Status Perpustakaan ===\n\n");
        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colStatus + 2)).append("+\n");
        sb.append("| ").append(padRight("ID", colId)).append("| ").append(padRight("Judul", colTitle))
          .append("| ").append(padRight("Status", colStatus)).append(" |\n");
        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colStatus + 2)).append("+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append("| ").append(padRight(String.valueOf(item.getItemId()), colId)).append("| ")
              .append(padRight(item.getTitle(), colTitle)).append("| ").append(padRight(status, colStatus))
              .append(" |\n");
        }

        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2))
          .append("+").append("-".repeat(colStatus + 2)).append("+");
        
        return sb.toString();
    }

    private String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        return text + " ".repeat(length - text.length());
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() { return logger; }
    public void addMember(Member member) { members.add(member); }
    public List<Member> getMembers() { return members; }
    
    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) return member;
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan.");
    }
}