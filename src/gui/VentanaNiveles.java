package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaNiveles extends JFrame {
    private JButton btnNivel1;
    private static VentanaNivel1 nivel1;
    private Fondo fondo;

    public VentanaNiveles() {
        super("Niveles");
        configVentana();
        iniciarLabelsNiveles();
        iniciarBotonesNiveles();
        iniciarNiveles();
    }

    private void configVentana(){
        fondo = new Fondo();
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(fondo);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
    }

    private void iniciarLabelsNiveles() {
        JLabel mensajeJugador = new JLabel("Bienvenid@ " + VentanaPrincipal.jugadorLab); // Aqui nombre del jugador
        mensajeJugador.setOpaque(true);
        mensajeJugador.setBounds(25, 17, 350, 40);
        mensajeJugador.setFont(new Font("Arial Black", 0, 22));
        mensajeJugador.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeJugador.setBackground(new Color(255,255,255,0));
        this.add(mensajeJugador);

        JLabel L_titulo = new JLabel("Seleccione el nivel");
        L_titulo.setOpaque(true);
        L_titulo.setBounds(25, 57, 350, 40);
        L_titulo.setFont(new Font("Arial Black", 1, 22));
        L_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        L_titulo.setBackground(new Color(255,255,255,0));
        this.add(L_titulo);

        JLabel L_nivel1 = new JLabel("Nivel 1");
        L_nivel1.setOpaque(true);
        L_nivel1.setBounds(97, 265, 50, 25);
        L_nivel1.setFont(new Font("Arial Black", 1, 15));
        L_nivel1.setHorizontalAlignment(SwingConstants.CENTER);
        L_nivel1.setBackground(new Color(255,255,255,0));
        //panel3.add(L_nivel1);
    }

    private void iniciarBotonesNiveles() {
        btnNivel1 = new JButton();
        btnNivel1.setBounds(100, 140, 200, 150);
        ImageIcon imagen = new ImageIcon("src/gui/img/nivel.png");
        btnNivel1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNivel1.getWidth(), btnNivel1.getHeight(), Image.SCALE_SMOOTH)));
        btnNivel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnNivel1);
    }

    private void iniciarNiveles() {
        btnNivel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nivel1 = new VentanaNivel1();
                nivel1.setVisible(true);
            }
        });
    }

    public static void finNIvel1(){
        nivel1.setVisible(false);
    }
}
