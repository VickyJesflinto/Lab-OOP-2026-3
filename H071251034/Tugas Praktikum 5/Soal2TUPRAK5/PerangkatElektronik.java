package Soal2TUPRAK5;

abstract class PerangkatElektronik {
    String merk;
    public int dayalistrik;


    public PerangkatElektronik(String merk, int dayalistrik) {
        this.merk = merk;
        this.dayalistrik = dayalistrik;
    }
    abstract void cekFungsi();

    public void infopower() {
        System.out.println("Perangkat sedang menyedot daya sebesar: " + dayalistrik + " Watt");
    }
}
