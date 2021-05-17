import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class WeaponSelectionMenu extends JPanel {
    private JPanel backgroundImageWeaponSelection = new BackgroundImageWeaponSelection();
    private JPanel weaponPanel = new BackgroundWeapons();
    private JPanel weaponDescriptionPanel = new BackgroundWeapons();
    private JPanel mainPanel = new JPanel();
    private JPanel turnBackButtonPanel = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JPanel invisiblePanel = new JPanel();
    private JPanel invisiblePanelWeaponImage = new JPanel();
    private JPanel invisiblePanelWeaponStats = new JPanel();
    private ArrayList<JButton> weaponButtons = new ArrayList<JButton>();
    private JButton turnBackButton = new JButton();
    private ImageIcon imageIcon;
    private ArrayList<Weapon> weaponArrayList;
    private JLabel weaponDescription[] = new JLabel[6];
    private JLabel title;
    private Window principalFrame;
    private String race;
    private String parts[];

    public WeaponSelectionMenu(String race){
        //INIT COMPONENT
        this.race = race;
        initComponent();


        for (int i = 0; i < weaponArrayList.size(); i++){
            int index = i;
            weaponButtons.get(index).addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mouseClicked(e);
                    parts = weaponArrayList.get(index).getWeapon_image_path().split("\\.");
                    imageIcon =  new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                            File.separator + "weapons" + File.separator + parts[0] + "_selected." + parts[1]);
                    weaponButtons.get(index).setIcon(imageIcon);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    Data.playerWeapon = weaponArrayList.get(index);
                    principalFrame = (Window) Frame.getFrames()[0];
                    principalFrame.swapWiew("Main Menu");

                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    parts = weaponArrayList.get(index).getWeapon_image_path().split("\\.");
                    imageIcon =  new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                            File.separator + "weapons" + File.separator + parts[0] + "_hover." + parts[1]);
                    weaponButtons.get(index).setIcon(imageIcon);
                    weaponDescription[1].setText(weaponArrayList.get(index).getWeapon_name());
                    weaponDescription[3].setText(String.valueOf(weaponArrayList.get(index).getWeapon_strength()));
                    weaponDescription[5].setText(String.valueOf(weaponArrayList.get(index).getWeapon_speed()));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    imageIcon =  new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                            File.separator + "weapons" + File.separator + weaponArrayList.get(index).getWeapon_image_path());
                    weaponButtons.get(index).setIcon(imageIcon);
                    weaponDescription[1].setText("");
                    weaponDescription[3].setText("");
                    weaponDescription[5].setText("");
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
                principalFrame.swapWiew("Main Menu");
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


        //ADD WEAPONS TO MAIN PANEL

        backgroundImageWeaponSelection.add(titlePanel);
        backgroundImageWeaponSelection.add(mainPanel);
        backgroundImageWeaponSelection.add(turnBackButtonPanel);

        add(backgroundImageWeaponSelection);

    }

    public void initComponent() {
        titlePanel.setPreferredSize(new Dimension(1280, 100));
        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_your_weapon.png");
        title = new JLabel(imageIcon);
        titlePanel.add(title);
        titlePanel.setOpaque(false);

        weaponArrayList = new Weapon().getWeapons(race);

        invisiblePanelWeaponImage.setPreferredSize(new Dimension(448, 12));
        weaponPanel.add(invisiblePanelWeaponImage);
        invisiblePanelWeaponImage.setOpaque(false);

        invisiblePanelWeaponStats.setPreferredSize(new Dimension(448, 12));
        weaponDescriptionPanel.add(invisiblePanelWeaponStats);
        invisiblePanelWeaponStats.setOpaque(false);

        for (int i = 0; i < weaponArrayList.size(); i++) {

            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "weapons" + File.separator + weaponArrayList.get(i).getWeapon_image_path());
            ImageIcon image = new ImageIcon(imageIcon.getImage().getScaledInstance(132, 132, Image.SCALE_DEFAULT));
            weaponButtons.add(new JButton(image));
            weaponButtons.get(i).setPreferredSize(new Dimension(132, 132));
            weaponButtons.get(i).setContentAreaFilled(false);
            weaponButtons.get(i).setBorderPainted(false);
        }
        weaponPanel.setPreferredSize(new Dimension(448, 450));
        weaponPanel.setOpaque(false);

        for (int i = 0; i < weaponButtons.size(); i++) {
            weaponPanel.add(weaponButtons.get(i));
        }

        weaponDescriptionPanel.setPreferredSize(new Dimension(448, 450));
        weaponDescriptionPanel.setOpaque(false);

        mainPanel.setPreferredSize(new Dimension(1280, 450));
        invisiblePanel.setPreferredSize(new Dimension(100, 450));
        invisiblePanel.setOpaque(false);

        for (int i = 0; i < weaponDescription.length; i++) {
            if (i == 0) weaponDescription[i] = new JLabel("Weapon Name: ");
            else if (i == 2) weaponDescription[i] = new JLabel("Weapon Strength: ");
            else if (i == 4) weaponDescription[i] = new JLabel("Weapon Speed: ");
            else weaponDescription[i] = new JLabel();

            if (i == 0 || i % 2 == 0) weaponDescription[i].setPreferredSize(new Dimension(150,132));
            else weaponDescription[i].setPreferredSize(new Dimension(200,132));

            weaponDescription[i].setFont(new Font("", Font.BOLD, 16));
            weaponDescription[i].setForeground(Color.WHITE);
            weaponDescriptionPanel.add(weaponDescription[i]);
        }

        mainPanel.add(weaponPanel);
        mainPanel.add(invisiblePanel);
        mainPanel.add(weaponDescriptionPanel);
        mainPanel.setOpaque(false);
        // Turn Back Button

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

