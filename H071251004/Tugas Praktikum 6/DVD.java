public class DVD extends LibraryItem {
    private int duration;

    private static final int Maksimal_Hari_Peminjaman = 7;
    private static final double Denda_Per_Hari_Keterlambatan = 25000;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", Durasi: " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > Maksimal_Hari_Peminjaman) {
            throw new IllegalArgumentException("DVD hanya bisa dipinjam maksimal " + Maksimal_Hari_Peminjaman + " hari.");
        }

        if (isBorrowed) {
            throw new IllegalArgumentException("DVD '" + title + "' sedang dipinjam dan belum dikembalikan.");
        }
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0) return 0;
        return daysLate * Denda_Per_Hari_Keterlambatan;
    }

    public int getDuration() {
        return duration;
    }
}
