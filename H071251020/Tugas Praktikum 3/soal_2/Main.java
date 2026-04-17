public class Main {
    public static void main(String[] args) {
        MemberCard member1 = new MemberCard("12345", 0, "Silver");
        boolean ujiTambahPoin1 = member1.tambahPoin(1000);
        boolean ujiRedeemPoin1 = member1.reedemPoin(1000);
        
        MemberCard member2 = new MemberCard("12345", 0, "Silver");
        boolean ujiTambahPoin2 = member2.tambahPoin(400);
        boolean ujiRedeemPoin2 = member2.reedemPoin(500);
        
        MemberCard member3 = new MemberCard("12345", 0, "Silver");
        boolean ujiTambahPoin3 = member3.tambahPoin(5000);
        // boolean ujiRedeemPoin3 = member3.reedemPoin(1000);
    }
}
