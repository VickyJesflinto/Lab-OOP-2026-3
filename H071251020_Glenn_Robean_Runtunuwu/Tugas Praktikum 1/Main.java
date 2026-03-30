import java.util.Scanner; // Mengimpor alat untuk input pengguna

public class Main {
    
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true; 

        while (run) {
            // Menampilkan Menu
            System.out.println("\n=== MENU TUGAS PRAKTIKUM 1 ===");
            System.out.println("Nomor 1 (Merubah Huruf Pertama dari Tiap Kata Menjadi Kapital)");
            System.out.println("Nomor 2 (Mengkonversi Tanggal)");
            System.out.println("Nomor 3 (Validasi Password)");
            System.out.println("Nomor 4 (Menghitung n! (Faktorial))");
            System.out.println("Nomor 5 (Mencari Angka dari Array 2D)");
            System.out.println("0. Keluar");
            System.out.print("Pilih nomor (0-5): ");

            try {
                int pilihan = in.nextInt();
                in.nextLine();

                switch (pilihan) {
                    case 1:
                        nomorSatu();
                        break;
                    case 2:
                        nomorDua();
                        break;
                    case 3:
                        nomorTiga();
                        break;
                    case 4:
                        nomorEmpat();
                        break;
                    case 5:
                        nomorLima();
                        break;
                    case 0:
                        System.out.println("Terima kasih, sampai jumpa!");
                        run = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak ada, silakan coba lagi!");
                }
            } catch (Exception e) {
                System.out.println("Input error! Masukkan angka saja.");
                in.nextLine(); 
            }
        }
    }

    // Nomor 1
    public static void nomorSatu() {
        System.out.println("\n--- Nomor 1 (Merubah Huruf Pertama dari Tiap Kata Menjadi Kapital) ---");
        System.out.print("Masukkan Judul Film: ");
        String input = in.nextLine();

        String[] kumpulanKata = input.split(" ");
        String hasil = "";

        for (int i = 0; i < kumpulanKata.length; i++) {
            if (kumpulanKata[i].length() > 0) {
                char hurufPertama = Character.toUpperCase(kumpulanKata[i].charAt(0));
                
                String sisaKata = kumpulanKata[i].substring(1);

                hasil += hurufPertama + sisaKata.toLowerCase() + " ";
            }
        }

        System.out.println("Output: " + hasil);
    }

    // Nomor 2
    public static void nomorDua() {
        System.out.println("\n--- Nomor 2 (Mengkonversi Tanggal) ---");
        System.out.println("Input: ");
        String inputTanggal = in.nextLine();

        try {
            String[] formatTanggal = inputTanggal.split("-");

            int hari = Integer.parseInt(formatTanggal[0]);
            int bulan = Integer.parseInt(formatTanggal[1]);
            int tahun = Integer.parseInt(formatTanggal[2]);

            // Menentukan tahun lengkap 
            int tahunLengkap;
            if (tahun <= 26) { 
                tahunLengkap = 2000 + tahun;
            } else {
                tahunLengkap = 1900 + tahun;
            }

            // Menentukan bulan
            String[] namaBulan = {
                "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };

            if (bulan >= 1 && bulan <= 12) {
                System.out.println("Output: " + hari + " " + namaBulan[bulan] + " " + tahunLengkap);
            } else {
                System.out.println("Bulan tidak valid!");
            }

        } catch (Exception e) {
            System.out.println("Format tanggal salah! (dd-mm-yy)");
        }
    }

    // Nomor 3
    public static void nomorTiga() {
        System.out.println("\n--- Nomor 3 (Validasi Password) ---");
        System.out.print("Masukkan password: ");
        String password = in.nextLine();

        boolean validasiPassword = true;

        // Cek panjang minimal 8 karakter
        if (password.length() < 8) {
            validasiPassword = false;
            System.out.println("Password tidak valid! (Minimal 8 karakter)");
        } else {
            // Cek apakah benar ada huruf besar, kecil, dan angka
            boolean adaHurufBesar = false;
            boolean adaHurufKecil = false;
            boolean adaAngka = false;

            for (int i = 0; i < password.length(); i++) {
                char cek = password.charAt(i);
                
                if (Character.isUpperCase(cek)) adaHurufBesar = true;
                if (Character.isLowerCase(cek)) adaHurufKecil = true;
                if (Character.isDigit(cek)) adaAngka = true;
            }

            if (!adaHurufBesar || !adaHurufKecil || !adaAngka) {
                validasiPassword = false;
                System.out.println("Password tidak valid! (Harus ada Huruf Besar, Kecil, dan Angka)");
            }
        }

        if (validasiPassword) {
            System.out.println("Password valid!");
        }
    }

    // Nomor 4
    public static void nomorEmpat() {
        System.out.println("\n--- Nomor 4 (Menghitung n! (Faktorial)) ---");
        System.out.print("Input: ");
        
        try {
            int n = in.nextInt();
            in.nextLine();

            if (n < 0) {
                System.out.println("Output: Tidak bisa menghitung faktorial negatif!");
            } else {
                int hasil = faktorial(n);
                System.out.println("Output: " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input error! Masukkan angka.");
            in.nextLine();
        }
    }

    // Fungsi rekursif
    public static int faktorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }

    // Nomor 5
    public static void nomorLima() {
        System.out.println("\n--- Nomor 5 (Mencari Angka dari Array 2D) ---");
        
        // Membuat Array 2D sesuai soal
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Input: ");
        
        try {
            int cariAngka = in.nextInt();
            in.nextLine();

            boolean ditemukan = false;
            int indexBaris = 0;
            int indexKolom = 0;

            // Cek setiap baris dan kolom dalam array
            for (int i = 0; i < nums.length; i++) {         // Loop baris
                for (int j = 0; j < nums[i].length; j++) {  // Loop kolom
                    if (nums[i][j] == cariAngka) {
                        indexBaris = i;
                        indexKolom = j;
                        ditemukan = true;
                        break;
                    }
                }
            }

            if (ditemukan) {
                System.out.println("Found " + cariAngka + " at[" + indexBaris + "][" + indexKolom + "]");
            } else {
                System.out.println("Output: Angka tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            in.nextLine();
        }
    }
}