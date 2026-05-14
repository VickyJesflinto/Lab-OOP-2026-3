package Soal2TUPRAK5;

public class SmartSpeaker extends PerangkatElektronik implements IInteraksiInternet,IKontrolSuara {
    public SmartSpeaker(String merk, int dayalistrik) {
        super(merk, dayalistrik);
    }

    public void hubungkanWIFI() {
        System.out.println("Mengirim data ke server");
    }

    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("putar")) {
            System.out.println("Memutar musik favorit Anda.");
            infopower();
        } else {
            System.out.println("Perintah tidak dikenali.");
        }
    }

    @Override
    public void cekFungsi() {   
        System.out.println("\nSmartSpeaker sedang berfungsi dengan baik");
    }

}
