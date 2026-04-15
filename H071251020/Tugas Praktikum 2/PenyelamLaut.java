public class PenyelamLaut {
    private String nama;
    private int sisaOksigen;
    private ScubaGear alatSelam; // ← Atribut Objek (Instance Variable)

    public PenyelamLaut() {
        this.nama = "Anonim";
        this.sisaOksigen = 30;
        this.alatSelam = new ScubaGear();
    }

    public PenyelamLaut(String nama, int sisaOksigen, ScubaGear alatSelam) {
        this.nama = nama;
        this.sisaOksigen = sisaOksigen;
        this.alatSelam = alatSelam;
    }

    public void lakukanPenyelaman(int kedalamanTarget) {
        System.out.println(" [" + nama + "] Memulai penyelaman ke " + kedalamanTarget + "m...");
        
        if (kedalamanTarget > alatSelam.batasKedalaman) {
            System.out.println(" GAGAL: Kedalaman melebihi batas aman alat " + alatSelam.merek + 
                               " (" + alatSelam.batasKedalaman + "m).");
            return;
        }

        int konsumsiOksigen = (int) Math.ceil(kedalamanTarget / 5.0);
        if (sisaOksigen >= konsumsiOksigen) {
            sisaOksigen -= konsumsiOksigen;
            System.out.println(" BERHASIL: Menyelam ke " + kedalamanTarget + "m. " +
                               "Oksigen terpakai: " + konsumsiOksigen + " menit. Sisa: " + sisaOksigen);
        } else {
            System.out.println(" GAGAL: Sisa oksigen tidak cukup untuk menyelam.");
        }
    }

    public void transferOksigen(PenyelamLaut rekan) {
        System.out.println(" [" + this.nama + "] mencoba berbagi oksigen dengan [" + rekan.nama + "]...");
        
        // Logika interaksi antar 2 objek PenyelamLaut
        if (this.sisaOksigen > 15) {
            int jumlahTransfer = 10;
            this.sisaOksigen -= jumlahTransfer; 
            rekan.sisaOksigen += jumlahTransfer;    
            
            System.out.println(" Berhasil transfer! " + jumlahTransfer + " menit oksigen berpindah.");
            System.out.println(" Status Oksigen -> " + this.nama + ": " + this.sisaOksigen + 
                               " | " + rekan.nama + ": " + rekan.sisaOksigen);
        } else {
            System.out.println(" " + this.nama + " tidak memiliki cukup oksigen untuk dibagikan.");
        }
    }

    // Getter & Setter (Opsional)
    public String getNama() { return nama; }
    public int getSisaOksigen() { return sisaOksigen; }
    public ScubaGear getAlatSelam() { return alatSelam; }
}