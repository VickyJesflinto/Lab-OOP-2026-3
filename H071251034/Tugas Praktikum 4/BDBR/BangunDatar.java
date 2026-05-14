package BDBR;

public class BangunDatar {
    public void hitungLuas() {}
    public void hitungKeliling() {}
}

class Persegi extends BangunDatar {
    double sisi;
    public Persegi(double sisi) { this.sisi = sisi; }    
    public void hitungLuas() { 
        System.out.println("Luas persegi: " + (sisi * sisi)); 
    }
    public void hitungKeliling() { 
        System.out.println("Keliling persegi: " + (4 * sisi)); 
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;
    public PersegiPanjang(double p, double l) { this.p = p; this.l = l; }
    
    public void hitungLuas() { 
        System.out.println("Luas persegi panjang: " + (p * l)); 
    }
    public void hitungKeliling() { 
        System.out.println("Keliling persegi panjang: " + (2 * (p + l))); 
    }
}

class Lingkaran extends BangunDatar {
    double r;
    public Lingkaran(double r) { this.r = r; }
    
    public void hitungLuas() { 
        System.out.println("Luas lingkaran: " + (3.14 * r * r)); 
    }
    public void hitungKeliling() { 
        System.out.println("Keliling lingkaran: " + (2 * 3.14 * r)); 
    }
}

class Trapesium extends BangunDatar {
    double s1, s2, s3, s4, t;
    public Trapesium(double s1, double s2, double s3, double s4, double t) {
        this.s1 = s1; this.s2 = s2; this.s3 = s3; this.s4 = s4; this.t = t;
    }
    
    public void hitungLuas() { 
        System.out.println("Luas trapesium: " + (0.5 * (s1 + s2) * t)); 
    }
    public void hitungKeliling() { 
        System.out.println("Keliling trapesium: " + (s1 + s2 + s3 + s4)); 
    }
}