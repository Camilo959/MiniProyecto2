package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {
    public static VentanaPrincipal ventana = new VentanaPrincipal();
    public static String jugadorLab;
    private JLabel L_laberinto;
    private JLabel L_creators;
    private JLabel L_color;
    public JButton btnIniciar;
    private JButton btnSalir;
    private JTextField TFnombre;
    public static String colorBola;
    public JComboBox<String> listaColores;
    private Fondo fondo;

    public VentanaPrincipal() {
        super("Menú Principal");
        configVentana();
        iniciarLabels();
        iniciarBotones();
        iniciarTextFields();
        iniciarVentana2();
        iniciarColor();
        cerrarJuego();
    }

    public void configVentana(){
        fondo = new Fondo();
        this.setContentPane(fondo);
        this.setSize(350, 380);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciarLabels() {
        L_laberinto = new JLabel("Laberinto");
        L_laberinto.setOpaque(true);
        L_laberinto.setBounds(80, 30, 200, 40);
        L_laberinto.setFont(new Font("Arial Black", 1, 30));
        L_laberinto.setHorizontalAlignment(SwingConstants.CENTER);
        L_laberinto.setBackground(new Color(255,255,255,0));
        //L_laberinto.setForeground(Color.white);
        this.add(L_laberinto);

        L_creators = new JLabel("By: Los tocayos & Dylan");
        L_creators.setOpaque(true);
        L_creators.setBounds(182, 325, 200, 30);
        L_creators.setFont(new Font("Arial", 0, 11));
        L_creators.setHorizontalAlignment(SwingConstants.CENTER);
        L_creators.setBackground(new Color(255,255,255,0));
        //L_creators.setForeground(Color.white);
        this.add(L_creators);

        L_color= new JLabel("Color :");
        L_color.setOpaque(true);
        L_color.setBounds(93, 162, 60, 25);
        L_color.setFont(new Font("Arial Black", 0, 15));
        L_color.setHorizontalAlignment(SwingConstants.CENTER);
        L_color.setBackground(new Color(255,255,255,0));
        this.add(L_color);
    }

    //Crear Botones
    public void iniciarBotones() {
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setOpaque(true);
        btnIniciar.setBounds(125, 220, 110, 35);
        btnIniciar.setFont(new Font("Arial Black", 0, 20));
        btnIniciar.setHorizontalAlignment(SwingConstants.CENTER);
        btnIniciar.setBackground(new Color(240,240,240));
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnIniciar);

        btnSalir = new JButton("Salir");
        btnSalir.setOpaque(true);
        btnSalir.setBounds(125, 280, 110, 35);
        btnSalir.setFont(new Font("Arial Black", 0, 20));
        btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
        btnSalir.setBackground(new Color(240, 240, 240));
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnSalir);
    }

    //Crear caja de texto
    public void iniciarTextFields() {
        TFnombre = new JTextField(10);
        TFnombre.setBounds(105, 105, 150, 35);
        TextPrompt placeholder = new TextPrompt("Ingrese su sombre",TFnombre);
        placeholder.setFont(new Font("Arial",2,13));
        placeholder.setForeground(Color.lightGray);
        this.add(TFnombre);
    }

    //Selección de color
    public void iniciarColor(){
        String[] colores = {"Blanco","Azul","Morado","Verde","Rojo","Rosa","Aguamarina","Amarillo","Verde Amarilloso","Café"};
        listaColores = new JComboBox<>(colores);
        listaColores.setBounds(155,162,120,30);
        listaColores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listaColores.setBackground(new Color(255,255,255));
        listaColores.setFont(new Font("Arial",0,13));
        this.add(listaColores);
    }

    //iniciar la segunda ventana
    public void iniciarVentana2() {
        btnIniciar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(false);
                colorBola = (String)listaColores.getSelectedItem();
                jugadorLab = TFnombre.getText();
                if(jugadorLab.length() == 0){
                    jugadorLab = "User";
                }
                VentanaNiveles ventanas = new VentanaNiveles();
                ventanas.setVisible(true);
            }
        });
    }
    
    //cerrar el juego
    public void cerrarJuego(){
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "¡Gracias por jugar! :)");
                System.exit(0);
            }
        });
    }
}
