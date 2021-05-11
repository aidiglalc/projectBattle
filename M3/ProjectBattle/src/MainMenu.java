import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    BackgroundImageTitle backgroundImageTitle = new BackgroundImageTitle();
    JButton jButtons[] = new JButton[4];
    JPanel jPanels[] = new JPanel[4];
    JPanel jPanelsInvisible[] = new JPanel[5];
    JLabel jLabel;

    public MainMenu(){
        //INIT COMPONENT
        initComponent();

        setSize(1280, 720);
        this.setTitle("AWSttle"); //titulo

        Toolkit pantalla = Toolkit.getDefaultToolkit();
        setLocation(pantalla.getScreenSize().width/2 - getWidth()/2,pantalla.getScreenSize().height/2 - getHeight()/2);




        jPanels[0].add(jLabel);
        jPanels[1].add(jButtons[0]);
        jPanels[2].add(jButtons[1]);
        jPanels[2].add(jPanelsInvisible[4]);
        jPanels[2].add(jButtons[2]);
        jPanels[3].add(jButtons[3]);

        backgroundImageTitle.add(jPanelsInvisible[0]);
        backgroundImageTitle.add(jPanels[0]);
        backgroundImageTitle.add(jPanelsInvisible[1]);
        backgroundImageTitle.add(jPanels[1]);
        backgroundImageTitle.add(jPanelsInvisible[2]);
        backgroundImageTitle.add(jPanels[2]);
        backgroundImageTitle.add(jPanelsInvisible[3]);
        backgroundImageTitle.add(jPanels[3]);

        add(backgroundImageTitle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Si cierra la ventana, finaliza el programa
        setResizable(false); //No permitir que la ventana se redimensione
        setVisible(true); //hacer visible (debe ir siempre el ultimo)
    }

    public void initComponent() {
        //PANEL 1
        jLabel = new JLabel("Awsttle");

        //CAMBIAR FUENTE Y TAMAÑO LABEL[0]
        jLabel.setFont(new Font("comic sans ms", Font.BOLD, 50));

        //BOTONES
        jButtons[0] = new JButton("¡FIGHT!");
        jButtons[1] = new JButton("Choose Fighter");
        jButtons[2] = new JButton("Choose Weapon");
        jButtons[3] = new JButton("Ranking");

        jButtons[0].setPreferredSize(new Dimension(240, 50));
        jButtons[1].setPreferredSize(new Dimension(240, 50));
        jButtons[2].setPreferredSize(new Dimension(240, 50));
        jButtons[3].setPreferredSize(new Dimension(240, 50));

        //COLOR BOTONES
        for (int i = 0; i< jButtons.length; i++) {
            jButtons[i].setBackground(new java.awt.Color(253, 253, 150));
        }

        //CAMBIAR FUENTE Y TAMAÑO BOTONES
        jButtons[0].setFont(new Font("Helvetica", Font.PLAIN, 20));
        jButtons[1].setFont(new Font("Arial", Font.PLAIN, 20));
        jButtons[2].setFont(new Font("Action Man Extended", Font.PLAIN, 20));
        jButtons[3].setFont(new Font("Action Man Shaded", Font.PLAIN, 20));

        //INICIAR JPANEL

        for (int i = 0; i< jPanels.length; i++){
            jPanels[i] = new JPanel();
        }

        for (int i = 0; i< jPanelsInvisible.length; i++){
            jPanelsInvisible[i] = new JPanel();
        }

        jPanels[1].setPreferredSize(new Dimension(1280, 60));
        jPanels[2].setPreferredSize(new Dimension(1280, 60));
        jPanels[3].setPreferredSize(new Dimension(1280, 60));

        jPanelsInvisible[0].setPreferredSize(new Dimension(1280, 60));
        jPanelsInvisible[1].setPreferredSize(new Dimension(1280, 140));
        jPanelsInvisible[2].setPreferredSize(new Dimension(1280, 20));
        jPanelsInvisible[3].setPreferredSize(new Dimension(1280, 20));
        jPanelsInvisible[4].setPreferredSize(new Dimension(160, 50));

        // jPanels[0].setOpaque(false);
        jPanels[1].setOpaque(false);
        jPanels[2].setOpaque(false);
        jPanels[3].setOpaque(false);
        jPanelsInvisible[0].setOpaque(false);
        jPanelsInvisible[1].setOpaque(false);
        jPanelsInvisible[2].setOpaque(false);
        jPanelsInvisible[3].setOpaque(false);
        jPanelsInvisible[4].setOpaque(false);
    }
}


