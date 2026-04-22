public class Kamera extends Produk {
    private int megapixel;
    private String jenisLensa;

    public Kamera(String merek, String nomorSeri, double harga, 
                  int megapixel, String jenisLensa) {
        super(merek, nomorSeri, harga);
        this.megapixel = megapixel;
        this.jenisLensa = jenisLensa;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Megapixel: " + megapixel);
        System.out.println("Jenis Lensa: " + jenisLensa);
    }
}