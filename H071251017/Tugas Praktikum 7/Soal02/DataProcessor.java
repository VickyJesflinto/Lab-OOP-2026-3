package soal2;

import java.util.Random;

public class DataProcessor {
    private static final Random random = new Random();

    
    public int process(String fileName) throws InterruptedException {
        int delay = 500 + random.nextInt(1500); 
        Thread.sleep(delay);
        int jumlahKata = 50 + random.nextInt(451); 
        return jumlahKata;
    }
}
