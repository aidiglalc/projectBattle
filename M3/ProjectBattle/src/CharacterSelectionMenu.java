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
    private JPanel screenPanel;
    private JPanel invisiblePanel[] = new JPanel[3];
    private JLabel titlePanel;
    private JLabel characterDescriptionLabels[] = new JLabel[15];
    private JPanel characterButtonsPanel;
    private JPanel characterDescriptionsPanel;
    private JPanel turnBackButtonPanel;
    private JButton buttons[] = new JButton[3];
    private JButton turnBackButton;
    private ImageIcon imageIcon;
    private Window principalFrame;
    private String race;

    public CharacterSelectionMenu(String race) {
        this.race = race;

        if (race.equalsIgnoreCase("human")) backgroundImageCharacterSelection = new BackgroundImageHumanSelection();
        else if (race.equalsIgnoreCase("elf")) backgroundImageCharacterSelection = new BackgroundImageElfSelection();
        else if (race.equalsIgnoreCase("dwarf")) backgroundImageCharacterSelection = new BackgroundImageDwarfSelection();

        initComponent();

        // For each button we add the methods so each button can add a diferent character, and return to the main menu,
        // the turn back button makes you to go back to the race selection menu

        for (int i = 0; i < buttons.length; i++){
            int index = i;
            buttons[index].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mouseClicked(e);

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    Data.player = characters.get(index);
                    Data.playerWeapon = new Weapon (0, "null", 0, 0, "null", "null", 0);
                    principalFrame = (Window) Frame.getFrames()[0];
                    principalFrame.swapWiew("Main Menu");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    characterDescriptionLabels[1].setText(characters.get(index).getWarrior_name());
                    characterDescriptionLabels[3].setText(String.valueOf(characters.get(index).getHp()));
                    characterDescriptionLabels[5].setText(String.valueOf(characters.get(index).getStrength()));
                    characterDescriptionLabels[7].setText(String.valueOf(characters.get(index).getDefense()));
                    characterDescriptionLabels[9].setText(String.valueOf(characters.get(index).getAgility()));
                    characterDescriptionLabels[11].setText(String.valueOf(characters.get(index).getSpeed()));
                    characterDescriptionLabels[13].setText(characters.get(index).getWarrior_lore());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    characterDescriptionLabels[1].setText("");
                    characterDescriptionLabels[3].setText("");
                    characterDescriptionLabels[5].setText("");
                    characterDescriptionLabels[7].setText("");
                    characterDescriptionLabels[9].setText("");
                    characterDescriptionLabels[11].setText("");
                    characterDescriptionLabels[13].setText("");
                }
            });
        }

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
                principalFrame = (Window) Frame.getFrames()[0];
                principalFrame.swapWiew("Race Selection Menu");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "turn_back_button_hover.png");
                turnBackButton.setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "turn_back_button.png");
                turnBackButton.setIcon(imageIcon);
            }

        });

        backgroundImageCharacterSelection.add(titlePanel);
        backgroundImageCharacterSelection.add(screenPanel);
        backgroundImageCharacterSelection.add(turnBackButtonPanel);

        add(backgroundImageCharacterSelection);

    }

    public void initComponent() {

        // We initialize all the components we have

        screenPanel = new JPanel();
        screenPanel.setPreferredSize(new Dimension(1160, 460));
        screenPanel.setOpaque(false);

        // We check the race to set the background

        if (race.equalsIgnoreCase("Human")) {
            characterButtonsPanel = new HumanBackgroundSelection();
            characterDescriptionsPanel = new HumanBackgroundSelection();
        }
        else if (race.equalsIgnoreCase("Elf")) {
            characterButtonsPanel = new ElfBackgroundSelection();
            characterDescriptionsPanel = new ElfBackgroundSelection();
        }

        else if (race.equalsIgnoreCase("Dwarf")) {
            characterButtonsPanel = new DwarfBackgroundSelection();
            characterDescriptionsPanel = new DwarfBackgroundSelection();
        }

        // We create the panels to set all the items how we want

        for (int i = 0 ; i < invisiblePanel.length; i++){
            invisiblePanel[i] = new JPanel();
            invisiblePanel[i].setOpaque(false);
        }

        // We set and create each panel

        invisiblePanel[0].setPreferredSize(new Dimension(100, 0));
        invisiblePanel[1].setPreferredSize(new Dimension(440, 15));
        invisiblePanel[2].setPreferredSize(new Dimension(440, 15));

        characterButtonsPanel.setPreferredSize(new Dimension(450, 450));
        characterButtonsPanel.setOpaque(false);
        characterDescriptionsPanel.setPreferredSize(new Dimension(450, 450));
        characterDescriptionsPanel.setOpaque(false);

        screenPanel.add(characterButtonsPanel);
        screenPanel.add(invisiblePanel[0]);
        screenPanel.add(characterDescriptionsPanel);

        characterButtonsPanel.add(invisiblePanel[1]);
        characterDescriptionsPanel.add(invisiblePanel[2]);

        // We set the title Panel

        if (race.equalsIgnoreCase("human")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_human.png");
        else if (race.equalsIgnoreCase("elf")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_elf.png");
        else if (race.equalsIgnoreCase("dwarf")) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator +
                "src" + File.separator + "Images" + File.separator + "Icons" + File.separator + "choose_your_dwarf.png");

        titlePanel = new JLabel(imageIcon);
        titlePanel.setPreferredSize(new Dimension(500, 100));

        // We obtain the array of characters that we have

        characters = new DatabaseConnection().getRace(race);

        // We make each character token

        for (int i = 0; i < characters.size(); i++) {

            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Characters" + File.separator + characters.get(i).getWarrior_image_path()); // We select the image from the array of characters

            // We scale the image and add it to the button

            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(320, 400, Image.SCALE_DEFAULT));
            buttons[i] = new JButton(image);
            buttons[i].setPreferredSize(new Dimension(130, 400));

            // We add the button to the character panel

            characterButtonsPanel.add(buttons[i]);
        }

        for (int i = 0; i < characterDescriptionLabels.length; i++) {
            if (i == 0) characterDescriptionLabels[i] = new JLabel("Character Name:");
            else if (i == 2) characterDescriptionLabels[i] = new JLabel("HP:");
            else if (i == 4) characterDescriptionLabels[i] = new JLabel("Strength:");
            else if (i == 6) characterDescriptionLabels[i] = new JLabel("Defense:");
            else if (i == 8) characterDescriptionLabels[i] = new JLabel("Agility:");
            else if (i == 10) characterDescriptionLabels[i] = new JLabel("Speed:");
            else if (i == 12) characterDescriptionLabels[i] = new JLabel("Lore:");
            else characterDescriptionLabels[i] = new JLabel();

            characterDescriptionLabels[i].setForeground(Color.WHITE);
            characterDescriptionLabels[i].setFont(new Font("", Font.BOLD, 16));

            characterDescriptionsPanel.add(characterDescriptionLabels[i]);
        }

        characterDescriptionLabels[0].setPreferredSize(new Dimension(140,50)); // Name
        characterDescriptionLabels[1].setPreferredSize(new Dimension(270,50)); // Name Value
        characterDescriptionLabels[2].setPreferredSize(new Dimension(100,50)); // HP
        characterDescriptionLabels[3].setPreferredSize(new Dimension(100,50)); // HP value
        characterDescriptionLabels[4].setPreferredSize(new Dimension(100,50)); // Strength
        characterDescriptionLabels[5].setPreferredSize(new Dimension(100,50)); // Strength Value
        characterDescriptionLabels[6].setPreferredSize(new Dimension(100,50)); // Defense
        characterDescriptionLabels[7].setPreferredSize(new Dimension(100,50)); // Defense Value
        characterDescriptionLabels[8].setPreferredSize(new Dimension(100,50)); // Agility
        characterDescriptionLabels[9].setPreferredSize(new Dimension(100,50)); // Agility Value
        characterDescriptionLabels[10].setPreferredSize(new Dimension(100,50)); // Speed
        characterDescriptionLabels[11].setPreferredSize(new Dimension(310,50)); // Speed Value
        characterDescriptionLabels[12].setPreferredSize(new Dimension(415,50)); // Lore
        characterDescriptionLabels[13].setPreferredSize(new Dimension(410,120)); // Lore Value
        characterDescriptionLabels[13].setHorizontalAlignment(JLabel.LEFT);
        characterDescriptionLabels[13].setVerticalAlignment(JLabel.TOP);

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
    }
}