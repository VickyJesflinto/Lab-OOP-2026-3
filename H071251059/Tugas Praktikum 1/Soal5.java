import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Masukkan angka yang dicari: ");
        int cari = input.nextInt();

        try {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        throw new Exception("Stop");
                    }
                }
            }
            System.out.println("Angka tidak ditemukan");
        } catch (Exception e) {
            // Menghentikan loop
        }
    }
}