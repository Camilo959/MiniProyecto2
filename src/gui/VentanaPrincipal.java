package gui;

import net.Despachador;
import net.Cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;

public class VentanaPrincipal extends JFrame { //hereda las propiedades de la clase padre (JFrame)

    Container panel;  //contenedor de la ventana, un atributo de la ventana
    public Tablero lienzo; // se vuelve global a la clase
    public Despachador despachador;

    public VentanaPrincipal() { //metodo constructor de la clase
        super("Nivel 1");
        setSize(750, 777);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(300,0);
        setResizable(false);

        panel = getContentPane();
        panel.setLayout((new FlowLayout()));  //contiene los objetos de forma ordenada

        lienzo = new Tablero();
        panel.add(lienzo);

        Cliente c = new Cliente();
        c.conectar(this, lienzo); // Se conecta al servidor

        conectar(); // Conecta el usuario con el juego

    }

    public void conectar() {
        String color = JOptionPane.showInputDialog(this,"Color: ");
        despachador.send("login:"+color);
        lienzo.jugadorPresente = color;

    }
}
