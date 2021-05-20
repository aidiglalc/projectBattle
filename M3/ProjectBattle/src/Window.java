import javax.swing.*;
import java.awt.*;
// This class manage all Panels and have the method to show one or another panel with a card layout

public class Window extends JFrame {
    private MainMenu mainMenu;
    private RaceSelectionMenu raceSelectionMenu;
    private CharacterSelectionMenu elfSelectionMenu;
    private CharacterSelectionMenu dwarfSelectionMenu;
    private CharacterSelectionMenu humanSelectionMenu;
    private WeaponSelectionMenu elfWeaponSelectionMenu;
    private WeaponSelectionMenu dwarfWeaponSelectionMenu;
    private WeaponSelectionMenu humanWeaponSelectionMenu;
    private Ranking ranking;
    private Fight fight;
    private JPanel mainPanel;
    private EndFightMenu endFightMenu;
    private CardLayout cardLayout;

    public Window(){

        // We call the method to get the connection to database

        new DatabaseConnection().setDataBaseConection();

        // We initialize all the panels

        mainMenu = new MainMenu();
        raceSelectionMenu = new RaceSelectionMenu();
        elfSelectionMenu = new CharacterSelectionMenu("elf");
        dwarfSelectionMenu = new CharacterSelectionMenu("dwarf");
        humanSelectionMenu = new CharacterSelectionMenu("human");
        elfWeaponSelectionMenu = new WeaponSelectionMenu("elf");
        dwarfWeaponSelectionMenu = new WeaponSelectionMenu("dwarf");
        humanWeaponSelectionMenu = new WeaponSelectionMenu("human");
        ranking = new Ranking();
        fight = new Fight();
        endFightMenu = new EndFightMenu();
        mainPanel = new JPanel();
        cardLayout = new CardLayout();

        setSize(1280, 720);
        this.setTitle("Awsttle");

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setIconImage(pantalla.getImage("src/Images/Logo/game_icon.png"));
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);

        // Here we add the multiple panels to the card layout

        mainPanel.setLayout(cardLayout);
        mainPanel.add(mainMenu, "Main Menu");
        mainPanel.add(raceSelectionMenu, "Race Selection Menu");
        mainPanel.add(elfSelectionMenu, "Elf Selection Menu");
        mainPanel.add(dwarfSelectionMenu, "Dwarf Selection Menu");
        mainPanel.add(humanSelectionMenu, "Human Selection Menu");
        mainPanel.add(elfWeaponSelectionMenu, "Elf Weapon Selection Menu");
        mainPanel.add(dwarfWeaponSelectionMenu, "Dwarf Weapon Selection Menu");
        mainPanel.add(humanWeaponSelectionMenu, "Human Weapon Selection Menu");
        mainPanel.add(ranking, "Ranking Menu");
        mainPanel.add(fight, "Fighting Menu");
        mainPanel.add(endFightMenu, "End Fight Menu");

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public Ranking getRanking() {
        return ranking;
    }

    public Fight getFight() {
        return fight;
    }

    public EndFightMenu getEndFightMenu() {
        return endFightMenu;
    }

    // This method changes the panel to other that is introduced previously

    public void swapWiew(String key) {
        cardLayout.show(mainPanel, key);
    }
}
