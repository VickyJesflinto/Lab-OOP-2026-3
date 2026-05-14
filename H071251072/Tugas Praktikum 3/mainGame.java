public class mainGame {
    public static void main(String[] args) {
        GameProfile profile = new GameProfile("eren", "123456789");

        System.out.println("Username: " + profile.getUsername());
        System.out.println("Level: " + profile.getLevel());

        profile.levelUp();
        profile.receiveDamage(120);

        profile.setPassword("111");
        profile.setPassword("ABCDEFGHI");
    }
}
