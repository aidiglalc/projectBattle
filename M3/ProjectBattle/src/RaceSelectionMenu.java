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
    private JPanel jPanelTitle;
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

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Human Selection Menu");
            }
        });

        jButtons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Elf Selection Menu");
            }
        });

        jButtons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                framePrincipal = (Window) Frame.getFrames()[0];
                framePrincipal.swapWiew("Dwarf Selection Menu");
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

        backgroundImageCharacterSelection.add(jPanelTitle);
        backgroundImageCharacterSelection.add(jPanel);
        backgroundImageCharacterSelection.add(turnBackButtonPanel);

        add(backgroundImageCharacterSelection);

    }

    public void initComponent() {

        // This panels is the title

        jPanelTitle = new JPanel();
        jPanelTitle.setPreferredSize((new Dimension(500, 100)));
        jPanelTitle.setOpaque(false);

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
            jButtons[i] = new JButton();
            jButtons[i].setPreferredSize(new Dimension(300, 450));
        }

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
