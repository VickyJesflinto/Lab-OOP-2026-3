package soal2;

public class Main {
    public static void main(String[] args) {
        // Instansiasi ketiga objek
        SmartLamp lamp = new SmartLamp("Philips Hue", 10);
        SmartCCTV cctv = new SmartCCTV("Hikvision", 15);
        SmartSpeaker speaker = new SmartSpeaker("Amazon Echo", 30);

        System.out.println("======= SMART LAMP =======");
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");
        lamp.prosesPerintah("MATI");

        System.out.println();
        System.out.println("======= SMART CCTV =======");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();
        System.out.println("======= SMART SPEAKER (kedua interface) =======");
        speaker.cekFungsi();           
        speaker.infoPower();           
        speaker.hubungkanWiFi();          
        speaker.prosesPerintah("PUTAR MUSIK"); 
    }
}
