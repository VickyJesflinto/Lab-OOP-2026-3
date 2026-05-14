package soal2;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {
      SmartLamp sl = new SmartLamp("Philips", 25);
      SmartSpeaker ss = new SmartSpeaker("Gojoodoq", 40);
      CCTV sisitipi = new CCTV("pret", 15);
      System.out.println("--- Demonstrasi SmartLamp ---");
      sl.infoPower();
      sl.ProsesPerintah("NYALA");
      System.out.println("\n--- Demonstrasi SmartCCTV ---");
      sisitipi.infoPower();
      sisitipi.HubungkanWifi();
      System.out.println("\n--- Demonstrasi SmartSpeaker (Multi-Interface) ---");
      ss.infoPower();
      ss.cekFungsi();
      ss.HubungkanWifi();
      ss.ProsesPerintah("Mainkan lagu jazz");
   }
}
