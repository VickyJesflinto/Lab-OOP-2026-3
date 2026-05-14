package Soal1TUPRAK5;

public class KaryawanKontrak extends Karyawan {
    public double gajiPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double gajiPerHari) {
        super(nama, idKaryawan);
        this.gajiPerHari = gajiPerHari;
    }

    @Override
    public double hitungGaji(){
        double totalgaji = gajiPerHari * getJumlahKehadiran();
        if (getJumlahKehadiran() > 20) {
            totalgaji += 500000;
        }return totalgaji;
        
    }
}
