package soal1;

import java.util.Scanner;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      Scanner sabri = new Scanner(System.in);
      KaryawanKontrak rizo = new KaryawanKontrak("rizo", "I345", 500000);
      System.out.print("jumlah kehadiran Karyawan Kontrak: ");
      int absenKK = sabri.nextInt();

      for(int i = 0; i < absenKK; ++i) {
         rizo.hadir();
      }

      rizo.tampilkanInfo();
      KaryawanTetap ahmad = new KaryawanTetap("Ahmad", "H0712", 2000000, 500000);
      System.out.print("jumlah kehadiran Karyawan Tetap: ");
      int absenKT = sabri.nextInt();

      for(int i = 0; i < absenKT; ++i) {
         ahmad.hadir();
      }

      ahmad.tampilkanInfo();
   }
}
