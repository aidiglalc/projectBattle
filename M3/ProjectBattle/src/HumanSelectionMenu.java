import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

// This class is the panel that we show in the human selection

public class HumanSelectionMenu extends JPanel {
    private BackgroundImageHumanSelection backgroundImageHumanSelection = new BackgroundImageHumanSelection();
    private ArrayList<Character> humans;
    private JPanel characterPanel[] = new JPanel[3];
    private JPanel screenPanel;
    private JPanel invisiblePanel[] = new JPanel[2];
    private JPanel invisiblePanelCharacter[] = new JPanel[9];
    private JLabel titlePanel;
    private JPanel turnBackButtonPanel;
    private JLabel label[] = new JLabel[19];
    private JButton buttons[] = new JButton[3];
    private JButton turnBackButton;
    private int labelCounter = 0;
    private ImageIcon imageIcon;
    private Window framePrincipal;

    public HumanSelectionMenu() {
        initComponent();

        // For each button we add the methods so each button can add a diferent character, and return to the main menu,
        // the turn back button makes you to go back to the race selection menu

        buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Window.player = humans.get(0);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Main Menu");
            }
        });

        buttons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Window.player = humans.get(1);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Main Menu");
            }
        });

//        buttons[2].addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mouseClicked(e);
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
//                framePrincipal = (Window) Frame.getFrames()[0];
//                framePrincipal.swapWiew("Main Menu");
//            }
//        });

        turnBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "turn_back_button_pressed.png");
                turnBackButton.setIcon(imageIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "turn_back_button.png");
                turnBackButton.setIcon(imageIcon);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Race Selection Menu");
            }
        });

        screenPanel.add(characterPanel[0]); // Character Left
        screenPanel.add(invisiblePanel[0]);
        screenPanel.add(characterPanel[1]); // Character Center
        screenPanel.add(invisiblePanel[1]);
        screenPanel.add(characterPanel[2]); // Character Right
        screenPanel.add(turnBackButtonPanel);
        screenPanel.setOpaque(false);

        screenPanel.setPreferredSize(new Dimension(1160, 460));

        backgroundImageHumanSelection.add(titlePanel);
        backgroundImageHumanSelection.add(screenPanel);
        backgroundImageHumanSelection.add(turnBackButtonPanel);

        add(backgroundImageHumanSelection);

    }

    public void initComponent() {

        // We initialize all the components we have

        screenPanel = new JPanel();

        // We set the turn back button, inside the panel

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "turn_back_button.png");
        turnBackButton = new JButton(imageIcon);
        turnBackButton.setPreferredSize(new Dimension(50, 50));
        turnBackButton.setContentAreaFilled(false);
        turnBackButton.setBorderPainted(false);

        turnBackButtonPanel = new JPanel();
        turnBackButtonPanel.setPreferredSize(new Dimension(1160, 60));
        turnBackButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        turnBackButtonPanel.add(turnBackButton);
        turnBackButtonPanel.setOpaque(false);

        // We set the title Panel

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_your_human.png");
        titlePanel = new JLabel(imageIcon);
        titlePanel.setPreferredSize(new Dimension(500, 100));

        // We set all the invisible auxiliar panels

        for (int i = 0 ; i < invisiblePanel.length; i++){
            invisiblePanel[i] = new JPanel();
            invisiblePanel[i].setPreferredSize(new Dimension(150, 0));
        }

        for (int i = 0; i < invisiblePanelCharacter.length; i++) {
            invisiblePanelCharacter[i] = new JPanel();
            invisiblePanelCharacter[i].setOpaque(false);
        }

        // We obtain the array of elves that we have

        humans = new Character().getRace("Human");

        // We initialize the panels for each character

        for(int i = 0; i < characterPanel.length ; i++){
            characterPanel[i] = new BorderImageHumanSelection();
            characterPanel[i].setLayout(new BoxLayout(characterPanel[i], BoxLayout.Y_AXIS));
            characterPanel[i].setPreferredSize(new Dimension(170, 450));
            characterPanel[i].setMaximumSize(new Dimension(170, 450));
        }

        // We make each character token

        for (int i = 0; i < humans.size(); i++) {
            labelCounter = i * 5 + i; // This is a counter to make the loop work

            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Characters" + File.separator + humans.get(i).getWarrior_image_path()); // We select the image from the array of elves

            // We scale the image and add it to the button

            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(165, 205, Image.SCALE_DEFAULT));
            buttons[i] = new JButton(image);
            buttons[i].setMaximumSize(new Dimension(165, 205));
            buttons[i].setPreferredSize(new Dimension(165, 205));
            buttons[i].setBackground(new java.awt.Color(189, 236, 182));

            // We add the button to the character panel

            characterPanel[i].add(buttons[i]);

            // This, like all the invisible panels, are to make the distance we want from two components in this cas the button to the text

            invisiblePanelCharacter[i * 3].setPreferredSize(new Dimension(20, 2));
            characterPanel[i].add(invisiblePanelCharacter[i * 3]);

            // We add the name

            label[labelCounter] = new JLabel("Name");
            label[labelCounter].setFont(new Font("", Font.BOLD, 16));
            characterPanel[i].add(label[labelCounter]);
            label[labelCounter + 1] = new JLabel(humans.get(i).getWarrior_name());
            characterPanel[i].add(label[labelCounter + 1]);

            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 1]);

            // We add the stats

            label[labelCounter + 2] = new JLabel("Stats");
            label[labelCounter + 2].setFont(new Font("", Font.BOLD, 16));
            characterPanel[i].add(label[labelCounter + 2]);
            label[labelCounter + 3] = new JLabel("<html>Hit Points: " + humans.get(i).getHp() +
                    "<br>Strength: " + humans.get(i).getStrength() +
                    "<br>Defense: " + humans.get(i).getDefense() +
                    "<br>Agility: " + humans.get(i).getAgility() +
                    "<br>Speed: " + humans.get(i).getSpeed() + "</html>");
            characterPanel[i].add(label[labelCounter + 3]);

            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 2]);

            // We add the lore

            label[labelCounter + 4] = new JLabel("Lore");
            label[labelCounter + 4].setFont(new Font("", Font.BOLD, 16));
            characterPanel[i].add(label[labelCounter + 4]);
            label[labelCounter + 5]= new JLabel(humans.get(i).getWarrior_lore());
            characterPanel[i].add(label[labelCounter + 5]);
        }
    }
}
