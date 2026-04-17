import java.util.Scanner;

public class Soal1 {
    public static String kapitalAwal(String kalimat) {
        String[] kata = kalimat.split(" ");
        String hasil = "";

        for (String k : kata) {
            hasil += k.substring(0, 1).toUpperCase() + k.substring(1) + " ";
        }

        return hasil.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String kalimat = input.nextLine();

        System.out.println(kapitalAwal(kalimat));
    }
}
