public class DompetDigital {
    private String pin;
    private double saldo;
    protected String namaNasabah;
    String idAkun;

    public DompetDigital (String idAkun, String namaNasabah, String pin) {
        this.idAkun = idAkun;
        this.namaNasabah = namaNasabah;
        this.pin = pin;
        this.saldo = 0.0;
        pesanSistem ("Akun berhasil dibuat. ID: " + idAkun);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public String getIdAkun() {
        return idAkun;
    }

    public boolean setPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            pesanSistem("Gagal ubah PIN: PIN lama yang dimasukkan salah.");
            return false;
        }
        
        if (pinBaru == null || pinBaru.length() != 6) {
            pesanSistem("Gagal ubah PIN: PIN baru wajib 6 digit.");
            return false;
        }

        this.pin = pinBaru;
        pesanSistem("PIN berhasil diperbarui.");
        return true;
    }

    public boolean setorTunai(double nominal) {
        if (nominal > 0) {
            this.saldo += nominal;
            pesanSistem("Setor tunai berhasil: +" + formatRupiah(nominal) + " | Saldo: " + formatRupiah(this.saldo));
            return true;
        }

        else {
            pesanSistem("Gagal setor tunai: Nominal tidak valid (harus > 0).");
            return false;
        }
    }

    public boolean tarikTunai(double nominal, String pinInput) {
        if (!this.pin.equals(pinInput)) {
            pesanSistem("Gagal tarik tunai: PIN salah.");
            return false;
        }

        if (nominal > this.saldo) {
            pesanSistem("Gagal tarik tunai: Saldo tidak mencukupi.");
            return false;
        }

        this.saldo -= nominal;
        pesanSistem("Tarik tunai berhasil: -" + formatRupiah(nominal) + " | Saldo: " + formatRupiah(this.saldo));
        return true;
    }

    private void pesanSistem(String pesan) {
        System.out.println("[SISTEM]: " + pesan);
    }

    private String formatRupiah(double jumlah) {
        return "Rp " + String.format("%,.0f", jumlah);
    }
}
