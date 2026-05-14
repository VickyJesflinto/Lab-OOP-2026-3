package TP7SOAL1;
import java.util.Random;

public class Pemasok implements Runnable {
    Gudang gudang;
    Random random = new Random();
    boolean isRunning = true;

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    public void stopThread() {
        isRunning = false;
    }

    @Override
    public void run() {
        try {
            while (isRunning && !Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1;
                gudang.tambahStok(jumlah);
                Thread.sleep(random.nextInt(1000) + 1000); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}