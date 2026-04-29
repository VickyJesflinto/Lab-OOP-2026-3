package Soal2;

public class Smartspeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
 
    public Smartspeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
 
    @Override
    public void cekFungsi() {
        System.out.println("Fungsi       : Speaker pintar dengan WiFi dan kontrol suara");
    }
 
    @Override
    public void hubungkanWiFi() {
        System.out.println("WiFi         : Terhubung ke WiFi, siap streaming musik.");
    }
 
    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Status       : Speaker aktif, siap memainkan musik!");
        } else if (perintah.equalsIgnoreCase("MATI")) {
            System.out.println("Status       : Speaker dimatikan.");
        } else {
            System.out.println("Status       : Memproses perintah -> " + perintah);
        }
    }
 
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Tipe         : SmartSpeaker\n" +
               "Fitur        : Koneksi Internet + Kontrol Suara";
    }
}
