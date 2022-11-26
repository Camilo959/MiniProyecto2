package gui;

import net.Despachador;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Tablero extends Canvas implements KeyListener {

    private Color colorLaberinto = new Color(28,143,24);
    private final int nFilas = 25;
    private final int nColumnas = 25;
    private final int altoB = 30;
    private final int anchoB = 30;
    private int velocidad = 30;

    private int laberinto[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1},
            {1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1},
            {1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1},
            {1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1},
            {1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
            {1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1}
    };

    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;
    public Laberinto lab = new Laberinto(nFilas, nColumnas, altoB, anchoB, laberinto,colorLaberinto);


    public Tablero() { // constructor de la clase tablero
        super();
    
        setSize(750, 777);
        setBackground(new Color(22,90,20));
        // overload mismos metodo en una clase -- overread se repite con distintos parametros

        addKeyListener(this);
    }

    public void paint(Graphics g) { 
        for (Jugador j: jugadores.values()) {
            g.setColor(j.login);
            g.fillOval(j.x, j.y,30,30);
            lab.paint(g);
        }
    }

    /* 
    public void mover(String[] datosJugador) {
        jugadores.get(datosJugador[0]).x = Integer.parseInt(datosJugador[1]);
        jugadores.get(datosJugador[0]).y = Integer.parseInt(datosJugador[2]);
        repaint();
    }

     public void adicionarJugador(String login) {

        Color c = Color.black;
        System.out.println("login: " + login);
        switch (login) {
            case "rojo":
                c = Color.red;
                break;
            case "azul":
                c = Color.blue;
                break;
            case "verde":
                c = Color.green;
                break;
        }
        jugadores.put(login, new Jugador(c,10,10  ));
     }*/

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent e) { // la idea esta en el keycode
        
            int [][] laberinto = lab.obtenerLaberinto();
            int x_ = jugadores.get(jugadorPresente).x;
            int y_ = jugadores.get(jugadorPresente).y;

            if(e.getKeyCode()==37){
                if(laberinto[y_/30][(x_/30)-1]!=1) {
                    jugadores.get(jugadorPresente).x -= velocidad;
                }
            }
            if(e.getKeyCode()==39){
                if(laberinto[y_/30][(x_/30)+1]!=1) {  
                    jugadores.get(jugadorPresente).x += velocidad;
                }
            }
            if(e.getKeyCode()==40) {
                if (laberinto[(y_/30)+1][x_/30]!=1) {
                    jugadores.get(jugadorPresente).y += velocidad;
                }
            }
            if(e.getKeyCode()==38) {
                if(laberinto[(y_/30)-1][x_/30]!=1) {
                    jugadores.get(jugadorPresente).y -= velocidad;
                }
            }
            //repaint();
            /*case KeyEvent.VK_UP:
                jugadores.get(jugadorPresente).y -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                jugadores.get(jugadorPresente).x +=5;
                break;
            case KeyEvent.VK_DOWN:
                jugadores.get(jugadorPresente).y +=5;
                break;
            case KeyEvent.VK_LEFT:
                jugadores.get(jugadorPresente).x -=5;
                break;*/

        int _x = jugadores.get(jugadorPresente).x;
        int _y= jugadores.get(jugadorPresente).y;

        despachador.send("mover:"+jugadorPresente+","+_x + ","+_y);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
