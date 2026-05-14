package soal1;

public class KaryawanKontrak extends Karyawan {
    private double upahPerHari;
    private final double BONUS_FLAT = 500000;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        
        if (getJumlahKehadiran() > 20) {
            totalGaji += BONUS_FLAT;
        }
        return totalGaji;
    }
}