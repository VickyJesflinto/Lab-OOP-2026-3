import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("----------------------------------------");
            System.out.println("===== BANGUN RUANG =====");
            System.out.println("1. KUBUS");
            System.out.println("2. BALOK");
            System.out.println("3. BOLA");
            System.out.println("4. TABUNG");
            System.out.println();
            System.out.println("===== BANGUN DATAR =====");
            System.out.println("5. PERSEGI");
            System.out.println("6. PERSEGI PANJANG");
            System.out.println("7. LINGKARAN");
            System.out.println("8. TRAPESIUM");
            System.out.println("----------------------------------------");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan sisi kubus: ");
                    double sisiKubus = input.nextDouble();
                    Kubus kubus = new Kubus(sisiKubus);
                    System.out.println("Luas permukaan kubus: " + kubus.hitungLuasPermukaan());
                    System.out.println("Volume kubus: " + kubus.hitungVolume());
                    break;
                case 2:
                    System.out.print("Masukkan panjang balok: ");
                    double p = input.nextDouble();
                    System.out.print("Masukkan lebar balok: ");
                    double l = input.nextDouble();
                    System.out.print("Masukkan tinggi balok: ");
                    double t = input.nextDouble();
                    Balok balok = new Balok(p, l, t);
                    System.out.println("Luas permukaan balok: " + balok.hitungLuasPermukaan());
                    System.out.println("Volume balok: " + balok.hitungVolume());
                    break;
                case 3:
                    System.out.print("Masukkan jari-jari bola: ");
                    double rBola = input.nextDouble();
                    Bola bola = new Bola(rBola);
                    System.out.println("Luas permukaan bola: " + bola.hitungLuasPermukaan());
                    System.out.println("Volume bola: " + bola.hitungVolume());
                    break;
                case 4:
                    System.out.print("Masukkan jari-jari tabung: ");
                    double rTabung = input.nextDouble();
                    System.out.print("Masukkan tinggi tabung: ");
                    double tTabung = input.nextDouble();
                    Tabung tabung = new Tabung(rTabung, tTabung);
                    System.out.println("Luas permukaan tabung: " + tabung.hitungLuasPermukaan());
                    System.out.println("Volume tabung: " + tabung.hitungVolume());
                    break;
                case 5:
                    System.out.print("Masukkan sisi persegi: ");
                    double sisiPersegi = input.nextDouble();
                    Persegi persegi = new Persegi(sisiPersegi);
                    System.out.println("Luas persegi: " + persegi.hitungLuas());
                    System.out.println("Keliling persegi: " + persegi.hitungKeliling());
                    break;
                case 6:
                    System.out.print("Masukkan panjang persegi panjang: ");
                    double pp = input.nextDouble();
                    System.out.print("Masukkan lebar persegi panjang: ");
                    double lp = input.nextDouble();
                    PersegiPanjang persegipanjang = new PersegiPanjang(pp, lp);
                    System.out.println("Luas persegi panjang: " + persegipanjang.hitungLuas());
                    System.out.println("Keliling persegi panjang: " + persegipanjang.hitungKeliling());
                    break;
                case 7:
                    System.out.print("Masukkan jari-jari lingkaran: ");
                    double rLingkaran = input.nextDouble();
                    Lingkaran lingkaran = new Lingkaran(rLingkaran);
                    System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
                    System.out.println("Keliling lingkaran: " + lingkaran.hitungKeliling());
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
                    double tTrapesium = input.nextDouble();
                    Trapesium trapesium = new Trapesium(s1, s2, s3, s4, tTrapesium);
                    System.out.println("Luas trapesium: " + trapesium.hitungLuas());
                    System.out.println("Keliling trapesium: " + trapesium.hitungKeliling());
                    break;
                default:
                    if (pilihan != 0) {
                        System.out.println("Pilihan tidak valid!");
                    }
            }
            System.out.println("----------------------------------------\n");
        } while (pilihan != 0);

        input.close();
    }
}