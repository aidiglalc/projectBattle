import javax.swing.*;
import java.awt.*;
import java.io.File;

// Contains all the Jpanels with the background for each scene that we have in the game

public class BackgroundImage extends JPanel {
    private ImageIcon image;

    public BackgroundImage(int width, int height, String background) {
        image = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
                File.separator + "Backgrounds" + File.separator + background);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}