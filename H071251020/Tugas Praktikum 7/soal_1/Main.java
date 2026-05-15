import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Gudang gudang = new Gudang(20); // Kapasitas maksimal 20
        
        // Thread Pool: 2 Pemasok + 3 Kurir + 1 Monitoring = 6 thread
        ExecutorService executor = Executors.newFixedThreadPool(6);

        System.out.println(" Sistem Gudang Dimulai...");
        executor.submit(new Pemasok(gudang));
        executor.submit(new Pemasok(gudang));
        executor.submit(new Kurir(gudang));
        executor.submit(new Kurir(gudang));
        executor.submit(new Kurir(gudang));
        executor.submit(new Monitoring(gudang));

        // Jalankan sistem selama 15 detik
        Thread.sleep(15000);
        System.out.println("\n Waktu habis. Menghentikan sistem...");

        // Hentikan aman
        executor.shutdown();
        if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        System.out.println("Sistem Gudang Berhenti!");
    }
}