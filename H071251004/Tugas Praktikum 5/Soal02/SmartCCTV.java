package Soal02;

public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
 
    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] aktif. Terhubung ke internet untuk streaming.");
    }
 
    @Override
    public void hubungkanWiFi() {
        System.out.println("[" + merk + "] Mengirim data ke server...");
    }
}
