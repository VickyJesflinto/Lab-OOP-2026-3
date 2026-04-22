package Soal_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG\n");
        
        System.out.println("===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("----------------------------------------");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        System.out.println("----------------------------------------");

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double sKubus = scanner.nextDouble();
                if (sKubus <= 0) {
                    System.out.println("Sisi kubus harus lebih besar dari nol!");
                    break;
                }
                Kubus kubus = new Kubus(sKubus);
                System.out.println("Luas permukaan kubus: " + kubus.hitungLuasPermukaan());
                System.out.println("Volume kubus: " + kubus.hitungVolume());
                break;
            
            case 2:
                System.out.print("Masukkan panjang balok: ");
                double pBalok = scanner.nextDouble();
                System.out.print("Masukkan lebar balok: ");
                double lBalok = scanner.nextDouble();
                System.out.print("Masukkan tinggi balok: ");
                double tBalok = scanner.nextDouble();
                if (pBalok <= 0 || lBalok <= 0 || tBalok <= 0) {
                    System.out.println("Panjang, lebar, dan tinggi balok harus lebih besar dari nol!");
                    break;
                }
                Balok balok = new Balok(pBalok, lBalok, tBalok);
                System.out.println("Luas permukaan balok: " + balok.hitungLuasPermukaan());
                System.out.println("Volume balok: " + balok.hitungVolume());
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double rBola = scanner.nextDouble();
                if (rBola <= 0) {
                    System.out.println("Jari-jari bola harus lebih besar dari nol!");
                    break;
                }
                Bola bola = new Bola(rBola);
                System.out.println("Luas permukaan bola: " + bola.hitungLuasPermukaan());
                System.out.println("Volume bola: " + bola.hitungVolume());
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double rTabung = scanner.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tTabung = scanner.nextDouble();
                if (rTabung <= 0 || tTabung <= 0) {
                    System.out.println("Jari-jari dan tinggi tabung harus lebih besar dari nol!");
                    break;
                }
                Tabung tabung = new Tabung(rTabung, tTabung);
                System.out.println("Luas permukaan tabung: " + tabung.hitungLuasPermukaan());
                System.out.println("Volume tabung: " + tabung.hitungVolume());
                break;

            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sPersegi = scanner.nextDouble();
                if (sPersegi <= 0) {
                    System.out.println("Sisi persegi harus lebih besar dari nol!");
                    break;
                }
                Persegi persegi = new Persegi(sPersegi);
                System.out.println("Luas persegi: " + persegi.hitungLuas());
                System.out.println("Keliling persegi: " + persegi.hitungKeliling());
                break;

            case 6:
                System.out.print("Masukkan panjang persegi panjang: ");
                double pPP = scanner.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lPP = scanner.nextDouble();
                if (pPP <= 0 || lPP <= 0) {
                    System.out.println("Panjang dan lebar persegi panjang harus lebih besar dari nol!");
                    break;
                }

                PersegiPanjang pp = new PersegiPanjang(pPP, lPP);
                System.out.println("Luas persegi panjang: " + pp.hitungLuas());
                System.out.println("Keliling persegi panjang: " + pp.hitungKeliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rLingkaran = scanner.nextDouble();
                if (rLingkaran <= 0) {
                    System.out.println("Jari-jari lingkaran harus lebih besar dari nol!");
                    break;
                }
                Lingkaran lingkaran = new Lingkaran(rLingkaran);
                System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
                System.out.println("Keliling lingkaran: " + lingkaran.hitungKeliling());
                break;
                
            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = scanner.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = scanner.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = scanner.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = scanner.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tTrapesium = scanner.nextDouble();
                if (s1 <= 0 || s2 <= 0 || s3 <= 0 || s4 <= 0 || tTrapesium <= 0) {
                    System.out.println("Sisi dan tinggi trapesium harus lebih besar dari nol!");
                    break;
                }
                Trapesium trapesium = new Trapesium(s1, s2, s3, s4, tTrapesium);
                System.out.println("Luas trapesium: " + trapesium.hitungLuas());
                System.out.println("Keliling trapesium: " + trapesium.hitungKeliling());
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
        System.out.println("----------------------------------------");
        scanner.close();
    }
}