package net;

import  java.net.Socket;
import gui.VentanaNivel1;
import gui.Tablero;    

public class Cliente {
    public void conectar(VentanaNivel1 gui, Tablero tablero) {
        String hostName = "localhost";
        int portNumber = 1234;

        try {
            Socket kkSocket = new Socket(hostName, portNumber);

            Despachador lector = new Despachador(kkSocket, "lector");
            lector.gui = gui;
            lector.start();

            Despachador escritor = new Despachador(kkSocket, "escritor");
            escritor.gui = gui;
            gui.lienzo.despachador = gui.despachador = escritor;
            escritor.start();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}