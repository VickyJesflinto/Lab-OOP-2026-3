package soal1;

public class Gudang {
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.printf("[Pemasok-%s] Gudang penuh (%d/%d). Menunggu...%n",
                    Thread.currentThread().getName(), stok, kapasitasMaksimal);
            wait();
        }
        stok += jumlah;
        System.out.printf("[Pemasok-%s] Menambah %d barang. Stok: %d/%d%n",
                Thread.currentThread().getName(), jumlah, stok, kapasitasMaksimal);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.printf("[Kurir-%s] Stok tidak cukup (%d/%d). Menunggu...%n",
                    Thread.currentThread().getName(), stok, kapasitasMaksimal);
            wait();
        }
        stok -= jumlah;
        System.out.printf("[Kurir-%s]  Mengambil %d barang. Stok: %d/%d%n",
                Thread.currentThread().getName(), jumlah, stok, kapasitasMaksimal);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}
