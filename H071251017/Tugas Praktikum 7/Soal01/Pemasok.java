package soal1;

import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int jumlah = random.nextInt(10) + 1; 
                gudang.tambahStok(jumlah);

                int delay = 1000 + random.nextInt(1000); 
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
