import java.util.ArrayList;

public class CombatAlgorithm {
    public Character getOponentCharacter() {
        ArrayList<Character> characters = new ArrayList();
        ArrayList<Character> allCharacters = null;

        for (int i = 0; i < 3; i ++) {
            if (i == 0) allCharacters = new Character().getRace("Human");
            else if (i == 1) allCharacters = new Character().getRace("Elf");
            else if (i == 2) allCharacters = new Character().getRace("Dwarf");
            for (int j = 0; j < allCharacters.size(); j++) {
                if (allCharacters.get(j).getWarrior_id() != Data.player.getWarrior_id()){
                    characters.add(allCharacters.get(j));
                }
            }
        }
        return characters.get((int)(Math.random() * characters.size()));
    }

    public Weapon getOponentWeapon(String race) {
        ArrayList<Weapon> weaponList = new Weapon().getWeapons(race);
        return weaponList.get((int)(Math.random() * weaponList.size()));
    }

}
