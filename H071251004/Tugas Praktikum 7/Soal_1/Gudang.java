package Soal_1;

public class Gudang {
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("\n"+ Thread.currentThread().getName() + " menunggu... Stok saat ini: " + stok + "/" + kapasitasMaksimal);
            wait();
        }

        stok += jumlah;
        System.out.println("\n[STOK DITAMBAHKAN] " + Thread.currentThread().getName() + " menambahkan " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("\n"+ Thread.currentThread().getName() + " menunggu... Stok saat ini: " + stok + "/" + kapasitasMaksimal);
            wait();
        }

        stok -= jumlah;
        System.out.println("\n[STOK DIAMBIL] " + Thread.currentThread().getName() + " mengambil " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}