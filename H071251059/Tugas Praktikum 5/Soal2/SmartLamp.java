package Soal2;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara {
 
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
 
    @Override
    public void cekFungsi() {
        System.out.println("Fungsi       : Lampu pintar dengan kontrol suara");
    }
 
    @Override
    public void prosesPerintah(String perintahLamp) {
        if (perintahLamp.equalsIgnoreCase("NYALA")) {
            System.out.println("Status       : Lampu berpijar!");
        } else if (perintahLamp.equalsIgnoreCase("MATI")) {
            System.out.println("Status       : Lampu dimatikan.");
        } else {
            System.out.println("Status       : Perintah tidak dikenali -> " + perintahLamp);
        }
    }
 
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Tipe         : SmartLamp\n" +
               "Fitur        : Kontrol Suara";
    }
}