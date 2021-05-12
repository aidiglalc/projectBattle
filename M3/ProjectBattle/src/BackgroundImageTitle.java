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

class BackgroundImageElfSelection extends JPanel {
    private ImageIcon image = new ImageIcon("src/Images/Backgrounds/ElfSelectionBackground.png");

    public BackgroundImageElfSelection() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}

class BorderImageElfSelection extends JPanel {
    private ImageIcon image = new ImageIcon("src/Images/Characters/elf_selection_border.png");

    public BorderImageElfSelection() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}
