import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class WeaponSelectionMenu extends JFrame {
    private JPanel backgroundImageWeaponSelection;
    private JPanel weaponPanel[] = new JPanel[3];
    private JPanel panelInvisible[] = new JPanel[10];
    private JPanel mainPanel = new JPanel();
    private JPanel turnBackButtonPanel = new JPanel();
    private JPanel titlePanel = new JPanel();

    private JButton button[] = new JButton[8];
    private JButton weaponButtons[] = new JButton[8];
    private JButton turnBackButton = new JButton();
    private JButton tittleButton = new JButton();

    private ImageIcon imageIcon;
    private ArrayList<Weapon> elves;
    private JLabel label[] = new JLabel[40];
    private int labelCounter = 0;

    public WeaponSelectionMenu(){
        this.setTitle("AWSttle");

        backgroundImageWeaponSelection = new BackgroundImageWeaponSelection();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit screen = Toolkit.getDefaultToolkit();

        this.setDefaultLookAndFeelDecorated(true);

        Dimension size_s = screen.getScreenSize();
        int width_s = size_s.width; //WIDTH
        int height_s = size_s.height; //HEIGHT
        setSize(1280, 720);
        setLocation(screen.getScreenSize().width / 2 - getWidth() / 2, screen.getScreenSize().height / 2 - getHeight() / 2);


        this.setResizable(false);

        //INIT COMPONENT
        initComponent();

        mainPanel.add(weaponPanel[0]); //WEAPON 1
        weaponPanel[0].setPreferredSize(new Dimension(1180, 111));

        mainPanel.add(weaponPanel[1]); //WEAPON 2
        weaponPanel[1].setPreferredSize(new Dimension(1180, 111));

        mainPanel.add(weaponPanel[2]); //WEAPON 3
        weaponPanel[2].setPreferredSize(new Dimension(1180, 111));

        mainPanel.add(titlePanel); //TITTLE
        titlePanel.setPreferredSize(new Dimension(1180, 170));


        //PANEL 1 WEAPONS 1
        weaponPanel[0].add(weaponButtons[0]); //PHOTO
        weaponPanel[0].add(panelInvisible[4]); //AUX PANEL
        weaponPanel[0].add(weaponButtons[1]); //PHOTO

        //PANEL 2 WEAPONS 2
        weaponPanel[1].add(weaponButtons[2]); //PHOTO
        weaponPanel[1].add(panelInvisible[5]); //AUX PANEL
        weaponPanel[1].add(weaponButtons[3]); //PHOTO

        //PANEL 3 WEAPONS 3
        weaponPanel[2].add(weaponButtons[4]); //PHOTO
        weaponPanel[2].add(panelInvisible[6]); //AUX PANEL
        weaponPanel[2].add(weaponButtons[5]); //PHOTO

        //PANEL 5 PHOTO TITTLE
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(tittleButton);


        //ADD WEAPONS TO MAIN PANEL
        mainPanel.add(weaponPanel[0],BorderLayout.CENTER);
        mainPanel.add(weaponPanel[1],BorderLayout.CENTER);
        mainPanel.add(weaponPanel[2],BorderLayout.CENTER);
        mainPanel.add(turnBackButtonPanel,BorderLayout.CENTER);
        mainPanel.setOpaque(false);


        //PANEL AUX SUP
        panelInvisible[0].setPreferredSize(new Dimension(50, 50));

        //PANEL AUX INF
        panelInvisible[1].setPreferredSize(new Dimension(50, 50));

        //PANEL AUX LEFT
        panelInvisible[2].setPreferredSize(new Dimension(50, 50));

        //PANEL AUX RIGHT
        panelInvisible[3].setPreferredSize(new Dimension(50, 50));

        //ADD INVISIBLE PANELS TO ElfWeapon
        this.add(panelInvisible[0],BorderLayout.NORTH); //SUP
        this.add(panelInvisible[1], BorderLayout.SOUTH); //INF
        this.add(panelInvisible[2],BorderLayout.WEST); //LEFT
        this.add(panelInvisible[3],BorderLayout.EAST); //RIGHT





        this.add(mainPanel,BorderLayout.CENTER);

        backgroundImageWeaponSelection.add(titlePanel);
        backgroundImageWeaponSelection.add(mainPanel);
        backgroundImageWeaponSelection.add(turnBackButtonPanel);

        add(backgroundImageWeaponSelection);

        setVisible(true);
    }

    public void initComponent() {
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

        Weapon w = new Weapon();
        elves = w.getWeapons("Elf");

        for(Weapon wp : elves){
            System.out.println(wp); //Printa por consola los datos de las armas
        }

        for(int i = 0 ; i < weaponPanel.length ; i++){
            weaponPanel[i] = new JPanel();
        }

        for(int i = 0 ; i < panelInvisible.length ; i++){
            panelInvisible[i] = new JPanel();

        }

        for (int i = 0; i < weaponButtons.length; i++) {
            weaponButtons[i] = new JButton();
            weaponButtons[i].setPreferredSize(new Dimension(186, 186));
        }

        turnBackButton.setPreferredSize(new Dimension(50,50)); //RETURN BUTTON SIZE

        for (int i = 0; i < elves.size(); i++) {
            labelCounter = i * 2 + i;
            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "weapons" + File.separator + elves.get(i).getWeapon_image_path());
            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(165, 205, Image.SCALE_DEFAULT));

            weaponButtons[i] = new JButton(image);
            weaponButtons[i].setMaximumSize(new Dimension(160, 200));
            weaponButtons[i].setPreferredSize(new Dimension(160, 200));
            weaponButtons[i].setBackground(new java.awt.Color(189, 236, 182));

            label[labelCounter + 6] = new JLabel("<html>Strenght: " + elves.get(i).getWeapon_race()+
                    "<br>Speed: " + elves.get(i).getWeapon_speed()
                    + "</html>");

        }
    }
}
