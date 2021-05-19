import java.awt.*;
import java.util.ArrayList;

// This class has two method, one to generate a random character to fight with and the other to get their weapon

public class EnemyGenerator {

    // In the generation method we remove the character the player has selected

    public Character getOponentCharacter() {
        ArrayList<Character> characters = new ArrayList();
        ArrayList<Character> allCharacters = null;

        for (int i = 0; i < 3; i ++) {
            if (i == 0) allCharacters = new DatabaseConnection().getRace("Human");
            else if (i == 1) allCharacters = new DatabaseConnection().getRace("Elf");
            else if (i == 2) allCharacters = new DatabaseConnection().getRace("Dwarf");
            for (int j = 0; j < allCharacters.size(); j++) {
                if (allCharacters.get(j).getWarrior_id() != Data.player.getWarrior_id()){
                    characters.add(allCharacters.get(j));
                }
            }
        }
        return characters.get((int)(Math.random() * characters.size()));
    }

    // This method seeks to have a weapon that the enemy race could handle

    public Weapon getOponentWeapon(String race) {
        ArrayList<Weapon> weaponList = new DatabaseConnection().getWeapons(race);
        return weaponList.get((int)(Math.random() * weaponList.size()));
    }

}
