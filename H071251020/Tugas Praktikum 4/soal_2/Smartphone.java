public class Smartphone extends Produk {
    private double ukuranLayar;
    private int kapasitasPenyimpanan;

    public Smartphone(String merek, String nomorSeri, double harga, 
                      double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inch");
        System.out.println("Kapasitas Penyimpanan: " + kapasitasPenyimpanan + " GB");
    }
}