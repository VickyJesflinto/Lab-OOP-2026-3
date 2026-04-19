package Livecoding;

public class mainBuku {
    public static void main(String[] args) {
        bukuDigital java = new bukuDigital("001","Pemrograman Java",7);

        System.out.println("judul: " +java.getJudul());
        java.isTersedia();
        java.pinjamBuku();
        java.pinjamBuku();
        java.kembalikanBuku();
        java.setJudul("Pemrograman Java","");
    }
}
