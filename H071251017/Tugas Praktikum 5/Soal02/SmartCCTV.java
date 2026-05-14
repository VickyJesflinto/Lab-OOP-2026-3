package soal2;

public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartCCTV - " + getMerk() + "] Fungsi: Kamera keamanan dengan koneksi internet.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("[SmartCCTV - " + getMerk() + "] Mengirim data ke server...");
    }
}
