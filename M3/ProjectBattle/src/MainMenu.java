import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

// This class shows the pannel for the main menu

public class MainMenu extends JPanel {
    private BackgroundImageTitle backgroundImageTitle = new BackgroundImageTitle();
    private JButton jButtons[] = new JButton[5];
    private JPanel jPanels[] = new JPanel[5];
    private JPanel jPanelsInvisible[] = new JPanel[6];
    private JLabel jLabel;
    private Icon icon;
    private Window framePrincipal;

    public MainMenu(){
        initComponent();

        // We make every button to change image when presses and change back to normal. The actions of the button will be activated when the button is released
        // All the actions except the exit button change the panel we show, the exit option closes the app

        // Fight Button

        jButtons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight_pressed.png");
                jButtons[0].setIcon(icon);
                System.out.println(Window.player);
                System.out.println(Window.playerWeapon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight.png");
                jButtons[0].setIcon(icon);
                if (Window.playerWeapon == null) JOptionPane.showMessageDialog(null,
                        "Select your weapon before to begin the fight!", "No Weapon Selected!", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Choose Character Button

        jButtons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "choose_fighter_pressed.png");
                jButtons[1].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "choose_fighter.png");
                jButtons[1].setIcon(icon);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Race Selection Menu");
            }
        });


        //Choose Weapon Button

        jButtons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "choose_weapon_pressed.png");
                jButtons[2].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "choose_weapon.png");
                jButtons[2].setIcon(icon);

                if (Window.player == null) JOptionPane.showMessageDialog(null,
                        "Select your character before choosing your Weapon!", "No Character Selected!", JOptionPane.ERROR_MESSAGE);
            }
        });


        //Ranking Button

        jButtons[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ranking_pressed.png");
                jButtons[3].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ranking.png");
                jButtons[3].setIcon(icon);
            }
        });


        //Exit Button

        jButtons[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_pressed.png");
                jButtons[4].setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit.png");
                jButtons[4].setIcon(icon);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.dispose();
            }
        });

        jPanels[0].add(jLabel);
        jPanels[1].add(jButtons[0]);
        jPanels[2].add(jButtons[1]);
        jPanels[2].add(jPanelsInvisible[5]);
        jPanels[2].add(jButtons[2]);
        jPanels[3].add(jButtons[3]);
        jPanels[4].add(jButtons[4]);

        // This loop adds the JPanels we prepared into the background image

        for (int i = 0; i < jPanels.length; i++) {
            backgroundImageTitle.add(jPanelsInvisible[i]);
            backgroundImageTitle.add(jPanels[i]);
        }

        add(backgroundImageTitle);
    }

    public void initComponent() {
        // We make a pannel title with the desired image
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Logo" + File.separator + "logo.png");
        jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(400,150));
        jLabel.setIcon(icon);

        // We make every button with the image that we want to see
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight.png");
        jButtons[0] = new JButton(icon); // Fight button
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_fighter.png");
        jButtons[1] = new JButton(icon); // Choose fighter button
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_weapon.png");
        jButtons[2] = new JButton(icon); // Choose Weapon button
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "ranking.png");
        jButtons[3] = new JButton(icon); // Ranking button
        icon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "exit.png");
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
            jPanels[i].setOpaque(false);
        }

        // We use the jPanel with index 0 to show the title

        for (int i = 1; i< jPanels.length; i++){
            jPanels[i].setPreferredSize(new Dimension(1280, 60));
        }

        for (int i = 0; i< jPanelsInvisible.length; i++){
            jPanelsInvisible[i] = new JPanel();
            jPanelsInvisible[i].setPreferredSize(new Dimension(1280, 20));
            jPanelsInvisible[i].setOpaque(false);
        }

        // We use the JPanelsInvisible[1] to set the distance between the title and the buttons

        jPanelsInvisible[1].setPreferredSize(new Dimension(1280, 60));

        // We use the JPanelsInvisible[5] to set the distance between choose race and choose weapon

        jPanelsInvisible[5].setPreferredSize(new Dimension(60, 50));
    }
}


