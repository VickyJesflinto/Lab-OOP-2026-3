import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenToko {
    private ArrayList<Produk> stok = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void tambahProduk() {
        
        System.out.print("Masukkan nama produk: ");
        String merek = sc.nextLine();
        System.out.print("Masukkan nomor seri: ");
        String seri = sc.nextLine();
        System.out.print("Masukkan harga: ");
        double harga = sc.nextDouble();
        sc.nextLine();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Kamera");
        System.out.print("Pilih tipe produk (1-3): ");
        int jenis = sc.nextInt();
        sc.nextLine();

        if (jenis == 1) {
            System.out.print("Masukkan ukuran layar (inch): ");
            double layar = sc.nextDouble();
            sc.nextLine();
            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
            int storage = sc.nextInt();
            sc.nextLine();
            stok.add(new Smartphone(merek, seri, harga, layar, storage));
            System.out.println("Produk smartphone berhasil ditambahkan!");
        } else if (jenis == 2) {
            System.out.print("Masukkan prosesor: ");
            String cpu = sc.nextLine();
            System.out.print("Masukkan RAM (GB): ");
            int ram = sc.nextInt();
            sc.nextLine();
            stok.add(new Laptop(merek, seri, harga, cpu, ram));
            System.out.println("Produk laptop berhasil ditambahkan!");
        } else if (jenis == 3) {
            System.out.print("Masukkan megapixel: ");
            int mp = sc.nextInt();
            sc.nextLine();
            System.out.print("Masukkan jenis lensa: ");
            String lensa = sc.nextLine();
            stok.add(new Kamera(merek, seri, harga, mp, lensa));
            System.out.println("Produk kamera berhasil ditambahkan!");
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    public void tampilkanSemua() {
        System.out.println("Daftar Produk yang Tersedia:");
        if (stok.isEmpty()) {
            System.out.println("Tidak ada produk dalam stok.");
            return;
        }
        int no = 1;
        for (Produk p : stok) {
            System.out.println("Produk ke-" + no);
            p.tampilkanInfo();
            System.out.println("---------------------------------");
            no++;
        }
    }

    public void beliProduk() {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        String cariSeri = sc.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < stok.size(); i++) {
            if (stok.get(i).getNomorSeri().equals(cariSeri)) {
                System.out.println("Produk ditemukan!");
                stok.get(i).tampilkanInfo();
                System.out.print("Konfirmasi pembelian? (y/n): ");
                String konfirmasi = sc.nextLine();
                
                if (konfirmasi.equalsIgnoreCase("y")) {
                    stok.remove(i);
                    System.out.println("Produk berhasil dibeli dan dihapus dari stok!");
                } else {
                    System.out.println("Pembelian dibatalkan.");
                }
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}