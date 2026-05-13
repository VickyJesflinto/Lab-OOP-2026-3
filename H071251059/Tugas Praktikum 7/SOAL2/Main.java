package SOAL2;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

// 1. Class DataProcessor untuk simulasi indexing
class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        // Simulasi waktu proses acak 500ms - 2000ms
        int duration = 500 + random.nextInt(1501);
        Thread.sleep(duration);
        
        // Simulasi jumlah kata yang ditemukan (acak 50 - 500 kata)
        return 50 + random.nextInt(451);
    }
}

// Class untuk menyimpan detail hasil per dokumen (untuk tabel akhir)
class ResultDetail {
    String threadName;
    int wordCount;
    long duration;

    public ResultDetail(String threadName, int wordCount, long duration) {
        this.threadName = threadName;
        this.wordCount = wordCount;
        this.duration = duration;
    }
}

public class Main {

    public static void main(String[] args) {
        int jumlahDokumen = 10;
        int jumlahThread = 4;

        // 2. Thread Management & Concurrent Storage
        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread);
        ConcurrentHashMap<String, ResultDetail> results = new ConcurrentHashMap<>();
        
        // 3. Synchronization Barrier
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);
        DataProcessor processor = new DataProcessor();
        
        System.out.println("=== MEMULAI PROSES INDEXING PARALEL ===\n");
        long startTimeGlobal = System.currentTimeMillis();

        for (int i = 1; i <= jumlahDokumen; i++) {
            String docName = "Dokumen_" + (char) ('A' + (i - 1)) + ".txt";
            
            executor.execute(() -> {
                long startTask = System.currentTimeMillis();
                try {
                    int words = processor.process(docName);
                    long endTask = System.currentTimeMillis();
                    long duration = endTask - startTask;

                    // Simpan hasil ke ConcurrentHashMap (Thread-Safe)
                    results.put(docName, new ResultDetail(Thread.currentThread().getName(), words, duration));

                    // 4. Monitoring Progres Real-time
                    System.out.printf("[%s] Selesai memproses %s (%d kata)\n", 
                                      Thread.currentThread().getName(), docName, words);

                } catch (InterruptedException e) {
                    System.err.println("Thread terinterupsi: " + e.getMessage());
                } finally {
                    latch.countDown(); // Mengurangi count latch
                }
            });
        }

        try {
            // Tunggu hingga semua dokumen selesai diproses
            latch.await();
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeGlobal = System.currentTimeMillis();
        tampilkanOutputAkhir(results, endTimeGlobal - startTimeGlobal);
    }

    // 5. Output Akhir (Klasemen)
    private static void tampilkanOutputAkhir(ConcurrentHashMap<String, ResultDetail> results, long totalDuration) {
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-15s | %-15s | %-15s\n", "Nama Dokumen", "Thread", "Durasi (ms)");
        System.out.println("-".repeat(60));

        long totalWords = 0;
        long totalProcessingTime = 0;

        for (Map.Entry<String, ResultDetail> entry : results.entrySet()) {
            ResultDetail detail = entry.getValue();
            System.out.printf("%-15s | %-15s | %-15d ms\n", 
                              entry.getKey(), detail.threadName, detail.duration);
            
            totalWords += detail.wordCount;
            totalProcessingTime += detail.duration;
        }

        System.out.println("=".repeat(60));
        System.out.println("RINGKASAN STATISTIK:");
        System.out.println("Total Kata Keseluruhan : " + totalWords + " kata");
        System.out.printf("Rata-rata Waktu Proses : %.2f ms\n", (double) totalProcessingTime / results.size());
        System.out.println("Total Durasi Eksekusi  : " + totalDuration + " ms");
        System.out.println("=".repeat(60));
    }
}


