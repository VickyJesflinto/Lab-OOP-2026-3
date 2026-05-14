package TokoElektronik;

public class Produk {
    String merek;
    int nomorSeri;
    double harga;

    public Produk(String merek, int nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Nomor Seri: " + nomorSeri);
        System.out.println("Harga: Rp" + harga);
    }
}

class Smartphone extends Produk {
    double ukuranLayar;
    int kapasitasPenyimpanan;

    public Smartphone(String merek, int nomorSeri, double harga, double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inci");
        System.out.println("Kapasitas Penyimpanan: " + kapasitasPenyimpanan + "GB");
    }
}

class Laptop extends Produk {
    int ukuranRam;
    String tipeProsesor;

    public Laptop(String merek, int nomorSeri, double harga, int ukuranRam, String tipeProsesor) {
        super(merek, nomorSeri, harga);
        this.ukuranRam = ukuranRam;
        this.tipeProsesor = tipeProsesor;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Prosesor: " + tipeProsesor);
        System.out.println("Ukuran RAM: " + ukuranRam + "GB");
    }
}

class Kamera extends Produk {
    int resolusi;
    String tipeLensa;

    public Kamera(String merek, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipeLensa = tipeLensa;
    }

    void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi: " + resolusi + "MP");
        System.out.println("Tipe Lensa: " + tipeLensa);
    }
}