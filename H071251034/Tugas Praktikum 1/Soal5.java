import java.util.Scanner;
public class Soal5 {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in); 
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        try {
            System.out.print("Masukkan angka : ");
            int angkaDicari = a.nextInt();

            boolean ketemu = false;

            for (int i = 0; i < nums.length; i++) {   
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == angkaDicari) {
                        System.out.println("Angka ditemukan " + angkaDicari + " di [" + i + "][" + j + "]");
                        ketemu = true;
                        break; 
                    }
                }
                if (ketemu) {
                    break; 
                }
            }

            if (!ketemu) {
                System.out.println("Angka tidak ada di dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Error: Tolong masukkan angka saja!");
        }a.close();
    }
}

