import java.util.ArrayList;
import java.util.Scanner;


class Produk {
    protected String merek;
    protected String nomorSeri;
    protected double harga;

    public Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}


class Smartphone extends Produk {
    double ukuranLayar;
    int penyimpanan;

    public Smartphone(String merek, String nomorSeri, double harga, double ukuranLayar, int penyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.penyimpanan = penyimpanan;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inch");
        System.out.println("Penyimpanan: " + penyimpanan + " GB");
    }
}

class Laptop extends Produk {
    int ram;

    public Laptop(String merek, String nomorSeri, double harga, int ram) {
        super(merek, nomorSeri, harga);
        this.ram = ram;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("RAM: " + ram + " GB");
    }
}

class Kamera extends Produk {
    int resolusi;

    public Kamera(String merek, String nomorSeri, double harga, int resolusi) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi: " + resolusi + " MP");
    }
}


public class Main002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> daftarProduk = new ArrayList<>();

        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {

                
                case 1:
                    System.out.println("\nPilih jenis produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Kamera");
                    System.out.print("Pilihan: ");
                    int jenis = input.nextInt();

                    input.nextLine(); 

                    System.out.print("Merek: ");
                    String merek = input.nextLine();

                    System.out.print("Nomor Seri: ");
                    String nomorSeri = input.nextLine();

                    System.out.print("Harga: ");
                    double harga = input.nextDouble();

                    if (jenis == 1) {
                        System.out.print("Ukuran Layar: ");
                        double layar = input.nextDouble();

                        System.out.print("Penyimpanan (GB): ");
                        int storage = input.nextInt();

                        daftarProduk.add(new Smartphone(merek, nomorSeri, harga, layar, storage));

                    } else if (jenis == 2) {
                        System.out.print("RAM (GB): ");
                        int ram = input.nextInt();

                        daftarProduk.add(new Laptop(merek, nomorSeri, harga, ram));

                    } else if (jenis == 3) {
                        System.out.print("Resolusi (MP): ");
                        int res = input.nextInt();

                        daftarProduk.add(new Kamera(merek, nomorSeri, harga, res));
                    }

                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                
                case 2:
                    if (daftarProduk.isEmpty()) {
                        System.out.println("Stok produk kosong");
                    } else {
                        for (Produk p : daftarProduk) {
                            p.tampilkanInfo();
                            System.out.println("---------------------");
                        }
                    }
                    break;

                
                case 3:
                    input.nextLine(); // buang enter
                    System.out.print("Masukkan nomor seri: ");
                    String cari = input.nextLine();

                    boolean ditemukan = false;

                    for (int i = 0; i < daftarProduk.size(); i++) {
                        if (daftarProduk.get(i).getNomorSeri().equalsIgnoreCase(cari)) {

                            System.out.println("Produk ditemukan:");
                            daftarProduk.get(i).tampilkanInfo();

                            System.out.println("Pembelian berhasil!");

                            
                            daftarProduk.remove(i);

                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan");
                    }
                    break;

                
                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }

        } while (pilihan != 4);
    }
}