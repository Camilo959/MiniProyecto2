package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    public static String jugadorLab;
    private JLabel L_laberinto;
    private JLabel L_creators;
    private JLabel L_color;
    public JButton btnIniciar;
    private JButton btnSalir;
    private JTextField TFnombre;
    public static String colorBola;
    public JComboBox<String> listaColores;


   Fondo fondo = new Fondo();

    public VentanaPrincipal() {
        super("Menú Principal");
        configVentana();
        iniciarLabels();
        iniciarBotones();
        iniciarTextFields();
        iniciarVentana2();
        iniciarColor();
    }

    public void configVentana(){
        this.setSize(380, 380);
        this.setLocationRelativeTo(null);
        this.setContentPane(fondo);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void iniciarLabels() {
        L_laberinto = new JLabel("Laberinto");
        L_laberinto.setOpaque(true);
        L_laberinto.setBounds(95, 30, 200, 40);
        L_laberinto.setFont(new Font("Arial", 1, 30));
        L_laberinto.setHorizontalAlignment(SwingConstants.CENTER);
        L_laberinto.setBackground(new Color(255,255,255,0));
        //L_laberinto.setForeground(Color.white);
        this.add(L_laberinto);

        L_creators = new JLabel("By: Los tocayos & Dylan");
        L_creators.setOpaque(true);
        L_creators.setBounds(205, 325, 200, 30);
        L_creators.setFont(new Font("Bolina", 0, 12));
        L_creators.setHorizontalAlignment(SwingConstants.CENTER);
        L_creators.setBackground(new Color(255,255,255,0));
        //L_creators.setForeground(Color.white);
        this.add(L_creators);


        L_color= new JLabel("Color :");
        L_color.setOpaque(true);
        L_color.setBounds(104, 162, 60, 25);
        L_color.setFont(new Font("Arial", 0, 15));
        L_color.setHorizontalAlignment(SwingConstants.CENTER);
        L_color.setBackground(new Color(255,255,255,0));
        this.add(L_color);
    }

    //Crear Botones
    public void iniciarBotones() {
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setOpaque(true);
        btnIniciar.setBounds(130, 220, 110, 35);
        btnIniciar.setFont(new Font("Arial", 0, 20));
        btnIniciar.setHorizontalAlignment(SwingConstants.CENTER);
        btnIniciar.setBackground(new Color(255,255,255));
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnIniciar);

        btnSalir = new JButton("Salir");
        btnSalir.setOpaque(true);
        btnSalir.setBounds(130, 280, 110, 35);
        btnSalir.setFont(new Font("Arial", 0, 20));
        btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
        btnSalir.setBackground(new Color(255, 255, 255));
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnSalir);
    }

    //Crear caja de texto
    public void iniciarTextFields() {

        TFnombre = new JTextField(10);
        TFnombre.setBounds(120, 105, 150, 35);
        TextPrompt placeholder = new TextPrompt("Ingrese su sombre",TFnombre);
        placeholder.setFont(new Font("Arial",2,13));
        this.add(TFnombre);

    }

    public void iniciarColor(){
        String[] colores = {"Normal","Negro","Naranja","Morado","Verde","Marrón","Gris","Azul","Rojo","Blanco","Rosa"};
        listaColores = new JComboBox<>(colores);
        listaColores.setBounds(160,160,120,30);
        listaColores.setCursor(new Cursor(Cursor.HAND_CURSOR));
        listaColores.setBackground(new Color(255,255,255));
        this.add(listaColores);
    }

    public void iniciarVentana2() {
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorBola = (String)listaColores.getSelectedItem();
                jugadorLab = TFnombre.getText();
                if(jugadorLab.length() == 0){
                    jugadorLab = "User";
                }
                JOptionPane.showMessageDialog(VentanaPrincipal.this, "Hola " + jugadorLab);
                VentanaNiveles ventanas = new VentanaNiveles();
                ventanas.setVisible(true);
            }
        });
    }
}
