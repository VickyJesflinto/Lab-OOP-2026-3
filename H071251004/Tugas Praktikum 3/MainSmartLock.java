public class MainSmartLock {
    public static void main(String[] args) {
        System.out.println("=== SMART LOCK SYSTEM ===\n");
        SmartLock smartLock = new SmartLock("SL001", "111111");

        //Unlock dengan passcode salah(3x)
        System.out.println(">> Uji Coba: Unlock dengan Passcode Salah");
        smartLock.unlock("000000");
        smartLock.unlock("123456");
        smartLock.unlock("654321");

        //Unlock dengan passcode benar
        System.out.println("\n>> Uji Coba: Unlock dengan Passcode Benar");
        smartLock.unlock("111111");
    }
}
