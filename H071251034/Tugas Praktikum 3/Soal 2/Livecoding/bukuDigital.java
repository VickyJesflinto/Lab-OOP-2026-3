package Livecoding;

public class bukuDigital {
    private String judul;
    private boolean isTersedia;
    protected String idBuku;
    int jumlahHalaman;

    public bukuDigital(String idBuku,String judul,int jumlahHalaman){
        this.idBuku = idBuku;
        this.judul = judul;
        this.jumlahHalaman = jumlahHalaman;
        isTersedia = true ;

    }

    public String getJudul(){
        return judul;
    }
    public boolean getisTersedia(){
        return isTersedia;
    }

    public void isTersedia(){
        if(isTersedia == true){
            updateStatus("\nStatus : Tersedia");
        }else {
            updateStatus("\nStatus : Tidak Tersedia");
        }
    }
    public  void setJudul(String judulLama,String judulBaru){
        if (this.judul.equals(judulLama)){
            if (judulBaru.equals("")){
            System.out.println("\nerror: tidak boleh kosong");
            }else{
                this.judul = judulBaru;
                updateStatus("judul baru " + judul);
            }
        }else{
            updateStatus("nama judul tidak di dapat");
        }
    }

    public void pinjamBuku(){
        if (isTersedia == true){
            isTersedia = false;
            updateStatus("\nBuku berhasil dipinjam");
        }else{
            System.out.println("\nbuku sedang tidak tersedia");
        }
    }

    public void kembalikanBuku(){
        isTersedia = true;
        updateStatus("\nbuku berhasil dikembalikan");

    }

    public void namaTersedia(boolean getisTersedia){
        if(isTersedia == true){
            System.out.println("Status : Tersedia");
        }else{
            System.out.println("Status : Tidak Tersedia");
        }
    }

    private void updateStatus(String pesan){
        System.out.println(pesan + "\nsistem status buku diperbarui");
    }
}