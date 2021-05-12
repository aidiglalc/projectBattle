import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.util.ArrayList;

public class Elf extends JFrame {
    private ArrayList<Character> elves;
    private JPanel characterPanel[] = new JPanel[3];
    private JPanel screenPanel = new JPanel();
    private JPanel invisiblePanel[] = new JPanel[2];
    private JPanel invisiblePanelCharacter[] = new JPanel[9];
    private JPanel invisiblePanelFrame[] = new JPanel[4];
    private JLabel label[] = new JLabel[19];
    private JButton buttons[] = new JButton[3];
    private int labelCounter = 0;

    public Elf () {
        setTitle("AWSttle");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension size_s = screen.getScreenSize();
        setSize(1280, 720);
        setLocation(screen.getScreenSize().width / 2 - getWidth() / 2, screen.getScreenSize().height / 2 - getHeight() / 2);

        setResizable(false);

        //INIT COMPONENT
        initComponent();

        //PANEL POSITION (AIDA, MARTÍ, SANDRA)
        screenPanel.add(characterPanel[0]); //AIDA
        screenPanel.add(invisiblePanel[0]); //AUX CENTR LEFT
        screenPanel.add(characterPanel[1]); //MARTÍ
        screenPanel.add(invisiblePanel[1]); //AUX CENTR RIGHT
        screenPanel.add(characterPanel[2]); //SANDRA

        //ADD PANEL
        this.add(invisiblePanelFrame[0],BorderLayout.NORTH); //SUP
        this.add(invisiblePanelFrame[1], BorderLayout.SOUTH); //INF
        this.add(invisiblePanelFrame[2],BorderLayout.WEST); //LEFT
        this.add(invisiblePanelFrame[3],BorderLayout.EAST); //RIGHT

        add(screenPanel);

        setVisible(true);
    }
    public void initComponent() {
        elves = new Character().getRace("Elf");
        System.out.println(elves);

        for(int i = 0; i < characterPanel.length ; i++){
            characterPanel[i] = new JPanel();
            characterPanel[i].setLayout(new BoxLayout(characterPanel[i], BoxLayout.Y_AXIS));
        }

        for (int i = 0 ; i < invisiblePanelFrame.length ; i++){
            invisiblePanelFrame[i] = new JPanel();
            if (i == 0 || i == 1) {
                invisiblePanelFrame[i].setPreferredSize(new Dimension(50, 100));
            }
            else if (i == 2 || i == 3) {
                invisiblePanelFrame[i].setPreferredSize(new Dimension(50, 0));
            }
        }

        for (int i = 0 ; i < invisiblePanel.length; i++){
            invisiblePanel[i] = new JPanel();
            invisiblePanel[i].setPreferredSize(new Dimension(150, 0));
        }

        for (int i = 0; i < invisiblePanelCharacter.length; i++) {
            invisiblePanelCharacter[i] = new JPanel();
            invisiblePanelCharacter[i].setPreferredSize(new Dimension(50, 20));
        }

        for (int i = 0; i < elves.size(); i++) {
            labelCounter = i * 5 + i;
            ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Characters" + File.separator + elves.get(i).getWarrior_image_path());
            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));
            buttons[i] = new JButton(image);
            buttons[i].setMinimumSize(new Dimension(20, 20));
            buttons[i].setMaximumSize(new Dimension(210, 260));
            buttons[i].setPreferredSize(new Dimension(210, 260));
            buttons[i].setBackground(new java.awt.Color(189, 236, 182));

            characterPanel[i].add(buttons[i]);

            characterPanel[i].add(invisiblePanelCharacter[i * 3]);

            label[labelCounter] = new JLabel("NAME");
            label[labelCounter].setFont(new Font("Waree", Font.PLAIN, 20));
            label[labelCounter].setHorizontalAlignment(JLabel.CENTER);

            characterPanel[i].add(label[labelCounter]);

            label[labelCounter + 1] = new JLabel(elves.get(i).getWarrior_name());
            label[labelCounter + 1].setFont(new Font("Waree", Font.PLAIN, 10));

            characterPanel[i].add(label[labelCounter + 1]);
            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 1]);

            label[labelCounter + 2] = new JLabel("STATS");
            label[labelCounter + 2].setFont(new Font("Waree", Font.PLAIN, 20));

            characterPanel[i].add(label[labelCounter + 2]);

            label[labelCounter + 3] = new JLabel("EJEMPLO");
            label[labelCounter + 3].setFont(new Font("Waree", Font.PLAIN, 10));

            characterPanel[i].add(label[labelCounter + 3]);
            characterPanel[i].add(invisiblePanelCharacter[i * 3 + 2]);

            label[labelCounter + 4] = new JLabel("LORE");
            label[labelCounter + 4].setFont(new Font("Waree", Font.PLAIN, 20));

            characterPanel[i].add(label[labelCounter + 4]);

            label[labelCounter + 5] = new JLabel("EJEMPLO");
            label[labelCounter + 5].setFont(new Font("Waree", Font.PLAIN, 10));

            characterPanel[i].add(label[labelCounter + 5]);
        }
    }
}