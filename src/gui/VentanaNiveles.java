package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNiveles extends JFrame {
    
    private Container panel3;
    private JButton btnNivel1;
    private static VentanaNivel1 nivel1;

    public VentanaNiveles() {
        super("Niveles");
        setSize(450, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel3 = getContentPane();
        panel3.setBackground(Color.white);
        panel3.setLayout(null);

        iniciarLabelsNiveles();
        iniciarBotonesNiveles();
        iniciarNiveles();
    }

    private void iniciarLabelsNiveles() {
        JLabel mensajeJugador = new JLabel("Bienvenid@ " + VentanaPrincipal.jugadorLab); // Aqui nombre del jugador
        mensajeJugador.setOpaque(true);
        mensajeJugador.setBounds(25, 17, 400, 40);
        mensajeJugador.setFont(new Font("Arial", 3, 22));
        mensajeJugador.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeJugador.setBackground(Color.white);
        panel3.add(mensajeJugador);

        JLabel L_titulo = new JLabel("Seleccione un nivel");
        L_titulo.setOpaque(true);
        L_titulo.setBounds(55, 57, 350, 40);
        L_titulo.setFont(new Font("Arial", 1, 22));
        L_titulo.setHorizontalAlignment(SwingConstants.CENTER);
        L_titulo.setBackground(Color.white);
        panel3.add(L_titulo);

        JLabel L_nivel1 = new JLabel("Nivel 1");
        L_nivel1.setOpaque(true);
        L_nivel1.setBounds(97, 265, 50, 25);
        L_nivel1.setFont(new Font("Arial", 1, 15));
        L_nivel1.setHorizontalAlignment(SwingConstants.CENTER);
        L_nivel1.setBackground(Color.white);
        panel3.add(L_nivel1);

    }

    private void iniciarBotonesNiveles() {
        btnNivel1 = new JButton();
        btnNivel1.setBounds(60, 140, 120, 120);
        ImageIcon imagen = new ImageIcon("src/img/img2.png");
        btnNivel1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(btnNivel1.getWidth(), btnNivel1.getHeight(), Image.SCALE_SMOOTH)));
        btnNivel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel3.add(btnNivel1);
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
