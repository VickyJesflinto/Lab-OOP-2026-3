package soal2;

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartSpeaker - " + getMerk() + "] Fungsi: Speaker pintar dengan WiFi dan kontrol suara.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("[SmartSpeaker - " + getMerk() + "] Mengirim data ke server...");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("[SmartSpeaker - " + getMerk() + "] Lampu berpijar!");
        } else {
            System.out.println("[SmartSpeaker - " + getMerk() + "] Memproses perintah: " + perintah);
        }
    }
}