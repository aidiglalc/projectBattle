import javax.swing.*;
import java.awt.*;

public class BackgroundImageTitle extends JPanel {
    ImageIcon image = new ImageIcon("src/Images/TitleBackground.jpg");

    public BackgroundImageTitle() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}
