public class Data {

    // Game Variables

    protected static Character player = new Character(0, "Player", "", "null", "null", 54, 0, 0, 0, 0,0);
    protected static Weapon playerWeapon = new Weapon (0, "PlayerWeapon", 0, 0, "null", "null", 0);
    protected static Character enemy =  new Character(0, "Enemy", "", "null", "null", 27, 0, 0, 0, 0,0);
    protected static Weapon enemyWeapon = new Weapon (0, "EnemyWeapon", 0, 0, "null", "null", 0);
    protected static int points = 0;
    protected static int winningStreak = 0;
    protected static String playerName = "";
    protected static int playerId = 0;
    protected static int gameId = 0;
    protected static int gameSpeed = 500;

    // Database variables

    protected static String dataBaseUrl = "jdbc:mysql://localhost/battle_database?serverTimezone=UTC";
    protected static String dataBaseUser = "";
    protected static String dataBasePassword = "";

}
