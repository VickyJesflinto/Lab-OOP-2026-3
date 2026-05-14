package soal1;

public class DompetDigital {
    private String pin;
    private double saldo;
    protected String idnasabah;
    protected String namanasabah;
    int jumlah_transaksi_harian;

    public DompetDigital(String idnasabah, String namanasabah, String pinawal) {
        this.idnasabah = idnasabah;
        this.namanasabah = namanasabah;
        this.pin = pinawal;
        this.saldo = 0;
        this.jumlah_transaksi_harian = 0;
        catatLog("Akun baru berhasil dibuat untuk: " + namanasabah);
    }
    
    public String getidnasabah() {
        return idnasabah;
    }

    public String getnamanasabah() {
        return namanasabah;
    }

    public String getinfosaldo() {
        return "Rp " + String.format("%,.0f", saldo);
    }

    public void setpinbaru(String pinlama, String pinbaru) {
        if (!this.pin.equals(pinlama)) {
            System.out.println("UBAH PIN DITOLAK: PIN LAMA YANG ANDA MASUKKAN SALAH.");
            catatLog("PERCOBAAN UBAH PIN GAGAL - PIN LAMA SALAH");
            return;
        }
        if (pinbaru.length() != 6) {
            System.out.println("UBAH PIN DITOLAK: PIN HARUS TEPAT 6 KARAKTER (SAAT INI " + pinbaru.length() +" karakter).");
            catatLog("PERCOBAAN UBAH PIN GAGAL - PIN BARU TIDAK 6 KARAKTER");
            return;
        }
        
        this.pin = pinbaru;
        System.out.println("PIN BERHASIL DIUBAH.");
        catatLog("PIN BERHASIL DIUBAH");
    }
    
    public void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("SETOR TUNAI DITOLAK: NOMINAL TIDAK BOLEH NOL ATAU NEGATIF (INPUT: Rp " + jumlah +").");
            catatLog("GAGAL - NOMINAL TIDAK VALID: " + jumlah);
            return;
        }
        this.saldo += jumlah;
        System.out.println("BERHASIL SETOR TUNAI Rp" + String.format("%,.0f", jumlah) + " berhasil. SALDO SEKARANG: " + getinfosaldo());
        catatLog("BERHASIL - NOMINAL: Rp " + String.format("%,.0f", jumlah));
    }

    public void tariktunai(double jumlah, String pinmasukkan) {
        if (!this.pin.equals(pinmasukkan)) {
            System.out.println("TARIK TUNAI DITOLAK: PIN YANG ANDA MASUKKAN SALAH.");
            catatLog("GAGAL- PIN SALAH");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("TARIK TUNAI DITOLAK: NOMINAL HARUS LEBIH DARI 0.");
            catatLog("GAGAL - NOMINAL TIDAK VALID: " + jumlah);
            return;
        }
        if (jumlah > this.saldo) {
            System.out.println("TARIK TUNAI DITOLAK: SALDO TIDAK MENCUKUPI. SALDO ANDA: " + getinfosaldo());
            catatLog("GAGAL - SALDO TIDAK CUKUP");
            return;
        }
        this.saldo -= jumlah;
        System.out.println("BERHASIL TARIK TUNAI Rp " + String.format("%,.0f", jumlah) + "berhasil. SALDO SEKARANG: " + getinfosaldo());
        catatLog("BERHASIL - NOMINAL: Rp" + String.format("%,.0f", jumlah));
    }

    private void catatLog(String keterangan) {
        System.out.println(" [LOG] ID:" + idnasabah +" | " + keterangan);
    }
}

