package TP7SOAL1;

public class Monitoring extends Thread {
    Gudang gudang;
    boolean isRunning = true;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    public void stopThread() {
        isRunning = false;
        this.interrupt(); 
    }

    @Override
    public void run() {
        try {
            while (isRunning && !Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int max = gudang.getKapasitasMaksimal();
                int persen = (stok * 100) / max;
                int barLength = 10;
                int filled = (persen * barLength) / 100;
                
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < barLength; i++) {
                    if (i < filled) bar.append("#");
                    else bar.append("-");
                }
                bar.append("]");
                
                System.out.println("Status Gudang: " + bar + " " + persen + "%");
                Thread.sleep(1000); // Set 1 detik agar sering muncul di log
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}