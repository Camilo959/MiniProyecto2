package gui;

import javax.swing.*;
import java.awt.*;

public class Fondo extends JPanel {
    private ImageIcon imgFondo;
    @Override
    public void paint(Graphics g) {
        Dimension tamano = getSize();
        imgFondo = new ImageIcon(((getClass().getResource("img/fondo.png"))));
        g.drawImage(imgFondo.getImage(),0,0,tamano.width,tamano.height,null);
        setOpaque(false);
        super.paint(g);
    }
}
