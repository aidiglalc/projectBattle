import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EndFight extends JPanel{
    private BackgroundImageFighting backgroundImageFighting = new BackgroundImageFighting();

    private JPanel titlePanel = new JPanel();
    private ImageIcon imageIcon_title;

    private JPanel buttonPanel = new JPanel();
    private JPanel button_invisiblePanel = new JPanel();
    private JButton buttons[] = new JButton[2];
    private ImageIcon imageIcon_button[] = new ImageIcon[2];

    private JPanel mainPanel = new JPanel();
    private JPanel statsPanel[] = new JPanel[2];
    private JPanel stats_invisiblePanel[] = new JPanel[5];
    private JLabel statsLabel[] = new JLabel[4];
    private ImageIcon imageIcon_stats[] = new ImageIcon[4];
    private JLabel infoLabel[] = new JLabel[4];
    private JLabel outcome = new JLabel();
    private ImageIcon outcomeImage = new ImageIcon();
    private JLabel playerImage = new JLabel();
    private ImageIcon imageIcon_player = new ImageIcon();

    public EndFight() {
        stats_invisiblePanel[0]=new JPanel();
        stats_invisiblePanel[1]=new JPanel();
        stats_invisiblePanel[2]=new JPanel();
        stats_invisiblePanel[3]=new JPanel();
        stats_invisiblePanel[4]=new JPanel();

        statsPanel[0] = new JPanel();
        statsPanel[1] = new JPanel();


        initComponent();
        mainPanel.setLayout(new GridLayout(1,2));
        statsPanel[0].setLayout(new BoxLayout(statsPanel[0], BoxLayout.Y_AXIS));
        statsPanel[1].setLayout(new BoxLayout(statsPanel[1], BoxLayout.Y_AXIS));

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

        mainPanel.add(statsPanel[0]);
        mainPanel.add(statsPanel[1]);

        backgroundImageFighting.add(titlePanel,BorderLayout.CENTER);
        backgroundImageFighting.add(buttonPanel,BorderLayout.CENTER);
        backgroundImageFighting.add(mainPanel);


        this.add(backgroundImageFighting);

        setVisible(true);
    }

    private void initComponent() {
        //Yes/No buttons
        for (int i = 0 ; i < imageIcon_button.length ; i++) {
            imageIcon_button[i] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "fight.png");
            buttons[i] = new JButton(imageIcon_button[i]);
        }

        for (int i = 0 ; i < buttons.length ; i++){
            buttonPanel.add(buttons[i]);
            if (i == 0){
                buttonPanel.add(button_invisiblePanel);
                button_invisiblePanel.setPreferredSize(new Dimension(100, 100));
                button_invisiblePanel.setOpaque(false);
            }
            buttons[i].setPreferredSize(new Dimension(100, 50));
            buttonPanel.setOpaque(false);
        }

        //Title
        titlePanel.setPreferredSize(new Dimension(1280, 100));
        imageIcon_title = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "choose_your_race.png");
        JLabel titleLabel = new JLabel(imageIcon_title);
        titlePanel.add(titleLabel);
        titlePanel.setOpaque(false);

        //Stats and info
        imageIcon_stats[0] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight.png"); //HAS GANADO A
        ImageIcon imageIcon_s0 = new ImageIcon(imageIcon_stats[0].getImage().getScaledInstance(450,40, Image.SCALE_DEFAULT));
        statsLabel[0] = new JLabel(imageIcon_stats[2]);
        statsLabel[0].setIcon(imageIcon_s0);
        infoLabel[0] = new JLabel("Prueba 0"); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO


        imageIcon_stats[1] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight.png"); //LLEVABA EL ARMA
        ImageIcon imageIcon_s1 = new ImageIcon(imageIcon_stats[1].getImage().getScaledInstance(450,40, Image.SCALE_DEFAULT));
        statsLabel[1] = new JLabel(imageIcon_stats[1]);
        statsLabel[1].setIcon(imageIcon_s1);
        infoLabel[1] = new JLabel("Prueba 1"); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO


        imageIcon_stats[2] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight.png"); //TIENES UN TOTAL DE
        ImageIcon imageIcon_s2 = new ImageIcon(imageIcon_stats[2].getImage().getScaledInstance(450,40, Image.SCALE_DEFAULT));
        statsLabel[2] = new JLabel(imageIcon_stats[2]);
        statsLabel[2].setIcon(imageIcon_s2);
        infoLabel[2] = new JLabel("Prueba 2"); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO


        imageIcon_stats[3] = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Icons" + File.separator + "fight.png"); //HAS DERROTADO A UN TOTAL DE
        ImageIcon imageIcon_s3 = new ImageIcon(imageIcon_stats[3].getImage().getScaledInstance(450,40, Image.SCALE_DEFAULT));
        statsLabel[3] = new JLabel(imageIcon_stats[3]);
        statsLabel[3].setIcon(imageIcon_s3);
        infoLabel[3] = new JLabel("Prueba 3"); //PRUEBA PARA VER QUE EL LABEL SE MAQUETA BIEN, HAY QUE ELIMINARLO

        //Winner/Loser
        if (Data.player.getHp() < 0) {
            outcomeImage = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "fight.png"); //loser
            ImageIcon imageIcon_oc = new ImageIcon(outcomeImage.getImage().getScaledInstance(450, 50, Image.SCALE_DEFAULT));
            outcome = new JLabel(outcomeImage);
            outcome.setIcon(imageIcon_oc);
        }
        else{
            outcomeImage = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                    File.separator + "Icons" + File.separator + "fight.png"); //winner
            ImageIcon imageIcon_oc = new ImageIcon(outcomeImage.getImage().getScaledInstance(450, 50, Image.SCALE_DEFAULT));
            outcome = new JLabel(outcomeImage);
            outcome.setIcon(imageIcon_oc);
        }

        imageIcon_player = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + "Dwarf_1.JPG"); //PRUEBA PARA VER QUE LA FOTO SE MAQUETA BIEN, HAY QUE ELIMINARLO
        ImageIcon imageIcon_p = new ImageIcon(imageIcon_player.getImage().getScaledInstance(250,320, Image.SCALE_DEFAULT));
        playerImage = new JLabel(imageIcon_player);
        playerImage.setIcon(imageIcon_p);



        //Info label color
        for (int i = 0; i < infoLabel.length; i++) {
            infoLabel[i].setForeground(Color.WHITE);
            infoLabel[i].setFont(new Font("", Font.BOLD, 16));}

        statsPanel[0].setPreferredSize(new Dimension(500,400));
        statsPanel[0].setOpaque(false);
        statsPanel[1].setPreferredSize(new Dimension(500,400));
        statsPanel[1].setOpaque(false);
        mainPanel.setOpaque(false);
    }
   /*
        public void reloadScreen () {
        infoLabel[0].setText(String.valueOf(Data.enemy.getWarrior_name())); //Bot's name
        infoLabel[1].setText(String.valueOf(Data.enemyWeapon.getWeapon_name())); //Bot's weapon
        infoLabel[2].setText(String.valueOf(Data.points)); //Player total points
        infoLabel[3].setText(String.valueOf(Data.enemy.getRace_points())); //Enemies defeated

        imageIcon_player = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.player.getWarrior_image_path());
        ImageIcon imageIcon_p = new ImageIcon(imageIcon_player.getImage().getScaledInstance(250,320, Image.SCALE_DEFAULT));
        playerImage = new JLabel(imageIcon_player);
        playerImage.setIcon(imageIcon_p);
    }
    */
}