import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

// This class have all the stats of the character and the stat of currenthp to know how to heal that character

public class Character {
    private int warrior_id;
    private String warrior_name, warrior_image_path, warrior_lore, race;
    private int currenthp, hp, strength, defense, agility, speed, race_points;

    public Character() {

    };

    public Character(int warrior_id, String warrior_name, String warrior_image_path, String warrior_lore, String race, int hp, int strength, int defense, int agility, int speed, int race_points) {
        this.warrior_id = warrior_id;
        this.warrior_name = warrior_name;
        this.warrior_image_path = warrior_image_path;
        this.warrior_lore = warrior_lore;
        this.race = race;
        this.currenthp = hp;
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

    public String getWarrior_lore() {
        return warrior_lore;
    }

    public void setWarrior_lore(String warrior_lore) {
        this.warrior_lore = warrior_lore;
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

    public int getCurrenthp() {
        return currenthp;
    }

    public void setCurrenthp(int currenthp) {
        this.currenthp = currenthp;
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
                ", warrior_lore='" + warrior_lore + '\'' +
                ", race='" + race + '\'' +
                ", currenthp=" + currenthp +
                ", hp=" + hp +
                ", strength=" + strength +
                ", defense=" + defense +
                ", agility=" + agility +
                ", speed=" + speed +
                ", race_points=" + race_points +
                '}';
    }
}
