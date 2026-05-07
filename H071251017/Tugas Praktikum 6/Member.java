import java.util.ArrayList;
import java.util.List;

public class Member {
     String name;
     int memberId;
     List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " tidak tersedia (sudah dipinjam).");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!item.isBorrowed) {
            throw new IllegalStateException("Item " + item.title + " tidak terpinjam.");
        }
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %,.0f", item.title, fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+------+----------------------+");
        System.out.printf("| %-4s | %-20s |%n", "ID", "Judul");
        System.out.println("+------+----------------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-20s |%n", item.itemId, item.title);
        }
        System.out.println("+------+----------------------+");
    }
}
