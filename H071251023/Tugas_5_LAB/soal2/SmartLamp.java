package soal2;

class SmartLamp extends PerangkatElektronik implements KontrolSuara {
   SmartLamp(String merk, int dayalistrik) {
      super(merk, dayalistrik);
   }

   public void ProsesPerintah(String Perintah) {
      if (Perintah.equals("NYALA")) {
         System.out.println("Lampu berpijar");
      } else {
         System.out.println("kamu ngapain...");
      }

   }

   void cekFungsi() {
      System.out.println("Memeriksa sistem pencahayaan...");
   }
}
