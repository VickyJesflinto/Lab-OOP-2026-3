package Soal_2;

public class Produk {
    public String merek;
    public int nomorSeri;
    public double harga;
 
    public Produk(String merek, int nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    public int getNomorSeri() {
        return nomorSeri;
    }

    public void tampilkanInfo() {
        System.out.println("Brand: " + merek);
        System.out.println("Series Number: " + nomorSeri);
        System.out.println("Price: $" + harga);
    }
}

class Smartphone extends Produk {
    public double ukuranLayar;
    public int kapasitasPenyimpanan;

    public Smartphone(String merek, int nomorSeri, double harga, double ukuranLayar, int kapasitasPenyimpanan) {
        super(merek, nomorSeri, harga);
        this.ukuranLayar = ukuranLayar;
        this.kapasitasPenyimpanan = kapasitasPenyimpanan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran Layar: " + ukuranLayar + " inci");
        System.out.println("Kapasitas Penyimpanan: " + kapasitasPenyimpanan + " GB");
    }
}

class Laptop extends Produk {
    public int ukuranRAM;
    public String tipeProsesor;


    public Laptop(String merek, int nomorSeri, double harga, String tipeProsesor, int ukuranRAM) {
        super(merek, nomorSeri, harga);
        this.ukuranRAM = ukuranRAM;
        this.tipeProsesor = tipeProsesor;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Ukuran RAM: " + ukuranRAM + " GB");
        System.out.println("Tipe Prosesor: " + tipeProsesor);
    }
}

class Kamera extends Produk {
    public int resolusi;
    public String tipeLensa;

    public Kamera(String merek, int nomorSeri, double harga, int resolusi, String tipeLensa) {
        super(merek, nomorSeri, harga);
        this.resolusi = resolusi;
        this.tipeLensa = tipeLensa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Resolusi: " + resolusi + " MP");
        System.out.println("Tipe Lensa: " + tipeLensa);
    }
}


