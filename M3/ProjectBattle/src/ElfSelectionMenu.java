import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class ElfSelectionMenu extends JFrame {
    private BackgroundImageElfSelection backgroundImageElfSelection = new BackgroundImageElfSelection();
    private ArrayList<Character> elves;
    private JPanel characterPanel[] = new JPanel[3];
    private JPanel screenPanel;
    private JPanel invisiblePanel[] = new JPanel[2];
    private JPanel invisiblePanelCharacter[] = new JPanel[9];
    private JLabel invisiblePanelFrame;
    private JPanel turnBackButtonPanel;
    private JLabel label[] = new JLabel[19];
    private JButton buttons[] = new JButton[3];
    private JButton turnBackButton;
    private int labelCounter = 0;
    private ImageIcon imageIcon;

    public ElfSelectionMenu() {
        setTitle("AWSttle");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension size_s = screen.getScreenSize();
        setSize(1280, 720);
        setLocation(screen.getScreenSize().width / 2 - getWidth() / 2, screen.getScreenSize().height / 2 - getHeight() / 2);

        setResizable(false);

        //INIT COMPONENT
        initComponent();

        turnBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon("src/Images/Icons/turn_back_button_pressed.png");
                turnBackButton.setIcon(imageIcon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon("src/Images/Icons/turn_back_button.png");
                turnBackButton.setIcon(imageIcon);
            }
        });

        //PANEL POSITION (AIDA, MARTÍ, SANDRA)
        screenPanel.add(characterPanel[0]); //AIDA
        screenPanel.add(invisiblePanel[0]); //AUX CENTR LEFT
        screenPanel.add(characterPanel[1]); //MARTÍ
        screenPanel.add(invisiblePanel[1]); //AUX CENTR RIGHT
        screenPanel.add(characterPanel[2]); //SANDRA
        screenPanel.add(turnBackButtonPanel);
        screenPanel.setOpaque(false);

        screenPanel.setPreferredSize(new Dimension(1160, 460));

        backgroundImageElfSelection.add(invisiblePanelFrame);
        backgroundImageElfSelection.add(screenPanel);
        backgroundImageElfSelection.add(turnBackButtonPanel);

        add(backgroundImageElfSelection);

        setVisible(true);
    }

    public void initComponent() {
        screenPanel = new JPanel();
        turnBackButtonPanel = new JPanel();
        imageIcon = new ImageIcon("src/Images/Icons/turn_back_button.png");
        turnBackButton = new JButton(imageIcon);

        elves = new Character().getRace("Elf");

        for(int i = 0; i < characterPanel.length ; i++){
            characterPanel[i] = new BorderImageElfSelection();
            characterPanel[i].setLayout(new BoxLayout(characterPanel[i], BoxLayout.Y_AXIS));
            characterPanel[i].setPreferredSize(new Dimension(170, 450));
            characterPanel[i].setMaximumSize(new Dimension(170, 450));
        }

        imageIcon = new ImageIcon("src/Images/Icons/choose_your_elf.png");

        invisiblePanelFrame = new JLabel(imageIcon);
        invisiblePanelFrame.setPreferredSize(new Dimension(500, 100));


        for (int i = 0 ; i < invisiblePanel.length; i++){
            invisiblePanel[i] = new JPanel();
            invisiblePanel[i].setPreferredSize(new Dimension(150, 0));
        }

        for (int i = 0; i < invisiblePanelCharacter.length; i++) {
            invisiblePanelCharacter[i] = new JPanel();
            invisiblePanelCharacter[i].setOpaque(false);
        }

        for (int i = 0; i < elves.size(); i++) {
            labelCounter = i * 5 + i;
            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Characters" + File.separator + elves.get(i).getWarrior_image_path());
            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(165, 205, Image.SCALE_DEFAULT));
            buttons[i] = new JButton(image);
            buttons[i].setMaximumSize(new Dimension(165, 205));
            buttons[i].setPreferredSize(new Dimension(165, 205));
            buttons[i].setBackground(new java.awt.Color(189, 236, 182));

            characterPanel[i].add(buttons[i]);
            invisiblePanelCharacter[i*3].setPreferredSize(new Dimension(20, 2));
            characterPanel[i].add(invisiblePanelCharacter[i * 3]);

            label[labelCounter] = new JLabel("Name");
            label[labelCounter].setFont(new Font("Waree", Font.BOLD, 16));

            characterPanel[i].add(label[labelCounter]);
            label[labelCounter + 1] = new JLabel(elves.get(i).getWarrior_name());

            characterPanel[i].add(label[labelCounter + 1]);
            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 1]);

            label[labelCounter + 2] = new JLabel("Stats");
            label[labelCounter + 2].setFont(new Font("Waree", Font.BOLD, 16));

            characterPanel[i].add(label[labelCounter + 2]);

            label[labelCounter + 3] = new JLabel("<html>Hit Points: " + elves.get(i).getHp() +
                    "<br>Strength: " + elves.get(i).getStrength() +
                    "<br>Defense: " + elves.get(i).getDefense() +
                    "<br>Agility: " + elves.get(i).getAgility() +
                    "<br>Speed: " + elves.get(i).getSpeed() + "</html>");


            characterPanel[i].add(label[labelCounter + 3]);
            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 2]);

            label[labelCounter + 4] = new JLabel("Lore");
            label[labelCounter + 4].setFont(new Font("Waree", Font.BOLD, 16));

            characterPanel[i].add(label[labelCounter + 4]);

            label[labelCounter + 5]= new JLabel(elves.get(i).getWarrior_lore());


            characterPanel[i].add(label[labelCounter + 5]);
        }

        turnBackButton.setPreferredSize(new Dimension(50, 50));
        turnBackButton.setContentAreaFilled(false);
        turnBackButton.setBorderPainted(false);
        turnBackButtonPanel.setPreferredSize(new Dimension(1160, 60));
        turnBackButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        turnBackButtonPanel.add(turnBackButton);
        turnBackButtonPanel.setOpaque(false);
    }
}