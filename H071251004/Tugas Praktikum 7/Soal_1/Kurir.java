package Soal_1;

import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random;

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int jumlahAmbil = random.nextInt(5) + 1;
                gudang.ambilStok(jumlahAmbil);
                Thread.sleep(random.nextInt(1001) + 2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
