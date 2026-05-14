package soal1;
import java.util.*;
class KaryawanTetap extends Karyawan {
   private int gajiPokok;
   private int tunjanganMakan;

   KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan) {
      super(nama, idKaryawan);
      this.gajiPokok = gajiPokok;
      this.tunjanganMakan = tunjanganMakan;
   }

   public int hitungGaji() {
      return this.gajiPokok + this.tunjanganMakan * this.getinfohadir();
   }

   public double hitungGaji(double bonusKinerja) {
      return hitungGaji() + bonusKinerja;
   }

   void tampilkanInfo() {
      Scanner sabri = new Scanner(System.in);
      System.out.print("bonus kinerja :");int input = sabri.nextInt();
      super.tampilkanInfo("Karyawan Tetap");
      System.out.println("Gaji Pokok     : " + this.gajiPokok);
      System.out.println("Tunjangan Makan: " + this.tunjanganMakan);
      System.out.println("total gaji : " + hitungGaji(input));
   }
}
