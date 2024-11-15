package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        int fila, columna;
        columna = 3;
        fila = 3;

        while (fila > 2 || columna > 2){
            System.out.println("dijite la posicion de su movimiento: fila, columna por separado");
            fila = reader.nextInt();
            reader.nextLine();
            columna = reader.nextInt();
            reader.nextLine();
            if (fila > 2 || columna > 2){
                System.out.println("no se pueden numeros mayores a 2");
            }
        }

        if (cont.jugadaHumano(fila, columna)){
            System.out.println("Usted ha realizado su jugada.");
            imprimirTablero();
        } else{
            System.out.println("nuh uh, ta ocupao o el juego ya está lleno");
        }

    }

    private void validarGanador() {
        System.out.println(cont.quienGana());
    }
}