package soal1;

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
        this.jumlahKehadiran++;
    }

    public abstract double hitungGaji();

    //buat getter buat akses atb privatnya.
    public String getNama() { return nama; }
    public int getJumlahKehadiran() { return jumlahKehadiran; }
}