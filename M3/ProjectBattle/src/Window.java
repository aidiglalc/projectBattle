import javax.swing.*;
import java.awt.*;

// This class manage all Panels and have the method to show one or another panel with a card layout

public class Window extends JFrame {
    MainMenu mainMenu = new MainMenu();
    RaceSelectionMenu raceSelectionMenu = new RaceSelectionMenu();
    ElfSelectionMenu elfSelectionMenu = new ElfSelectionMenu();
    DwarfSelectionMenu dwarfSelectionMenu = new DwarfSelectionMenu();
    HumanSelectionMenu humanSelectionMenu = new HumanSelectionMenu();
    JPanel mainPanel = new JPanel();
    CardLayout cardLayout = new CardLayout();

    public Window(){
        setSize(1280, 720);
        this.setTitle("Awsttle"); //titulo

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

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        setResizable(false); //No permitir que la ventana se redimensione
        setVisible(true); //hacer visible (debe ir siempre el ultimo)
    }

    // This method changes the panel to other that is introduced previously

    public void swapWiew(String key) {
        cardLayout.show(mainPanel, key);
    }
}
