public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOAL 2: SMART HOME ECOSYSTEM - THE HARMONY PROTOCOL ===\n");

        // 1. SmartLamp (Hanya KontrolSuara)
        System.out.println("1) Smart Lamp");
        SmartLamp lamp = new SmartLamp("Philips Hue", 10.5);
        // lamp.cekFungsi();
        // lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        System.out.println("\n2) Smart CCTV");
        // 2. SmartCCTV (Hanya InteraksiInternet)
        SmartCCTV cctv = new SmartCCTV("Hikvision Pro", 15.0);
        // cctv.cekFungsi();
        // cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n3) Smart Speaker");
        // 3. SmartSpeaker (Kedua Interface + Abstract Class)
        SmartSpeaker speaker = new SmartSpeaker("JBL Link", 25.0);
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("NYALA");

        System.out.println();
    }
}