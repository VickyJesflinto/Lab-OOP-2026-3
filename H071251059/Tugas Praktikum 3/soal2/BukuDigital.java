package soal2;

public class BukuDigital {
    private String idbuku;
    private String judul;
    private int jumlahhalaman;
    private boolean isTersedia;

        public BukuDigital (String idbuku, String judul, int jumlahhalaman) {
            this.idbuku = idbuku;
            this.judul = judul;
            this.jumlahhalaman = jumlahhalaman;
            this.isTersedia = true;
        }
        public String getjudul() {
            return judul;
        }
        public boolean isTersedia() {
            return isTersedia;
        }

        public void setjudul(String judulBaru) {
            if (judulBaru == null || judulBaru.trim().isEmpty()) {
                System.out.println("error: judul tidak boleh kosong");
            } else {
                this.judul = judulBaru;
            }
        }
        public void pinjamBuku() {
            if (isTersedia) {
                isTersedia = false;
                System.out.println("buku tidak tersedia");
            } else {
                System.out.println("buku tersedia");
            }
            updateStatus();
        }
        public void kembalikanBuku() {
            isTersedia = true;
            System.out.println("buku berhasil dikembalikan");
            updateStatus();
        }
        private void updateStatus() {
            System.out.println("Status buku diperbaharui");
        }


    }

