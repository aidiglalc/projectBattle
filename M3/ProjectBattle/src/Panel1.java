import javax.swing.*;
import java.awt.*;


//PONER FONDO PANEL
public class Panel1 extends JPanel {
    ImageIcon image = new ImageIcon("src/Images/TitleBackground.jpg");

    public Panel1() {

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}
