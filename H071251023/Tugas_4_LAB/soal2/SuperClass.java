package soal2;
import java.util.Scanner;
class product {
    protected String brand;
    protected int seriesnumber;
    double price;

    public product(String brand, int seriesnumber, double price) {
        this.brand = brand;
        this.seriesnumber = seriesnumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("╔═════════════════" + "═".repeat(50)                                                      + "╗");
        System.out.println("║ NAMA BRAND    : " + brand + " ".repeat(50-brand.length())                               + "║");
        System.out.println("║ SERIES NUMBER : " + seriesnumber + " ".repeat(50-String.valueOf(seriesnumber).length()) + "║");
        System.out.println("║ PRICE         : " +"Rp "+ price + " ".repeat(50-String.valueOf(price).length())               + "║");
        System.out.println("╚═════════════════" + "═".repeat(50)                                                      + "╝");
    }

    void validasi(int n){
        if (n <= 0) {
            System.out.println("Input tidak valid. Harap masukkan angka positif.");
        }
    }
}

class dekorasi {
    void DEKORASI(){
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║       MENU                     ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║  1. Tambah Produk              ║");
        System.out.println("║  2. Tampilkan Semua Produk     ║");
        System.out.println("║  3. Beli Produk                ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║  4. Exit                       ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Pilih Menu : ");
    }
    void tipe(){
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║       PILIH TIPE PRODUK        ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║  1. HP                         ║");
        System.out.println("║  2. Laptop                     ║");
        System.out.println("║  3. Camera                     ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Pilih Tipe : ");
    }
}

