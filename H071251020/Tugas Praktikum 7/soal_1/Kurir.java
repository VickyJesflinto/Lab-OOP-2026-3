import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = rand.nextInt(4) + 1; // Random 1-4 barang
                gudang.ambilStok(jumlah);
                Thread.sleep(2000 + rand.nextInt(1001)); // Delay 2-3 detik
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}