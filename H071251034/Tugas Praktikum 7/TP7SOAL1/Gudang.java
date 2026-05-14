package TP7SOAL1;

public class Gudang {
    int stok = 0;
    int kapasitasMaksimal;

    public Gudang(int kapasitas) {
        this.kapasitasMaksimal = kapasitas;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("Gudang penuh, pemasok menunggu...");
            wait();
        }
        stok += jumlah;
        System.out.printf("%-6s %d | stok = %2d\n", "Tambah", jumlah, stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("Stok tidak cukup, kurir menunggu...");
            wait();
        }
        stok -= jumlah;
        System.out.printf("%-6s %d | stok = %2d\n", "Ambil", jumlah, stok);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}