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
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                return m;
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan.");
    }

    public String addMember(Member member) {
        members.add(member);
        return "Anggota " + member.getName() + " berhasil ditambahkan";
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days);
        String timestamp = LibraryLogger.getCurrentTimestamp();
        String type = (item instanceof Book) ? "Buku" : "DVD";
        logger.logActivity(timestamp + " [" + type + "] " + item.getTitle() + " dipinjam oleh " + member.getName());
        logger.logBorrow(timestamp, item.getTitle(), member.getName());
        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        String timestamp = LibraryLogger.getCurrentTimestamp();
        String type = (item instanceof Book) ? "Buku" : "DVD";
        logger.logActivity(timestamp + " [" + type + "] " + item.getTitle() + " dikembalikan oleh " + member.getName());
        logger.logReturn(item.getTitle(), member.getName(), timestamp);
        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Tidak ada item di perpustakaan.";
        }

        int idWidth = 2;
        int titleWidth = 5;
        int statusWidth = 6;
        for (LibraryItem item : items) {
            idWidth = Math.max(idWidth, String.valueOf(item.getItemId()).length());
            titleWidth = Math.max(titleWidth, item.getTitle().length());
        }
        String sep = "+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(titleWidth + 2)
                   + "+" + "-".repeat(statusWidth + 2) + "+";
        String fmt = "| %-" + idWidth + "s | %-" + titleWidth + "s | %-" + statusWidth + "s |";

        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format(fmt, "ID", "Judul", "Status")).append("\n");
        sb.append(sep).append("\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format(fmt, item.getItemId(), item.getTitle(), status)).append("\n");
        }
        sb.append(sep);
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<Member> getMembers() { return members; }
    public List<LibraryItem> getItems() { return items; }
}
