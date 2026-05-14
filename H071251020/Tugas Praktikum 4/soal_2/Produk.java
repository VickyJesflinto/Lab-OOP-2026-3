public class Produk {
    protected String merek;
    protected String nomorSeri;
    protected double harga;

    public Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public double getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: Rp " + (int)harga);
    }
}