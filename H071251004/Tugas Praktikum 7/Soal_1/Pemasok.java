package Soal_1;

import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random;

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int jumlahBarang = random.nextInt(7) + 1;
                gudang.tambahStok(jumlahBarang);   
                Thread.sleep(random.nextInt(1001) + 1000);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
