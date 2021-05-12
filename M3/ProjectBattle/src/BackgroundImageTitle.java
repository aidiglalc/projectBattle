import javax.swing.*;
import java.awt.*;

public class BackgroundImageTitle extends JPanel {
    private ImageIcon image = new ImageIcon("src/Images/Backgrounds/TitleBackground.jpg");

    public BackgroundImageTitle() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}

class BackgroundImageCharacterSelection extends JPanel {
    private ImageIcon image = new ImageIcon("src/Images/Backgrounds/CharacterSelectionBackground.jpg");

    public BackgroundImageCharacterSelection() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}