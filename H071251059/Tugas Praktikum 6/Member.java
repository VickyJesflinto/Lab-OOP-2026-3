import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberID;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia: " + item.getTitle() + " Sudah dipinjam. ");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return ("Item" + item.getTitle() + " berhasil dipinjam selama " + days + " hari ");
    }

    public String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return ("Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine).replace(",", "."));
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        int idWidth = 4;
        int titleWidth = 10;
        for (LibraryItem item : borrowedItems) {
            idWidth = Math.max(idWidth, String.valueOf(item.getItemId()).length());
            titleWidth = Math.max(titleWidth, item.getTitle().length());
        }
        String separator = "+" + "-".repeat(idWidth + 2) + "+" + "-".repeat(titleWidth + 2) + "+";
        String format = "| %-" + idWidth + "s | %-" + titleWidth + "s |";
        System.out.println(separator);
        System.out.printf((format) + "%n", "ID", "Judul");
        System.out.println(separator);
        for (LibraryItem item : borrowedItems) {
            System.out.printf((format) + "%n", item.getItemId(), item.getTitle());
        }
        System.out.println(separator);
    }
    public String getName() { 
        return name; 
    }
    public int getMemberId() { 
        return memberID; 
    }
    public List<LibraryItem> getBorrowedItemsList() { 
        return borrowedItems;
    }
}