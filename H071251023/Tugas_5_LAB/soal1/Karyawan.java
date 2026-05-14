package soal1;

abstract class Karyawan {
   private String nama;
   private String idKaryawan;
   private int jumlahKehadiran = 0;

   Karyawan(String nama, String idKaryawan) {
      this.nama = nama;
      this.idKaryawan = idKaryawan;
   }

   void tampilkanInfo(String tipe) {
      System.out.println("Nama       : " + nama);
      System.out.println("ID Karyawan: " + idKaryawan);
      System.out.println("Jumlah Kehadiran " + tipe + ": " + jumlahKehadiran);
   }

   void hadir() {
      ++this.jumlahKehadiran;
   }

   int getinfohadir() {
      return this.jumlahKehadiran;
   }

   abstract int hitungGaji();
}
