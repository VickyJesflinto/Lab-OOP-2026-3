class DompetDigital {

    
    private double saldo;
    private String pin;

    protected String idNasabah;

    int batasTransaksi;

    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.batasTransaksi = 1000000;
    }

    
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    
    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("PIN lama salah!");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 digit!");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah");
        }
    }

    
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid!");
        } else {
            saldo += jumlah;
            log("Setor berhasil: " + jumlah);
        }
    }

    
    public void tarik(double jumlah, String inputPin) {
        if (!this.pin.equals(inputPin)) {
            System.out.println("PIN salah!");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
        } else {
            saldo -= jumlah;
            log("Tarik berhasil: " + jumlah);
        }
    }

    
    private void log(String pesan) {
        System.out.println("[LOG] " + pesan);
    }
}