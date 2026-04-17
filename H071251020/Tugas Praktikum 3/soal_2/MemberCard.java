class MemberCard {
    // Private
    private int totalPoin;
    private String secretReferralCode;

    // Default
    String tierLevel;

    // Contructor
    public MemberCard(String secretReferralCode, int totalPoin, String tierLevel){
        this.secretReferralCode = secretReferralCode;
        this.totalPoin = totalPoin;
        this.tierLevel = tierLevel;
        // autoUpgradeTier(tierLevel);
    }

    // getter
    public int getTotalPoin() {
        return totalPoin;
    }

    public String getTierLevel() {
        return tierLevel;
    }

    // method utama
    public boolean tambahPoin(int poin) {
        this.totalPoin += poin;
        
        if (this.totalPoin >= 5000) {
            System.out.println("\nPoin berhasil ditambahkan: " + this.totalPoin);
            autoUpgradeTier("Tier berhasil di-upgrade ke Platinum" );
            return true;
        }
        
        else if (this.totalPoin >= 1000) {
            System.out.println("\nPoin berhasil ditambahkan: " + this.totalPoin);
            autoUpgradeTier("Tier berhasil di-upgrade ke Gold" );
            return true;

        }

        else{
            System.out.println("\nError: Poin tidak cukup");
            return false;
        }
    }

    public boolean reedemPoin(int poin) {
        if (this.totalPoin >= 1000) {
            System.out.println("\nRedeem berhasil");
            return true;
        }

        else {
            System.out.println("\nError: Tier tidak memenuhi syarat");
            return false;
        }
    }

    // method internal
    private void autoUpgradeTier(String tier) {
        System.out.println("Sistem: " + tier);
    }
}