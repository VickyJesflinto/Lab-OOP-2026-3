import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tgl = input.nextLine();

        String[] parts = tgl.split("-");
        int hari = Integer.parseInt(parts[0]);
        int bulan = Integer.parseInt(parts[1]);
        int tahun = Integer.parseInt(parts[2]);

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April",
            "Mei", "Juni", "Juli", "Agustus",
            "September", "Oktober", "November", "Desember"
        };

        // Konversi tahun
        if (tahun < 50) {
            tahun += 2000;
        } else {
            tahun += 1900;
        }

        System.out.println("Output: " + hari + " " + namaBulan[bulan - 1] + " " + tahun);
    }
}
