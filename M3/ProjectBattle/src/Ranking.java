import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

// In this class we show a panel with the top ten players

public class Ranking extends JPanel {
    private JPanel jPanels[] = new JPanel[4];
    private JLabel jLabels[] = new JLabel[10];
    private JLabel name[] = new JLabel[10];
    private JLabel points[] = new JLabel[10];
    private JLabel titleRankingLabel;
    private JLabel titleNameLabel;
    private JLabel titlePointsLabel;
    private JPanel invisiblePanelPoints;
    private ArrayList top = new DatabaseConnection().getTopTen();
    private BackgroundImage backgroundImageRanking = new BackgroundImage(1280, 720, "RankingBackground.png");
    private ImageIcon imageIcon;
    private JButton turnBackButton;
    private JPanel turnBackButtonPanel;
    private Window principalFrame;
    private BackgroundImage backgroundImageTopTen = new BackgroundImage(600, 460, "TopTenRankingBackground.png");

    public Ranking() {
        initComponent();

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

        // We add the Statistics Panels into the center panel

        backgroundImageTopTen.add(jPanels[0]); // Position Panel
        backgroundImageTopTen.add(jPanels[1]); // Name Panel
        backgroundImageTopTen.add(jPanels[2]); // Points Panel


        //PANEL POSITION (TITTLE, NAME, POINTS)
        backgroundImageRanking.add(titleRankingLabel); //TITTLE RANKING
        backgroundImageRanking.add(backgroundImageTopTen);
        backgroundImageRanking.add(turnBackButtonPanel);

        add(backgroundImageRanking);
        setVisible(true);
    }

    public void initComponent() {

        // We make the panels and set the size

        for (int i = 0; i < jPanels.length; i++) {
            jPanels[i] = new JPanel();
            jPanels[i].setOpaque(false);
        }

        jPanels[0].setPreferredSize(new Dimension(45, 450)); // Position Panel
        jPanels[1].setPreferredSize(new Dimension(245, 450)); // Name Panel
        jPanels[2].setPreferredSize(new Dimension(245, 450)); // Points Panel
        backgroundImageTopTen.setPreferredSize(new Dimension(600, 460)); // Panel with all the other panels
        backgroundImageTopTen.setOpaque(false);

        // Here we make all the title labels

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "ranking_title.png");

        titleRankingLabel = new JLabel(imageIcon);//TITTLE RANKING
        titleRankingLabel.setPreferredSize((new Dimension(1280, 100)));
        titleRankingLabel.setFont(new Font("", Font.BOLD, 36));

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "name.png");

        titleNameLabel = new JLabel(imageIcon);//TITTLE NAME
        titleNameLabel.setPreferredSize((new Dimension(245, 62)));
        titleNameLabel.setFont(new Font("", Font.PLAIN, 22));
        titleNameLabel.setOpaque(false);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "points.png");

        titlePointsLabel = new JLabel(imageIcon);//TITTLE POINTS
        titlePointsLabel.setPreferredSize((new Dimension(245, 62)));
        titlePointsLabel.setFont(new Font("", Font.PLAIN, 22));

        // This invisible panel is to set the height of the numbers correctly

        invisiblePanelPoints = new JPanel();
        invisiblePanelPoints.setPreferredSize((new Dimension(45, 62)));
        invisiblePanelPoints.setOpaque(false);

        // We add those labels to each panel

        jPanels[0].add(invisiblePanelPoints);
        jPanels[1].add(titleNameLabel);
        jPanels[2].add(titlePointsLabel);

        // Here we get all the players in the top ten and add then into their respective panels

        for (int i = 0; i < top.size(); i++) {

            // Name labels

            name[i] = new JLabel((String)((ArrayList)top.get(i)).get(0), SwingConstants.CENTER );
            name[i].setFont(new Font("", Font.PLAIN, 20));
            name[i].setPreferredSize((new Dimension(500, 32)));


            // Points labels

            points[i] = new JLabel(String.valueOf(((ArrayList)top.get(i)).get(1)), SwingConstants.CENTER);
            points[i].setFont(new Font("", Font.PLAIN, 20));
            points[i].setPreferredSize((new Dimension(500, 32)));


            if (i == 0)  {
                name[i].setForeground(Color.YELLOW);
                points[i].setForeground(Color.YELLOW);
            }
            else if (i == 1)  {
                name[i].setForeground(Color.LIGHT_GRAY);
                points[i].setForeground(Color.LIGHT_GRAY);
            }
            else if (i == 2)  {
                name[i].setForeground(Color.ORANGE);
                points[i].setForeground(Color.ORANGE);
            }
            else {
                name[i].setForeground(Color.WHITE);
                points[i].setForeground(Color.WHITE);
            }

            // Position Labels
            imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Numbers" + File.separator + (i + 1) + ".png");
            jLabels[i] = new JLabel(imageIcon, SwingConstants.CENTER);
            jLabels[i].setFont(new Font("", Font.PLAIN, 20));
            jLabels[i].setPreferredSize((new Dimension(45, 32)));

            // We add them into their respective panels

            jPanels[0].add(jLabels[i]);
            jPanels[1].add(name[i]);
            jPanels[2].add(points[i]);
        }

        if (top.size() < 10) {
            for (int i = top.size(); i < 10; i++){
                // Name labels

                name[i] = new JLabel("", SwingConstants.CENTER);
                name[i].setFont(new Font("", Font.PLAIN, 20));
                name[i].setPreferredSize((new Dimension(500, 32)));


                // Points labels

                points[i] = new JLabel("", SwingConstants.CENTER);
                points[i].setFont(new Font("", Font.PLAIN, 20));
                points[i].setPreferredSize((new Dimension(500, 32)));


                if (i == 0)  {
                    name[i].setForeground(Color.YELLOW);
                    points[i].setForeground(Color.YELLOW);
                }
                else if (i == 1)  {
                    name[i].setForeground(Color.LIGHT_GRAY);
                    points[i].setForeground(Color.LIGHT_GRAY);
                }
                else if (i == 2)  {
                    name[i].setForeground(Color.ORANGE);
                    points[i].setForeground(Color.ORANGE);
                }
                else {
                    name[i].setForeground(Color.WHITE);
                    points[i].setForeground(Color.WHITE);
                }

                // Position Labels
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Numbers" + File.separator + (i + 1) + ".png");
                jLabels[i] = new JLabel(imageIcon, SwingConstants.CENTER);
                jLabels[i].setFont(new Font("", Font.PLAIN, 20));
                jLabels[i].setPreferredSize((new Dimension(45, 32)));
                jLabels[i].setVisible(false);

                // We add them into their respective panels

                jPanels[0].add(jLabels[i]);
                jPanels[1].add(name[i]);
                jPanels[2].add(points[i]);
            }
        }

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

    }

    // This method reloads the ranking

    public void reloadRanking() {
        ArrayList top = new DatabaseConnection().getTopTen();
        for (int i = 0; i < top.size(); i++){
            jLabels[i].setVisible(true);
            name[i].setText((String)((ArrayList)top.get(i)).get(0));
            points[i].setText((String.valueOf(((ArrayList)top.get(i)).get(1))));
        }
    }
}
