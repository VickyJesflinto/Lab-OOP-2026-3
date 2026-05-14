package soal2;
class hp extends product{
    double screenSize;
    int storageCapacity;

    public hp(String brand, int seriesnumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesnumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        System.out.println("╔═══════════════════" + "═".repeat(50)                                                              + "╗");
        System.out.println("║ NAMA BRAND      : " + brand + " ".repeat(50-brand.length())                                       + "║");
        System.out.println("║ SERIES NUMBER   : " + seriesnumber + " ".repeat(50-String.valueOf(seriesnumber).length())         + "║");
        System.out.println("║ PRICE           : " +"Rp "+ price + " ".repeat(50-String.valueOf(price).length()-3)                       + "║");
        System.out.println("║ SCREEN SIZE     : " + screenSize +" Inches" + " ".repeat(50-String.valueOf(screenSize).length()-7)            + "║");
        System.out.println("║ STORAGE CAPACITY: " + storageCapacity + "GB" + " ".repeat(50-String.valueOf(storageCapacity).length()-2) +"║");
        System.out.println("╚═══════════════════" + "═".repeat(50)                                                              + "╝");
    }

}
class laptop extends product {
    double RamSize;
    String processorType;

    public laptop(String brand, int seriesnumber, double price, double RamSize, String processorType) {
        super(brand, seriesnumber, price);
        this.RamSize = RamSize;
        this.processorType = processorType;
    }

    void displayInfo() {
        System.out.println("╔═════════════════" + "═".repeat(50)                                                        + "╗");
        System.out.println("║ NAMA BRAND    : " + brand + " ".repeat(50-brand.length())                                 + "║");
        System.out.println("║ SERIES NUMBER : " + seriesnumber + " ".repeat(50-String.valueOf(seriesnumber).length())   + "║");
        System.out.println("║ PRICE         : " +"Rp "+ price + " ".repeat(50-String.valueOf(price).length()-3)                 + "║");
        System.out.println("║ RAM SIZE      : " + RamSize +"GB"+ " ".repeat(50-String.valueOf(RamSize).length()-2)             + "║");
        System.out.println("║ PROCESSOR TYPE: " + processorType + " ".repeat(50-processorType.length()) + "║");
        System.out.println("╚═════════════════" + "═".repeat(50)                                                        + "╝");
    }
}

class camera extends product {
    double resolution;
    String lensType;

    public camera(String brand, int seriesnumber, double price, double resolution, String lensType) {
        super(brand, seriesnumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        System.out.println("╔═════════════════" + "═".repeat(50)                                                      + "╗");
        System.out.println("║ NAMA BRAND    : " + brand + " ".repeat(50-brand.length())                               + "║");
        System.out.println("║ SERIES NUMBER : " + seriesnumber + " ".repeat(50-String.valueOf(seriesnumber).length()) + "║");
        System.out.println("║ PRICE         : " +"Rp "+ price + " ".repeat(50-String.valueOf(price).length()-3)               + "║");
        System.out.println("║ RESOLUTION    : " + resolution +"MP"+ " ".repeat(50-String.valueOf(resolution).length()-2)     + "║");
        System.out.println("║ LENS TYPE     : " + lensType + " ".repeat(50-lensType.length())         + "║");
        System.out.println("╚═════════════════" + "═".repeat(50)                                                      + "╝");
    }

}
