import java.util.Random;

public class DataProcessor {
    public ProcessingResult process(String fileName) throws InterruptedException {
        long start = System.currentTimeMillis();
        
        // Simulasi pembacaan file (500ms - 2000ms)
        int sleepTime = 500 + new Random().nextInt(1501);
        Thread.sleep(sleepTime);
        
        // Simulasi hitung kata (100 - 1000 kata)
        int wordCount = 100 + new Random().nextInt(901);
        long duration = System.currentTimeMillis() - start;
        
        return new ProcessingResult(fileName, Thread.currentThread().getName(), duration, wordCount);
    }
}