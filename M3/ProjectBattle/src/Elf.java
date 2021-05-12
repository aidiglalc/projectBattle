package projectBattle;

import javax.swing.*;
import java.awt.*;

public class Elf {
    public static void main(String[] args)
    {new Marco2();}
}

class Marco2 extends JFrame {
    JPanel panel[] = new JPanel[4];
    JPanel panelInvisible[] = new JPanel[15];
    JLabel label[] = new JLabel[19];
    JButton boton[] = new JButton[3];


    public Marco2() {

        this.setTitle("AWSttle"); //titulo

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        Toolkit pantalla = Toolkit.getDefaultToolkit();

        //AIDA
        Image image1 = pantalla.getImage("Elf_1.JPG");
        this.setIconImage(image1);

        //MARTÍ
        Image image2 = pantalla.getImage("Elf_2.JPG");
        this.setIconImage(image2);

        //SANDRA
        Image image3 = pantalla.getImage("Elf_3.JPG");
        this.setIconImage(image3);


        this.setDefaultLookAndFeelDecorated(true);


        Dimension grandaria = pantalla.getScreenSize();
        int anchura = grandaria.width; //WIDTH
        int altura = grandaria.height; //HEIGHT
        setSize(1280, 720);
        setLocation(pantalla.getScreenSize().width / 2 - getWidth() / 2, pantalla.getScreenSize().height / 2 - getHeight() / 2);


        this.setResizable(false); //No permitir que la ventana se redimensione


        //INIT COMPONENT
        initComponent();

        //MAIN PANELS POSITION
        panel[0].setLayout(new BoxLayout(panel[0], BoxLayout.Y_AXIS)); //AIDA
        panel[1].setLayout(new BoxLayout(panel[1], BoxLayout.Y_AXIS)); //MARTÍ
        panel[2].setLayout(new BoxLayout(panel[2], BoxLayout.Y_AXIS)); //SANDRA

        //PANEL 0 AIDA
        panel[0].add(boton[0]); //PHOTO

        panel[0].add(panelInvisible[6]); //AUX PANEL (PHOTO-NAME)

        panel[0].add(label[0]); //NAME
        panel[0].add(label[9]); //TEXT

        panel[0].add(panelInvisible[7]); //AUX PANEL (NAME-STATS)

        panel[0].add(label[1]); //STATS
        panel[0].add(label[10]); //TEXT

        panel[0].add(panelInvisible[8]); //AUX PANEL (STATS-LORE)

        panel[0].add(label[2]); //LORE
        panel[0].add(label[11]); //TEXT


        //PANEL 1 MARTÍ
        panel[1].add(boton[1]); //PHOTO

        panel[1].add(panelInvisible[9]); //AUX PANEL (PHOTO-NAME)

        panel[1].add(label[3]); //NAME
        panel[1].add(label[12]); //TEXT

        panel[1].add(panelInvisible[10]); //AUX PANEL (NAME-STATS)

        panel[1].add(label[4]); //STATS
        panel[1].add(label[13]); //TEXT

        panel[1].add(panelInvisible[11]); //AUX PANEL (STATS-LORE)

        panel[1].add(label[5]); //LORE
        panel[1].add(label[14]); //TEXT


        //PANEL 2 SANDRA
        panel[2].add(boton[2]); //PHOTO

        panel[2].add(panelInvisible[12]); //AUX PANEL (PHOTO-NAME)

        panel[2].add(label[6]); //NAME
        panel[2].add(label[15]); //TEXT

        panel[2].add(panelInvisible[13]); //AUX PANEL (NAME-STATS)

        panel[2].add(label[7]); //STATS
        panel[2].add(label[16]); //TEXT

        panel[2].add(panelInvisible[14]); //AUX PANEL (STATS-LORE)

        panel[2].add(label[8]); //LORE
        panel[2].add(label[17]); //TEXT


        //PANEL AUX SUP
        panelInvisible[0].setPreferredSize(new Dimension(50, 100));

        //PANEL AUX INF
        panelInvisible[1].setPreferredSize(new Dimension(50, 100));

        //PANEL AUX LEFT
        panelInvisible[2].setPreferredSize(new Dimension(50, 0));

        //PANEL AUX RIGHT
        panelInvisible[3].setPreferredSize(new Dimension(50, 0));

        //PANEL AUX CENTR LEFT
        panelInvisible[4].setPreferredSize(new Dimension(150, 0));

        //PANEL AUX CENTR RIGHT
        panelInvisible[5].setPreferredSize(new Dimension(150, 0));

        //PANEL AUX AIDA (PHOTO-NAME)
        panelInvisible[6].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX AIDA (NAME-STATS)
        panelInvisible[7].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX AIDA (STATS-LORE)
        panelInvisible[8].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX MARTÍ (PHOTO-NAME)
        panelInvisible[9].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX MARTÍ (NAME-STATS)
        panelInvisible[10].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX MARTÍ (STATS-LORE)
        panelInvisible[11].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX SANDRA (PHOTO-NAME)
        panelInvisible[12].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX SANDRA (NAME-STATS)
        panelInvisible[13].setPreferredSize(new Dimension(50, 20));

        //PANEL AUX SANDRA (STATS-LORE)
        panelInvisible[14].setPreferredSize(new Dimension(50, 20));


        //ADD PANEL
        this.add(panel[0],BorderLayout.WEST); //AIDA
        this.add(panelInvisible[4],BorderLayout.NORTH); //AUX CENTR LEFT
        this.add(panel[1],BorderLayout.CENTER); //MARTÍ
        this.add(panelInvisible[5],BorderLayout.WEST); //AUX CENTR RIGHT
        this.add(panel[2],BorderLayout.EAST); //SANDRA

        this.add(panelInvisible[0],BorderLayout.NORTH); //SUP
        this.add(panelInvisible[1], BorderLayout.SOUTH); //INF
        this.add(panelInvisible[2],BorderLayout.WEST); //LEFT
        this.add(panelInvisible[3],BorderLayout.EAST); //RIGHT


        //PANEL POSITION (AIDA, MARTÍ, SANDRA)
        panel[3].add(panel[0]); //AIDA
        panel[3].add(panelInvisible[4]); //AUX CENTR LEFT
        panel[3].add(panel[1]); //MARTÍ
        panel[3].add(panelInvisible[5]); //AUX CENTR RIGHT
        panel[3].add(panel[2]); //SANDRA

        this.add(panel[3],BorderLayout.CENTER);

        setVisible(true);
    }
    public void initComponent() {


        for(int i = 0 ; i < panel.length ; i++){
            panel[i] = new JPanel();
        }

        for(int i = 0 ; i < panelInvisible.length ; i++){
            panelInvisible[i] = new JPanel();
        }

        //AIDA
        ImageIcon imageIcon1 = new ImageIcon("Elf_1.JPG");
        ImageIcon image1 = new ImageIcon(imageIcon1.getImage().getScaledInstance(200,250, Image.SCALE_DEFAULT));
        boton[0] = new JButton(image1);

        boton[0].setMinimumSize(new Dimension(20,20));
        boton[0].setMaximumSize(new Dimension(210,260));
        boton[0].setPreferredSize(new Dimension(210,260));


        boton[0].setBackground(new java.awt.Color(189,236,182)); //BOTTON COLOR

        label[0] = new JLabel("NAME");
        label[0].setFont(new Font("comic sans ms", Font.PLAIN, 20));
        label[0].setHorizontalAlignment(JLabel.CENTER); //Centrar texto

        label[9] = new JLabel("EJEMPLO");
        label[9].setSize(40,40);

        label[1] = new JLabel("STATS");
        label[1].setFont(new Font("Arial", Font.PLAIN, 20));

        label[10] = new JLabel("EJEMPLO");

        label[2] = new JLabel("LORE");
        label[2].setFont(new Font("calibri", Font.PLAIN, 20));

        label[11] = new JLabel("EJEMPLO");



        //MARTÍ
        ImageIcon imageIcon2 = new ImageIcon("Elf_2.JPG");
        ImageIcon image2 = new ImageIcon(imageIcon2.getImage().getScaledInstance(200,250, Image.SCALE_DEFAULT));
        boton[1] = new JButton(image2);

        boton[1].setMinimumSize(new Dimension(20,20));
        boton[1].setMaximumSize(new Dimension(210,260));
        boton[1].setPreferredSize(new Dimension(210,260));

        boton[1].setBackground(new java.awt.Color(189,236,182)); //BOTTON COLOR

        label[3] = new JLabel("NAME");
        label[3].setFont(new Font("Arial", Font.PLAIN, 20));
        label[3].setHorizontalAlignment(JLabel.CENTER); //Centrar texto

        label[12] = new JLabel("EJEMPLO");

        label[4] = new JLabel("STATS");
        label[4].setFont(new Font("Arial", Font.PLAIN, 20));

        label[13] = new JLabel("EJEMPLO");

        label[5] = new JLabel("LORE");
        label[5].setFont(new Font("Arial", Font.PLAIN, 20));

        label[14] = new JLabel("EJEMPLO");


        //SANDRA
        ImageIcon imageIcon3 = new ImageIcon("Elf_3.JPG");
        ImageIcon image3 = new ImageIcon(imageIcon3.getImage().getScaledInstance(200,250, Image.SCALE_DEFAULT));
        boton[2] = new JButton(image3);

        boton[2].setMinimumSize(new Dimension(20,20));
        boton[2].setMaximumSize(new Dimension(210,260));
        boton[2].setPreferredSize(new Dimension(210,260));

        boton[2].setBackground(new java.awt.Color(189,236,182)); //BOTTON COLOR

        label[6] = new JLabel("NAME");
        label[6].setFont(new Font("Arial", Font.PLAIN, 20));
        label[6].setHorizontalAlignment(JLabel.CENTER); //Centrar texto

        label[15] = new JLabel("EJEMPLO");

        label[7] = new JLabel("STATS");
        label[7].setFont(new Font("Arial", Font.PLAIN, 20));

        label[16] = new JLabel("EJEMPLO");

        label[8] = new JLabel("LORE");
        label[8].setFont(new Font("Arial", Font.PLAIN, 20));

        label[17] = new JLabel("EJEMPLO");

    }
}