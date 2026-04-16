public class ScubaGear {
    // Atribut class pendukung
    public String merek;
    public int kapasitasOksigen; // dalam menit
    public double batasKedalaman; // dalam meter

    // Constructor default
    public ScubaGear() {
        this.merek = "Generic";
        this.kapasitasOksigen = 60;
        this.batasKedalaman = 20.0;
    }

    // Constructor berparameter
    public ScubaGear(String merek, int kapasitasOksigen, double batasKedalaman) {
        this.merek = merek;
        this.kapasitasOksigen = kapasitasOksigen;
        this.batasKedalaman = batasKedalaman;
    }
}