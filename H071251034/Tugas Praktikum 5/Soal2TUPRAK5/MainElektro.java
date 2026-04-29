package Soal2TUPRAK5;

public class MainElektro {
    public static void main(String[] args) {
        SmartCCTV cctv1 = new SmartCCTV("Xiaomi",15 );
        SmartLamp lampu1 = new SmartLamp("panasonic",3 );
        SmartSpeaker speaker1 = new SmartSpeaker("Sony", 6);


        speaker1.cekFungsi();
        speaker1.hubungkanWIFI();
        speaker1.prosesPerintah("putar");
        lampu1.cekFungsi();
        lampu1.prosesPerintah("nyala");
        // lampu1.hubungkanWIFI();
        cctv1.cekFungsi();
        cctv1.hubungkanWIFI();
        // cctv1.prosesPerintah("rekam");
    }
    
}
