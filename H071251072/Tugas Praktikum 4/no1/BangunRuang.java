package no1;

public class BangunRuang {
    double Volume(){
        return 0;
    }
    double LuasPermukaan(){
        return 0;
    }
}

class Kubus extends BangunRuang{
    double sisi;
    Kubus(double sisi){
        this.sisi = sisi;
    }
    double LuasPermukaan(){
        return 6*sisi*sisi;
    }
    double volume(){
        return sisi*sisi*sisi;
    }
}

class Balok extends BangunRuang{
    Double p,l,t;
    Balok (double p, double l, double t){
        this.p = p;
        this.l = l;
        this.t = t;
    }
    double LuasPermukaan(){return 2*(p*l +p*t +l*t);
    }
    double volume(){return p*l*t;}
}

class Bola extends BangunRuang{
    double r;

    Bola(double r){
        this.r = r;
    }
    double LuasPermukaan(){return 4*3.14*r*r;}
    double volume (){return (4.0/3)*3.14*r*r*r; }
}
class Tabung extends BangunRuang{
    double r, t;

    Tabung(double r, double t){
        this.r = r;
        this.t = t;
    }
    double LuasPermukaan(){return 2*3.14*r*(r*t);}
    double volume(){return 3*14*r*r*t; }
}


