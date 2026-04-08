public class Skincare {
    String namaProduk;
    int harga;
    Brand brand; 
    Review ulasanUtama; 

    
    public Skincare() {
        this.namaProduk = "Produk Sample";
        this.harga = 0;
        this.brand = new Brand("No Brand", "Unknown");
        this.ulasanUtama = new Review("Anonymous", 0, "Belum ada review.");
    }

    
    public Skincare(String namaProduk, int harga, Brand brand, Review ulasanUtama) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.brand = brand;
        this.ulasanUtama = ulasanUtama;
    }

    
    public void displayInfo() {
        System.out.println("========= PRODUK SKINCARE =========");
        System.out.println("Produk : " + this.namaProduk);
        System.out.println("Brand  : " + this.brand.namaBrand + " (" + this.brand.asalNegara + ")");
        System.out.println("Harga  : Rp" + this.harga);
        System.out.println("--- Review Terbaru ---");
        this.ulasanUtama.tampilkanReview(); 
        System.out.println("===================================\n");
    }

    
    public void aduKualitas(Skincare produkLain) {
        System.out.println(">>> ADU KUALITAS: " + this.namaProduk + " VS " + produkLain.namaProduk);
        
        if (this.ulasanUtama.rating > produkLain.ulasanUtama.rating) {
            System.out.println("Hasil: " + this.namaProduk + " lebih disukai pengguna!");
        } else if (this.ulasanUtama.rating < produkLain.ulasanUtama.rating) {
            System.out.println("Hasil: " + produkLain.namaProduk + " memiliki rating lebih tinggi.");
        } else {
            System.out.println("Hasil: Kedua produk memiliki kepuasan pelanggan yang sama.");
        }
        System.out.println();
    }
}
