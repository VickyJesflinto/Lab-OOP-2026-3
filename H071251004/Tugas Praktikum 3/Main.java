public class Main {
    public static void main(String[] args) {
        System.out.println("=== DOMPET DIGITAL ===\n");
        DompetDigital dompetKu = new DompetDigital("AA001", "Jake", "123456");

        // 1. Informasi identitas akun 
        System.out.println("== Identitas Akun ==");
        System.out.println("Nama: " + dompetKu.getNama());
        System.out.println("ID Nasabah: " + dompetKu.getIdNasabah());
        System.out.println("--------------------------------------------------");

        // 2. Uji coba Setter (Ubah PIN) - PIN lama SALAH
        System.out.println(">> Uji Coba: Ubah PIN (PIN Lama Salah)");
        dompetKu.ubahPin("000000", "654321");

        // 3. Uji coba Setter (Ubah PIN) - Syarat BENAR
        System.out.println(">> Uji Coba: Ubah PIN (Kondisi Benar)");
        dompetKu.ubahPin("123456", "654321");

        // 4. Setor tunai nominal VALID
        System.out.println(">> Uji Coba: Setor Tunai Valid");
        dompetKu.setorTunai(500000); 

        // 5. Setor tunai nominal ILEGAL/NEGATIF
        System.out.println(">> Uji Coba: Setor Tunai Ilegal (Negatif)");
        dompetKu.setorTunai(-50000);

        // 6. Tarik tunai menggunakan PIN LAMA/SALAH
        System.out.println(">> Uji Coba: Tarik Tunai (PIN Salah)");
        dompetKu.tarikTunai(100000, "123456");

        // 7. Tarik tunai menggunakan PIN BARU/BENAR
        System.out.println(">> Uji Coba: Tarik Tunai (PIN Benar)");
        dompetKu.tarikTunai(100000, "654321");

        // 8. Sisa saldo akhir
        System.out.println(">> Sisa Saldo Akhir");
        System.out.println("Saldo Anda saat ini: Rp" + dompetKu.getSaldo());
    }
}