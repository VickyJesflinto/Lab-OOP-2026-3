package soal2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class IndexerTask implements Runnable {
    private final String fileName;
    private final DataProcessor processor;
    private final ConcurrentHashMap<String, Integer> hasilIndex;
    private final ConcurrentHashMap<String, String[]> metadata; 
    private final CountDownLatch latch;

    public IndexerTask(String fileName,
                       DataProcessor processor,
                       ConcurrentHashMap<String, Integer> hasilIndex,
                       ConcurrentHashMap<String, String[]> metadata,
                       CountDownLatch latch) {
        this.fileName  = fileName;
        this.processor = processor;
        this.hasilIndex = hasilIndex;
        this.metadata   = metadata;
        this.latch      = latch;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        long mulai = System.currentTimeMillis();
        try {
            int jumlahKata = processor.process(fileName);
            long durasi = System.currentTimeMillis() - mulai;

            hasilIndex.put(fileName, jumlahKata);
            metadata.put(fileName, new String[]{threadName, durasi + "ms"});

            System.out.printf("[%s]  Selesai memproses %-25s (%d kata, %dms)%n",
                    threadName, fileName, jumlahKata, durasi);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("[%s]  Diinterupsi saat memproses %s%n", threadName, fileName);
        } finally {
            latch.countDown();
        }
    }
}
