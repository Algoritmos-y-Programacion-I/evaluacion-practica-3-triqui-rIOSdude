package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;
    private String[] raya;
    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        raya = new String[3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    public boolean jugadaHumano(int i, int j){
        if (tableroTresEnRaya[i][j].equals(" ")){
            tableroTresEnRaya[i][j] = "O";
            return true;
        }
        else {
            return false;
        }
    }

    public String quienGana(){
        int d = 0;
        String mensajeBot = "te gana la pc jaja";
        String mensajeHumano = "gana el jugador (tu)";
        String mensajeNadie = "nadie gana :(";

        //chequeamos las 3 filas
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                raya[j] = tableroTresEnRaya[i][j];
            }
            if (raya[0].equals("X") && raya[1].equals("X") && raya[2].equals("X")){
                return mensajeBot;
            }
            if (raya[0].equals("O") && raya[1].equals("O") && raya[2].equals("O")){
                return mensajeHumano;
            }
        }

        //chequeamos las 3 columnas
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                raya[j] = tableroTresEnRaya[j][i];
            }
            if (raya[0].equals("X") && raya[1].equals("X") && raya[2].equals("X")){
                return mensajeBot;
            }
            if (raya[0].equals("O") && raya[1].equals("O") && raya[2].equals("O")){
                return mensajeHumano;
            }
        }

        //chequeamos las 2 diagonales
        for (int j = 0; j<3; j++){
            raya[j] = tableroTresEnRaya[j][j];
        }
        if (raya[0].equals("X") && raya[1].equals("X") && raya[2].equals("X")){
            return mensajeBot;
        }
        if (raya[0].equals("O") && raya[1].equals("O") && raya[2].equals("O")){
            return mensajeHumano;
        }

        for (int i = 2; i>(-1); i--){
            d = d+1;
            raya[i] = tableroTresEnRaya[i][i];

        }
        if (raya[0].equals("X") && raya[1].equals("X") && raya[2].equals("X")){
            return mensajeBot;
        }
        if (raya[0].equals("O") && raya[1].equals("O") && raya[2].equals("O")){
            return mensajeHumano;
        }


        return mensajeNadie;
    }
}