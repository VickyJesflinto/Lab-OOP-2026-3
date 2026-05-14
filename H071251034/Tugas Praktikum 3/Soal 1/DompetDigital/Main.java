 package DompetDigital;

public class Main {
    public static void main(String[] args) {
        Dompet dompet = new Dompet("Aura", "12345");

        System.out.println("\nID Nasabah: " + dompet.IdNasabah());
        System.out.println("\nUji Ubah PIN (PIN lama salah):");
        dompet.setPin("00000", "54321");

        System.out.println("\nUji Ubah PIN (Benar):");
        dompet.setPin("12345", "12312");

        System.out.println("\nUji Setor Tunai (Valid):");
        dompet.setorTunai(500000);

        System.out.println("\nUji Setor Tunai (Negatif):");
        dompet.setorTunai(-50000);

        System.out.println("\nUji Tarik Tunai (PIN Salah):");
        dompet.tarikTunai(100000, "000000");

        System.out.println("\nUji Tarik Tunai (PIN Benar):");
        dompet.tarikTunai(200000, "12312");

        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Sisa Saldo: Rp" + dompet.getSaldo());
    }
}
    

