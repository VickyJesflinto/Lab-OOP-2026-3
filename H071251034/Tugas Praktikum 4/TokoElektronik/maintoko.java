package TokoElektronik;

import java.util.ArrayList;
import java.util.Scanner;

public class maintoko {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();
        boolean programBerjalan = true;

        while (programBerjalan) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
            
            int pilihanMenu = input.nextInt();
            input.nextLine();

            switch (pilihanMenu) {
                case 1:
                    System.out.print("Masukkan nama produk (merek): ");
                    String merek = input.nextLine();
                    System.out.print("Masukkan nomor seri: ");
                    int nomorSeri = input.nextInt();
                    System.out.print("Masukkan harga: ");
                    double harga = input.nextDouble();
                    
                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Smartphone\n2. Laptop\n3. Kamera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipe = input.nextInt();
                    input.nextLine(); 

                    if (tipe == 1) {
                        System.out.print("Masukkan ukuran layar (inci): ");
                        double ukuranLayar = input.nextDouble();
                        System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                        int kapasitasPenyimpanan = input.nextInt();
                        daftarProduk.add(new Smartphone(merek, nomorSeri, harga, ukuranLayar, kapasitasPenyimpanan));
                    } else if (tipe == 2) {
                        System.out.print("Masukkan ukuran RAM (GB): ");
                        int ukuranRam = input.nextInt();
                        input.nextLine(); 
                        System.out.print("Masukkan tipe prosesor: ");
                        String tipeProsesor = input.nextLine();
                        daftarProduk.add(new Laptop(merek, nomorSeri, harga, ukuranRam, tipeProsesor));
                    } else if (tipe == 3) {
                        System.out.print("Masukkan resolusi (MP): ");
                        int resolusi = input.nextInt();
                        input.nextLine(); 
                        System.out.print("Masukkan tipe lensa: ");
                        String tipeLensa = input.nextLine();
                        daftarProduk.add(new Kamera(merek, nomorSeri, harga, resolusi, tipeLensa));
                    }
                    break;

                case 2:
                System.out.println("\nDaftar Produk:");
                    if (daftarProduk.isEmpty()) {
                        System.out.println("Stok produk masih kosong.");
                    } else {
                        for (Produk p : daftarProduk) {
                            p.tampilkanInfo();
                            System.out.println(); // Spasi antar produk
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                    int nomorDicari = input.nextInt();
                    boolean ditemukan = false;
                    
                    for (int i = 0; i < daftarProduk.size(); i++) {
                        if (daftarProduk.get(i).nomorSeri == nomorDicari) {
                            System.out.println("Anda telah membeli produk:");
                            daftarProduk.get(i).tampilkanInfo();
                            daftarProduk.remove(i); 
                            ditemukan = true;
                            break;
                        }
                    }
                    
                    if (!ditemukan) {
                        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    programBerjalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}