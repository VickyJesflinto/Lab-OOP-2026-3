package Soal_2;
import java.util.ArrayList;
import java.util.Scanner;

public class TokoElektronik {
 
    static ArrayList<Produk> stok = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
 
    public static void main(String[] args) {
 
        int pilihan;
        do {
            tampilMenu();
            System.out.print(">>> Pilih menu (1-4): ");
            pilihan = input.nextInt();
            input.nextLine();
 
            switch (pilihan) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    tampilkanSemuaProduk();
                    break;
                case 3:
                    beliProduk();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
            }
        } while (pilihan != 4);
 
        input.close();
    }
 
    static void tampilMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }
 
    static void tambahProduk() {
        System.out.print("Masukkan nama produk : ");
        String merek = input.nextLine();
        System.out.print("Masukkan nomor seri  : ");
        int nomor = input.nextInt();
        System.out.print("Masukkan harga       : ");
        double harga = input.nextDouble();
        input.nextLine();
 
        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Kamera");
        System.out.print("Pilih tipe produk (1-3): ");
        int tipe = input.nextInt();
        input.nextLine();
 
        switch (tipe) {
            case 1:
                System.out.print("Masukkan ukuran layar (inci)        : ");
                double layar = input.nextDouble();
                System.out.print("Masukkan kapasitas penyimpanan (GB) : ");
                int penyimpanan = input.nextInt();
                input.nextLine();
                stok.add(new Smartphone(merek, nomor, harga, layar, penyimpanan));
                System.out.println("Smartphone berhasil ditambahkan.");
                break;

            case 2:
                System.out.print("Masukkan tipe prosesor   : ");
                String prosesor = input.nextLine();
                System.out.print("Masukkan ukuran RAM (GB) : ");
                int ram = input.nextInt();
                input.nextLine();
                stok.add(new Laptop(merek, nomor, harga, prosesor, ram));
                System.out.println("Laptop berhasil ditambahkan.");
                break;

            case 3:
                System.out.print("Masukkan resolusi kamera (MP) : ");
                int resolusi = input.nextInt();
                input.nextLine();
                System.out.print("Masukkan tipe lensa           : ");
                String lensa = input.nextLine();
                stok.add(new Kamera(merek, nomor, harga, resolusi, lensa));
                System.out.println("Kamera berhasil ditambahkan.");
                break;

            default:
                System.out.println("Tipe produk tidak valid!");
        }
    }
 
    static void tampilkanSemuaProduk() {
        System.out.println("Daftar Produk:");
        for (Produk p : stok) {
            p.tampilkanInfo();
            System.out.println();
        }
        if (stok.isEmpty()) {
            System.out.println("Belum ada produk di stok.");
            return;
        }
    }
 
    static void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int cari = input.nextInt();
        input.nextLine();
 
        boolean ditemukan = false;
        for (Produk p : stok) {
            if (p.getNomorSeri() == cari) {
                System.out.println("Anda telah membeli produk:");
                p.tampilkanInfo();
                stok.remove(p);
                ditemukan = true;
                break;
            }
        }
 
        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}
