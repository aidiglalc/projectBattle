import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

// This class shows the panel for the class selection menu

public class RaceSelectionMenu extends JPanel {
    private BackgroundImageCharacterSelection backgroundImageCharacterSelection = new BackgroundImageCharacterSelection();
    private JButton jButtons[] = new JButton[3];
    private JPanel jPanel;
    private JPanel jPanelInvisible[] = new JPanel[3];
    private JLabel jLabelTitle;
    private Window framePrincipal;
    private JPanel turnBackButtonPanel;
    private ImageIcon imageIcon;
    private JButton turnBackButton;

    public RaceSelectionMenu(){
        initComponent();

        // The buttons are for selecting the race and the turn back button return us to the main screen

        jButtons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "HumanBannerSelected.png");
                jButtons[0].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "HumanBanner.png");
                jButtons[0].setIcon(imageIcon);

                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Human Selection Menu");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "HumanBannerHover.png");
                jButtons[0].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "HumanBanner.png");
                jButtons[0].setIcon(imageIcon);
            }
        });

        jButtons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ElfBannerSelected.png");
                jButtons[1].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ElfBanner.png");
                jButtons[1].setIcon(imageIcon);

                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Elf Selection Menu");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ElfBannerHover.png");
                jButtons[1].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "ElfBanner.png");
                jButtons[1].setIcon(imageIcon);
            }
        });

        jButtons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "DwarfBannerSelected.png");
                jButtons[2].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "DwarfBanner.png");
                jButtons[2].setIcon(imageIcon);

                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Dwarf Selection Menu");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "DwarfBannerHover.png");
                jButtons[2].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "DwarfBanner.png");
                jButtons[2].setIcon(imageIcon);
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
                framePrincipal.swapWiew("Main Menu");
            }
        });

        backgroundImageCharacterSelection.add(jLabelTitle);
        backgroundImageCharacterSelection.add(jPanel);
        backgroundImageCharacterSelection.add(turnBackButtonPanel);

        add(backgroundImageCharacterSelection);

    }

    public void initComponent() {

        // This panels is the title

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_your_race.png");

        jLabelTitle = new JLabel(imageIcon);
        jLabelTitle.setPreferredSize((new Dimension(500, 100)));
        jLabelTitle.setOpaque(false);

        // Here we make the turn back button

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


        // Here we make the three buttons to choose race

        for (int i = 0; i < jButtons.length; i++) {
            if (i == 0) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "HumanBanner.png");
            else if (i == 1) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "ElfBanner.png");
            else if (i == 2) imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "DwarfBanner.png");
            jButtons[i] = new JButton(imageIcon);
            jButtons[i].setPreferredSize(new Dimension(300, 450));
            jButtons[i].setContentAreaFilled(false);
            jButtons[i].setBorderPainted(false);
        }
        imageIcon = new ImageIcon();
        for (int i = 0; i < jPanelInvisible.length; i++) {
            jPanelInvisible[i] = new JPanel();
            jPanelInvisible[i].setPreferredSize(new Dimension(50, 20));
            jPanelInvisible[i].setOpaque(false);

        }

        jPanel = new JPanel();
        jPanel.add(jButtons[0]);
        jPanel.add(jPanelInvisible[0]);
        jPanel.add(jButtons[1]);
        jPanel.add(jPanelInvisible[1]);
        jPanel.add(jButtons[2]);
        jPanel.setOpaque(false);
    }
}
