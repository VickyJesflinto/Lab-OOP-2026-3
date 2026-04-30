package soal2;

class CCTV extends PerangkatElektronik implements InteraksiListrik {
   CCTV(String merk, int dayalistrik) {
      super(merk, dayalistrik);
   }

   public void HubungkanWifi() {
      System.out.println("Mengirim data ke server...");
   }

   void cekFungsi() {
      System.out.println("Cek jaringan internet...");
   }
}
