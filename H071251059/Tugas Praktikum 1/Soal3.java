import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        boolean panjang = password.length() >= 8;
        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) adaHurufBesar = true;
            if (Character.isLowerCase(c)) adaHurufKecil = true;
            if (Character.isDigit(c)) adaAngka = true;
        }

        if (panjang && adaHurufBesar && adaHurufKecil && adaAngka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}
