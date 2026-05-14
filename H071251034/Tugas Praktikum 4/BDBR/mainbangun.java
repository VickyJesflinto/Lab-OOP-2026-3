package BDBR;

import java.util.Scanner;

public class mainbangun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("======== BANGUN RUANG ========");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println("\n======== BANGUN DATAR ========");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("------------------------------");
        System.out.print("Pilih bangun datar atau bangun ruang: ");
        int pilihan = input.nextInt();
        
        switch(pilihan) {
            case 1:
                System.out.print("Masukkan panjang sisi: ");
                double sisiKubus = input.nextDouble();
                Kubus kubus = new Kubus(sisiKubus);
                kubus.hitungLuas();
                kubus.hitungVolume();
                break;
                
            case 2:
                System.out.print("Masukkan panjang: ");
                double pBalok = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lBalok = input.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double tBalok = input.nextDouble();
                Balok balok = new Balok(pBalok, lBalok, tBalok);
                balok.hitungLuas();
                balok.hitungVolume();
                break;
                
            case 3:
                System.out.print("Masukkan jari-jari: ");
                double rBola = input.nextDouble();
                Bola bola = new Bola(rBola);
                bola.hitungLuas();
                bola.hitungVolume();
                break;
                
            case 4:
                System.out.print("Masukkan jari-jari: ");
                double rTabung = input.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double tTabung = input.nextDouble();
                Tabung tabung = new Tabung(rTabung, tTabung);
                tabung.hitungLuas();
                tabung.hitungVolume();
                break;
                
            case 5:
                System.out.print("Masukkan panjang sisi: ");
                double sisiPersegi = input.nextDouble();
                Persegi persegi = new Persegi(sisiPersegi);
                persegi.hitungLuas();
                persegi.hitungKeliling();
                break;
                
            case 6:
                System.out.print("Masukkan panjang: ");
                double pPersegiPanjang = input.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lPersegiPanjang = input.nextDouble();
                PersegiPanjang pp = new PersegiPanjang(pPersegiPanjang, lPersegiPanjang);
                pp.hitungLuas();
                pp.hitungKeliling();
                break;
                
            case 7:
                System.out.print("Masukkan jari-jari: ");
                double rLingkaran = input.nextDouble();
                Lingkaran lingkaran = new Lingkaran(rLingkaran);
                lingkaran.hitungLuas();
                lingkaran.hitungKeliling();
                break;
                
            case 8: 
                System.out.print("Masukkan sisi 1: ");
                double s1 = input.nextDouble();
                System.out.print("Masukkan sisi 2: ");
                double s2 = input.nextDouble();
                System.out.print("Masukkan sisi 3: ");
                double s3 = input.nextDouble();
                System.out.print("Masukkan sisi 4: ");
                double s4 = input.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double t = input.nextDouble();
                
                Trapesium trapesium = new Trapesium(s1, s2, s3, s4, t);
                trapesium.hitungLuas();
                trapesium.hitungKeliling();
                break;
                
            default:
                System.out.println("Pilihan tidak valid.");
        }
        input.close();
    }
}