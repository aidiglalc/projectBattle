import javax.swing.*;
import java.awt.*;

public class RaceSelectionMenu extends JFrame {
    private BackgroundImageCharacterSelection backgroundImageCharacterSelection = new BackgroundImageCharacterSelection();
    private JButton jButtons[] = new JButton[3];
    private JPanel jPanel;
    private JPanel jPanelInvisible[] = new JPanel[4];

    public RaceSelectionMenu(){
        initComponent();
        setSize(1280, 720);
        this.setTitle("Awsttle"); //title

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setIconImage(pantalla.getImage("src/Images/Logo/game_icon.png"));
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);

        backgroundImageCharacterSelection.add(jPanelInvisible[3]);
        backgroundImageCharacterSelection.add(jPanel);

        add(backgroundImageCharacterSelection);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        setResizable(false); //No permitir que la ventana se redimensione
        setVisible(true); //hacer visible (debe ir siempre el ultimo)

    }

    public void initComponent() {
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton();
            jButtons[i].setPreferredSize(new Dimension(400, 550));
        }

        for (int i = 0; i < jPanelInvisible.length; i++) {
            jPanelInvisible[i] = new JPanel();
            jPanelInvisible[i].setPreferredSize(new Dimension(5, 20));
            jPanelInvisible[i].setOpaque(false);

        }

        jPanel = new JPanel();
        jPanel.setOpaque(false);

        jPanel.add(jButtons[0]);
        jPanel.add(jPanelInvisible[0]);
        jPanel.add(jButtons[1]);
        jPanel.add(jPanelInvisible[1]);
        jPanel.add(jButtons[2]);

        jPanelInvisible[3].setPreferredSize((new Dimension(20, 95)));
        jPanelInvisible[3].setOpaque(true);
    }
}
