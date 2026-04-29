package Soal1TUPRAK5;

public class Main {
    public static void main(String[] args) {
        KaryawanTetap aura = new KaryawanTetap("Aura", "tetap01", 3000000, 100000);
        KaryawanKontrak niki = new KaryawanKontrak("niki", "kontrak01", 200000);

        aura.hadir();
        aura.hadir();
        aura.hadir();
        System.out.println("Nama: " + aura.getNama());
        System.out.println("ID Karyawan: " + aura.getIdKaryawan());
        System.out.println("Gaji Karyawan Tetap dengan bonus: Rp" + aura.hitungGaji(100000));

        for (int i = 0; i < 24; i++) { 
             niki.hadir();
        }
        System.out.println("\nNama: " + niki.getNama());
        System.out.println("ID Karyawan: " + niki.getIdKaryawan());
        System.out.println("Gaji Karyawan Kontrak: Rp" + niki.hitungGaji());
    }
}