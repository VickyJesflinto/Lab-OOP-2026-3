import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam).");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return "Item [" + item.getTitle() + "] berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(LibraryItem item, int daysLate) {
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "Item [" + item.getTitle() + "] berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        System.out.println("Daftar item yang dipinjam oleh " + name + ":");
        
        // Format tabel langsung di sini
        int colId = 7;
        int colTitle = 20;

        StringBuilder sb = new StringBuilder();
        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2)).append("+\n");
        sb.append("| ").append(padRight("ID", colId)).append("| ").append(padRight("Judul", colTitle)).append(" |\n");
        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2)).append("+\n");

        for (LibraryItem item : borrowedItems) {
            sb.append("| ").append(padRight(String.valueOf(item.getItemId()), colId))
              .append("| ").append(padRight(item.getTitle(), colTitle)).append(" |\n");
        }

        sb.append("+").append("-".repeat(colId + 2)).append("+").append("-".repeat(colTitle + 2)).append("+");
        System.out.println(sb.toString());
    }

    // Helper method untuk padding
    private String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        return text + " ".repeat(length - text.length());
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public List<LibraryItem> getBorrowedItemsList() { return borrowedItems; }
}