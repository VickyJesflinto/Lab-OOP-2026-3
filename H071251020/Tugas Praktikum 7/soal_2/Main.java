import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        // ConcurrentHashMap menjamin thread-safety saat banyak thread menulis bersamaan
        ConcurrentHashMap<String, ProcessingResult> hasilIndexing = new ConcurrentHashMap<>();
        
        // Daftar 10 dokumen simulasi
        List<String> documents = Arrays.asList(
            "Dok_A.txt", "Dok_B.txt", "Dok_C.txt", "Dok_D.txt", "Dok_E.txt",
            "Dok_F.txt", "Dok_G.txt", "Dok_H.txt", "Dok_I.txt", "Dok_J.txt"
        );

        // CountDownLatch: Main thread akan BLOCKED sampai latch mencapai 0
        CountDownLatch latch = new CountDownLatch(documents.size());
        
        // Executor dengan 4 thread tetap
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Memulai indexing " + documents.size() + " dokumen...\n");

        for (String doc : documents) {
            executor.submit(() -> {
                try {
                    ProcessingResult result = processor.process(doc);
                    hasilIndexing.put(doc, result);
                    System.out.println("[" + result.threadName + "] Selesai memproses " + doc + " (" + result.wordCount + " kata, " + result.durationMs + "ms)");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // Kurangi counter, jika 0 → release main thread
                }
            });
        }

        try {
            // Tunggu sampai semua dokumen selesai
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tampilkan Klasemen Akhir
        System.out.println("\n=== KLASEMEN INDEXING ===");
        System.out.printf("%-15s | %-10s | %-10s | %-10s%n", "Dokumen", "Thread", "Durasi(ms)", "Kata");
        System.out.println("-------------------------------------------------------------");
        
        int totalWords = 0;
        long totalTime = 0;
        
        for (ProcessingResult res : hasilIndexing.values()) {
            System.out.printf("%-15s | %-10s | %-10d | %-10d%n", res.fileName, res.threadName, res.durationMs, res.wordCount);
            totalWords += res.wordCount;
            totalTime += res.durationMs;
        }
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Kata: " + totalWords);
        System.out.printf("Rata-rata Waktu: %.2f ms%n", (double) totalTime / documents.size());

        executor.shutdown();
    }
}