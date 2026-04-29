package Soal2;

public abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;
 
    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }
 
    public abstract void cekFungsi();
 
    public void infoPower() {
        System.out.println("Daya         : " + dayaListrik + " Watt");
    }
 
    @Override
    public String toString() {
        return "Merk         : " + merk + "\n" +
               "Daya Listrik : " + dayaListrik + " Watt";
    }
}
