package soal1;

public class MainGaji {
    public static void main(String[] args) {
        KaryawanTetap kt = new KaryawanTetap("selena", "S01", 4000000, 50000);
        kt.absen();
        kt.absen();
        kt.absen();
        System.out.println("Total Gaji Tetap (Selena): " + kt.hitungGaji(1000000));

        KaryawanKontrak kk = new KaryawanKontrak("oliver", "O01", 200000);
        for (int i = 0; i < 19; i++) {
            kk.absen();
        }
        System.out.println("Total Gaji Kontrak (Oliver): " + kk.hitungGaji());
    }
}