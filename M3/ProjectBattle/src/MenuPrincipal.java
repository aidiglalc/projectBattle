import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    public static void main(String[] args) {
        new Marco();
    }
}

class Marco extends JFrame {
    JButton botones[] = new JButton[5];
    JPanel panel1, panel2;
    JLabel label[] = new JLabel[2];

    public Marco(){
        Panel1 panel1 = new Panel1();

        JPanel panel2 = new JPanel();


        this.setTitle("AWSttle"); //titulo

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        this.setDefaultLookAndFeelDecorated(true);

        Dimension grandaria = pantalla.getScreenSize();
        int anchura = grandaria.width; //Saber anchura
        int altura = grandaria.height; //Saber altura
//        setBounds((anchura / 2) - (this.getWidth() / 2),  (altura / 2) - (this.getHeight() / 2),1280, 720); //posición y tamaño
        setSize(1280, 720);
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);


        this.setResizable(false); //No permitir que la ventana se redimensione



        //INIT COMPONENT
        initComponent();

        //PANEL 1
        this.add(panel2,BorderLayout.NORTH);
        panel2.add(label[0]);

        panel1.setLayout(null);
        this.add(panel1,BorderLayout.CENTER);

        panel1.setSize(1280,720);

        botones[0].setBounds(64, ((panel1.getHeight() / 2) - 50),240, 50);
        botones[1].setBounds(368, ((panel1.getHeight() / 2) - 50),240, 50);
        botones[2].setBounds(672, ((panel1.getHeight() / 2) - 50),240, 50);
        botones[3].setBounds(976, ((panel1.getHeight() / 2) - 50),240, 50);
        System.out.println(panel1.getWidth()/8);
        System.out.println((panel1.getWidth()/8)*3);



        panel1.add(botones[0]);
        panel1.add(botones[1]);
        panel1.add(botones[2]);
        panel1.add(botones[3]);


        this.setVisible(true); //hacer visible (debe ir siempre el ultimo)
    }

    public void initComponent() {
        //PANEL 1
        label[0] = new JLabel("Awsttle");

        //CAMBIAR FUENTE Y TAMAÑO LABEL[0]
        label[0].setFont(new Font("Serif", Font.PLAIN, 50));


        //BOTONES
        botones[0] = new JButton("Chose Fighter");
        botones[1] = new JButton("Chose Weapon");
        botones[2] = new JButton("Ranking");
        botones[3] = new JButton("¡FIGHT!");

        //COLOR BOTONES
        botones[0].setBackground(new java.awt.Color(253,253,150));
        botones[1].setBackground(new java.awt.Color(253,253,150));
        botones[2].setBackground(new java.awt.Color(253,253,150));
        botones[3].setBackground(new java.awt.Color(253,253,150));

        //CAMBIAR FUENTE Y TAMAÑO BOTONES
        botones[0].setFont(new Font("Comic SANS", Font.PLAIN, 20));
        botones[1].setFont(new Font("Arial", Font.PLAIN, 20));
        botones[2].setFont(new Font("Action Man Extended", Font.PLAIN, 20));
        botones[3].setFont(new Font("Action Man Shaded", Font.PLAIN, 20));

    }
}


