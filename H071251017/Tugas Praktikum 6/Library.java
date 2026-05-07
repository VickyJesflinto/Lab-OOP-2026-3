import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
     List<LibraryItem> items;
     List<Member> members;
     LibraryLogger logger;
     static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        boolean isAdded = false;
        for (LibraryItem library_item: items) {
            if (library_item.itemId == item.itemId) {
                isAdded = true;
            }
        }

        if (isAdded) {
            throw new IllegalStateException("Item dengan id tersebut sudah ada");
        }

        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        boolean isAdded = false;
        for (Member library_member: members) {
            if (library_member.memberId == member.memberId) {
                isAdded = true;
            }
        }

        if (isAdded) {
            throw new IllegalStateException("Member dengan ID tersebut sudah ada");
        }

        members.add(member);
        return "Anggota " + member.name + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.memberId == memberId) return m;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.borrow(item, days);
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logger.logBorrow(timestamp, item.title, member.name);
        return result;
    }

    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        String result = member.returnItem(item, daysLate);
        String timestamp = LocalDateTime.now().format(FORMATTER);
        logger.logReturn(item.title, member.name, timestamp);
        return result;
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) return "Tidak ada item di perpustakaan.";
        int colId = 4, colJudul = 30, colStatus = 10;
        String sep = "+" + "-".repeat(colId + 2) + "+" + "-".repeat(colJudul + 2) + "+" + "-".repeat(colStatus + 2) + "+";
        StringBuilder sb = new StringBuilder();
        sb.append(sep).append("\n");
        sb.append(String.format("| %-" + colId + "s | %-" + colJudul + "s | %-" + colStatus + "s |%n", "ID", "Judul", "Status"));
        sb.append(sep).append("\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-" + colId + "d | %-" + colJudul + "s | %-" + colStatus + "s |%n",
                    item.itemId, item.title, status));
        }
        sb.append(sep);
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}
