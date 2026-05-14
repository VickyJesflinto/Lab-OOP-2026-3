package Soal02;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    public  SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] siap beroperasi. Kontrol via suara.");
    }
 
    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("[" + merk + "] Lampu berpijar!"); 
        } else if (perintah.equalsIgnoreCase("MATI")) {
            System.out.println("[" + merk + "] Lampu dimatikan.");
        } else {
            System.out.println("[" + merk + "] Perintah '" + perintah + "' tidak dikenali.");
        }
    }
}