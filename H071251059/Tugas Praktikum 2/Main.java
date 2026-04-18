public class Main {
    public static void main(String[] args) {
        
        Brand brand1 = new Brand("Skintific", "Canada");
        Brand brand2 = new Brand("The Originote", "Indonesia");

        
        Review rev1 = new Review("Karis", 5, "Sangat melembabkan, teksturnya juara!");
        Review rev2 = new Review("Kesia", 4, "Murah meriah tapi nampol di wajah.");

        
        Skincare moisturizer = new Skincare("5X Ceramide", 130000, brand1, rev1);
        Skincare serum = new Skincare("Hyalucera Serum", 42000, brand2, rev2);

        
        moisturizer.displayInfo();
        serum.displayInfo();

        
        moisturizer.aduKualitas(serum);
    }
}
