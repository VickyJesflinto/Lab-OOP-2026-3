package DompetDigital;

public class Dompet{
    private String pin;
    private double saldo;
    protected String idNasabah;
    String kategori;

    public Dompet(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0; 
        this.kategori = "regular";
    }

    public String IdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo; 
    }

    private void pesanTrans(String pesan) {
        System.out.println(pesan);
    }

    public void setPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            if (pinBaru.length() == 5) {
                this.pin = pinBaru;
                pesanTrans("Ubah PIN Berhasil");
            } else {
                pesanTrans("Gagal: PIN baru harus tepat 6 karakter!");
            }
        } else {
            pesanTrans("Gagal: PIN lama salah!");
        }
    }

    public void setorTunai(double nominal) {
        if (nominal > 0) {
            this.saldo += nominal;
            pesanTrans("Setor Tunai: +" + nominal);
        } else {
            pesanTrans("Gagal: Nominal tidak boleh negatif");
        }
    }

    public void tarikTunai(double nominal, String inputPin) {
        if (!this.pin.equals(inputPin)) {
            pesanTrans("Gagal: PIN salah!");
        } else if (nominal > saldo) {
            pesanTrans("Gagal: Saldo tidak mencukupi!");
        } else {
            this.saldo -= nominal;
            pesanTrans("Tarik Tunai: -" + nominal);
        }
    }
}