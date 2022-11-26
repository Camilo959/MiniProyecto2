package gui;

import java.awt.*;

public class Laberinto {
    private int fila = 0;
    private int columna = 0;
    private int nFilas, nColumnas ,altoB, anchoB;
    private int[][] mapa;
    private Color colorlab;

    public Laberinto(int Nfila, int nColumnas, int altoB, int anchoB, int[][] mapa,Color colorLaberinto){
        this.altoB = altoB;
        this.anchoB = anchoB;
        this.mapa = mapa;
        this.nColumnas = nColumnas;
        this.nFilas = Nfila;
        this.colorlab = colorLaberinto;
    }

    public void paint(Graphics g){
        int[][] laberinto = obtenerLaberinto();

        for(fila = 0; fila < nFilas; fila++){
            for(columna = 0; columna < nColumnas; columna++){
                if(laberinto[fila][columna] == 1){
                    g.setColor(colorlab);
                    g.fillRect(columna*anchoB, fila*altoB, anchoB, altoB);
                }
            }
        }
    }

    public int[][] obtenerLaberinto(){
        return mapa;
    }
}
