package soal1;

public class Monitoring implements Runnable {
    private final Gudang gudang;
    private static final int BAR_LENGTH = 20;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                int persen = (kapasitas == 0) ? 0 : (stok * 100 / kapasitas);
                int filled = (int) ((persen / 100.0) * BAR_LENGTH);
                int empty = BAR_LENGTH - filled;

                String bar = "#".repeat(filled) + "-".repeat(empty);
                System.out.printf("%n Status Gudang: [%s] %d%% (%d/%d)%n%n",
                        bar, persen, stok, kapasitas);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
