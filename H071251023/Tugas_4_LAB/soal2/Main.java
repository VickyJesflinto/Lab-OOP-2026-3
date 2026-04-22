package soal2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner riz = new Scanner(System.in);
        dekorasi dekor = new dekorasi();
        ArrayList<product> products = new ArrayList<>();
        while (true){
            try{
                dekor.DEKORASI();
                int menu = riz.nextInt();
                if (menu == 1){
                    riz.nextLine();
                    System.out.print("Nama Brand : ");String brand = riz.nextLine();
                    System.out.print("Series Number : ");int seriesnumber = riz.nextInt();
                    System.out.print("Price : ");double price = riz.nextDouble();
                    boolean valid = true;
                    if (price <= 0 || seriesnumber <= 0){
                        System.out.println("Input tidak valid. Harap masukkan angka positif.❌");
                        valid = false;
                    }
                    for (product p : products){
                        if (seriesnumber == p.seriesnumber){
                            System.out.println("Series number sudah ada.");
                            valid = false;
                        }
                    } if (valid){
                        dekor.tipe();
                        int tipe = riz.nextInt();
                        boolean validasitipe = true;
                        if (tipe == 1){
                            System.out.println("Screen Size : ");double screenSize = riz.nextDouble();
                            System.out.println("Storage Capacity : ");int storageCapacity = riz.nextInt();
                            if (screenSize <= 0 || storageCapacity <= 0){
                                System.out.println("Harap masukkan angka positif.❌");
                                validasitipe = false;
                            } if (validasitipe) {
                                products.add(new hp(brand, seriesnumber, price, screenSize, storageCapacity));
                                System.out.println("produk berhasil ditambahkan.✅");
                            }
                        } else if (tipe == 2){
                            System.out.println("RAM Size : ");double RamSize = riz.nextDouble();
                            riz.nextLine();
                            System.out.println("Processor Type : ");String processorType = riz.nextLine();
                            if (RamSize <= 0){
                                System.out.println("Harap masukkan angka positif.❌");
                                validasitipe = false;
                            } if (validasitipe) {
                                products.add(new laptop(brand, seriesnumber, price, RamSize, processorType));
                                System.out.println("produk berhasil ditambahkan.✅");
                            }
                        } else if (tipe == 3){
                            System.out.println("Resolution : ");double resolution = riz.nextDouble();
                            riz.nextLine();
                            System.out.println("Lens Type : ");String lensType = riz.nextLine();
                            if (resolution <= 0){
                                System.out.println("Harap masukkan angka positif.❌");
                                validasitipe = false;
                            } if (validasitipe) {
                                products.add(new camera(brand, seriesnumber, price, resolution, lensType));
                                System.out.println("produk berhasil ditambahkan.✅");
                            }
                        } else {
                            System.out.println("Tipe ke-"+ menu + " tidak tersedia.❌");
                        }
                    }

                } else if (menu == 2){
                    for (product p : products){
                        p.displayInfo();
                    }
                } else if (menu == 3){
                    System.out.print("Masukkan series number produk yang ingin dibeli : ");
                    int seriesnumber = riz.nextInt();
                    boolean found = false;
                    for (product p : products){
                        if (seriesnumber == p.seriesnumber){
                            System.out.println("Anda membeli produk dengan series number " + seriesnumber);
                            System.out.println("Total harga yang harus dibayar : Rp " + p.price);
                            System.out.println("transaksi berhasil.✅");
                            products.remove(p);
                            found = true;
                        }
                    }
                    if (!found){
                        System.out.println("Produk dengan series number " + seriesnumber + " tidak ditemukan.❌");
                    }
                } else if (menu == 4){
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                } else {
                    System.out.println("Menu ke-"+ menu + " tidak tersedia.❌");
                }

            }catch (Exception e) {
                riz.nextLine();

            }
        }
    }
}