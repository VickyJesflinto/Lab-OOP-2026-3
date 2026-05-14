public class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    
    public SmartLamp(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartLamp] Status fungsi: Berjalan normal.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if ("NYALA".equals(perintah)) {
            System.out.println("Lampu berpijar!");
        }
    }
}