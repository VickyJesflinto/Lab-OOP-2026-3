package Soal_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainWarehouse {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=============================");
        System.out.println("    The Central Warehouse    ");
        System.out.println("=============================");

        Gudang gudang = new Gudang(20);

        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        poolPemasok.submit(new Pemasok(gudang));
        poolPemasok.submit(new Pemasok(gudang));

        ExecutorService poolKurir = Executors.newFixedThreadPool(3);
        poolKurir.submit(new Kurir(gudang));
        poolKurir.submit(new Kurir(gudang));
        poolKurir.submit(new Kurir(gudang));

        Thread monitorThread = new Thread(new Monitoring(gudang), "Monitor");
        monitorThread.setDaemon(true);
        monitorThread.start();
        System.out.println("\nSistem berjalan selama 15 detik...");

        Thread.sleep(15000);

        System.out.println("\n==================================");
        System.out.println("Waktu Habis. Menghentikan Sistem...");
        System.out.println("==================================");

        poolPemasok.shutdown();
        if (!poolPemasok.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Pemasok masih berjalan, memaksa shutdown...");
            poolPemasok.shutdownNow();
        }

        poolKurir.shutdown();
        if (!poolKurir.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Kurir masih berjalan, memaksa shutdown...");
            poolKurir.shutdownNow();
        }

        monitorThread.interrupt();

        System.out.println("Semua thread dihentikan. Sistem Warehouse ditutup.");
        System.out.println("Stok akhir di gudang: " + gudang.getStok() + " barang.");
    }
}
