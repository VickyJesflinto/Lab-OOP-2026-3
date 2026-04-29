public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    
    public SmartSpeaker(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartSpeaker] Status fungsi: Speaker siap digunakan.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if ("NYALA".equals(perintah)) {
            System.out.println("Speaker aktif dan siap memutar audio!");
        }
    }
}