package Soal02;

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
 
    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
 
    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] aktif. WiFi + kontrol suara tersedia.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("[" + merk + "] Mengirim data ke server........");
    }
 
    @Override
    public void prosesPerintah(String perintah) {
        switch (perintah.toUpperCase()) {
            case "NYALA":
                System.out.println("[" + merk + "] Speaker menyala, siap memutar musik!");
                break;
            case "MATI":
                System.out.println("[" + merk + "] Speaker dimatikan.");
                break;
            case "VOLUME NAIK":
                System.out.println("[" + merk + "] Volume dinaikkan.");
                break;
            default:
                System.out.println("[" + merk + "] Perintah '" + perintah + "' diterima.");
        }
    }
}
