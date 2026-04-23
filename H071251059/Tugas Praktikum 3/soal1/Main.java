package soal1;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);  
    
    static void tampilkanmenu() {
        System.out.println("----------- MENU UTAMA -----------");
        System.out.println(" 1. LIHAT INFORMASI AKUN");
        System.out.println(" 2. UBAH PIN");
        System.out.println(" 3. SETOR TUNAI");
        System.out.println(" 4. TARIK TUNAI");
        System.out.println(" 0. KELUAR");
        System.out.println("----------------------------------");
        System.out.println(" PILIH MENU: ");
    }

    public static void main(String[] args) {
        System.out.println("----- BUAT AKUN BARU DOMPET DIGITAL -----");
        System.out.print(" MASUKKAN ID NASABAH  : ");
        String id = sc.nextLine();

        System.out.print(" MASUKKAN NAMA        :");
        String nama = sc.nextLine();

        System.out.println(" BUAT PIN (6 DIGIT)   :");
        String pin = sc.nextLine();

        DompetDigital dompet = new DompetDigital(id, nama, pin);
        System.out.println(" AKUN BERHASIL DIBUAT!! SALDO AWAL: Rp 0");

        int pilihan = -1;
        while (pilihan != 0) {
            tampilkanmenu();

            try {
                pilihan = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = -1;
            }

            System.out.println();

            switch (pilihan) {
                
                case 1:
                    System.out.println(" INFORMASI AKUN");
                    System.out.println(" ID NASABAH :" + dompet.getidnasabah());
                    System.out.println(" NAMA       :" + dompet.getnamanasabah());
                    System.out.println(" SALDO      :" + dompet.getinfosaldo());
                    System.out.println();
                    System.out.println(" PIN & SALDO TIDAK BISA DIAKSES");
                    break;
                
                case 2:
                    System.out.println("UBAH PIN");
                    System.out.print(" MASUKKAN PIN LAMA   : ");
                    String pinlama = sc.nextLine();

                    System.out.print(" MASUKKAN PIN BARU   :" );
                    String pinbaru = sc.nextLine();

                    System.out.println();
                    dompet.setpinbaru(pinlama, pinbaru);
                    break;
                
                case 3:
                    System.out.println(" SETOR TUNAI");
                    System.out.print(" NOMINAL SETOR (Rp)   : ");
                    double nominalsetor;
                    try {
                        nominalsetor = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println(" ERROR INPUT TIDAK VALID.");
                        break;
                    }
                    System.out.println();
                    dompet.setorTunai(nominalsetor);
                    break;

                case 4:
                    System.out.println(" TARIK TUNAI");
                    System.out.print(" NOMINAL TARIK (Rp)   : ");
                    double nominaltarik;
                    try {
                        nominaltarik = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println(" ERROR INPUT TIDAK VALID.");
                        break;
                    }
                    System.out.print(" MASUKKAN PIN       : ");
                    String pintarik = sc.nextLine();

                    System.out.println();
                    dompet.tariktunai(nominaltarik, pintarik);
                    break;
                
                case 0:
                    System.out.println(" terima kasih telah menggunakan DOMPETDIGITAL!!!");
                    System.out.println(" SALDO AKHIR ANDA: " + dompet.getinfosaldo());
                    break;
                    
                default:
                    System.out.println(" ERROR MENU TIDAK TERSEDIA. PILIH 0-4");
            }
        }

        sc.close();
    }
}

