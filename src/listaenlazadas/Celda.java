/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaenlazadas;

/**
 *
 * @author pablonoguera
 */
public class Celda {

    private String simbolo;
     private int id;

    Celda izquierda, arriba, abajo, derecha;
    Celda diagIzqAbajo;
    Celda diagIzArriba;
    Celda diagDerAbajo;
    Celda diagDerArriba;

    
    public Celda(int id) {
        this.id = id;
        simbolo= " ";
        derecha = null;
        izquierda = null;
        arriba = null;
        abajo = null;
        diagIzqAbajo = null;
        diagIzArriba = null;
        diagDerAbajo = null;
        diagDerArriba = null;

    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Celda{" + "simbolo=" + simbolo + ", izquierda=" + izquierda + ", arriba=" + arriba + ", abajo=" + abajo + ", derecha=" + derecha + ", diagIzqAbajo=" + diagIzqAbajo + ", diagIzArriba=" + diagIzArriba + ", diagDerAbajo=" + diagDerAbajo + ", diagDerArriba=" + diagDerArriba + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   
    

}
