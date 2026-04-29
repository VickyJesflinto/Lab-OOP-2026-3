public class main {
    public static void main(String[] args) {
        DompetDigital dompet = new DompetDigital("SI123", "Eren", "123456");

        System.out.println("--- Informasi Akun ---");
        System.out.println("ID Nasabah: " + dompet.getIdNasabah());
        System.out.println("Nama Pemilik: " + dompet.getNamaPemilik());
        System.out.println("-----------------------");

        System.out.println("\nMencoba ubah PIN (PIN lama salah):");
        dompet.setPin("000000", "654321");

        System.out.println("Mencoba ubah PIN (Data benar):");
        dompet.setPin("123456", "654321");

        System.out.println("\nSetor tunai Rp500.000:");
        dompet.setorTunai(500000);

        System.out.println("Setor tunai Rp-50.000:");
        dompet.setorTunai(-50000);

        System.out.println("\nTarik tunai Rp100.000 (PIN lama/salah):");
        dompet.tarikTunai(100000, "123456");

        System.out.println("Tarik tunai Rp100.000 (PIN baru/benar):");
        dompet.tarikTunai(100000, "654321");

        System.out.println("\n--- Status Akhir ---");
        System.out.println("Sisa Saldo: Rp" + dompet.getSaldo());
    }
}