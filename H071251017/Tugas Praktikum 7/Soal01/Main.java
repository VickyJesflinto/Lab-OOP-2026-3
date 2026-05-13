package soal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=================================================");
        System.out.println("   SISTEM LOGISTIK - THE CENTRAL WAREHOUSE");
        System.out.println("=================================================");

        Gudang gudang = new Gudang(50);

        
        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool   = Executors.newFixedThreadPool(3);

        
        Thread monitorThread = new Thread(new Monitoring(gudang), "Monitor");
        monitorThread.setDaemon(true);
        monitorThread.start();

       
        for (int i = 0; i < 2; i++) {
            pemasokPool.submit(new Pemasok(gudang));
        }

       
        for (int i = 0; i < 3; i++) {
            kurirPool.submit(new Kurir(gudang));
        }

        
        System.out.println("Sistem berjalan selama 15 detik...\n");
        Thread.sleep(15_000);

        
        System.out.println("\n Menghentikan semua thread...");
        pemasokPool.shutdownNow();
        kurirPool.shutdownNow();

        pemasokPool.awaitTermination(3, TimeUnit.SECONDS);
        kurirPool.awaitTermination(3, TimeUnit.SECONDS);

        monitorThread.interrupt();

        System.out.println("\n=================================================");
        System.out.printf("   Sistem selesai. Stok akhir gudang: %d/%d%n",
                gudang.getStok(), gudang.getKapasitasMaksimal());
        System.out.println("=================================================");
    }
}
