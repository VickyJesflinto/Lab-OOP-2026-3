package Soal_1;

class BangunDatar {
    double hitungLuas() {
        return 0;
    }

    double hitungKeliling() {
        return 0;
    }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double s) {
        this.sisi = s;
    }

    double hitungLuas() {
        return sisi * sisi;
    }

    double hitungKeliling() {
        return 4 * sisi; 
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    double hitungLuas() {
        return p * l;
    }

    double hitungKeliling() {
        return 2 * (p + l);
    }
}

class Lingkaran extends BangunDatar {
    double r;

    Lingkaran(double r) {
        this.r = r;
    }

    double hitungLuas() {
        return Math.PI * r * r;
    }

    double hitungKeliling() {
        return 2 * Math.PI * r;
    }
}

class Trapesium extends BangunDatar {
    double sisi1, sisi2, sisi3, sisi4, tinggi;
    
    Trapesium(double s1, double s2, double s3, double s4, double t) {
        this.sisi1 = s1; 
        this.sisi2 = s2; 
        this.sisi3 = s3;
        this.sisi4 = s4;
        this.tinggi = t;
    }

    double hitungLuas() {
        return ((sisi1 + sisi2) * tinggi) / 2;
    }

    double hitungKeliling() {
        return sisi1 + sisi2 + sisi3 + sisi4;
    }
}