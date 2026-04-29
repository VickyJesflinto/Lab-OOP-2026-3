public class DompetDigital {
    private double saldo;           
    private String pin;                
    protected String idNasabah;        
    String namaPemilik;                

    public DompetDigital(String idNasabah, String namaPemilik, String pinAwal) {
        this.idNasabah = idNasabah;
        this.namaPemilik = namaPemilik;
        this.pin = pinAwal;
        this.saldo = 0;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() == 6) {
                this.pin = pinBaru;
                mencatatLog("PIN berhasil diperbarui.");
            } else {
                mencatatLog("Gagal: PIN baru harus 6 karakter.");
            }
        } else {
            mencatatLog("Gagal: PIN lama salah.");
        }
    }

    public void setorTunai(double jumlah) {
        if (jumlah > 0) { 
            this.saldo += jumlah;
            mencatatLog("Setor tunai berhasil: Rp" + jumlah);
        } else {
            mencatatLog("Gagal: Nominal setor tidak valid.");
        }
    }

    public void tarikTunai(double jumlah, String inputPin) {
        if (!this.pin.equals(inputPin)) {
            mencatatLog("Gagal: PIN salah.");
        } else if (jumlah > saldo) {
            mencatatLog("Gagal: Saldo tidak mencukupi.");
        } else if (jumlah <= 0) {
            mencatatLog("Gagal: Nominal tarik tidak valid.");
        } else {
            this.saldo -= jumlah;
            mencatatLog("Tarik tunai berhasil: Rp" + jumlah);
        }
    }

    private void mencatatLog(String pesan) {
        System.out.println("[LOG SISTEM]: " + pesan);
    }
}