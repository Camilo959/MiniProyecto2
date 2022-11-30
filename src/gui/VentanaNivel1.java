package gui;

import net.Despachador;
import net.Cliente;
import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;

import static gui.VentanaPrincipal.colorBola;

public class VentanaNivel1 extends JFrame {

    private Container panel;
    public Tablero lienzo;
    public Despachador despachador;
   
    public VentanaNivel1() {
        super("Nivel 1");
        setSize(1200, 783);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        lienzo = new Tablero();
        panel.add(lienzo);

        Cliente c = new Cliente();
        c.conectar(this, lienzo);

        conectar();
    }



    public void conectar() {
        System.out.println(colorBola);
        despachador.send("login:"+colorBola);
        lienzo.jugadorPresente = colorBola;
    }
}