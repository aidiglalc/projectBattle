import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class EndFightMenu extends JPanel{
    private BackgroundImage backgroundImageEndFight = new BackgroundImage(1280, 720, "ResultsBackground.png");

    private ImageIcon imageIcon_title;

    private JPanel buttonPanel = new JPanel();
    private JButton buttons[] = new JButton[3];
    private ImageIcon imageIcon_button[] = new ImageIcon[2];

    private JPanel mainPanel = new BackgroundImage(900, 400, "results_main_panel_background.png");
    private JPanel statsPanel[] = new JPanel[2];
    private JPanel stats_invisiblePanel[] = new JPanel[5];
    private JLabel statsLabel[] = new JLabel[4];
    private ImageIcon imageIcon_stats[] = new ImageIcon[4];
    private JLabel infoLabel[] = new JLabel[4];
    private JLabel outcome = new JLabel();
    private ImageIcon outcomeImage = new ImageIcon();
    private JLabel playerImage = new JLabel();
    private ImageIcon imageIcon_player = new ImageIcon();
    private JLabel titleLabel;
    private JLabel keepFighting;
    private JLabel winnerName;
    private ImageIcon imageIcon;
    private Window principalFrame;

    public EndFightMenu() {
        stats_invisiblePanel[0]=new JPanel();
        stats_invisiblePanel[1]=new JPanel();
        stats_invisiblePanel[2]=new JPanel();
        stats_invisiblePanel[3]=new JPanel();
        stats_invisiblePanel[4]=new JPanel();

        statsPanel[0] = new JPanel();
        statsPanel[1] = new JPanel();


        initComponent();
        mainPanel.setLayout(new GridLayout(1,2));

        statsPanel[0].add(statsLabel[0]);
        statsPanel[0].add(infoLabel[0]);
        statsPanel[0].add(stats_invisiblePanel[0]);
        stats_invisiblePanel[0].setOpaque(false);

        statsPanel[0].add(statsLabel[1]);
        statsPanel[0].add(infoLabel[1]);
        statsPanel[0].add(stats_invisiblePanel[1]);
        stats_invisiblePanel[1].setOpaque(false);

        statsPanel[0].add(statsLabel[2]);
        statsPanel[0].add(infoLabel[2]);
        statsPanel[0].add(stats_invisiblePanel[2]);
        stats_invisiblePanel[2].setOpaque(false);

        statsPanel[0].add(statsLabel[3]);
        statsPanel[0].add(infoLabel[3]);
        statsPanel[0].add(stats_invisiblePanel[3]);
        stats_invisiblePanel[3].setOpaque(false);


        statsPanel[1].add(outcome);
        statsPanel[1].add(stats_invisiblePanel[4]);
        stats_invisiblePanel[4].setOpaque(false);
        playerImage.setHorizontalAlignment(JLabel.CENTER);

        statsPanel[1].add(playerImage);
        statsPanel[1].add(winnerName);

        mainPanel.add(statsPanel[0]);
        mainPanel.add(statsPanel[1]);

        backgroundImageEndFight.add(titleLabel);
        backgroundImageEndFight.add(mainPanel);
        backgroundImageEndFight.add(keepFighting);
        backgroundImageEndFight.add(buttonPanel);


        this.add(backgroundImageEndFight);

        buttons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "yes_button_pressed.png");
                buttons[0].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "yes_button.png");
                buttons[0].setIcon(imageIcon);
                if (Data.player.getCurrenthp() > 0) {
                    Data.player.setCurrenthp(Data.player.getHp());
                    principalFrame = (Window) Frame.getFrames()[0];
                    Data.enemy = new EnemyGenerator().getOponentCharacter();
                    Data.player.setCurrenthp(Data.player.getHp());
                    Data.enemy.setCurrenthp(Data.enemy.getHp());
                    principalFrame.getFight().reloadScreen();
                    principalFrame.swapWiew("Fighting Menu");
                }
                else {
                    new DatabaseConnection().updateGameDatabase();
                    principalFrame = (Window) Frame.getFrames()[0];
                    principalFrame.getFight().reloadScreen();
                    principalFrame.swapWiew("Race Selection Menu");
                    Data.points = 0;
                    Data.winningStreak = 0;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "yes_button_hover.png");
                buttons[0].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "yes_button.png");
                buttons[0].setIcon(imageIcon);
            }
        });

        buttons[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "no_button_pressed.png");
                buttons[1].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "no_button.png");
                buttons[1].setIcon(imageIcon);
                new DatabaseConnection().updateGameDatabase();
                Data.points = 0;
                Data.winningStreak = 0;
                Data.player = new Character(0, "Player", "Dwarf_2.JPG", "null", "null", 1, 0, 0, 0, 0,0);
                Data.playerWeapon = new Weapon (0, "PlayerWeapon", 0, 0, "null", "null", 0);
                principalFrame = (Window) Frame.getFrames()[0];
                principalFrame.swapWiew("Main Menu");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "no_button_hover.png");
                buttons[1].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "no_button.png");
                buttons[1].setIcon(imageIcon);
            }
        });

        buttons[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_button_pressed.png");
                buttons[2].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_button.png");
                buttons[2].setIcon(imageIcon);
                principalFrame = (Window) Frame.getFrames()[0];
                new DatabaseConnection().updateGameDatabase();
                System.exit(1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_button_hover.png");
                buttons[2].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_button.png");
                buttons[2].setIcon(imageIcon);
            }
        });
        setVisible(true);
    }

    private void initComponent() {
        //Yes/No buttons

        keepFighting = new JLabel();
        winnerName = new JLabel("PROBIS PROBIS", SwingConstants.CENTER);
        winnerName.setFont(new Font("", Font.BOLD, 16));
        winnerName.setPreferredSize(new Dimension(300, 30));
        winnerName.setForeground(Color.WHITE);

        for (int i = 0 ; i < buttons.length ; i++) {
            if (i == 0) {
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "yes_button.png");
            }
            else if (i == 1) {
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "no_button.png");
            }
            else if (i == 2) {
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "exit_button.png");
            }
            buttons[i] = new JButton(imageIcon);
            buttons[i].setPreferredSize(new Dimension(150, 50));
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
        }

        for (int i = 0 ; i < buttons.length ; i++){
            buttonPanel.add(buttons[i]);
            buttonPanel.setOpaque(false);
        }
        buttonPanel.setPreferredSize(new Dimension(1280, 100));
        //Title

        imageIcon_title = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "results.png");
        titleLabel = new JLabel(imageIcon_title);
        imageIcon_title = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "keep_fighting.png");
        keepFighting = new JLabel(imageIcon_title);

        //Stats and info
        imageIcon_stats[0] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "enemy.png"); //HAS GANADO A
        ImageIcon imageIcon_s0 = new ImageIcon(imageIcon_stats[0].getImage().getScaledInstance(300,50, Image.SCALE_DEFAULT));
        statsLabel[0] = new JLabel(imageIcon_stats[2]);
        statsLabel[0].setIcon(imageIcon_s0);
        infoLabel[0] = new JLabel("Prueba 0", SwingConstants.CENTER); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO

        imageIcon_stats[1] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "enemy_weapon.png"); //LLEVABA EL ARMA
        ImageIcon imageIcon_s1 = new ImageIcon(imageIcon_stats[1].getImage().getScaledInstance(300,50, Image.SCALE_DEFAULT));
        statsLabel[1] = new JLabel(imageIcon_stats[1]);
        statsLabel[1].setIcon(imageIcon_s1);
        infoLabel[1] = new JLabel("Prueba 1", SwingConstants.CENTER); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO


        imageIcon_stats[2] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "total_points.png"); //TIENES UN TOTAL DE
        ImageIcon imageIcon_s2 = new ImageIcon(imageIcon_stats[2].getImage().getScaledInstance(300,50, Image.SCALE_DEFAULT));
        statsLabel[2] = new JLabel(imageIcon_stats[2]);
        statsLabel[2].setIcon(imageIcon_s2);
        infoLabel[2] = new JLabel("Prueba 2", SwingConstants.CENTER); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO


        imageIcon_stats[3] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "winning_streak.png"); //HAS DERROTADO A UN TOTAL DE
        ImageIcon imageIcon_s3 = new ImageIcon(imageIcon_stats[3].getImage().getScaledInstance(300,50, Image.SCALE_DEFAULT));
        statsLabel[3] = new JLabel(imageIcon_stats[3]);
        statsLabel[3].setIcon(imageIcon_s3);
        infoLabel[3] = new JLabel("Prueba 3", SwingConstants.CENTER); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO

        //Winner/Loser
        outcomeImage = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "winner.png"); //loser
        ImageIcon imageIcon_oc = new ImageIcon(outcomeImage.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        outcome = new JLabel(outcomeImage);
        outcome.setIcon(imageIcon_oc);

        imageIcon_player = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + "Dwarf_1.JPG"); //PRUEBA PARA VER QUE LA FOTO SE MAQUETA BIEN, HAY QUE ELIMINARLO

        ImageIcon imageIcon_p = new ImageIcon(imageIcon_player.getImage().getScaledInstance(230,265, Image.SCALE_DEFAULT));
        playerImage = new JLabel(imageIcon_player);
        playerImage.setIcon(imageIcon_p);



        //Info label color
        for (int i = 0; i < infoLabel.length; i++) {
            infoLabel[i].setForeground(Color.WHITE);
            infoLabel[i].setFont(new Font("", Font.BOLD, 16));
            infoLabel[i].setPreferredSize(new Dimension(300, 30));
        }

        statsPanel[0].setPreferredSize(new Dimension(450,370));
        statsPanel[0].setOpaque(false);
        statsPanel[1].setPreferredSize(new Dimension(450,370));
        statsPanel[1].setOpaque(false);
        mainPanel.setOpaque(false);
    }
        public void reloadScreen () {
        infoLabel[0].setText(String.valueOf(Data.enemy.getWarrior_name())); //Bot's name
        infoLabel[1].setText(String.valueOf(Data.enemyWeapon.getWeapon_name())); //Bot's weapon
        infoLabel[2].setText(String.valueOf(Data.points)); //Player total points
        infoLabel[3].setText(String.valueOf(Data.winningStreak)); //Enemies defeated

            if (Data.player.getCurrenthp() > 0) {
                imageIcon_player = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Characters" + File.separator + Data.player.getWarrior_image_path());
                ImageIcon imageIcon_p = new ImageIcon(imageIcon_player.getImage().getScaledInstance(230,265, Image.SCALE_DEFAULT));
                playerImage.setIcon(imageIcon_p);
                winnerName.setText(Data.player.getWarrior_name());
            }
            else {
                imageIcon_player = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Characters" + File.separator + Data.enemy.getWarrior_image_path());
                ImageIcon imageIcon_p = new ImageIcon(imageIcon_player.getImage().getScaledInstance(230,265, Image.SCALE_DEFAULT));
                playerImage.setIcon(imageIcon_p);
                winnerName.setText(Data.enemy.getWarrior_name());
            }
    }
}