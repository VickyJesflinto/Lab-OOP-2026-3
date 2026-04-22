public class Laptop extends Produk {
    private String prosesor;
    private int ram;

    public Laptop(String merek, String nomorSeri, double harga, 
                  String prosesor, int ram) {
        super(merek, nomorSeri, harga);
        this.prosesor = prosesor;
        this.ram = ram;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Prosesor: " + prosesor);
        System.out.println("RAM: " + ram + " GB");
    }
}