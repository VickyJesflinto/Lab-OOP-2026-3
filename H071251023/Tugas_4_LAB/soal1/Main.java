package soal1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dekorasi dekor = new dekorasi();
        while (true){
            try {
                dekor.DEKORASI();
                int pilihan = input.nextInt();
                if (pilihan == 0) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    break;
                }
                else if (pilihan == 1) {
                    persegi p = new persegi();
                    p.tampilkan();
                } else if (pilihan == 2) {
                    persegi_panjang pp = new persegi_panjang();
                    pp.tampilkan();
                } else if (pilihan == 3) {
                    lingkaran l = new lingkaran();
                    l.tampilkan();
                } else if (pilihan == 4) {
                    trapesium t = new trapesium();
                    t.tampilkan();
                } else if (pilihan == 5) {
                    kubus k = new kubus();
                    k.tampilkan();
                } else if (pilihan == 6) {
                    balok b = new balok();
                    b.tampilkan();
                } else if (pilihan == 7) {
                    bola b = new bola();
                    b.tampilkan();
                } else if (pilihan == 8) {
                    tabung t = new tabung();
                    t.tampilkan();
                } else {
                    System.out.println("Menu ke- " + pilihan + " tidak ada.");
                }

            }catch (Exception e){
                System.out.println("Input tidak valid. Silakan coba lagi.");
                input.nextLine(); // Clear the invalid input
            }
        }
    }
}