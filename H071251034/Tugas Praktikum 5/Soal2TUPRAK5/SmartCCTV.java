package Soal2TUPRAK5;

public class SmartCCTV extends PerangkatElektronik implements IInteraksiInternet {
    public SmartCCTV(String merk, int dayalistrik) {
        super(merk, dayalistrik);
    }
    public void hubungkanWIFI() {
        System.out.println("Mengirim data ke server...");
        infopower();
    }
    @Override
    public void cekFungsi() {
        System.out.println("\nSmartCCTV sedang berfungsi dengan baik");
    }
    
}
