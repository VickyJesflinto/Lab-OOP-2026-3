package soal2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=======================================================");
        System.out.println("   HIGH-PERFORMANCE DATA INDEXER - SEARCH ENGINE CORE");
        System.out.println("=======================================================\n");

        // Daftar 10 dokumen simulasi
        List<String> dokumen = Arrays.asList(
                "Dokumen_A.txt", "Dokumen_B.txt", "Dokumen_C.txt",
                "Dokumen_D.txt", "Dokumen_E.txt", "Dokumen_F.txt",
                "Dokumen_G.txt", "Dokumen_H.txt", "Dokumen_I.txt",
                "Dokumen_J.txt"
        );

        int jumlahDokumen = dokumen.size();

       
        ConcurrentHashMap<String, Integer> hasilIndex = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String[]> metadata  = new ConcurrentHashMap<>();

        
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);

     
        ExecutorService executor = Executors.newFixedThreadPool(4);
        DataProcessor processor  = new DataProcessor();

        System.out.println(" Memulai indexing " + jumlahDokumen + " dokumen dengan 4 thread...\n");
        long startTotal = System.currentTimeMillis();

       
        for (String doc : dokumen) {
            executor.submit(new IndexerTask(doc, processor, hasilIndex, metadata, latch));
        }

       
        latch.await();
        long totalDurasi = System.currentTimeMillis() - startTotal;

        executor.shutdown();

        
        System.out.println("\n=======================================================");
        System.out.println("                   KLASEMEN HASIL INDEXING");
        System.out.println("=======================================================");
        System.out.printf("%-20s %-20s %-15s %-10s%n",
                "Nama Dokumen", "Thread", "Durasi", "Jumlah Kata");
        System.out.println("-------------------------------------------------------");

        int totalKata = 0;
        long totalDurasiMs = 0;

        for (String doc : dokumen) {
            int kata = hasilIndex.getOrDefault(doc, 0);
            String[] meta = metadata.getOrDefault(doc, new String[]{"?", "?"});
            long durMs = Long.parseLong(meta[1].replace("ms", ""));
            totalKata    += kata;
            totalDurasiMs += durMs;

            System.out.printf("%-20s %-20s %-15s %-10d%n",
                    doc, meta[0], meta[1], kata);
        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-20s %-20s %-15s %-10d%n",
                "TOTAL", "-", totalDurasi + "ms (wall)", totalKata);
        System.out.printf("%nTotal Kata Keseluruhan : %d kata%n", totalKata);
        System.out.printf("Rata-rata Waktu Proses : %.0f ms/dokumen%n",
                (double) totalDurasiMs / jumlahDokumen);
        System.out.println("=======================================================");
    }
}
