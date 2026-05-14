package Soal2TUPRAK5;

public class SmartLamp extends PerangkatElektronik implements IKontrolSuara{

    public SmartLamp(String merk, int dayalistrik) {
        super(merk, dayalistrik);
    }

    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("nyala")) {
            System.out.println("Lampu berpijar");
            infopower();;
        } else if (perintah.equalsIgnoreCase("mati")) {
            System.out.println("Lampu dimatikan.");
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }

    @Override
    public void cekFungsi() {
        System.out.println("\nSmartLamp berfungsi dengan baik");
    }
    
}
