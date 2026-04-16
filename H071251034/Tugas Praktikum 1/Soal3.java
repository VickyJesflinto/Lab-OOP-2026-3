import java.util.Scanner;
public class Soal3 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = a.nextLine();
  
        boolean minimalDelapan = password.length() >= 8;
        boolean HurufBesar = false;
        boolean HurufKecil = false;
        boolean Angka = false;

        for (int n = 0; n < password.length(); n++) {
            char kata = password.charAt(n);
            if (Character.isUpperCase(kata)) {
                HurufBesar = true;
            } else if (Character.isLowerCase(kata)) {
                HurufKecil = true;
            } else if (Character.isDigit(kata)) {
                Angka = true;
            }
        }

        if (minimalDelapan && HurufBesar && HurufKecil && Angka) {
            System.out.println("Password valid");
        }else {
            System.out.println("Password tidak valid");
        }
        a.close();


    }
}
