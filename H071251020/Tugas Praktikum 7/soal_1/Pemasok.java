import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            // Loop berjalan selama thread tidak di-interrupt oleh Executor shutdown
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = rand.nextInt(5) + 1; // Random 1-5 barang
                gudang.tambahStok(jumlah);
                Thread.sleep(1000 + rand.nextInt(1001)); // Delay 1-2 detik
            }
        } catch (InterruptedException e) {
            // Normal exit saat executor shutdown()
            Thread.currentThread().interrupt(); // Restore interrupt flag
        }
    }
}