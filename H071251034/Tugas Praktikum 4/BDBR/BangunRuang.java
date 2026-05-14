package BDBR;

public class BangunRuang {
    public void hitungLuas() {}
    public void hitungVolume() {}
}

class Kubus extends BangunRuang {
    double sisi;
    public Kubus(double sisi) { this.sisi = sisi; }
    
    public void hitungLuas() { 
        System.out.println("Luas permukaan kubus: " + (6 * (sisi * sisi))); 
    }
    public void hitungVolume() { 
        System.out.println("Volume kubus: " + (sisi * sisi * sisi)); 
    }
}

class Balok extends BangunRuang {
    double p, l, t;
    public Balok(double p, double l, double t) { this.p = p; this.l = l; this.t = t; }
    
    public void hitungLuas() { 
        System.out.println("Luas permukaan balok: " + (2 * ((p*l) + (p*t) + (l*t)))); 
    }
    public void hitungVolume() { 
        System.out.println("Volume balok: " + (p * l * t)); 
    }
}

class Bola extends BangunRuang {
    double r;
    public Bola(double r) { this.r = r; }
    
    public void hitungLuas() { 
        System.out.println("Luas permukaan bola: " + (4 * 3.14 * r * r)); 
    }
    public void hitungVolume() { 
        System.out.println("Volume bola: " + ((4/3) * 3.14 * r * r * r)); 
    }
}

class Tabung extends BangunRuang {
    double r, t;
    public Tabung(double r, double t) { this.r = r; this.t = t; }
    
    public void hitungLuas() { 
        System.out.println("Luas permukaan tabung: " + (2 * 3.14 * r * (r + t))); 
    }
    public void hitungVolume() { 
        System.out.println("Volume tabung: " + (3.14 * r * r * t)); 
    }
}

