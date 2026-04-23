package Soal1;

public class BangunDatar {
    public double hitungLuas() {
        return 0;
    }
}

class Lingkaran extends BangunDatar {
    protected double r;
    public Lingkaran(double r) {
        this.r = r;
    }
    public double hitungLuas() {
        return Math.PI * r * r;
    }
    public double hitungKeliling() {
        return 2 * Math.PI * r;
    }
}

class Tabung extends Lingkaran {
    private double t;
    public Tabung(double r, double t) {
        super(r);
        this.t = t;
    }
    public double hitungVolume() {
        return hitungLuas() * t;
    }
    public double hitungLuasPermukaan() {
        return (r + t) * 2 * Math.PI * r;
    }
}

class Bola extends Lingkaran {
    public Bola(double r) {
        super(r);
    }
    public double hitungVolume() {
        return (4.0/3.0) * hitungLuas() * r;
    }
    public double hitungLuasPermukaan() {
        return 4 * hitungLuas();
    }
}

class Persegi extends BangunDatar {
    protected double sisi;
    public Persegi(double sisi) {
        this.sisi = sisi;
    }
    public double hitungLuas() {
        return sisi * sisi;
    }
    public double hitungKeliling() {
        return 4 * sisi;
    }
}

class Kubus extends Persegi {
    public Kubus(double sisi) {
        super(sisi);
    }
    public double hitungVolume() {
        return hitungLuas() * sisi;
    }
    public double hitungLuasPermukaan() {
        return hitungLuas() * 6;
    }
}

class PersegiPanjang extends BangunDatar {
    protected double p, l;
    public PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }
    public double hitungLuas() {
        return p * l;
    }
    public double hitungKeliling() {
        return (p + l) * 2;
    }
}

class Balok extends PersegiPanjang {
    private double t;
    public Balok(double p, double l, double t) {
        super(p, l);
        this.t = t;
    }
    public double hitungVolume() {
        return hitungLuas() * t;
    }
    public double hitungLuasPermukaan() {
        return ((p * l) + (p * t) + (l * t)) * 2;
    }
}

class Trapesium extends BangunDatar {
    private double sisi1, sisi2, sisi3, sisi4, tinggi;
    public Trapesium(double sisi1, double sisi2, double sisi3, double sisi4, double tinggi) {
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
        this.tinggi = tinggi;
    }
    public double hitungLuas() {
        return 0.5 * (sisi1 + sisi2) * tinggi;
    }
    public double hitungKeliling() {
        return sisi1 + sisi2 + sisi3 + sisi4;
    }
}
