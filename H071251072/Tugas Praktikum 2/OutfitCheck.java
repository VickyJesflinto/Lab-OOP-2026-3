public class OutfitCheck {
    public String username;
    public int cloutScore;
    public Aksesoris aksesorisAndalan; 

    public OutfitCheck() {
        this.username = "User_Anonim";
        this.cloutScore = 10;
        this.aksesorisAndalan = new Aksesoris("Masker Hitam", 2);
    }

    public OutfitCheck(String username, int cloutScore, Aksesoris aksesorisAndalan) {
        this.username = username;
        this.cloutScore = cloutScore;
        this.aksesorisAndalan = aksesorisAndalan;
    }

    public void spillAksesoris() {
        System.out.println("📸 " + username + " spill " + aksesorisAndalan.jenis + 
                           " yang nambah " + aksesorisAndalan.poinAesthetic + " poin aesthetic!");
        this.cloutScore += aksesorisAndalan.poinAesthetic;
    }

    public void battleFitCheck(OutfitCheck rival) {
        System.out.println("\n🔥 FIT CHECK BATTLE: " + this.username + " VS " + rival.username + " 🔥");
        
        if (this.cloutScore > rival.cloutScore) {
            System.out.println(">> Hasil: " + this.username + " menang kalcer! " + rival.username + " kena mental.");
            rival.cloutScore -= 10; 
        } else if (this.cloutScore < rival.cloutScore) {
            System.out.println(">> Hasil: " + rival.username + " lebih ootd. " + this.username + " harus asupan konten lagi.");
            this.cloutScore -= 10;
        } else {
            System.out.println(">> Hasil: Seri! Sama-sama aesthetic.");
        }
    }

    public void checkStatus() {
        System.out.println("User: " + username + " | Clout Score: " + cloutScore);
    }
}