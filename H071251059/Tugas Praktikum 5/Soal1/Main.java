package Soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("============================================================");
        System.out.println("              INPUT DATA KARYAWAN TETAP                    ");
        System.out.println("============================================================");
 
        System.out.print("Masukkan Nama Karyawan    : ");
        String namaKT = sc.nextLine();
 
        System.out.print("Masukkan ID Karyawan      : ");
        String idKT = sc.nextLine();
 
        System.out.print("Masukkan Gaji Pokok (Rp)  : ");
        double gajiPokok = sc.nextDouble();
 
        System.out.print("Masukkan Tunjangan Makan  : ");
        double tunjanganMakan = sc.nextDouble();
 
        System.out.print("Masukkan Jumlah Absen     : ");
        int absenKT = sc.nextInt();
 
        System.out.print("Masukkan Bonus Kinerja    : ");
        double bonusKinerja = sc.nextDouble();
        sc.nextLine();
 
        // Proses
        KaryawanTetap kt = new KaryawanTetap(namaKT, idKT, gajiPokok, tunjanganMakan);
        for (int i = 0; i < absenKT; i++) {
            kt.absen();
        }
 
        System.out.println();
        System.out.println("============================================================");
        System.out.println("              HASIL DATA KARYAWAN TETAP                    ");
        System.out.println("============================================================");
        System.out.println(kt);
        System.out.println("Bonus Kinerja: Rp" + String.format("%,.0f", bonusKinerja));
        System.out.println("Gaji + Bonus : Rp" + String.format("%,.0f", kt.hitungGaji(bonusKinerja)));
        System.out.println("============================================================");
 
        System.out.println();
 

        System.out.println("============================================================");
        System.out.println("             INPUT DATA KARYAWAN KONTRAK                   ");
        System.out.println("============================================================");
 
        System.out.print("Masukkan Nama Karyawan    : ");
        String namaKK = sc.nextLine();
 
        System.out.print("Masukkan ID Karyawan      : ");
        String idKK = sc.nextLine();
 
        System.out.print("Masukkan Upah Per Hari    : ");
        double upahPerHari = sc.nextDouble();
 
        System.out.print("Masukkan Jumlah Absen     : ");
        int absenKK = sc.nextInt();
 
        // Proses
        KaryawanKontrak kk = new KaryawanKontrak(namaKK, idKK, upahPerHari);
        for (int i = 0; i < absenKK; i++) {
            kk.absen();
        }
 
        System.out.println();
        System.out.println("============================================================");
        System.out.println("             HASIL DATA KARYAWAN KONTRAK                   ");
        System.out.println("============================================================");
        System.out.println(kk);
        System.out.println("============================================================");
 
        System.out.println();
 
        System.out.println("============================================================");
        System.out.println("              REKAP GAJI SEMUA KARYAWAN                    ");
        System.out.println("============================================================");
        Karyawan[] daftarKaryawan = {kt, kk};
        for (Karyawan k : daftarKaryawan) {
            System.out.printf("%-20s => Total Gaji: Rp%,.0f%n", k.getNama(), k.hitungGaji());
        }
        System.out.println("============================================================");
 
        sc.close();
    }
}
 

