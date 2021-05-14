import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

// This class is the panel that we show in the character selection

public class CharacterSelectionMenu extends JPanel {
    private JPanel backgroundImageCharacterSelection;
    private ArrayList<Character> characters;
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
    private String race;

    public CharacterSelectionMenu(String race) {
        this.race = race;

        if (race.equalsIgnoreCase("human")) backgroundImageCharacterSelection = new BackgroundImageHumanSelection();
        else if (race.equalsIgnoreCase("elf")) backgroundImageCharacterSelection = new BackgroundImageElfSelection();
        else if (race.equalsIgnoreCase("dwarf")) backgroundImageCharacterSelection = new BackgroundImageDwarfSelection();

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
                Window.player = characters.get(0);
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
                Window.player = characters.get(1);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Main Menu");
            }
        });

        buttons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                Window.player = characters.get(2);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Main Menu");
            }
        });

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

        backgroundImageCharacterSelection.add(titlePanel);
        backgroundImageCharacterSelection.add(screenPanel);
        backgroundImageCharacterSelection.add(turnBackButtonPanel);

        add(backgroundImageCharacterSelection);

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

        if (race.equalsIgnoreCase("human")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_human.png");
        else if (race.equalsIgnoreCase("elf")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_elf.png");
        else if (race.equalsIgnoreCase("dwarf")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_dwarf.png");


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

        // We obtain the array of characters that we have

        characters = new Character().getRace(race);

        // We initialize the panels for each character

        for(int i = 0; i < characterPanel.length ; i++){
            if (race.equalsIgnoreCase("human")) characterPanel[i] = new BorderImageHumanSelection();
            else if (race.equalsIgnoreCase("elf")) characterPanel[i] = new BorderImageElfSelection();
            else if (race.equalsIgnoreCase("dwarf")) characterPanel[i] = new BorderImageDwarfSelection();

            characterPanel[i].setLayout(new BoxLayout(characterPanel[i], BoxLayout.Y_AXIS));
            characterPanel[i].setPreferredSize(new Dimension(170, 450));
            characterPanel[i].setMaximumSize(new Dimension(170, 450));
        }

        // We make each character token

        for (int i = 0; i < characters.size(); i++) {
            labelCounter = i * 5 + i; // This is a counter to make the loop work

            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Characters" + File.separator + characters.get(i).getWarrior_image_path()); // We select the image from the array of characters

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
            label[labelCounter + 1] = new JLabel(characters.get(i).getWarrior_name());
            characterPanel[i].add(label[labelCounter + 1]);

            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 1]);

            // We add the stats

            label[labelCounter + 2] = new JLabel("Stats");
            label[labelCounter + 2].setFont(new Font("", Font.BOLD, 16));
            characterPanel[i].add(label[labelCounter + 2]);
            label[labelCounter + 3] = new JLabel("<html>Hit Points: " + characters.get(i).getHp() +
                    "<br>Strength: " + characters.get(i).getStrength() +
                    "<br>Defense: " + characters.get(i).getDefense() +
                    "<br>Agility: " + characters.get(i).getAgility() +
                    "<br>Speed: " + characters.get(i).getSpeed() + "</html>");
            characterPanel[i].add(label[labelCounter + 3]);

            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 2]);

            // We add the lore

            label[labelCounter + 4] = new JLabel("Lore");
            label[labelCounter + 4].setFont(new Font("", Font.BOLD, 16));
            characterPanel[i].add(label[labelCounter + 4]);
            label[labelCounter + 5]= new JLabel(characters.get(i).getWarrior_lore());
            characterPanel[i].add(label[labelCounter + 5]);
        }
    }
}