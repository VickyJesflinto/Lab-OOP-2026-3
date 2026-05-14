package soal1;

public class Main {
    public static void main(String[] args) {

        KaryawanTetap kt = new KaryawanTetap("Kim Seon woo", "KT-001", 5000000, 30000);

        for (int i = 0; i < 18; i++) {
            kt.absen();
        }

        System.out.println("===== KARYAWAN TETAP =====");
        System.out.println("Nama        : " + kt.getNama());
        System.out.println("ID          : " + kt.getIdKaryawan());
        System.out.println("Kehadiran   : " + kt.getJumlahKehadiran() + " hari");
        System.out.printf("Gaji Pokok  : Rp%.0f%n", kt.hitungGaji());
        System.out.printf("Gaji+Bonus  : Rp%.0f%n", kt.hitungGaji(1500000));

        System.out.println();


        KaryawanKontrak kk = new KaryawanKontrak("Jaekyung", "KK-001", 200000);

        for (int i = 0; i < 22; i++) {
            kk.absen();
        }

        System.out.println("===== KARYAWAN KONTRAK =====");
        System.out.println("Nama        : " + kk.getNama());
        System.out.println("ID          : " + kk.getIdKaryawan());
        System.out.println("Kehadiran   : " + kk.getJumlahKehadiran() + " hari");
        System.out.printf("Total Gaji  : Rp%.0f%n", kk.hitungGaji());
    }
}