import java.util.Scanner;

public class Soal02 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in) ;

        System.out.println("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = input.nextLine();

        String[] bagian = tanggal.split("-");

        String[] namaBulan = {
        "",
        "Januari","Februari","Maret","April","Mei","Juni",
        "Juli","Agustus","September","Oktober","November","Desember"
        };

        int hari  = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        String tahun = bagian[2];
        
        String tahunLengkap;
        if (Integer.parseInt(tahun) <= 26){
            tahunLengkap = "20" + tahun;
        } else {
            tahunLengkap = "19" + tahun;
        }
        System.out.println(hari + " " + namaBulan[bulan] + " " + tahunLengkap);
    
    input.close();
    }

}










