import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Fighting {

    public static void main(String[] args) {

        new fight();
    }
}
class fight extends JFrame {
    private JPanel panel[] = new JPanel[7];
    private JLabel label[] = new JLabel[13];
    private JLabel titleRankingLabel;
    //private JPanel panelInvisible[] = new JPanel[6];
    private JButton button[]=new JButton[5];
    private BackgroundImageFighting backgroundImageFighting = new BackgroundImageFighting();
    private JTextArea textarea=new JTextArea(5,100);
    private JScrollPane scrollpane;

    public fight() {
        setSize(1280, 720);
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension grandaria = screen.getScreenSize();
        int width = grandaria.width;
        int height = grandaria.height;
        this.setLocation((width / 2) - (this.getWidth() / 2), (height / 2) - (this.getHeight() / 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);
        initComponent();

        //TextArea and ScrolllPane
        textarea.setLineWrap(true);//salto de linea al llegar al final de textarea
        textarea.setBounds(30, 30, 1000, 800);
        scrollpane = new JScrollPane(textarea);
        scrollpane.setBounds(30, 30, 300, 800);

        //TITTLE RANKING
        panel[0].add(titleRankingLabel);
        titleRankingLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel[0].setPreferredSize(new Dimension(1280, 50));
        panel[0].setBorder(BorderFactory.createLineBorder(Color.black));

        //el panel general del medio, lo borro porque no me hace falta
        //panel[2].setLayout(new FlowLayout(FlowLayout.CENTER));//TEXT CENTER
        //panel[2].setPreferredSize(new Dimension(1280, 410));
        //PANEL2 TITTLE NAME
        //panel[2].setBorder(BorderFactory.createLineBorder(Color.black));


        //PLAYER 1
        panel[2].setBorder(BorderFactory.createLineBorder(Color.black));
        //panel[3].setLayout(new FlowLayout(FlowLayout.CENTER));//TEXT CENTER
        panel[2].setPreferredSize(new Dimension(545, 400));

        //PLAYER 2
        panel[3].setBorder(BorderFactory.createLineBorder(Color.black));
        //panel[4].setLayout(new FlowLayout(FlowLayout.CENTER));//TEXT CENTER
        panel[3].setPreferredSize(new Dimension(545, 400));

        //PANEL BUTTON INF
        panel[4].setPreferredSize(new Dimension(1280, 37));
        panel[4].setBorder(BorderFactory.createLineBorder(Color.black));

        //PANEL BUTTON SUP
        panel[5].setPreferredSize(new Dimension(1280, 37));
        panel[5].setBorder(BorderFactory.createLineBorder(Color.black));

        panel[6].setPreferredSize(new Dimension(1280,100));
        panel[6].setBorder(BorderFactory.createLineBorder(Color.black));

        backgroundImageFighting.add(panel[0]); //ADDING TITTLE FIGHTING ON PANEL0

        panel[1].add(panel[2]); //ADDING PANEL2(PLAYER1) ON PANEL1
        panel[1].add(panel[3]); //ADDING PANEL3(PLAYER2) ON PANEL1

        panel[4].add(button[0],BorderLayout.CENTER); //ADDING BUTTON0 ON PANEL4(INF)
        panel[4].add(button[1],BorderLayout.CENTER); //ADDING BUTTON1 ON PANEL4(INF)

        panel[5].add(button[2],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)
        panel[5].add(button[3],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)
        panel[5].add(button[4],BorderLayout.CENTER);//ADDING BUTTON0 ON PANEL5(SUP)

        panel[6].add(scrollpane,BorderLayout.CENTER);//ADDING SCROLLPANE ON PANEL6


        backgroundImageFighting.add(panel[5]);
        backgroundImageFighting.add(panel[1]);
        backgroundImageFighting.add(panel[4]);
        backgroundImageFighting.add(panel[6]);

        this.add(backgroundImageFighting);


        this.setVisible(true);
    }

    public void initComponent() {

        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
        }

        //TITTLE FIGHTING
        titleRankingLabel = new JLabel("FIGHTING");
        titleRankingLabel.setFont(new Font("", Font.BOLD, 36));

        //BUTTONS
        button[0]=new JButton("Fight");
        button[1]=new JButton("Clear Console");
        button[2]=new JButton("Choose Character");
        button[3]=new JButton("Choose Weapon");
        button[4]=new JButton("Ranking");


    }
}