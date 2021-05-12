import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Character {
    private int warrior_id;
    private String warrior_name, warrior_image_path, race;
    private int hp, strength, defense, agility, speed, race_points;

    public Character() {

    };

    public Character(int warrior_id, String warrior_name, String warrior_image_path, String race, int hp, int strength, int defense, int agility, int speed, int race_points) {
        this.warrior_id = warrior_id;
        this.warrior_name = warrior_name;
        this.warrior_image_path = warrior_image_path;
        this.race = race;
        this.hp = hp;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.speed = speed;
        this.race_points = race_points;
    }

    public int getWarrior_id() {
        return warrior_id;
    }

    public void setWarrior_id(int warrior_id) {
        this.warrior_id = warrior_id;
    }

    public String getWarrior_name() {
        return warrior_name;
    }

    public void setWarrior_name(String warrior_name) {
        this.warrior_name = warrior_name;
    }

    public String getWarrior_image_path() {
        return warrior_image_path;
    }

    public void setWarrior_image_path(String warrior_image_path) {
        this.warrior_image_path = warrior_image_path;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRace_points() {
        return race_points;
    }

    public void setRace_points(int race_points) {
        this.race_points = race_points;
    }

    @Override
    public String toString() {
        return "Character{" +
                "warrior_id=" + warrior_id +
                ", warrior_name='" + warrior_name + '\'' +
                ", warrior_image_path='" + warrior_image_path + '\'' +
                ", race='" + race + '\'' +
                ", hp=" + hp +
                ", strength=" + strength +
                ", defense=" + defense +
                ", agility=" + agility +
                ", speed=" + speed +
                ", race_points=" + race_points +
                '}';
    }

    public ArrayList<Character> getRace(String race) {
        ArrayList<Character> characters = new ArrayList<Character>();
        String url = "jdbc:mysql://localhost/battle_database?serverTimezone=UTC";
        String user = "root";
        String password = "t32i6zcf9893715";
        String query = "SELECT warriors.warrior_id, warriors.warrior_name, warriors.warrior_image_path, race.race, race.hp, race.strength,\n" +
                "race.defense, race.agility, race.speed, race.race_points FROM warriors INNER JOIN race ON warriors.warrior_race = race.race_id " +
                "WHERE race.race = \"" + race + "\";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                characters.add(new Character(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6),rs.getInt(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: Check Database Password", "Character loading Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
