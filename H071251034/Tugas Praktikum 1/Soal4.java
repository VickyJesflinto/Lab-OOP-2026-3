import java.util.Scanner;
public class Soal4 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("masukkan angka  : ");
        int factorial = a.nextInt();

        int hasil = hitungFaktorial(factorial);
        System.out.println("hasil factorial dari angka "+ factorial +" adalah : " + hasil);
        
        a.close();
    }

    public static int hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        }else {
            return n * hitungFaktorial(n - 1);
        }
    }
}
