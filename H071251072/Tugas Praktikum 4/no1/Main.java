package no1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");

        System.out.println("\n===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("======================================");

        System.out.print("Pilihan: ");
        int pilih = input.nextInt();

        switch (pilih) {

           
            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double s = input.nextDouble();
                Kubus k = new Kubus(s);
                System.out.println("Volume: " + k.volume());
                System.out.println("Luas Permukaan: " + k.LuasPermukaan());
                break;

            case 2:
                System.out.print("Masukkan panjang: ");
                double p = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double l = input.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double t = input.nextDouble();
                Balok b = new Balok(p, l, t);
                System.out.println("Volume: " + b.volume());
                System.out.println("Luas Permukaan: " + b.LuasPermukaan());
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double r = input.nextDouble();
                Bola bola = new Bola(r);
                System.out.println("Volume: " + bola.volume());
                System.out.println("Luas Permukaan: " + bola.LuasPermukaan());
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double rt = input.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tt = input.nextDouble();
                Tabung tabung = new Tabung(rt, tt);
                System.out.println("Volume: " + tabung.volume());
                System.out.println("Luas Permukaan: " + tabung.LuasPermukaan());
                break;

            
            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sp = input.nextDouble();
                Persegi ps = new Persegi(sp);
                System.out.println("Luas: " + ps.luas());
                System.out.println("Keliling: " + ps.keliling());
                break;

            case 6:
                System.out.print("Masukkan panjang: ");
                double pp = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lp = input.nextDouble();
                PersegiPanjang psp = new PersegiPanjang(pp, lp);
                System.out.println("Luas: " + psp.luas());
                System.out.println("Keliling: " + psp.keliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rl = input.nextDouble();
                Lingkaran ling = new Lingkaran(rl);
                System.out.println("Luas: " + ling.luas());
                System.out.println("Keliling: " + ling.keliling());
                break;

            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = input.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = input.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = input.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = input.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tinggi = input.nextDouble();

                Trapesium tr = new Trapesium(s1, s2, s3, s4, tinggi);
                System.out.println("Luas trapesium: " + tr.luas());
                System.out.println("Keliling trapesium: " + tr.keliling());
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}