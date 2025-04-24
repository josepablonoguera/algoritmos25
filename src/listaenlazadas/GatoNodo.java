/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaenlazadas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author pablonoguera
 */
public class GatoNodo {

    Celda celdaCentro;
    Celda celdaAbajo;
    Celda celdaArriba;
    Celda celdaDerecha;
    Celda celdaIzquierda;
    Celda celdaEsquina1;
    Celda celdaEsquina2;
    Celda celdaEsquina3;
    Celda celdaEsquina4;

    String jugador1 = "X";
    String jugador2 = "O";
    boolean turno = true;
    int jugadasValidas = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public GatoNodo() throws IOException {
        this.celdaCentro = new Celda(5);
        this.celdaAbajo = new Celda(8);
        this.celdaArriba = new Celda(2);
        this.celdaDerecha = new Celda(6);
        this.celdaIzquierda = new Celda(4);
        this.celdaEsquina1 = new Celda(1);
        this.celdaEsquina2 = new Celda(3);
        this.celdaEsquina3 = new Celda(7);
        this.celdaEsquina4 = new Celda(9);

        construirGato();

    }

    private void construirGato() throws IOException {
        //enlaces para el centro tipo Rosa de los vientos
        celdaCentro.abajo = celdaAbajo;
        celdaCentro.arriba = celdaArriba;
        celdaCentro.derecha = celdaDerecha;
        celdaCentro.izquierda = celdaIzquierda;
        celdaCentro.diagDerAbajo = celdaEsquina4;
        celdaCentro.diagIzqAbajo = celdaEsquina3;
        celdaCentro.diagDerArriba = celdaEsquina2;
        celdaCentro.diagIzArriba = celdaEsquina1;

        celdaArriba.abajo = celdaCentro;
        celdaArriba.derecha = celdaEsquina2;
        celdaArriba.izquierda = celdaEsquina1;

        celdaEsquina1.derecha = celdaArriba;
        celdaEsquina1.abajo = celdaIzquierda;
        celdaEsquina1.diagDerAbajo = celdaCentro;

        celdaEsquina2.izquierda = celdaArriba;
        celdaEsquina2.abajo = celdaDerecha;
        celdaEsquina2.diagIzqAbajo = celdaCentro;

        celdaIzquierda.derecha = celdaCentro;
        celdaIzquierda.arriba = celdaEsquina1;
        celdaIzquierda.abajo = celdaEsquina3;

        celdaDerecha.izquierda = celdaCentro;
        celdaDerecha.arriba = celdaEsquina2;
        celdaDerecha.abajo = celdaEsquina4;

        celdaEsquina3.diagDerArriba = celdaCentro;
        celdaEsquina3.arriba = celdaIzquierda;
        celdaEsquina3.derecha = celdaAbajo;

        celdaEsquina4.izquierda = celdaAbajo;
        celdaEsquina4.arriba = celdaDerecha;
        celdaEsquina4.diagIzArriba = celdaCentro;

        celdaAbajo.arriba = celdaCentro;
        celdaAbajo.derecha = celdaEsquina4;
        celdaAbajo.izquierda = celdaEsquina3;

        mostrarGato();
        iniciarJuego();

    }

    private void mostrarGato() {

        Celda iniciaPor[] = {celdaEsquina1, celdaIzquierda, celdaEsquina3};

//          Celda iniciaPor[] = {celdaEsquina2, celdaDerecha, celdaEsquina4};
        for (int i = 0; i < iniciaPor.length; i++) {

            Celda aux = iniciaPor[i];
            while (aux != null) {

                System.out.print(aux.getId() + "[" + aux.getSimbolo() + "] ");

                aux = aux.derecha;
            }

            System.out.println("");

        }

//    
    }

    private void iniciarJuego() throws IOException {

        //si el turno es verdadero, juega X
        if (turno) {

            System.out.println("Seleccione el número a marcar por X: ");
            int opc = Integer.parseInt(br.readLine());
            System.out.println("opc = " + opc);

            if (marcarCasilla(opc, "X")) {
                System.out.println("jugada valida1");
                jugadasValidas++;
                mostrarGato();
                if (verificaGanador("X")) {
                    System.out.println("Juego terminado ganador: X ");
                } else if (jugadasValidas == 9 && !verificaGanador("X")) {
                    System.out.println("Juego empatado");
                    reiniciarJuego();
                    return;
                } else {
                    turno = false;
                    iniciarJuego();

                }
            } else {
                System.out.println("jugada NO valida");
                iniciarJuego();
            }

        } else {
            System.out.println("Seleccione el número a marcar por O: ");
            int opc = Integer.parseInt(br.readLine());
            System.out.println("opc = " + opc);

            if (marcarCasilla(opc, "O")) {
                System.out.println("jugada valida2");
                  jugadasValidas++;
                mostrarGato();
                if (verificaGanador("O")) {
                    System.out.println("Juego terminado ganador: O ");
                } else if (jugadasValidas == 9 && !verificaGanador("O")) {
                    System.out.println("Juego empatado");
                    reiniciarJuego();
                    return;
                } else {
                    turno = true;
                    iniciarJuego();

                }
            } else {
                System.out.println("jugada NO valida");
                iniciarJuego();
            }

        }

    }

    private boolean marcarCasilla(int opc, String simb) throws IOException {

        switch (opc) {
            case 1:
                if (celdaEsquina1.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaEsquina1.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 2:
                if (celdaArriba.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaArriba.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 3:
                if (celdaEsquina2.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaEsquina2.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (celdaIzquierda.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaIzquierda.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 5:
                if (celdaCentro.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaCentro.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 6:
                if (celdaDerecha.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaDerecha.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            case 7:
                if (celdaEsquina3.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaEsquina3.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (celdaAbajo.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaAbajo.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (celdaEsquina4.getSimbolo().equalsIgnoreCase(" ")) {
                    celdaEsquina4.setSimbolo(simb);
                    return true;
                } else {
                    return false;
                }

            default:
                System.out.println("Celda invalida");
                mostrarGato();
                iniciarJuego();
                return turno;
        }

    }

    private boolean verificaGanador(String simb) {

        Celda iniciaPor[] = {celdaEsquina1, celdaArriba, celdaEsquina2, celdaEsquina3, celdaIzquierda};

        Celda aux = iniciaPor[0];
        int contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.derecha;
        }

        aux = iniciaPor[0];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.abajo;
        }

        aux = iniciaPor[0];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.diagDerAbajo;
        }

        aux = iniciaPor[1];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.abajo;
        }

        aux = iniciaPor[2];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.abajo;
        }

        aux = iniciaPor[2];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.diagIzqAbajo;
        }

        aux = iniciaPor[3];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.derecha;
        }

        aux = iniciaPor[4];
        contador = 0;
        while (aux != null) {
            if (aux.getSimbolo().equalsIgnoreCase(simb)) {
                contador++;
                if (contador == 3) {
                    return true;
                }
            }
            aux = aux.derecha;
        }

        return false;
    }

    private void reiniciarJuego() throws IOException {

        System.out.println("   -----     ");
        System.out.println("Juego Nuevo");
        System.out.println("   -----     ");
        Celda iniciaPor[] = {
            celdaEsquina1,
            celdaIzquierda,
            celdaEsquina3,
            celdaEsquina2,
            celdaEsquina4,
            celdaAbajo,
            celdaArriba,
            celdaDerecha,
            celdaCentro

        };

        for (int i = 0; i < iniciaPor.length; i++) {
            iniciaPor[i].setSimbolo(" ");
        }

        jugadasValidas = 0;
        turno = true;
        iniciarJuego();
    }

}
