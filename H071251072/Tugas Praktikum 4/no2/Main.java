package no2;

import java.util.Scanner;

public class Main {

    public static int remove(Object[] data, int jml, int index) {
        for (int i = index; i < jml - 1; i++) {
            data[i] = data[i + 1];
        }
        data[jml - 1] = null;
        return jml - 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Smartphone[] dataHp = new Smartphone[50];
        Laptop[] dataLaptop = new Laptop[50];
        Kamera[] dataKamera = new Kamera[50];

        int jmlHp = 0;
        int jmlLaptop = 0;
        int jmlKamera = 0;

        int pilihan;

        do {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    input.nextLine();

                    System.out.print("Masukkan Merk: ");
                    String merk = input.nextLine();

                    int noSeri;
                    do {
                        System.out.print("Masukkan No Seri (>=0): ");
                        noSeri = input.nextInt();
                        if (noSeri < 0) {
                            System.out.println("Tidak boleh negatif!");
                        }
                    } while (noSeri < 0);

                    double harga;
                    do {
                        System.out.print("Masukkan Harga (>=0): ");
                        harga = input.nextDouble();
                        if (harga < 0) {
                            System.out.println("Tidak boleh negatif!");
                        }
                    } while (harga < 0);

                    System.out.println("\nJenis Produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Kamera");
                    System.out.print("Pilih jenis: ");
                    int jenis = input.nextInt();

                    if (jenis == 1) {
                        double layar;
                        do {
                            System.out.print("Ukuran layar (>=0): ");
                            layar = input.nextDouble();
                            if (layar < 0) {
                                System.out.println("Tidak boleh negatif!");
                            }
                        } while (layar < 0);

                        int storage;
                        do {
                            System.out.print("Storage (>=0): ");
                            storage = input.nextInt();
                            if (storage < 0) {
                                System.out.println("Tidak boleh negatif!");
                            }
                        } while (storage < 0);

                        dataHp[jmlHp++] = new Smartphone(merk, noSeri, harga, layar, storage);

                    } else if (jenis == 2) {
                        int ram;
                        do {
                            System.out.print("RAM (>=0): ");
                            ram = input.nextInt();
                            if (ram < 0) {
                                System.out.println("Tidak boleh negatif!");
                            }
                        } while (ram < 0);

                        input.nextLine();
                        System.out.print("Processor: ");
                        String processor = input.nextLine();

                        dataLaptop[jmlLaptop++] = new Laptop(merk, noSeri, harga, ram, processor);

                    } else if (jenis == 3) {
                        int resolusi;
                        do {
                            System.out.print("Resolusi (>=0): ");
                            resolusi = input.nextInt();
                            if (resolusi < 0) {
                                System.out.println("Tidak boleh negatif!");
                            }
                        } while (resolusi < 0);

                        input.nextLine();
                        System.out.print("Jenis lensa: ");
                        String lensa = input.nextLine();

                        dataKamera[jmlKamera++] = new Kamera(merk, noSeri, harga, resolusi, lensa);

                    } else {
                        System.out.println("Jenis tidak valid!");
                    }

                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                case 2:
                    if (jmlHp == 0 && jmlLaptop == 0 && jmlKamera == 0) {
                        System.out.println("Belum ada produk.");
                    } else {

                        System.out.println("\n=== Smartphone ===");
                        for (int i = 0; i < jmlHp; i++) {
                            System.out.println("\nProduk ke-" + (i + 1));
                            dataHp[i].tampilInfo();
                        }

                        System.out.println("\n=== Laptop ===");
                        for (int i = 0; i < jmlLaptop; i++) {
                            System.out.println("\nProduk ke-" + (i + 1));
                            dataLaptop[i].tampilInfo();
                        }

                        System.out.println("\n=== Kamera ===");
                        for (int i = 0; i < jmlKamera; i++) {
                            System.out.println("\nProduk ke-" + (i + 1));
                            dataKamera[i].tampilInfo();
                        }
                    }
                    break;
                    
                case 3:
                    if (jmlHp == 0 && jmlLaptop == 0 && jmlKamera == 0) {
                        System.out.println("Stok kosong.");
                        break;
                    }

                    System.out.print("Masukkan No Seri yang ingin dibeli: ");
                    int cari = input.nextInt();

                    boolean ditemukan = false;

                    for (int i = 0; i < jmlHp; i++) {
                        if (dataHp[i].noSeri == cari) {
                            dataHp[i].tampilInfo();
                            jmlHp = remove(dataHp, jmlHp, i);
                            ditemukan = true;
                            break;
                        }
                    }

                    for (int i = 0; i < jmlLaptop && !ditemukan; i++) {
                        if (dataLaptop[i].noSeri == cari) {
                            dataLaptop[i].tampilInfo();
                            jmlLaptop = remove(dataLaptop, jmlLaptop, i);
                            ditemukan = true;
                            break;
                        }
                    }

                    for (int i = 0; i < jmlKamera && !ditemukan; i++) {
                        if (dataKamera[i].noSeri == cari) {
                            dataKamera[i].tampilInfo();
                            jmlKamera = remove(dataKamera, jmlKamera, i);
                            ditemukan = true;
                            break;
                        }
                    }

                    if (ditemukan) {
                        System.out.println("Pembelian berhasil!");
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);
    }
}