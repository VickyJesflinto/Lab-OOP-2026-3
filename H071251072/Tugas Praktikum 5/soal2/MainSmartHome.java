package soal2;

public class MainSmartHome {
    public static void main(String[] args) {
        SmartSpeaker sp = new SmartSpeaker("Google", 20); 
        sp.infoPower(); 
        sp.hubungkanWiFi(); 
        sp.prosesPerintah("Putar Musik"); 

        SmartLamp sl = new SmartLamp("led", 10);
        sl.infoPower();
        sl.prosesPerintah("NYALA");

        SmartCCTV sc = new SmartCCTV("neo", 11); 
        sc.infoPower(); 
        sc.hubungkanWiFi(); 

 
    }

        

   
}