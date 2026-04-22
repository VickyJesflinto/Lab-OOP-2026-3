package soal1;

import java.util.Scanner;
class persegi{
    protected double sisi;
    persegi(){}
    persegi(double sisi){
        this.sisi = sisi;
    }

    void luas(){
        double luas = sisi * sisi;
        System.out.println("Luas Persegi: " + luas);
    }

    void keliling(){
        double keliling = 4 * sisi;
        System.out.println("Keliling Persegi: " + keliling);
    }

    void tampilkan(){
        System.out.println("\n");
        System.out.println(  "          PERSEGI         ");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan sisi kubus: ");
        double sisi = x.nextDouble();
        persegi k = new persegi(sisi);
        k.luas();
        k.keliling();
    }
}

class persegi_panjang{
    protected double panjang;
    protected double lebar;
    persegi_panjang(){}
    persegi_panjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    void luas(){
        double luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang: " + luas);
    }

    void keliling(){
        double keliling = 2 * (panjang + lebar);
        System.out.println("Keliling Persegi Panjang: " + keliling);
    }

    void tampilkan(){
        System.out.println("\n");
        System.out.println(  "     PERSEGI PANJANG     ");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan panjang : ");
        double sisi = x.nextDouble();
        System.out.print("Masukkan lebar   : ");
        double lebar = x.nextDouble();
        persegi_panjang k = new persegi_panjang(sisi, lebar);
        k.luas();
        k.keliling();
    }
}

class lingkaran{
    protected double jari_jari;
    lingkaran(){}
    lingkaran(double jari_jari){
        this.jari_jari = jari_jari;
    }

    void luas(){
        double luas = Math.PI * jari_jari * jari_jari;
        System.out.printf("Luas Lingkaran: %.2f\n",luas);
    }

    void keliling(){
        double keliling = 2 * Math.PI * jari_jari;
        System.out.printf("Keliling Lingkaran: %.2f\n", keliling);
    }

    void tampilkan(){
        System.out.println("\n");
        System.out.println(  "        LINGKARAN        ");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran : ");
        double r = x.nextDouble();
        lingkaran k = new lingkaran(r);
        k.luas();
        k.keliling();
    }
}

class trapesium {
    protected double sisi_a;
    protected double sisi_b;
    protected double sisi_c;
    protected double sisi_d;
    protected double tinggi;
    trapesium(){}
    trapesium(double sisi_a, double sisi_b, double sisi_c, double sisi_d, double tinggi){
        this.sisi_a = sisi_a;
        this.sisi_b = sisi_b;
        this.sisi_c = sisi_c;
        this.sisi_d = sisi_d;
        this.tinggi = tinggi;
    }

    void luas(){
        double luas = 0.5 * (sisi_a + sisi_b) * tinggi;
        System.out.println("Luas Trapesium: " + luas);
    }

    void keliling(){
        double keliling = sisi_a + sisi_b + sisi_c + sisi_d;
        System.out.println("Keliling Trapesium: " + keliling);
    }
    void tampilkan(){
        System.out.println("\n");
        System.out.println(  "        TRAPESIUM        ");
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan sisi 1 kubus: ");
        double sisi1 = x.nextDouble();
        System.out.print("Masukkan sisi 2 kubus: ");
        double sisi2 = x.nextDouble();
        System.out.print("Masukkan sisi 3 kubus: ");
        double sisi3 = x.nextDouble();
        System.out.print("Masukkan sisi 4 kubus: ");
        double sisi4 = x.nextDouble();
        System.out.print("Masukkan tinggi trapesium: ");
        double tinggi = x.nextDouble();
        trapesium k = new trapesium(sisi1, sisi2, sisi3, sisi4, tinggi);
        k.luas();
        k.keliling();
    }
}
