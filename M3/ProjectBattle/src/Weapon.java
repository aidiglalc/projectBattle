import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

// This class have all the stats of the weapons
// This class also have a method to get an ArrayList of the weapons of the race selected

public class Weapon {
    private int weapon_id;
    private String weapon_name;
    private int weapon_strength, weapon_speed;
    private String weapon_race, weapon_image_path;
    private int weapon_points;

    public Weapon() {

    }

    public Weapon(int weapon_id, String weapon_name, int weapon_strength, int weapon_speed, String weapon_race, String weapon_image_path, int weapon_points) {
        this.weapon_id = weapon_id;
        this.weapon_name = weapon_name;
        this.weapon_strength = weapon_strength;
        this.weapon_speed = weapon_speed;
        this.weapon_race = weapon_race;
        this.weapon_image_path = weapon_image_path;
        this.weapon_points = weapon_points;
    }

    public int getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(int weapon_id) {
        this.weapon_id = weapon_id;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public int getWeapon_strength() {
        return weapon_strength;
    }

    public void setWeapon_strength(int weapon_strength) {
        this.weapon_strength = weapon_strength;
    }

    public int getWeapon_speed() {
        return weapon_speed;
    }

    public void setWeapon_speed(int weapon_speed) {
        this.weapon_speed = weapon_speed;
    }

    public String getWeapon_race() {
        return weapon_race;
    }

    public void setWeapon_race(String weapon_race) {
        this.weapon_race = weapon_race;
    }

    public String getWeapon_image_path() {
        return weapon_image_path;
    }

    public void setWeapon_image_path(String weapon_image_path) {
        this.weapon_image_path = weapon_image_path;
    }

    public int getWeapon_points() {
        return weapon_points;
    }

    public void setWeapon_points(int weapon_points) {
        this.weapon_points = weapon_points;
    }

    @Override
    public String toString() {
        return "Weapons{" +
                "weapon_id=" + weapon_id +
                ", weapon_name='" + weapon_name + '\'' +
                ", weapon_strength=" + weapon_strength +
                ", weapon_speed=" + weapon_speed +
                ", weapon_race='" + weapon_race + '\'' +
                ", weapon_image_path='" + weapon_image_path + '\'' +
                ", weapon_points=" + weapon_points +
                '}';
    }
}