import java.util.Scanner; 

public class Soal1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan judul film : ");
        String teks = a.nextLine();

        String[] kata = teks.split(" ");
        String hasil = "";

        for (String w : kata) {
            String pertama = w.substring(0, 1).toUpperCase();
            String sisa = w.substring(1).toLowerCase();
            
            hasil += pertama + sisa + " ";
        }a.close();
        
        System.out.println(hasil);
    }  
}