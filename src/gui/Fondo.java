package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Fondo extends JPanel{
    private ImageIcon imgFondo;
    @Override
    public void paint(Graphics g){
        Dimension tamano = getSize();
        imgFondo = new ImageIcon((Objects.requireNonNull(getClass().getResource("fondo5.png"))));
        g.drawImage(imgFondo.getImage(),0,0,tamano.width,tamano.height,null);
        setOpaque(false);
        super.paint(g);
    }
}
