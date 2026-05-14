public class Kubus extends BangunRuang {
    private double sisi;

    public Kubus(double sisi) {
        super("Kubus");
        this.sisi = sisi;
    }

    public double hitungLuasPermukaan() {
        return 6 * sisi * sisi;
    }

    public double hitungVolume() {
        return Math.pow(sisi, 3);
    }
}