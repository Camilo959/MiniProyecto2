package net;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import gui.Jugador;
import gui.VentanaNivel1;

public class Despachador extends Thread{
    private PrintWriter out;
    private BufferedReader in;
    public VentanaNivel1 gui = null;
    public ArrayList<Despachador> escritores = new ArrayList<>();
    public HashMap<String, Jugador> jugadores = new HashMap<>();

    public Despachador(Socket socket, String tipo) {
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            this.out = new PrintWriter(socket.getOutputStream(),true);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void run() {
        try {
            leer();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void leer() throws IOException { // lee socket e imprime en pantalla
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibido: " + inputLine);

            if (gui != null) { // Cliente
                String [] datosJugadores = inputLine.split("#");

                for (String jugador: datosJugadores) {
                    System.out.println("leyendo jugador: " + jugador);
                    String[] data = jugador.split(",");
                    Color c = Color.black;

                    switch (data[0]) {
                        case "Blanco" :  c = new Color(255,255,255); break;
                        case "Azul"   :  c = new Color(0,229,232);break;
                        case "Morado" :  c = new Color(197,1,226);break;
                        case "Verde"  :  c = new Color(28, 241, 6, 255);break;
                        case "Rojo"   :  c = new Color(255,5,52);break;
                        case "Rosa"   :  c = new Color(239, 39, 222, 255);break;
                        case "Aguamarina" :  c = new Color(128, 255, 219);break;
                        case "Amarillo"   :  c = new Color(240, 246, 0);break;
                        case "Verde Amarilloso"   :  c = new Color(175, 252, 65);break;
                        case "Café"   :  c = new Color(81, 60, 44);break;
                    }

                    gui.lienzo.jugadores.put(data[0] , new Jugador(data[0], c, Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                }
                gui.lienzo.repaint();
            }

            if (gui == null) { // Servidor
                String[] datos = inputLine.split(":");

                if (datos[0].equals("login")) {
                    Color c = Color.black;
                    switch (datos[1]) {
                        case "Blanco" :  c = new Color(255,255,255);break;
                        case "Azul"   :  c = new Color(0,229,232);break;
                        case "Morado" :  c = new Color(126, 32, 92);break;
                        case "Verde"  :  c = new Color(28, 241, 6, 255);break;
                        case "Rojo"   :  c = new Color(255,16,31);break;
                        case "Rosa"   :  c = new Color(255,5,176);break;
                        case "Aguamarina" :  c = new Color(128, 255, 219);break;
                        case "Amarillo"   :  c = new Color(240, 246, 0);break;
                        case "Verde Amarilloso"   :  c = new Color(175, 252, 65);break;
                        case "Café"   :  c = new Color(81, 60, 44);break;

                    }
                    jugadores.put(datos[1] , new Jugador(datos[1], c, 1185,720));//pos de inicio: x=1185 y=735
                } else if(datos[0].equals("mover")) {
                    String[] datosJugador = datos[1].split(",");
                    jugadores.get(datosJugador[0]).x = Integer.parseInt(datosJugador[1]);
                    jugadores.get(datosJugador[0]).y = Integer.parseInt(datosJugador[2]);
                }

                String[] lista = new String[jugadores.size()];
                int index = 0;
                for (Jugador e: jugadores.values()) {
                    lista[index++] = e.nickname + "," + e.x + "," + e.y;
                }

                for (Despachador e: escritores) {
                    e.send(String.join("#", lista));
                }
            }
        }
    }

    public void send(String inputLine) {
        try {
            System.out.println("Enviado: " + inputLine);
            out.println(inputLine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}