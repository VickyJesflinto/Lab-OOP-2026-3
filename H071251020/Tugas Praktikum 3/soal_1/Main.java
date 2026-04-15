public class Main {
    public static void main(String[] args) {
        DompetDigital dompet1 = new DompetDigital("Glenn12345", "Glenn", "123456");

        // 1
        System.out.println("\n1. Tampilkan informasi identitas akun menggunakan Getter.");
        System.out.println("ID Akun         : " + dompet1.getIdAkun());
        System.out.println("Nama Nasabah    : " + dompet1.getNamaNasabah());

        // 2
        System.out.println("\n2. Lakukan uji coba metode Setter (Ubah PIN) dengan memasukkan PIN lama yang salah (Pastikan sistem menolak)");
        boolean uji1 = dompet1.setPin("654321", "678901");
        System.out.println("Hasil: " + (uji1 ? "Berhasil" : "DITOLAK SISTEM"));
        
        // 3
        System.out.println("\n3. Lakukan uji coba metode Setter (Ubah PIN) dengan memenuhi syarat yang benar (Pastikan PIN berhasil diubah).");
        boolean uji2 = dompet1.setPin("123456", "678901");
        System.out.println("Hasil: " + (uji2 ? "Berhasil" : "DITOLAK SISTEM"));
        
        // 4
        System.out.println("\n4. Lakukan setor tunai dengan nominal yang valid.");
        boolean uji3 = dompet1.setorTunai(500000);
        System.out.println("Hasil: " + (uji3 ? "Berhasil" : "DITOLAK SISTEM"));
        
        // 5
        System.out.println("\n5. Lakukan setor tunai dengan nominal ilegal/negatif (Pastikan ditolak)");
        boolean uji4 = dompet1.setorTunai(-500000);
        System.out.println("Hasil: " + (uji4 ? "Berhasil" : "DITOLAK SISTEM"));
        
        // 6
        System.out.println("\n6.  Lakukan tarik tunai menggunakan PIN yang lama/salah (Pastikan ditolak).");
        boolean uji5 = dompet1.tarikTunai(1000000, "123456");
        System.out.println("Hasil: " + (uji5 ? "Berhasil" : "DITOLAK SISTEM"));
        
        // 7
        System.out.println("\n7. Lakukan tarik tunai menggunakan PIN yang baru/benar (Pastikan berhasil).");
        boolean uji6 = dompet1.tarikTunai(450000, "678901");
        System.out.println("Hasil: " + (uji6 ? "Berhasil" : "DITOLAK SISTEM"));

        // 8
        System.out.println("\n8.  Tampilkan sisa saldo akhir menggunakan Getter.");
        System.out.println("Saldo Akhir: Rp" + String.format("%,.0f", dompet1.getSaldo()));
    }
}
