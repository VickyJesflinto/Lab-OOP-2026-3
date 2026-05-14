package Soal2;

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
     
        System.out.println("============================================================");
        System.out.println("                 INPUT DATA SMART LAMP                     ");
        System.out.println("============================================================");
 
        System.out.print("Masukkan Merk SmartLamp       : ");
        String merkLamp = sc.nextLine();
 
        System.out.print("Masukkan Daya Listrik (Watt)  : ");
        int dayaLamp = sc.nextInt();
        sc.nextLine();
 
        System.out.print("Masukkan Perintah Suara       : ");
        String perintahLamp = sc.nextLine();
 
        SmartLamp lamp = new SmartLamp(merkLamp, dayaLamp);
 
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                 HASIL DATA SMART LAMP                     ");
        System.out.println("============================================================");
        System.out.println(lamp);
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah(perintahLamp);
        System.out.println("============================================================");
 
        System.out.println();
 
        System.out.println("============================================================");
        System.out.println("                 INPUT DATA SMART CCTV                     ");
        System.out.println("============================================================");
 
        System.out.print("Masukkan Merk SmartCCTV       : ");
        String merkCCTV = sc.nextLine();
 
        System.out.print("Masukkan Daya Listrik (Watt)  : ");
        int dayaCCTV = sc.nextInt();
        sc.nextLine();
 
        Smartcctv cctv = new Smartcctv(merkCCTV, dayaCCTV);
 
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                 HASIL DATA SMART CCTV                     ");
        System.out.println("============================================================");
        System.out.println(cctv);
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();
        System.out.println("============================================================");
 
        System.out.println();
 
        System.out.println("============================================================");
        System.out.println("                INPUT DATA SMART SPEAKER                   ");
        System.out.println("============================================================");
 
        System.out.print("Masukkan Merk SmartSpeaker    : ");
        String merkSpeaker = sc.nextLine();
 
        System.out.print("Masukkan Daya Listrik (Watt)  : ");
        int dayaSpeaker = sc.nextInt();
        sc.nextLine();
 
        System.out.print("Masukkan Perintah Suara       : ");
        String perintahSpeaker = sc.nextLine();
 
        Smartspeaker speaker = new Smartspeaker(merkSpeaker, dayaSpeaker);
 
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                HASIL DATA SMART SPEAKER                   ");
        System.out.println("============================================================");
        System.out.println(speaker);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah(perintahSpeaker);
        System.out.println("============================================================");
 
        System.out.println();
 
        System.out.println("============================================================");
        System.out.println("             REKAP SEMUA PERANGKAT (Override)              ");
        System.out.println("============================================================");
        PerangkatElektronik[] perangkat = {lamp, cctv, speaker};
        for (PerangkatElektronik p : perangkat) {
            System.out.println("------------------------------------------------------------");
            System.out.println(p);
            p.cekFungsi();
        }
        System.out.println("============================================================");
 
        sc.close();
    }
}
