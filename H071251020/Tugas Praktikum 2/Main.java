public class Main {
    public static void main(String[] args) {
        ScubaGear gear1 = new ScubaGear("AquaPro-X", 50, 40.0);
        ScubaGear gear2 = new ScubaGear("DeepDive-Lite", 40, 25.0);

        PenyelamLaut glenn = new PenyelamLaut("Glenn", 60, gear1);
        PenyelamLaut budi  = new PenyelamLaut("Budi", 10, gear2);

        PenyelamLaut defaultDiver = new PenyelamLaut();
        System.out.println(" Diver Default: " + defaultDiver.getNama() + "\n");

        glenn.lakukanPenyelaman(30);
        glenn.lakukanPenyelaman(50); 

        System.out.println();

        glenn.transferOksigen(budi);
        System.out.println();
        budi.transferOksigen(glenn);
    }
}