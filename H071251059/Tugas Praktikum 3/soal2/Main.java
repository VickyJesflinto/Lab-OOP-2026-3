package soal2;


public class Main {
    public static void main(String[] args) {

        // Membuat objek BukuDigital
        BukuDigital buku = new BukuDigital("BK001", "Pemrograman Java", 250);

        // Menampilkan data awal
        System.out.println("Judul: " + buku.getjudul());
        System.out.println("Status: " + (buku.isTersedia() ? "Tersedia" : "Dipinjam"));
        System.out.println();

        // Pinjam buku
        buku.pinjamBuku();
        System.out.println();

        // Coba pinjam lagi (harus gagal)
        buku.pinjamBuku();
        System.out.println();

        // Kembalikan buku
        buku.kembalikanBuku();
        System.out.println();

        // Ubah judul (gagal)
        buku.setjudul("");
        
        // Ubah judul (berhasil)
        buku.setjudul("Java Lanjutan");
    }
}
