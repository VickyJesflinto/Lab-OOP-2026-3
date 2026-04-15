public class SmartLock {
    private String passcode;
    private boolean isLocked;
    private boolean isFrozen;
    private int attemptCount;

    protected String deviceId;

    public SmartLock(String deviceId, String Passcode) {
        this.deviceId = deviceId;
        this.passcode = Passcode;
        this.isLocked = true; 
        this.isFrozen = false;
        this.attemptCount = 0;
    }

    public void unlock(String inputPasscode) {
        if (inputPasscode.equals(this.passcode)) {
            if (isFrozen) {
                this.isLocked = false;
                this.attemptCount = 0; 
                System.out.println("Unlock berhasil.");
            }
        } else {
            this.attemptCount++;
            if (this.attemptCount >= 3) {
                this.isFrozen = true;
                sendAlertToOwner();
                System.out.println("Percobaan gagal " + this.attemptCount++);
            }
        }

    }
    
    public void lock() {
        this.isLocked = true;
        System.out.println("Perangkat terkunci.");
    }
    

    private void sendAlertToOwner() {
        if (this.isFrozen == true) {
            System.out.println("Alert: Percobaan akses ilegal terdeteksi! Perangkat dibekukan.");
        }
    }
}
