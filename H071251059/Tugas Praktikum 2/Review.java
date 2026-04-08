public class Review {
    String namaUser;
    int rating; 
    String komentar;

    public Review(String namaUser, int rating, String komentar) {
        this.namaUser = namaUser;
        this.rating = rating;
        this.komentar = komentar;
    }

    public void tampilkanReview() {
        System.out.println("  [User: " + namaUser + " | ⭐ " + rating + "/5]");
        System.out.println("  Comment: \"" + komentar + "\"");
    }
}

