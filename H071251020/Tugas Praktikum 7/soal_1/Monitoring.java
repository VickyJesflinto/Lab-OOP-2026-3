public class Monitoring implements Runnable {
    private final Gudang gudang;
    private final int BAR_LENGTH = 20; // Panjang bar (jumlah karakter # dan -)

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                Thread.sleep(1000); // Update setiap 1 detik
                
                // Ambil data saat ini
                int stok = gudang.getStok();
                int max = gudang.getKapasitasMaksimal();
                
                // Hitung persentase dan jumlah karakter bar
                int percentage = (int) ((stok * 100.0) / max);
                int filledCount = (int) ((stok * BAR_LENGTH * 1.0) / max);
                int emptyCount = BAR_LENGTH - filledCount;

                // Format Output sesuai gambar
                String bar = "#".repeat(filledCount) + "-".repeat(emptyCount);
                System.out.println("\nStatus Gudang: [" + bar + "] " + percentage + "%\n");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}