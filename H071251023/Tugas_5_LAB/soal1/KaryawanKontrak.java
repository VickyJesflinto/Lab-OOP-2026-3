package soal1;

class KaryawanKontrak extends Karyawan {
   private int upahPerhari;

   KaryawanKontrak(String nama, String idKaryawan, int upahPerhari) {
      super(nama, idKaryawan);
      this.upahPerhari = upahPerhari;
   }

   int hitungGaji() {
      int totalGaji = this.upahPerhari * this.getinfohadir();
      if (this.getinfohadir() > 20) {
         totalGaji += 500000;
      }

      return totalGaji;
   }

   void tampilkanInfo() {
      super.tampilkanInfo("Karyawan Kontrak");
      System.out.println("Tipe Karyawan: Karyawan Kontrak");
      System.out.println("Upah Per Hari: " + this.upahPerhari);
      System.out.println("Hitung gaji : " + this.hitungGaji());
   }
}  
