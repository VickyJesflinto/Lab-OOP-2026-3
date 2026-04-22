import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManajemenToko toko = new ManajemenToko();
        int pilihan = 0;

        do {
            System.out.println("========================================");
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print(">>> Pilih menu (1-4): ");
            
            if (sc.hasNextInt()) {
                pilihan = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Input harus berupa angka!");
                sc.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("");
                    toko.tambahProduk();
                    break;
                case 2:
                    System.out.println("");
                    toko.tampilkanSemua();
                    break;
                case 3:
                    System.out.println("");
                    toko.beliProduk();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Pilihan menu tidak valid!");
            }
            System.out.println();
        } while (pilihan != 4);

        sc.close();
    }
}