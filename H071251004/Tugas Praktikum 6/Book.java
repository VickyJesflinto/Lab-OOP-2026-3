public class Book extends LibraryItem {
    private String author;

    private static final int Maksimal_Hari_Peminjaman = 14;
    private static final double Denda_Per_Hari_Keterlambatan = 10000;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > Maksimal_Hari_Peminjaman) {
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal " + Maksimal_Hari_Peminjaman + " hari.");
        }

        if (isBorrowed) {
            throw new IllegalArgumentException("Buku '" + title + "' sedang dipinjam dan belum dikembalikan.");
        }
        return "Item " + title + " berhasil dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0) return 0;
        return daysLate * Denda_Per_Hari_Keterlambatan;
    }

    public String getAuthor() {
        return author;
    }
}
