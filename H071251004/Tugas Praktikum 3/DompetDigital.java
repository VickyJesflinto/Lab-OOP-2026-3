public class DompetDigital {
    private String pin; 
    private double saldo; 

    protected String idNasabah; 
    protected String nama;

    // Default (tanpa modifier)
    String mataUang; 
    int limitGagalLogin; 

    // Constructor (public)
    public DompetDigital(String idNasabah, String nama, String pinAwal) {
        this.idNasabah = idNasabah;
        this.nama = nama;
        this.pin = pinAwal;
        this.saldo = 0;
        this.mataUang = "IDR";
        this.limitGagalLogin = 3;
    }

    // Metode Getter
    public String getNama() {
        return this.nama;
    }

    public String getIdNasabah() {
        return this.idNasabah;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Metode Setter
    public void ubahPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama) && pinBaru.length() == 6) {
            this.pin = pinBaru;
            System.out.println("Sukses: PIN berhasil diperbarui.");
            catatLog("Ubah PIN", "Berhasil");
        } else {
            System.out.println("Gagal: PIN lama salah atau PIN baru tidak 6 digit!");
            catatLog("Ubah PIN", "Ditolak - Validasi Gagal");
        }
    }

    // Metode Transaksi 1: Setor Tunai
    public void setorTunai(double nominal) {
        if (nominal > 0) {
            this.saldo += nominal;
            System.out.println("Sukses: Setor tunai Rp" + nominal + " berhasil.");
            catatLog("Setor Tunai", "Berhasil");
        } else {
            System.out.println("Gagal: Nominal setor tidak valid (tidak boleh negatif)!");
            catatLog("Setor Tunai", "Ditolak - Nominal Tidak Valid");
        }
    }

    // Metode Transaksi 2: Tarik Tunai
    public void tarikTunai(double nominal, String inputPin) {
        // Validasi 1: Kecocokan PIN
        if (this.pin.equals(inputPin)) {
            // Validasi 2: Saldo mencukupi
            if (this.saldo >= nominal) {
                this.saldo -= nominal;
                System.out.println("Sukses: Tarik tunai Rp" + nominal + " berhasil.");
                catatLog("Tarik Tunai", "Berhasil");
            } else {
                System.out.println("Gagal: Saldo tidak mencukupi untuk penarikan!");
                catatLog("Tarik Tunai", "Ditolak - Saldo Kurang");
            }
        } else {
            System.out.println("Gagal: Autentikasi ditolak. PIN salah!");
            catatLog("Tarik Tunai", "Ditolak - PIN Salah");
        }
    }

    // Method Internal untuk mencatat log transaksi (simulasi)
    private void catatLog(String jenisTransaksi, String status) {
        System.out.println("[LOG]: " + jenisTransaksi + " | Status: " + status);
        System.out.println("--------------------------------------------------");
    }
}