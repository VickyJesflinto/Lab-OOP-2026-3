public class Main1 {
    public static void main(String[] args) {
        BukuDigital buku = new BukuDigital("B001", "Pemrograman Java", 250);

        System.out.println("Judul: " + buku.getJudul());
        System.out.println("Status: " + (buku.isTersedia() ? "Tersedia" : "Tidak tersedia"));

        System.out.println();

        buku.pinjamBuku();
        buku.pinjamBuku();

        System.out.println();

        buku.kembalikanBuku();

        System.out.println();

        buku.setJudul(""); 
    }
}