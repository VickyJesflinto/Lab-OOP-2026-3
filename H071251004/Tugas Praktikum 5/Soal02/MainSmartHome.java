package Soal02;

public class MainSmartHome {
    public static void main(String[] args) {
        SmartLamp lamp = new SmartLamp("Philips", 15);
        SmartCCTV cctv = new SmartCCTV("EZVIZ", 12);
        SmartSpeaker speaker = new SmartSpeaker("JBL", 30);

        System.out.println("========== SMART LAMP ==========");
        lamp.cekFungsi();
        lamp.infoPower();

        lamp.prosesPerintah("NYALA");
        lamp.prosesPerintah("MATI");
        lamp.prosesPerintah("REDUP");

        System.out.println("\n========== SMART CCTV ==========");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n========== SMART SPEAKER ==========");
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();

        speaker.prosesPerintah("NYALA");
        speaker.prosesPerintah("VOLUME NAIK");
        speaker.prosesPerintah("MATI");

        PerangkatElektronik[] semuaPerangkat = { lamp, cctv, speaker };
        for (PerangkatElektronik p : semuaPerangkat) {
            p.infoPower();
            p.cekFungsi();
            System.out.println("---");
        }
    }
}