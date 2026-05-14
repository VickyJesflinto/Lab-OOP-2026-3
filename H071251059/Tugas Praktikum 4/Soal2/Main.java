package Soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList <Product> daftarProduk = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Data awal
        daftarProduk.add(new Smartphone("Samsung", 123456, 899.99,  6.5, 256));
        daftarProduk.add(new Laptop    ("Dell",    987654, 1299.99, 16, "Intel Core i7"));
        daftarProduk.add(new Camera    ("Canon",   456789, 699.99,  24, "Telephoto"));

        int pilihan = 0;
        do {
            tampilkanMenu();
            System.out.print(">>> Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

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
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-4.");
            }
        } while (pilihan != 4);
    }

    static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }

    static void tambahProduk() {
        System.out.print("Masukkan nama produk: ");
        String brand = scanner.nextLine();
        System.out.print("Masukkan nomor seri: ");
        int seriesNumber = scanner.nextInt();
        System.out.print("Masukkan harga: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print("Pilih tipe produk (1-3): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();

        switch (tipe) {
            case 1: {
                System.out.print("Masukkan ukuran layar (inci): ");
                double screenSize = scanner.nextDouble();
                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                int storage = scanner.nextInt();
                scanner.nextLine();
                daftarProduk.add(new Smartphone(brand, seriesNumber, price, screenSize, storage));
                break;
            }
            case 2: {
                System.out.print("Masukkan ukuran RAM (GB): ");
                int ram = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan tipe prosesor: ");
                String processor = scanner.nextLine();
                daftarProduk.add(new Laptop(brand, seriesNumber, price, ram, processor));
                break;
            }
            case 3: {
                System.out.print("Masukkan resolusi kamera (MP): ");
                int resolution = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan tipe lensa: ");
                String lensType = scanner.nextLine();
                daftarProduk.add(new Camera(brand, seriesNumber, price, resolution, lensType));
                break;
            }
            default:
                System.out.println("Tipe produk tidak valid!");
        }
    }

    static void tampilkanSemuaProduk() {
        System.out.println("Daftar Produk:");
        for (Product p : daftarProduk) {
            p.displayInfo();
            System.out.println();
        }
    }

    static void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int nomorSeri = scanner.nextInt();
        scanner.nextLine();

        boolean ditemukan = false;
        for (Product p : daftarProduk) {
            if (p.getSeriesNumber() == nomorSeri) {
                System.out.println("Anda telah membeli produk:");
                p.displayInfo();
                daftarProduk.remove(p);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}

