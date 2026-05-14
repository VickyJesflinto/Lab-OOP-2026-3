package soal2;

class SmartSpeaker extends PerangkatElektronik implements InteraksiListrik, KontrolSuara {
   SmartSpeaker(String merk, int dayalistrik) {
      super(merk, dayalistrik);
   }

   public void HubungkanWifi() {
      System.out.println("speaker kok pke wifi...");
   }

   public void ProsesPerintah(String Perintah) {
      System.out.println("Memutar lagu " + Perintah);
   }

   void cekFungsi() {
      System.out.println("The bluetooth is not connect...");
   }
}
