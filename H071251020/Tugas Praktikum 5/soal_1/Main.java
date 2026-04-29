public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOAL 1: SISTEM PENGGAJIAN & BONUS KINERJA ===\n");

        // 1. Karyawan Tetap
        System.out.println("1) Karyawan Tetap");
        KaryawanTetap karyawanTetap = new KaryawanTetap("Charice", "12345", 5000000, 50000);
        System.out.println("Mencatat kehadiran Karyawan Tetap sebanyak 20 hari...");
        for (int i = 0; i < 20; i++) {
            karyawanTetap.absen();
        }
        System.out.println("Total Gaji Karyawan Tetap (dengan bonus Rp 500.000): Rp " + karyawanTetap.hitungGaji(500000));

        System.out.println("\n----------------------------------------------------------------------------------\n");

        // 2. Karyawan Kontrak
        System.out.println("2) Karyawan Kontrak");
        KaryawanKontrak karyawanKontrak = new KaryawanKontrak("Glenn", "54321", 150000);
        System.out.println("Mencatat kehadiran Karyawan Kontrak sebanyak 25 hari...");
        for (int i = 0; i < 25; i++) {
            karyawanKontrak.absen();
        }
        System.out.println("Total Gaji Karyawan Kontrak (sudah termasuk bonus kehadiran): Rp " + karyawanKontrak.hitungGaji());
        System.out.println();
    }
}