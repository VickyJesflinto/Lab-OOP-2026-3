package soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara { 
    public SmartLamp(String merk, int daya) { super(merk, daya); }
    public void cekFungsi() { System.out.println("Lampu pintar."); }
    public void prosesPerintah(String perintah) {
        if (perintah.equals("NYALA")) System.out.println("Lampu berpijar!"); 
    }
}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet { 
    public SmartCCTV(String merk, int daya) { super(merk, daya); }
    public void cekFungsi() { System.out.println("Kamera keamanan."); }
    public void hubungkanWiFi() { System.out.println("Mengirim data ke server..."); } 
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara { 
    public SmartSpeaker(String merk, int daya) { super(merk, daya); }
    public void cekFungsi() { System.out.println("Speaker pintar."); }
    public void hubungkanWiFi() { System.out.println("Speaker terhubung WiFi."); }
    public void prosesPerintah(String perintah) { System.out.println("Memproses: " + perintah); }
}