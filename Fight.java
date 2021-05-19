import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Fight extends JPanel {
    private JPanel panel[] = new JPanel[9];
    private JLabel label[] = new JLabel[13];
    private JLabel titleFightLabel;
    private JButton button[]=new JButton[5];
    private BackgroundImageFighting backgroundImageFighting = new BackgroundImageFighting();
    private JTextArea textarea=new JTextArea(5,100);
    private JScrollPane scrollpane;
    private JProgressBar progressBar1 = new JProgressBar(0, 100);//barra de vida player1
    private JProgressBar progressBar2 = new JProgressBar(0, 100);//barra de vida player2
    private JLabel infoPlayer1[]=new JLabel[8];//LABELS INFO PLAYER 1
    private JLabel infoPlayer2[]=new JLabel[8];//LABELS INFO PLAYER 2
    private JLabel imagenPlayer1;
    private JLabel imagenPlayer2;
    private ImageIcon image1;
    private ImageIcon image2;


    public Fight() {
        //COLOR JPROGRESSBAR
        UIManager.put("ProgressBar.background", Color.white);//colour of the background
        UIManager.put("ProgressBar.foreground", Color.green);//colour of progress bar
        UIManager.put("ProgressBar.selectionBackground", Color.red);//colour of percentage counter on black background
        UIManager.put("ProgressBar.selectionForeground", Color.black);//colour of precentage counter on red background

        progressBar1 = new JProgressBar();
        progressBar1.setStringPainted(true); // para mostrar el porcentage como texto en la barra

        progressBar2 = new JProgressBar();
        progressBar2.setStringPainted(true);

        initComponent();

        //TextArea and ScrolllPane
        textarea.setLineWrap(true);//salto de linea al llegar al final de textarea
        textarea.setBounds(30, 30, 1000, 800);
        scrollpane = new JScrollPane(textarea);
        scrollpane.setBounds(30, 30, 300, 800);

        //TITTLE RANKING
        panel[0].add(titleFightLabel);
        panel[0].setPreferredSize(new Dimension(1280, 50));

        //BARRA DE VIDA PLAYER1
        progressBar1.setValue(100);
        progressBar1.setBounds(5, 10, 530, 30);
        progressBar1.setPreferredSize(new Dimension(50,30));
        progressBar1.setStringPainted(true); //Agrega el porcentaje en la barra
        button[0].addActionListener(new buttonFight());

        //BARRA DE VIDA PLAYER2
        progressBar2.setValue(100);
        progressBar2.setPreferredSize(new Dimension(50,30));
        progressBar2.setBounds(5, 10, 530, 30);
        progressBar2.setStringPainted(true); //Agrega el porcentaje en la barra


        //PLAYER 1
        panel[2].setBorder(BorderFactory.createLineBorder(Color.black));
        panel[2].setPreferredSize(new Dimension(545, 400));

        //PLAYER 2
        panel[3].setBorder(BorderFactory.createLineBorder(Color.black));
        panel[3].setPreferredSize(new Dimension(545, 400));

        //PANEL BUTTON INF
        panel[4].setPreferredSize(new Dimension(1280, 37));
        panel[4].setBorder(BorderFactory.createLineBorder(Color.black));

        //PANEL BUTTON SUP
        panel[5].setPreferredSize(new Dimension(1280, 37));
        panel[5].setBorder(BorderFactory.createLineBorder(Color.black));

        //PANEL TEXTAREA
        panel[6].setPreferredSize(new Dimension(1280,100));
        panel[6].setBorder(BorderFactory.createLineBorder(Color.black));

        //PANEL JLABEL INFO PLAYER1
        panel[7].setBorder(BorderFactory.createLineBorder(Color.black));
        panel[7].setLayout(new GridLayout(4,2));

        //PANEL JLABEL INFO PLAYER2
        panel[8].setBorder(BorderFactory.createLineBorder(Color.black));
        panel[8].setLayout(new GridLayout(4,2));


        //ADDING TITTLE FIGHTING ON PANEL0
        backgroundImageFighting.add(panel[0]);

        //ADDING LABELS TO PANEL7
        panel[7].add(infoPlayer1[0]);
        panel[7].add(infoPlayer1[1]);
        panel[7].add(infoPlayer1[2]);
        panel[7].add(infoPlayer1[3]);
        panel[7].add(infoPlayer1[4]);
        panel[7].add(infoPlayer1[5]);
        panel[7].add(infoPlayer1[6]);
        panel[7].add(infoPlayer1[7]);
        panel[7].setLayout(new GridLayout(4,2));

        //ADDING LABELS TO PANEL7
        panel[8].add(infoPlayer2[0]);
        panel[8].add(infoPlayer2[1]);
        panel[8].add(infoPlayer2[2]);
        panel[8].add(infoPlayer2[3]);
        panel[8].add(infoPlayer2[4]);
        panel[8].add(infoPlayer2[5]);
        panel[8].add(infoPlayer2[6]);
        panel[8].add(infoPlayer2[7]);
        panel[8].setLayout(new GridLayout(4,2));

        //añadiendo la barra de vida al panel 2
        panel[2].setLayout(new BorderLayout());
        panel[2].add(progressBar1,BorderLayout.NORTH);
        panel[2].add(panel[7],BorderLayout.SOUTH);//ADDING PANEL7(LABELS INFOR PLAYER1) TO PANEL2
        panel[2].add(imagenPlayer1,BorderLayout.CENTER);


        //añadiendo la barra de vida al panel 3
        panel[3].setLayout(new BorderLayout());
        panel[3].add(progressBar2,BorderLayout.NORTH);
        panel[3].add(panel[8],BorderLayout.SOUTH);//ADDING PANEL8(LABELS INFOR PLAYER2) TO PANEL3
        panel[3].add(imagenPlayer2,BorderLayout.CENTER);

        panel[1].add(panel[2]); //ADDING PANEL2(PLAYER1) ON PANEL1
        panel[1].add(panel[3]); //ADDING PANEL3(PLAYER2) ON PANEL1

        panel[4].add(button[0],BorderLayout.CENTER); //ADDING BUTTON0 ON PANEL4(INF)
        panel[4].add(button[1],BorderLayout.CENTER); //ADDING BUTTON1 ON PANEL4(INF)

        panel[5].add(button[2],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)
        panel[5].add(button[3],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)
        panel[5].add(button[4],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)

        panel[6].add(scrollpane,BorderLayout.CENTER);//ADDING SCROLLPANE ON PANEL6


        backgroundImageFighting.add(panel[0]);
        backgroundImageFighting.add(panel[5]);
        backgroundImageFighting.add(panel[1]);
        backgroundImageFighting.add(panel[4]);
        backgroundImageFighting.add(panel[6]);

        add(backgroundImageFighting);

    }

    public void initComponent() {

        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            panel[i].setOpaque(false);
        }

        //TITTLE FIGHTING
        titleFightLabel = new JLabel("FIGHTING");
        titleFightLabel.setFont(new Font("", Font.BOLD, 36));

        //BUTTONS
        button[0]=new JButton("Fight");
        button[1]=new JButton("Clear Console");
        button[2]=new JButton("Choose Character");
        button[3]=new JButton("Choose Weapon");
        button[4]=new JButton("Ranking");

        //LABELS INFO PLAYER1
        infoPlayer1[0]=new JLabel("Strength");
        infoPlayer1[0].setForeground(new Color(255,255,255));
        infoPlayer1[1]=new JLabel("0");
        infoPlayer1[1].setForeground(new Color(255,255,255));
        infoPlayer1[2]=new JLabel("Defense");
        infoPlayer1[2].setForeground(new Color(255,255,255));
        infoPlayer1[3]=new JLabel("0");
        infoPlayer1[3].setForeground(new Color(255,255,255));
        infoPlayer1[4]=new JLabel("Agility");
        infoPlayer1[4].setForeground(new Color(255,255,255));
        infoPlayer1[5]=new JLabel("0");
        infoPlayer1[5].setForeground(new Color(255,255,255));
        infoPlayer1[6]=new JLabel("Speed");
        infoPlayer1[6].setForeground(new Color(255,255,255));
        infoPlayer1[7]=new JLabel("0");
        infoPlayer1[7].setForeground(new Color(255,255,255));

        //LABELS INFO PLAYER2
        infoPlayer2[0]=new JLabel("Strength");
        infoPlayer2[0].setForeground(new Color(255,255,255));
        infoPlayer2[1]=new JLabel("0");
        infoPlayer2[1].setForeground(new Color(255,255,255));
        infoPlayer2[2]=new JLabel("Defense");
        infoPlayer2[2].setForeground(new Color(255,255,255));
        infoPlayer2[3]=new JLabel("0");
        infoPlayer2[3].setForeground(new Color(255,255,255));
        infoPlayer2[4]=new JLabel("Agility");
        infoPlayer2[4].setForeground(new Color(255,255,255));
        infoPlayer2[5]=new JLabel("0");
        infoPlayer2[5].setForeground(new Color(255,255,255));
        infoPlayer2[6]=new JLabel("Speed");
        infoPlayer2[6].setForeground(new Color(255,255,255));
        infoPlayer2[7]=new JLabel("0");
        infoPlayer2[7].setForeground(new Color(255,255,255));


        //IMAGEN PLAYER1
        image1 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.player.getWarrior_image_path());
        ImageIcon imagen1=new ImageIcon(image1.getImage().getScaledInstance(270,320, Image.SCALE_DEFAULT));
        imagenPlayer1 = new JLabel(imagen1);

        //IMAGEN PLAYER2
        image2 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.enemy.getWarrior_image_path());
        ImageIcon imagen2=new ImageIcon(image2.getImage().getScaledInstance(270,320, Image.SCALE_DEFAULT));
        imagenPlayer2 = new JLabel(imagen2);

    }
    public class buttonFight implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            new Thread(new Hilo()).start();
            button[0].setEnabled(false);
        }

        public class Hilo implements Runnable{
            @Override
            public void run(){
                //esto es lo q deberia poner aqui y lo demas borrarlo para q la barra se disminuya por el daño que le hagan
                //barra.setValue(barra.getValue()-daño);
                //barra.repaint(); //
                for (int i=100; i>=0; i--){//el for no me haria falta, el thread.sleep si quiero ver como baja la barrita si lo pondre
                    progressBar2.setValue(i); //cambia el estado de la barra en i unidades
                    progressBar2.repaint(); //"repinta" el estado de la barra a el actual
                    try{
                        Thread.sleep(50); //relentiza el hilo 50 milisegundos
                    } catch (InterruptedException e){}
                }
            }
        }
    }

    public void reloadScreen () {
        image1 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.player.getWarrior_image_path());
        ImageIcon imagen1 = new ImageIcon(image1.getImage().getScaledInstance(270,320, Image.SCALE_DEFAULT));
        imagenPlayer1.setIcon(imagen1);

        infoPlayer1[1].setText(String.valueOf(Data.player.getStrength() + Data.playerWeapon.getWeapon_strength()));
        infoPlayer1[3].setText(String.valueOf(Data.player.getDefense()));
        infoPlayer1[5].setText(String.valueOf(Data.player.getAgility()));
        infoPlayer1[7].setText(String.valueOf(Data.player.getSpeed() + Data.playerWeapon.getWeapon_speed()));

        image2 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Characters" + File.separator + Data.enemy.getWarrior_image_path());
        ImageIcon imagen2=new ImageIcon(image2.getImage().getScaledInstance(270,320, Image.SCALE_DEFAULT));
        imagenPlayer2.setIcon(imagen2);

        infoPlayer2[1].setText(String.valueOf(Data.enemy.getStrength() + Data.enemyWeapon.getWeapon_strength()));
        infoPlayer2[3].setText(String.valueOf(Data.enemy.getDefense()));
        infoPlayer2[5].setText(String.valueOf(Data.enemy.getAgility()));
        infoPlayer2[7].setText(String.valueOf(Data.enemy.getSpeed() + Data.enemyWeapon.getWeapon_speed()));
    }
}