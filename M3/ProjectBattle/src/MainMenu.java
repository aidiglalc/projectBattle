import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {
    private BackgroundImageTitle backgroundImageTitle = new BackgroundImageTitle();
    private JButton jButtons[] = new JButton[5];
    private JPanel jPanels[] = new JPanel[5];
    private JPanel jPanelsInvisible[] = new JPanel[6];
    private JLabel jLabel;
    private Icon icon;

    public MainMenu(){
        initComponent();

        // We set the title, resolution and the icon of the game, making it appear at the center of the screen when we open the app
        setSize(1280, 720);
        this.setTitle("Awsttle"); //titulo

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setIconImage(pantalla.getImage("src/Images/Logo/game_icon.png"));
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);

        // We make every button to change image when presses and change back to normal. The actions of the button will be activated when the button is released

        jButtons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon("src/Images/Icons/fight_pressed.png");
                jButtons[0].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon("src/Images/Icons/fight.png");
                jButtons[0].setIcon(icon);
            }
        });

        jButtons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon("src/Images/Icons/choose_fighter_pressed.png");
                jButtons[1].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon("src/Images/Icons/choose_fighter.png");
                jButtons[1].setIcon(icon);
            }
        });

        jButtons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon("src/Images/Icons/choose_weapon_pressed.png");
                jButtons[2].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon("src/Images/Icons/choose_weapon.png");
                jButtons[2].setIcon(icon);
            }
        });

        jButtons[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon("src/Images/Icons/ranking_pressed.png");
                jButtons[3].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon("src/Images/Icons/ranking.png");
                jButtons[3].setIcon(icon);
            }
        });

        jButtons[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon("src/Images/Icons/exit_pressed.png");
                jButtons[4].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon("src/Images/Icons/exit.png");
                jButtons[4].setIcon(icon);
                dispose();
            }
        });

        jPanels[0].add(jLabel);
        jPanels[1].add(jButtons[0]);
        jPanels[2].add(jButtons[1]);
        jPanels[2].add(jPanelsInvisible[4]);
        jPanels[2].add(jButtons[2]);
        jPanels[3].add(jButtons[3]);
        jPanels[4].add(jButtons[4]);

        backgroundImageTitle.add(jPanelsInvisible[0]);
        backgroundImageTitle.add(jPanels[0]);
        backgroundImageTitle.add(jPanelsInvisible[1]);
        backgroundImageTitle.add(jPanels[1]);
        backgroundImageTitle.add(jPanelsInvisible[2]);
        backgroundImageTitle.add(jPanels[2]);
        backgroundImageTitle.add(jPanelsInvisible[3]);
        backgroundImageTitle.add(jPanels[3]);
        backgroundImageTitle.add(jPanelsInvisible[5]);
        backgroundImageTitle.add(jPanels[4]);

        add(backgroundImageTitle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        setResizable(false); //No permitir que la ventana se redimensione
        setVisible(true); //hacer visible (debe ir siempre el ultimo)
    }

    public void initComponent() {
        // We make a pannel title with the desired image
        icon = new ImageIcon("src/Images/Logo/logo.png");
        jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(400,150));
        jLabel.setIcon(icon);

        // We make every button with the image that we want to see
        icon = new ImageIcon("src/Images/Icons/fight.png");
        jButtons[0] = new JButton(icon); // Fight button
        icon = new ImageIcon("src/Images/Icons/choose_fighter.png");
        jButtons[1] = new JButton(icon); // Choose fighter button
        icon = new ImageIcon("src/Images/Icons/choose_weapon.png");
        jButtons[2] = new JButton(icon); // Choose Weapon button
        icon = new ImageIcon("src/Images/Icons/ranking.png");
        jButtons[3] = new JButton(icon); // Ranking button
        icon = new ImageIcon("src/Images/Icons/exit.png");
        jButtons[4] = new JButton(icon); // Exit Button

        // We set the button with the features we want to see

        for (int i = 0; i < jButtons.length; i++){
            jButtons[i].setContentAreaFilled(false);
            jButtons[i].setBorderPainted(false);
            jButtons[i].setPreferredSize(new Dimension(240, 50));
        }

        // We make the pannels for the buttons, and some to set the others to the position we want to

        for (int i = 0; i< jPanels.length; i++){
            jPanels[i] = new JPanel();
        }

        for (int i = 0; i< jPanelsInvisible.length; i++){
            jPanelsInvisible[i] = new JPanel();
        }

        jPanels[1].setPreferredSize(new Dimension(1280, 60));
        jPanels[2].setPreferredSize(new Dimension(1280, 60));
        jPanels[3].setPreferredSize(new Dimension(1280, 60));
        jPanels[4].setPreferredSize(new Dimension(1280, 60));

        jPanelsInvisible[0].setPreferredSize(new Dimension(1280, 20));
        jPanelsInvisible[1].setPreferredSize(new Dimension(1280, 60));
        jPanelsInvisible[2].setPreferredSize(new Dimension(1280, 20));
        jPanelsInvisible[3].setPreferredSize(new Dimension(1280, 20));
        jPanelsInvisible[4].setPreferredSize(new Dimension(60, 50));
        jPanelsInvisible[5].setPreferredSize(new Dimension(1280, 20));

        jPanels[0].setOpaque(false);
        jPanels[1].setOpaque(false);
        jPanels[2].setOpaque(false);
        jPanels[3].setOpaque(false);
        jPanels[4].setOpaque(false);

        jPanelsInvisible[0].setOpaque(false);
        jPanelsInvisible[1].setOpaque(false);
        jPanelsInvisible[2].setOpaque(false);
        jPanelsInvisible[3].setOpaque(false);
        jPanelsInvisible[4].setOpaque(false);
        jPanelsInvisible[5].setOpaque(false);
    }
}


