package Soal1;

public abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;
 
    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }
 
    public void absen() {
        jumlahKehadiran++;
    }
 
    public abstract double hitungGaji();
 
    @Override
    public String toString() {
        return "Nama         : " + nama + "\n" +
               "ID Karyawan  : " + idKaryawan + "\n" +
               "Kehadiran    : " + jumlahKehadiran + " hari";
    }
 
    public String getNama() { return nama; }
    public String getIdKaryawan() { return idKaryawan; }
    public int getJumlahKehadiran() { return jumlahKehadiran; }
}
 
