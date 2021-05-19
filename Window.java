import javax.swing.*;
import java.awt.*;

// This class manage all Panels and have the method to show one or another panel with a card layout

public class Window extends JFrame {
    private MainMenu mainMenu = new MainMenu();
    private RaceSelectionMenu raceSelectionMenu = new RaceSelectionMenu();
    private CharacterSelectionMenu elfSelectionMenu = new CharacterSelectionMenu("elf");
    private CharacterSelectionMenu dwarfSelectionMenu = new CharacterSelectionMenu("dwarf");
    private CharacterSelectionMenu humanSelectionMenu = new CharacterSelectionMenu("human");
    private WeaponSelectionMenu elfWeaponSelectionMenu = new WeaponSelectionMenu("elf");
    private WeaponSelectionMenu dwarfWeaponSelectionMenu = new WeaponSelectionMenu("dwarf");
    private WeaponSelectionMenu humanWeaponSelectionMenu = new WeaponSelectionMenu("human");
    private EndFight endFight = new EndFight();
    private Ranking ranking = new Ranking();
    private Fight fight = new Fight();
    private JPanel mainPanel = new JPanel();
    private CardLayout cardLayout = new CardLayout();

    public Window(){
        setSize(1280, 720);
        this.setTitle("Awsttle"); //titulo

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setIconImage(pantalla.getImage("src/Images/Logo/game_icon.png"));
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);

        // Here we add the multiple panels to the card layout

        mainPanel.setLayout(cardLayout);

        //mainPanel.add(mainMenu, "Main Menu");
        /*mainPanel.add(raceSelectionMenu, "Race Selection Menu");
        mainPanel.add(elfSelectionMenu, "Elf Selection Menu");
        mainPanel.add(dwarfSelectionMenu, "Dwarf Selection Menu");
        mainPanel.add(humanSelectionMenu, "Human Selection Menu");
        mainPanel.add(elfWeaponSelectionMenu, "Elf Weapon Selection Menu");
        mainPanel.add(dwarfWeaponSelectionMenu, "Dwarf Weapon Selection Menu");
        mainPanel.add(humanWeaponSelectionMenu, "Human Weapon Selection Menu");
        mainPanel.add(ranking, "Ranking Menu");
        mainPanel.add(fight, "Fighting Menu");*/


        mainPanel.add(endFight, "End fighting Menu");
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        setResizable(false); //No permitir que la ventana se redimensione
        setVisible(true); //hacer visible (debe ir siempre el ultimo)
    }

    public Ranking getRanking() {
        return ranking;
    }

    public Fight getFight() {
        return fight;
    }

    // This method changes the panel to other that is introduced previously

    public void swapWiew(String key) {
        cardLayout.show(mainPanel, key);
    }
}