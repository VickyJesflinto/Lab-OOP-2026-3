package Soal1TUPRAK5;

abstract class Karyawan {
    private String nama;
    private String idKaryawan ;
    private int jumlahKehadiran = 0;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    public void hadir() {
        jumlahKehadiran++;
    }
    
    abstract double hitungGaji();

    public String getNama() {
        return nama;
    }
    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }
    public String getIdKaryawan() {
        return idKaryawan;
    }
}


