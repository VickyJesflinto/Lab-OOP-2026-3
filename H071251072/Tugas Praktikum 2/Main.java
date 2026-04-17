public class Main {
    public static void main(String[] args) {
        Aksesoris kacamata = new Aksesoris("Gentle Monster", 15);
        Aksesoris headphone = new Aksesoris("Sony XM5", 20);

        OutfitCheck player1 = new OutfitCheck("HaekalSkena_Jaksel", 50, kacamata);
        
        OutfitCheck player2 = new OutfitCheck();
        player2.username = "Lean_Kalcer";
        player2.aksesorisAndalan = headphone;

        player1.spillAksesoris();
        player2.spillAksesoris();

        System.out.println("\n--- STATUS SEBELUM BATTLE ---");
        player1.checkStatus();
        player2.checkStatus();

        player1.battleFitCheck(player2);

        System.out.println("\n--- STATUS SESUDAH BATTLE ---");
        player1.checkStatus();
        player2.checkStatus();
    }
}