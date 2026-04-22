import java.util.Scanner;


class Bangun {
    double luas() { return 0; }
    double keliling() { return 0; }
    double volume() { return 0; }
}

class Persegi extends Bangun {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double luas() { return sisi * sisi; }
    double keliling() { return 4 * sisi; }
}

class Lingkaran extends Bangun {
    double r;

    Lingkaran(double r) {
        this.r = r;
    }

    double luas() { return Math.PI * r * r; }
    double keliling() { return 2 * Math.PI * r; }
}

class Trapesium extends Bangun {
    double a, b, c, d, t;

    Trapesium(double a, double b, double c, double d, double t) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.t = t;
    }

    double luas() {
        return 0.5 * (a + b) * t;
    }

    double keliling() {
        return a + b + c + d;
    }
}

class Kubus extends Bangun {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    double luas() { return 6 * sisi * sisi; }
    double volume() { return sisi * sisi * sisi; }
}

class Bola extends Bangun {
    double r;

    Bola(double r) {
        this.r = r;
    }

    double luas() { return 4 * Math.PI * r * r; }
    double volume() { return (4.0/3.0) * Math.PI * r * r * r; }
}

public class Main001 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Persegi");
            System.out.println("2. Lingkaran");
            System.out.println("3. Kubus");
            System.out.println("4. Bola");
            System.out.println("5. Trapesium");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1: {
                    System.out.print("Masukkan sisi: ");
                    double sisi = input.nextDouble();

                    Persegi p = new Persegi(sisi);
                    System.out.println("Luas = " + p.luas());
                    System.out.println("Keliling = " + p.keliling());
                    break;
                }

                case 2: {
                    System.out.print("Masukkan jari-jari: ");
                    double r = input.nextDouble();

                    Lingkaran l = new Lingkaran(r);
                    System.out.println("Luas = " + l.luas());
                    System.out.println("Keliling = " + l.keliling());
                    break;
                }

                case 3: {
                    System.out.print("Masukkan sisi: ");
                    double s = input.nextDouble();

                    Kubus k = new Kubus(s);
                    System.out.println("Luas Permukaan = " + k.luas());
                    System.out.println("Volume = " + k.volume());
                    break;
                }

                case 4: {
                    System.out.print("Masukkan jari-jari: ");
                    double r = input.nextDouble();

                    Bola b = new Bola(r);
                    System.out.println("Luas Permukaan = " + b.luas());
                    System.out.println("Volume = " + b.volume());
                    break;
                }

                case 5: {
                    System.out.print("Masukkan sisi a: ");
                    double a = input.nextDouble();

                    System.out.print("Masukkan sisi b: ");
                    double b = input.nextDouble();

                    System.out.print("Masukkan sisi c: ");
                    double c = input.nextDouble();

                    System.out.print("Masukkan sisi d: ");
                    double d = input.nextDouble();

                    System.out.print("Masukkan tinggi: ");
                    double t = input.nextDouble();

                    Trapesium tr = new Trapesium(a, b, c, d, t);
                    System.out.println("Luas = " + tr.luas());
                    System.out.println("Keliling = " + tr.keliling());
                    break;
                }

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid");
            }

        } while (pilihan != 0);
    }
}