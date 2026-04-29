package Soal1;

public class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;
 
    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }
 
    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }
 
    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Gaji Pokok   : Rp" + String.format("%,.0f", gajiPokok) + "\n" +
               "Tunjangan    : Rp" + String.format("%,.0f", tunjanganMakan) + "/hari\n" +
               "Total Gaji   : Rp" + String.format("%,.0f", hitungGaji());
    }
}
