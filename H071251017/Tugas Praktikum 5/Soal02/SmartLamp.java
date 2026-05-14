package soal2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[SmartLamp - " + getMerk() + "] Fungsi: Lampu pintar dengan kontrol suara.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("[SmartLamp - " + getMerk() + "] Lampu berpijar!");
        } else {
            System.out.println("[SmartLamp - " + getMerk() + "] Perintah tidak dikenali: " + perintah);
        }
    }
}
