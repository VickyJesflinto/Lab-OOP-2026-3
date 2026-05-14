package Soal01;

public class MainPenggajian {
    public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap("Kenneth", "KT-001", 5000000, 20000);

        for (int i = 0; i < 10; i++) {
            kt.absen();
        }
        double gajiDenganBonus = kt.hitungGaji(1500000);
        
        System.out.println("\n====== Karyawan Tetap ======");
        System.out.println("Nama: " + kt.getNama() + " (" + kt.getIdKaryawan() + ")");
        System.out.println("kehadiran: " + kt.getJumlahKehadiran() + " hari");
        System.out.println("Gaji + Bonus: Rp" + String.format("%,.0f", gajiDenganBonus));

        KaryawanKontrak kk = new KaryawanKontrak("Key", "KK-002", 200000);

        for (int i = 0; i < 21; i++) {
            kk.absen();
        }
        double totalGajiKontrak = kk.hitungGaji();
        
        System.out.println("\n====== Karyawan Kontrak ======");
        System.out.println("Nama: " + kk.getNama() + " (" + kk.getIdKaryawan() + ")");
        System.out.println("kehadiran: " + kk.getJumlahKehadiran() + " hari");
        System.out.println("Total Gaji: Rp" + String.format("%,.0f", totalGajiKontrak));

    }
}