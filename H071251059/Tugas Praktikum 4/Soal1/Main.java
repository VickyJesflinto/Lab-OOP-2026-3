package Soal1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println(" ======= BANGUN RUANG =======");
        System.out.println("1. Kubus\n2. Bola\n3. Balok\n4. Tabung");
        System.out.println(" ======= BANGUN DATAR =======");
        System.out.println("5. Persegi\n6. Persegi Panjang\n7. Lingkaran\n8. Trapesium");
        System.out.println("-----------------------------");
        System.out.print("Pilih Menu: ");
        int pilihan = input.nextInt();
        System.out.println("-----------------------------");

        switch(pilihan) {
            case 1:
                System.out.print("Masukkan Sisi Kubus: ");
                double s = input.nextDouble();
                Kubus k = new Kubus(s);
                System.out.println("Volume Kubus: " + k.hitungVolume());
                System.out.println("Luas Permukaan Kubus: " + k.hitungLuasPermukaan());
                break;

            case 2:
                System.out.print("Masukkan Jari-Jari Bola: ");
                double rBola = input.nextDouble();
                Bola b = new Bola(rBola);
                System.out.printf("Volume Bola: " + b.hitungVolume());
                System.out.printf("Luas Permukaan Bola: " + b.hitungLuasPermukaan());
                break;

            case 3:
                System.out.print("Masukkan Panjang Balok: ");
                double pBalok = input.nextDouble();
                System.out.print("Masukkan Lebar Balok: ");
                double lBalok = input.nextDouble();
                System.out.print("Masukkan Tinggi Balok: ");
                double tBalok = input.nextDouble();
                Balok bl = new Balok(pBalok, lBalok, tBalok);
                System.out.println("Volume Balok: " + bl.hitungVolume());
                System.out.println("Luas Permukaan Balok: " + bl.hitungLuasPermukaan());
                break;

            case 4:
                System.out.print("Masukkan Jari-Jari Alas Tabung: ");
                double rTabung = input.nextDouble();
                System.out.print("Masukkan Tinggi Tabung: ");
                double tTabung = input.nextDouble();
                Tabung t = new Tabung(rTabung, tTabung);
                System.out.printf("Volume Tabung: " + t.hitungVolume());
                System.out.printf("Luas Permukaan Tabung: " + t.hitungLuasPermukaan());
                break;

            case 5:
                System.out.print("Masukkan Sisi Persegi: ");
                double sisi = input.nextDouble();
                Persegi p = new Persegi(sisi);
                System.out.println("Luas Persegi: " + p.hitungLuas());
                System.out.println("Keliling Persegi: " + p.hitungKeliling());
                break;

            case 6:
                System.out.print("Masukkan Panjang Persegi Panjang: ");
                double panjang = input.nextDouble();
                System.out.print("Masukkan Lebar Persegi Panjang: ");
                double lebar = input.nextDouble();
                PersegiPanjang pP = new PersegiPanjang(panjang, lebar);
                System.out.println("Luas Persegi Panjang: " + pP.hitungLuas());
                System.out.println("Keliling Persegi Panjang: " + pP.hitungKeliling());
                break;
            
            case 7:
                System.out.print("Masukkan Jari-Jari Lingkaran: ");
                double r = input.nextDouble();
                Lingkaran l = new Lingkaran(r);
                System.out.printf("Luas Lingkaran: " + l.hitungLuas());
                System.out.printf("Keliling Lingkaran: " + l.hitungKeliling());
                break;

            case 8:
                System.out.print("Masukkan Sisi 1 Trapesium: ");
                double a = input.nextDouble();
                System.out.print("Masukkan Sisi 2 Trapesium: ");
                double bTrapesium = input.nextDouble();
                System.out.print("Masukkan Sisi 3 Trapesium: ");
                double c = input.nextDouble();
                System.out.print("Masukkan Sisi 4 Trapesium: ");
                double d = input.nextDouble();
                System.out.print("Masukkan Tinggi Trapesium: ");
                double tTrapesium = input.nextDouble();
                Trapesium tr = new Trapesium(a, bTrapesium, c, d, tTrapesium);
                System.out.println("Luas Trapesium adalah " + tr.hitungLuas());
                System.out.println("Keliling Trapesium adalah " + tr.hitungKeliling());
                break;

        default:
                System.out.println("Pilihan Tidak Tersedia!");
        }
    }
}