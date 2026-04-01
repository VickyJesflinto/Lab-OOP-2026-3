import java.util.Scanner;

public class Soal05 {

    public static void main(String[] args) {

        try{

        int[][] nums = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
        };

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int cari = input.nextInt();

        boolean found = false;

        for(int i=0;i<nums.length;i++){

            for(int j=0;j<nums[i].length;j++){

                if(nums[i][j] == cari){

                    System.out.println("Found " + cari + " at ["+i+"]["+ j +"]");
                    found = true;
                    break;
                }
            }
        }
        input.close();
        if(!found){
                System.out.println("angka tidak ada");}

        } catch(Exception e){
            System.out.println("Terjadi error");
        }
    }
}