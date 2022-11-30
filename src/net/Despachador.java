package net;

import gui.Jugador;
import gui.Tablero;
import gui.VentanaNivel1;

import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Despachador extends Thread{

    private PrintWriter out;
    private BufferedReader in;
    private String tipo = "lector";
    private Socket socket;

    public VentanaNivel1 gui = null;
    public ArrayList<Despachador> escritores = new ArrayList<>();
    public HashMap<String, Jugador> jugadores = new HashMap<>();

    public Despachador(Socket socket, String tipo) {

        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            this.out = new PrintWriter(socket.getOutputStream(),true);
            this.socket = socket;
            this.tipo = tipo;

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
                        case "Normal": c = new Color(231, 196, 193);break;
                        case "Azul ": c = new Color(6, 154, 246);break;
                        case "Negro": c = new Color(0,0,0);break;
                        case "Naranja": c = new Color(238, 90, 45);break;
                        case "Morado": c = new Color(126, 32, 92);break;
                        case "Verde": c = new Color(28, 241, 6, 255);break;
                        case "Marrón": c = new Color(87, 61, 28);break;
                        case "Gris": c = new Color(79, 95, 96);break;
                        case "Rojo": c = new Color(213, 11, 14);break;
                        case "Blanco": c = new Color(255,255,255);break;
                        case "Rosa": c = new Color(239, 39, 222, 255);break;
                    }

                    Tablero.jugadores.put(data[0] , new Jugador(data[0], c, Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                }
                gui.lienzo.repaint();
            }

            if (gui == null) { // Servidor
                String[] datos = inputLine.split(":");

                if (datos[0].equals("login")) {
                    Color c = Color.black;
                    switch (datos[1]) {
                        case "Normal": c = new Color(231, 196, 193);break;
                        case "Negro": c = new Color(0,0,0);break;
                        case "Naranja": c = new Color(238, 90, 45);break;
                        case "Morado": c = new Color(126, 32, 92);break;
                        case "Verde": c = new Color(28, 241, 6, 255);break;
                        case "Marrón": c = new Color(87, 61, 28);break;
                        case "Gris": c = new Color(79, 95, 96);break;
                        case "Azul ": c = new Color(6, 153, 245);break;
                        case "Rojo": c = new Color(213, 11, 14);break;
                        case "Blanco": c = new Color(255,255,255);break;
                        case "Rosa": c = new Color(239, 39, 222, 255);break;
                    }
                    jugadores.put(datos[1] , new Jugador(datos[1], c, 15, 15));
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