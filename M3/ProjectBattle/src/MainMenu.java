import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private BackgroundImageTitle backgroundImageTitle = new BackgroundImageTitle();
    private JButton jButtons[] = new JButton[5];
    private JPanel jPanels[] = new JPanel[5];
    private JPanel jPanelsInvisible[] = new JPanel[6];
    private JLabel jLabel;
    private Icon icon;

    public MainMenu(){
        //INIT COMPONENT
        initComponent();

        setSize(1280, 720);
        this.setTitle("Awsttle"); //titulo

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setIconImage(pantalla.getImage("src/Images/Logo/game_icon.png"));
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);


        jButtons[0].addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel button0 = jButtons[0].getModel();

                if (button0.isPressed()) {
                    icon = new ImageIcon("src/Images/Icons/fight_pressed.png");
                    jButtons[0].setIcon(icon);
                }

                else {
                    icon = new ImageIcon("src/Images/Icons/fight.png");
                    jButtons[0].setIcon(icon);
                }
            }
        });

        jButtons[1].addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel button1 = jButtons[1].getModel();

                if (button1.isPressed()) {
                    icon = new ImageIcon("src/Images/Icons/choose_fighter_pressed.png");
                    jButtons[1].setIcon(icon);
                }

                else {
                    icon = new ImageIcon("src/Images/Icons/choose_fighter.png");
                    jButtons[1].setIcon(icon);
                }
            }
        });

        jButtons[2].addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel button2 = jButtons[2].getModel();

                if (button2.isPressed()) {
                    icon = new ImageIcon("src/Images/Icons/choose_weapon_pressed.png");
                    jButtons[2].setIcon(icon);
                }

                else {
                    icon = new ImageIcon("src/Images/Icons/choose_weapon.png");
                    jButtons[2].setIcon(icon);
                }
            }
        });

        jButtons[3].addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel button3 = jButtons[3].getModel();

                if (button3.isPressed()) {
                    icon = new ImageIcon("src/Images/Icons/ranking_pressed.png");
                    jButtons[3].setIcon(icon);
                }

                else {
                    icon = new ImageIcon("src/Images/Icons/ranking.png");
                    jButtons[3].setIcon(icon);
                }
            }
        });

        jButtons[4].addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel button4 = jButtons[4].getModel();

                if (button4.isPressed()) {
                    icon = new ImageIcon("src/Images/Icons/exit_pressed.png");
                    jButtons[4].setIcon(icon);
                    dispose();
                }

                else {
                    icon = new ImageIcon("src/Images/Icons/exit.png");
                    jButtons[4].setIcon(icon);

                }
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
        //PANEL 1
        icon = new ImageIcon("src/Images/Logo/logo.png");
        jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(400,150));
        jLabel.setIcon(icon);

        //BOTONES
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

        for (int i = 0; i < jButtons.length; i++){
            jButtons[i].setContentAreaFilled(false);
            jButtons[i].setBorderPainted(false);
            jButtons[i].setPreferredSize(new Dimension(240, 50));
        }

        //INICIAR JPANEL

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


