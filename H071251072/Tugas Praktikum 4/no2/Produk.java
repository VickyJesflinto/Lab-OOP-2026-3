package no2;

public class Produk {
    String merk;
    int noSeri;
    double harga;

    Produk(String merk, int noSeri, double harga) {
        this.merk = merk;
        this.noSeri = noSeri;
        this.harga = harga;
    }

    void tampilInfo() {
        System.out.println("Merk: " + merk);
        System.out.println("No Seri: " + noSeri);
        System.out.println("Harga: " + harga);
    }
}

class Smartphone extends Produk {
    double layar;
    int storage;

    Smartphone(String merk, int noSeri, double harga, double layar, int storage) {
        super(merk, noSeri, harga); 
        this.layar = layar;
        this.storage = storage;
    }

    void tampilInfo() {
        super.tampilInfo();
        System.out.println("Layar: " + layar);
        System.out.println("Storage: " + storage);
    }
}

class Kamera extends Produk {
    int resolusi;
    String lensa;

    Kamera(String merk, int noSeri, double harga, int resolusi, String lensa) {
        super(merk, noSeri, harga);
        this.resolusi = resolusi;
        this.lensa = lensa;
    }

    void tampilInfo() {
        super.tampilInfo();
        System.out.println("Resolusi: " + resolusi);
        System.out.println("Jenis Lensa: " + lensa);
    }
}

class Laptop extends Produk {
    int ram;
    String processor;

    Laptop(String merk, int noSeri, double harga, int ram, String processor) {
        super(merk, noSeri, harga);
        this.ram = ram;
        this.processor = processor;
    }

    void tampilInfo() {
        super.tampilInfo();
        System.out.println("Ram: " + ram);
        System.out.println("Processor: " + processor);
    }
}
