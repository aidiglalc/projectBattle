import javax.swing.*;
import java.awt.*;
import java.io.File;

// Contains all the Jpanels with the background for each scene that we have in the game

public class BackgroundImageTitle extends JPanel {
    private ImageIcon image = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
            File.separator + "Backgrounds" + File.separator + "TitleBackground.jpg");

    public BackgroundImageTitle() {
        setPreferredSize(new Dimension(1280, 720));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}

class BackgroundImageCharacterSelection extends JPanel {
    private ImageIcon image = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
            File.separator + "Backgrounds" + File.separator + "CharacterSelectionBackground.jpg");

    public BackgroundImageCharacterSelection() {
        setPreferredSize(new Dimension(1280, 720));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}

class BackgroundImageElfSelection extends JPanel {
    private ImageIcon image = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
            File.separator + "Backgrounds" + File.separator + "ElfSelectionBackground.png");

    public BackgroundImageElfSelection() {
        setPreferredSize(new Dimension(1280, 720));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}

class BorderImageElfSelection extends JPanel {
    private ImageIcon image = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + File.separator + "Images" +
            File.separator + "Characters" + File.separator + "elf_selection_border.png");

    public BorderImageElfSelection() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fondo = (Graphics2D) g;
        fondo.drawImage(image.getImage(),0,0,this);
    }
}
