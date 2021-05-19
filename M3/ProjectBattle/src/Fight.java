import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Fight extends JPanel {
    private JPanel buttonPanel;
    private JPanel playerPanel;
    private JPanel enemyPanel;
    private JPanel playerSumPanel;
    private JPanel enemySumPanel;
    private JPanel bodyPanel;
    private JPanel playerStatsPanel;
    private JPanel enemyStatsPanel;
    private JPanel invisiblePanel[] = new JPanel[2];
    private JPanel characterSeparation;
    private JPanel playerHpPanel;
    private JPanel enemyHpPanel;
    private JButton button[] = new JButton[5];
    private BackgroundImageFighting backgroundImageFighting = new BackgroundImageFighting();
    private static JTextArea textArea;
    private JScrollPane scrollPane;
    private static JProgressBar playerProgressBar;
    private static JProgressBar enemyProgressBar;
    private JLabel infoPlayer[] = new JLabel[8];//LABELS INFO PLAYER 1
    private JLabel infoEnemy[] = new JLabel[8];//LABELS INFO PLAYER 2
    private JLabel imagePlayer;
    private JLabel imageEnemy;
    private JLabel weaponImagePlayer;
    private JLabel weaponImageEnemy;
    private JPanel playerStats;
    private JPanel enemyStats;
    private JLabel playerRemainingHpLabel;
    private JLabel enemyRemainingHpLabel;
    private JLabel playerTotalHpLabel;
    private JLabel enemyTotalHpLabel;
    private JLabel playerNameLabel;
    private JLabel enemyNameLabel;
    private ImageIcon imageIcon;
    private Window principalFrame;

    public Fight() {

        // Here we set the JProgress Bar

        UIManager.put("ProgressBar.background", Color.white);//colour of the background
        UIManager.put("ProgressBar.foreground", Color.green);//colour of progress bar
        UIManager.put("ProgressBar.selectionBackground", Color.black);//colour of percentage counter on black background
        UIManager.put("ProgressBar.selectionForeground", Color.black);//colour of precentage counter on red background

        initComponent();

        // We add the two buttons and their functionality

        button[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight_button_selected.png");
                button[0].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight_button.png");
                button[0].setIcon(imageIcon);
                button[0].setEnabled(false);
                fight();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight_button_hover.png");
                button[0].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "fight_button.png");
                button[0].setIcon(imageIcon);
            }
        });


        button[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "results_button_selected.png");
                button[1].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);

                if (Data.player.getCurrenthp() > 0) {
                    Data.winningStreak += 1;
                    Data.points += Data.enemy.getRace_points() + Data.enemyWeapon.getWeapon_points();
                }

                button[1].setEnabled(false);
                button[1].setVisible(false);
                button[0].setVisible(true);
                button[0].setEnabled(true);
                enemyProgressBar.setValue(100);
                enemyProgressBar.setForeground(Color.green);
                playerProgressBar.setValue(100);
                playerProgressBar.setForeground(Color.green);
                textArea.setText("");
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "results_button.png");
                button[1].setIcon(imageIcon);

                new DatabaseConnection().insertBattleDatabase();

                principalFrame = (Window) Frame.getFrames()[0];
                principalFrame.getEndFightMenu().reloadScreen();
                principalFrame.swapWiew("End Fight Menu");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "results_button_hover.png");
                button[1].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "results_button.png");
                button[1].setIcon(imageIcon);
            }
        });

        button[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx1_pressed.png");
                button[2].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx1.png");
                button[2].setIcon(imageIcon);
                Data.gameSpeed = 500;
                button[2].setEnabled(false);
                button[3].setEnabled(true);
                button[4].setEnabled(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx1_hover.png");
                button[2].setIcon(imageIcon);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx1.png");
                button[2].setIcon(imageIcon);

            }
        });

        button[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx2_pressed.png");
                button[3].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx2.png");
                button[3].setIcon(imageIcon);
                Data.gameSpeed = 250;
                button[2].setEnabled(true);
                button[3].setEnabled(false);
                button[4].setEnabled(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx2_hover.png");
                button[3].setIcon(imageIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx2.png");
                button[3].setIcon(imageIcon);

            }
        });

        button[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx5_pressed.png");
                button[4].setIcon(imageIcon);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx5.png");
                button[4].setIcon(imageIcon);
                Data.gameSpeed = 100;
                button[2].setEnabled(true);
                button[3].setEnabled(true);
                button[4].setEnabled(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx5_hover.png");
                button[4].setIcon(imageIcon);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                        File.separator + "Icons" + File.separator + "speedx5.png");
                button[4].setIcon(imageIcon);
            }
        });

        // Here we construct the player portrait with the other pieces we have

        playerHpPanel.add(playerRemainingHpLabel);
        playerHpPanel.add(playerTotalHpLabel);
        playerSumPanel.add(playerHpPanel);

        playerStatsPanel.add(invisiblePanel[0]);
        playerStatsPanel.add(weaponImagePlayer);
        playerStatsPanel.add(playerStats);

        playerPanel.add(playerNameLabel);
        playerPanel.add(imagePlayer);
        playerPanel.add(playerSumPanel);
        playerPanel.add(playerStatsPanel);

        // And now the enmy Panel

        enemyHpPanel.add(enemyRemainingHpLabel);
        enemyHpPanel.add(enemyTotalHpLabel);
        enemySumPanel.add(enemyHpPanel);

        enemyStatsPanel.add(invisiblePanel[1]);
        enemyStatsPanel.add(weaponImageEnemy);
        enemyStatsPanel.add(enemyStats);

        enemyPanel.add(enemyNameLabel);
        enemyPanel.add(imageEnemy);
        enemyPanel.add(enemySumPanel);
        enemyPanel.add(enemyStatsPanel);

        // With those two we ensamble the body

        bodyPanel.add(playerPanel); //ADDING PANEL2(PLAYER1) ON PANEL1
        bodyPanel.add(characterSeparation);
        bodyPanel.add(enemyPanel); //ADDING PANEL3(PLAYER2) ON PANEL1
        bodyPanel.add(scrollPane, BorderLayout.CENTER);//ADDING SCROLLPANE ON PANEL6

        // We add the buttons to their pannel

        buttonPanel.add(button[0], BorderLayout.CENTER); //ADDING BUTTON0 ON PANEL4(INF)
        buttonPanel.add(button[1], BorderLayout.CENTER); //ADDING BUTTON1 ON PANEL4(INF)
        buttonPanel.add(button[2]);
        buttonPanel.add(button[3]);
        buttonPanel.add(button[4]);

        // Add the two main panels to the background and add them to this class

        backgroundImageFighting.add(bodyPanel);
        backgroundImageFighting.add(buttonPanel);

        add(backgroundImageFighting);

    }

    public void initComponent() {

        // HP bar for player

        playerProgressBar = new JProgressBar();
        playerProgressBar.setStringPainted(true);
        playerProgressBar.setValue(100);
        playerProgressBar.setBounds(0, 0, 30, 30);
        playerProgressBar.setPreferredSize(new Dimension(200, 30));

        // HP bar for enemy

        enemyProgressBar = new JProgressBar();
        enemyProgressBar.setStringPainted(true);
        enemyProgressBar.setValue(100);
        enemyProgressBar.setPreferredSize(new Dimension(200, 30));
        enemyProgressBar.setBounds(5, 10, 200, 30);

        // Text Area that informs the player how the game is going

        textArea = new JTextArea(6, 80);
        textArea.setLineWrap(true);//salto de linea al llegar al final de textarea
        textArea.setBounds(30, 30, 1000, 800);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(30, 30, 300, 800);

        // Here we set the panels of the player and the enemy

        playerPanel = new CombatCharacterBackground();
        playerPanel.setOpaque(false);
        playerPanel.setPreferredSize(new Dimension(345, 460));

        playerSumPanel = new JPanel();
        playerSumPanel.setLayout(new BoxLayout(playerSumPanel, BoxLayout.Y_AXIS));
        playerSumPanel.setPreferredSize(new Dimension(200,50));
        playerSumPanel.add(playerProgressBar);
        playerSumPanel.setOpaque(false);


        enemyPanel = new CombatCharacterBackground();
        enemyPanel.setOpaque(false);
        enemyPanel.setPreferredSize(new Dimension(345, 460));

        enemySumPanel = new JPanel();
        enemySumPanel.setLayout(new BoxLayout(enemySumPanel, BoxLayout.Y_AXIS));
        enemySumPanel.setPreferredSize(new Dimension(200,50));
        enemySumPanel.add(enemyProgressBar);
        enemySumPanel.setOpaque(false);

        playerStats = new JPanel();
        playerStats.setLayout(new GridLayout(4, 2));
        playerStats.setOpaque(false);

        enemyStats = new JPanel();
        enemyStats.setLayout(new GridLayout(4, 2));
        enemyStats.setOpaque(false);

        for (int i = 0; i < invisiblePanel.length; i++) {
            invisiblePanel[i] = new JPanel();
            invisiblePanel[i].setPreferredSize(new Dimension(50, 90));
            invisiblePanel[i].setOpaque(false);
        }

        characterSeparation = new JPanel();
        characterSeparation.setPreferredSize(new Dimension(150, 0));
        characterSeparation.setOpaque(false);

        bodyPanel = new JPanel();
        bodyPanel.setOpaque(false);
        bodyPanel.setPreferredSize(new Dimension (1280,570));

        playerStatsPanel = new JPanel();
        playerStatsPanel.setPreferredSize(new Dimension(345, 100));
        playerStatsPanel.setOpaque(false);

        playerHpPanel = new JPanel();
        playerHpPanel.setOpaque(false);
        playerRemainingHpLabel = new JLabel("60");
        playerRemainingHpLabel.setForeground(Color.WHITE);
        playerTotalHpLabel = new JLabel("/ 60");
        playerTotalHpLabel.setForeground(Color.WHITE);

        playerNameLabel = new JLabel("PRUEBAS", SwingConstants.CENTER);
        playerNameLabel.setPreferredSize(new Dimension(300, 30));
        playerNameLabel.setForeground(Color.WHITE);

        enemyStatsPanel = new JPanel();
        enemyStatsPanel.setPreferredSize(new Dimension(345, 100));
        enemyStatsPanel.setOpaque(false);

        enemyHpPanel = new JPanel();
        enemyHpPanel.setOpaque(false);
        enemyRemainingHpLabel = new JLabel("60");
        enemyRemainingHpLabel.setForeground(Color.WHITE);
        enemyTotalHpLabel = new JLabel("/ 60");
        enemyTotalHpLabel.setForeground(Color.WHITE);

        enemyNameLabel = new JLabel("PRUEBAS", SwingConstants.CENTER);
        enemyNameLabel.setPreferredSize(new Dimension(300, 30));
        enemyNameLabel.setForeground(Color.WHITE);

        weaponImagePlayer = new JLabel();
        weaponImageEnemy = new JLabel();

        // Here we handle the button creation

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1280, 60));
        buttonPanel.setOpaque(false);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight_button.png");

        button[0] = new JButton(imageIcon);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "results_button.png");

        button[1] = new JButton(imageIcon);
        button[0].setPreferredSize(new Dimension(200, 50));
        button[1].setPreferredSize(new Dimension(200, 50));
        button[1].setEnabled(false);
        button[1].setVisible(false);
        button[0].setContentAreaFilled(false);
        button[0].setBorderPainted(false);
        button[1].setContentAreaFilled(false);
        button[1].setBorderPainted(false);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "speedx1.png");

        button[2] = new JButton(imageIcon);
        button[2].setPreferredSize(new Dimension(200, 50));
        button[2].setEnabled(false);
        button[2].setContentAreaFilled(false);
        button[2].setBorderPainted(false);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "speedx2.png");

        button[3] = new JButton(imageIcon);
        button[3].setPreferredSize(new Dimension(200, 50));
        button[3].setContentAreaFilled(false);
        button[3].setBorderPainted(false);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "speedx5.png");

        button[4] = new JButton(imageIcon);
        button[4].setPreferredSize(new Dimension(200, 50));
        button[4].setContentAreaFilled(false);
        button[4].setBorderPainted(false);

        // And now we create the labels for the player

        for (int i = 0; i < infoPlayer.length; i++) {
            if (i == 0) {
                infoPlayer[i] = new JLabel("Strength: ");
                infoPlayer[i].setPreferredSize(new Dimension(60, 20));
                infoEnemy[i] = new JLabel("Strength: ");
                infoEnemy[i].setPreferredSize(new Dimension(60, 20));
            }
            else if (i == 2) {
                infoPlayer[i] = new JLabel("Defense: ");
                infoPlayer[i].setPreferredSize(new Dimension(60, 20));
                infoEnemy[i] = new JLabel("Defense: ");
                infoEnemy[i].setPreferredSize(new Dimension(60, 20));
            }
            else if (i == 4) {
                infoPlayer[i] = new JLabel("Agility: ");
                infoPlayer[i].setPreferredSize(new Dimension(60, 20));
                infoEnemy[i] = new JLabel("Agility: ");
                infoEnemy[i].setPreferredSize(new Dimension(60, 20));
            }
            else if (i == 6) {
                infoPlayer[i] = new JLabel("Speed: ");
                infoPlayer[i].setPreferredSize(new Dimension(60, 20));
                infoEnemy[i] = new JLabel("Speed: ");
                infoEnemy[i].setPreferredSize(new Dimension(60, 20));
            }
            else {
                infoPlayer[i] = new JLabel("");
                infoPlayer[i].setPreferredSize(new Dimension(60, 20));
                infoEnemy[i] = new JLabel("");
                infoEnemy[i].setPreferredSize(new Dimension(60, 20));
            }

            infoPlayer[i].setForeground(Color.WHITE);
            infoEnemy[i].setForeground(Color.WHITE);
            playerStats.add(infoPlayer[i]);
            enemyStats.add(infoEnemy[i]);
        }

        imagePlayer = new JLabel();
        imagePlayer.setPreferredSize(new Dimension(200, 250));

        imageEnemy = new JLabel();
        imageEnemy.setPreferredSize(new Dimension(200, 250));

    }

    // This method reloads the screen with the updated information

    public void reloadScreen() {
        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.player.getWarrior_image_path());
        ImageIcon imagen1 = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));
        imagePlayer.setIcon(imagen1);

        infoPlayer[1].setText(String.valueOf(Data.player.getStrength() + Data.playerWeapon.getWeapon_strength()));
        infoPlayer[3].setText(String.valueOf(Data.player.getDefense()));
        infoPlayer[5].setText(String.valueOf(Data.player.getAgility()));
        infoPlayer[7].setText(String.valueOf(Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed()));

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.enemy.getWarrior_image_path());
        ImageIcon imagen2 = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));
        imageEnemy.setIcon(imagen2);

        infoEnemy[1].setText(String.valueOf(Data.enemy.getStrength() + Data.enemyWeapon.getWeapon_strength()));
        infoEnemy[3].setText(String.valueOf(Data.enemy.getDefense()));
        infoEnemy[5].setText(String.valueOf(Data.enemy.getAgility()));
        infoEnemy[7].setText(String.valueOf(Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed()));

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "weapons" + File.separator + Data.playerWeapon.getWeapon_image_path());

        imagen1 = new ImageIcon(imageIcon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));

        weaponImagePlayer.setIcon(imagen1);

        imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "weapons" + File.separator + Data.enemyWeapon.getWeapon_image_path());

        imagen1 = new ImageIcon(imageIcon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));

        weaponImageEnemy.setIcon(imagen1);

        playerRemainingHpLabel.setText(String.valueOf(Data.player.getCurrenthp()));
        playerTotalHpLabel.setText("/ " + Data.player.getHp());
        playerNameLabel.setText(Data.player.getWarrior_name());

        enemyRemainingHpLabel.setText(String.valueOf(Data.enemy.getCurrenthp()));
        enemyTotalHpLabel.setText("/ " + Data.enemy.getHp());
        enemyNameLabel.setText(Data.enemy.getWarrior_name());
    }

    // This method handles the fight

    public void fight() {

        // We add the fight into a threat to make some animations and make the battle go step by step

        Thread thread = new Thread(() -> {
            boolean flagPlayerAttack = false; // This flag controls if the player attacks first or not
            boolean playerTurn = true;
            boolean enemyTurn = true;
            int damageDone = 0;

            // We make the choice of what player begins their turn

            if (Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed() > Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed())
                flagPlayerAttack = true;
            else if (Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed() < Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed())
                flagPlayerAttack = false;
            else if (Data.player.getAgility() > Data.enemy.getAgility()) flagPlayerAttack = true;
            else if (Data.player.getAgility() < Data.enemy.getAgility()) flagPlayerAttack = false;
            else {
                if ((int) (Math.random() * 100) >= 50) flagPlayerAttack = true;
                else flagPlayerAttack = false;
            }

            // Now we make a playerfight until one of those two dies by the logic asigned in the project information

            while (Data.player.getCurrenthp() > 0 && Data.enemy.getCurrenthp() > 0) {
                if (flagPlayerAttack == true && Data.enemy.getCurrenthp() > 0 && Data.player.getCurrenthp() > 0) {

                    textArea.append(Data.player.getWarrior_name() + " attacks! ");
                    while (playerTurn) {
                        if (Data.player.getAgility() * 10 > (int) (Math.random() * 100) + 1) {
                            if (Data.enemy.getAgility() > (int) ((Math.random()) * 50) + 1) {
                                textArea.append(Data.enemy.getWarrior_name() + " dodges the attack!\n");
                            } else {
                                damageDone = Data.player.getStrength() + Data.playerWeapon.getWeapon_strength() - Data.enemy.getDefense();
                                textArea.append(Data.player.getWarrior_name() + " hits " + Data.enemy.getWarrior_name() + " for " + damageDone + " points of damage!\n");

                                for (int i = 0; i < damageDone; i++) {
                                    Data.enemy.setCurrenthp(Data.enemy.getCurrenthp() - 1);
                                    enemyRemainingHpLabel.setText(String.valueOf(Data.enemy.getCurrenthp()));
                                    enemyProgressBar.setValue((int)(((float)Data.enemy.getCurrenthp() / (float)Data.enemy.getHp()) * 100));
                                    enemyProgressBar.repaint();
                                    if ((int)(((float)Data.enemy.getCurrenthp() / (float)Data.enemy.getHp()) * 100) <= 20) enemyProgressBar.setForeground(Color.RED);
                                    else if ((int)(((float)Data.enemy.getCurrenthp() / (float)Data.enemy.getHp()) * 100) <= 50) enemyProgressBar.setForeground(Color.YELLOW);
                                    try {
                                        Thread.sleep(Data.gameSpeed / 20);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            textArea.append(Data.player.getWarrior_name() + " attack misses!\n");
                        }

                        if ((Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed()) <= (Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed())) {
                            playerTurn = false;
                            enemyTurn = true;
                        } else if (((Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed()) - (Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed())) * 10
                                > (int) (Math.random() * 100) + 1 && Data.player.getCurrenthp() > 0 && Data.enemy.getCurrenthp() > 0) {
                            textArea.append(Data.player.getWarrior_name() + " attacks again! ");
                        } else {
                            playerTurn = false;
                            enemyTurn = true;
                        }

                        textArea.setSelectionStart(textArea.getText().length());

                        try {
                            Thread.sleep(Data.gameSpeed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                if (Data.enemy.getCurrenthp() > 0 && Data.player.getCurrenthp() > 0) {
                    textArea.append(Data.enemy.getWarrior_name() + " attacks! ");
                    while (enemyTurn) {
                        if (Data.enemy.getAgility() * 10 > (int) (Math.random() * 100) + 1) {
                            if (Data.player.getAgility() > (int) ((Math.random()) * 50) + 1) {
                                textArea.append(Data.player.getWarrior_name() + " dodges the attack!\n");
                            } else {
                                damageDone = Data.enemy.getStrength() + Data.enemyWeapon.getWeapon_strength() - Data.player.getDefense();
                                textArea.append(Data.enemy.getWarrior_name() + " hits " + Data.player.getWarrior_name() + " for " + damageDone + " points of damage!\n");
                                for (int i = 0; i < damageDone; i++) {
                                    Data.player.setCurrenthp(Data.player.getCurrenthp() - 1);
                                    playerRemainingHpLabel.setText(String.valueOf(Data.player.getCurrenthp()));
                                    playerProgressBar.setValue((int)(((float)Data.player.getCurrenthp() / (float)Data.player.getHp()) * 100));
                                    playerProgressBar.repaint();
                                    if ((int)(((float)Data.player.getCurrenthp() / (float)Data.player.getHp()) * 100) <= 20) playerProgressBar.setForeground(Color.RED);
                                    else if ((int)(((float)Data.player.getCurrenthp() / (float)Data.player.getHp()) * 100) <= 50) playerProgressBar.setForeground(Color.YELLOW);
                                    try {
                                        Thread.sleep(Data.gameSpeed / 20);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            textArea.append(Data.enemy.getWarrior_name() + " attack misses!\n");
                        }

                        if ((Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed()) <= (Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed())) {
                            enemyTurn = false;
                            playerTurn = true;
                            flagPlayerAttack = true;
                        } else if (((Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed()) - (Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed())) * 10
                                > (int) (Math.random() * 100) + 1 && Data.player.getCurrenthp() > 0 && Data.enemy.getCurrenthp() > 0) {
                            textArea.append(Data.enemy.getWarrior_name() + " attacks again! ");
                        } else {
                            enemyTurn = false;
                            playerTurn = true;
                            flagPlayerAttack = true;
                        }
                        textArea.setSelectionStart(textArea.getText().length());
                        try {
                            Thread.sleep(Data.gameSpeed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            // We add those functionalities at the end of the fight to change the button to results button

            button[0].setVisible(false);
            button[1].setEnabled(true);
            button[1].setVisible(true);
            imageIcon = new ImageIcon();
            button[1].setIcon(imageIcon = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "results_button.png"));
        });
        // We use the thread we created
        thread.start();
    }
}

