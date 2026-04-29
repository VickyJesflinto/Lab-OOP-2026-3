public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    
    public SmartCCTV(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartCCTV] Status fungsi: Kamera aktif & merekam.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}