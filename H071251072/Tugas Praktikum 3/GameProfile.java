public class GameProfile {
    private int level;
    private String password;
    protected String username;
    int healthPoint;

    public GameProfile (String username, String password) {
        this.username = username;
        this.password = password;
        this.level = 1;
        this.healthPoint = 100;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public void setPassword(String passwordBaru) {
        if (passwordBaru.length() > 8) {
            this.password = passwordBaru;
            saveData("Password berhasil diperbaharui");
        } else { 
            saveData("Error : password harus minimal 8 karakter");
        }
    }

    public void levelUp() {
        level ++;
        saveData("Level up!");
        saveData("Sistem : Progress otomatis disimpan ke server");
    } 

    public void receiveDamage(int damage) {
       this.healthPoint -= damage;
       saveData("Player menerima damage " + damage);
        if (this.healthPoint <= 0) {
            saveData("Player mati");
            } 
        }

    private void saveData(String x) {
        System.out.println(x);
    }
}
