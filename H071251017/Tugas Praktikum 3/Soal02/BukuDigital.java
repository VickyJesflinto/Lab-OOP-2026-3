class BukuDigital {
    
    private String judul  ;
    private boolean isTersedia   ;

    protected String idBuku  ;

    int jumlahHalaman ;

    
    public BukuDigital(String idBuku, String judul, int jumlahHalaman) {
        this.idBuku = idBuku ;
        this.jumlahHalaman = jumlahHalaman  ;
        setJudul(judul) ; 
        this.isTersedia = true ;
    }

    
    public String getJudul() {
        return judul ;
    }

    public boolean isTersedia() {
        return isTersedia ;
    }

    
    public void setJudul(String judulBaru) {
        if (judulBaru == null || judulBaru.trim().isEmpty()) {
            System.out.println("Error: Judul tidak boleh kosong") ;
        } else {
            this.judul = judulBaru;
        }
    }

    
    public void pinjamBuku() {
        if (isTersedia) {
            isTersedia = false  ;
            System.out.println("Buku berhasil dipinjam");
            updateStatus();
        } else {
            System.out.println("Buku sedang tidak tersedia") ;
        }
    }

    public void kembalikanBuku() {
        isTersedia = true ;
        System.out.println("Buku berhasil dikembalikan") ;
        updateStatus()  ;
    }

    
    private void updateStatus() {
        System.out.println("Sistem: Status buku diperbarui") ;
    }
}