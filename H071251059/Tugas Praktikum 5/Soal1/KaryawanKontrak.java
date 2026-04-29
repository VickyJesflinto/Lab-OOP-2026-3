package Soal1;

public class KaryawanKontrak extends Karyawan {
    private double upahPerHari;
    private static final double BONUS_KEHADIRAN = 500000;
    private static final int BATAS_BONUS = 20;
 
    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }
 
    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        if (getJumlahKehadiran() > BATAS_BONUS) {
            totalGaji += BONUS_KEHADIRAN;
        }
        return totalGaji;
    }
 
    public boolean mendapatBonus() {
        return getJumlahKehadiran() > BATAS_BONUS;
    }
 
    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Upah/Hari    : Rp" + String.format("%,.0f", upahPerHari) + "\n" +
               "Bonus Flat   : " + (mendapatBonus() ? "Rp500.000 (kehadiran > 20 hari)" : "Tidak ada") + "\n" +
               "Total Gaji   : Rp" + String.format("%,.0f", hitungGaji());
    }
}
