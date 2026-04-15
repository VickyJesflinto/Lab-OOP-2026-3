import java.util.Scanner;
public class Soal2 {

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Masukkan tanggal : ");
        String date = a.nextLine();
        String[] pisah = date.split("-");

        int hari = Integer.parseInt(pisah[0]);
        
        int angkaBulan = Integer.parseInt(pisah[1]);
        String[] namaBulan = {
            "","Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        String bulan = namaBulan[angkaBulan];

        int angkaTahun = Integer.parseInt(pisah[2]);
        int tahun;
        if (angkaTahun <= 26) { 
            tahun = 2000 + angkaTahun; 
        } else {
            tahun = 1900 + angkaTahun;
        }


        System.out.println("tanggal : ");
        System.out.println(hari + " " + bulan + " " + tahun);
        
        a.close();
    }
}
