package Soal_1;

class BangunRuang {
    double hitungLuasPermukaan() {
        return 0;
    }

    double hitungVolume() {
        return 0;
    }
}

class Balok extends BangunRuang {
    double p, l, t;
    
    Balok(double p, double l, double t) {
        this.p = p; this.l = l; this.t = t; 
    }

    double hitungLuasPermukaan() {
        return 2 * ((p * l) + (p * t) + (l * t));
    }

    double hitungVolume() {
        return p * l * t;
    }
}

class Bola extends BangunRuang {
    double r;

    Bola(double r) {
        this.r = r;
    }

    double hitungLuasPermukaan() {
        return 4 * Math.PI * r * r;
    }

    double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }
}

class Kubus extends BangunRuang {
    double sisi;
    
    Kubus(double s) { 
        this.sisi = s; 
    }

    double hitungLuasPermukaan() { 
        return 6 * (sisi * sisi); 
    }

    double hitungVolume() { 
        return sisi * sisi * sisi;
    }

}

class Tabung extends BangunRuang {
    double r, t;

    Tabung(double r, double t) {
        this.r = r; 
        this.t = t;
    }

    double hitungLuasPermukaan() {
        return 2 * Math.PI * r * (r + t);
    }

    double hitungVolume() {
        return Math.PI * r * r * t;
    }
}
