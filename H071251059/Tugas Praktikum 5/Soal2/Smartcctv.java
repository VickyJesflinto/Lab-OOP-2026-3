package Soal2;

public class Smartcctv extends PerangkatElektronik implements InteraksiInternet {
 
    public Smartcctv(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
 
    @Override
    public void cekFungsi() {
        System.out.println("Fungsi       : Kamera keamanan dengan koneksi internet");
    }
 
    @Override
    public void hubungkanWiFi() {
        System.out.println("WiFi         : Mengirim data ke server...");
    }
 
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Tipe         : SmartCCTV\n" +
               "Fitur        : Koneksi Internet / WiFi";
    }
}
