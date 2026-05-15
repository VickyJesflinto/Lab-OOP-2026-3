public class Gudang {
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(Thread.currentThread().getName() + " menunggu... Gudang PENUH.");
            wait();
        }
        stok += jumlah;
        System.out.println(Thread.currentThread().getName() + " (+) menambah " + jumlah + ". Stok: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println(Thread.currentThread().getName() + " menunggu... Stok KOSONG.");
            wait();
        }
        stok -= jumlah;
        System.out.println(Thread.currentThread().getName() + " (-) mengambil " + jumlah + ". Stok: " + stok);
        notifyAll();
    }

    public synchronized int getStok() { return stok; }
    public int getKapasitasMaksimal() { return kapasitasMaksimal; }
}