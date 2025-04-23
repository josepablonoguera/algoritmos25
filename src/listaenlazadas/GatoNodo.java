/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaenlazadas;

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

    public GatoNodo() {
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

    private void construirGato() {
        //enlaces para el centro Rosa de los vientos
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
        celdaEsquina2.diagIzqAbajo =celdaCentro;
        
        
        mostrarGato();

    }

    private void mostrarGato() {
  
        Celda aux = celdaEsquina2;
        
        while (aux !=null) {
            
            System.out.print("["+aux.getId()+ aux.getSimbolo()+"] ");
            aux = aux.diagIzqAbajo;
        }
    
    }
    
    
    
    

}
