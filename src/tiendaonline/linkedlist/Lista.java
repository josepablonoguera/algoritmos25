/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaonline.linkedlist;

/**
 *
 * @author pablonoguera
 */
public class Lista {

    NodoCliente cabeza;
    NodoCliente ultimo;

    public Lista() {
        this.cabeza = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {

        if (cabeza == null) {
            return true;
        }
        return false;
    }

    public void insertarInicio(NodoCliente nodoNuevo) {

        if (estaVacia()) {

            nodoNuevo.sig = cabeza;
            cabeza = nodoNuevo;
            ultimo = nodoNuevo;

            System.out.println(nodoNuevo.getName() + " es el primero en ingresar en la lista");

        } else {
            nodoNuevo.sig = cabeza;
            cabeza = nodoNuevo;
        }

    }

    public void mostrarLista() {

        if (estaVacia()) {
            System.out.println("Lista Vacia");
            return;
        }

        NodoCliente aux = cabeza;

        while (aux != null) {
            System.out.println(aux.getName());
            aux = aux.sig;

        }

    }

    public void insertarFinal(NodoCliente nodoNuevo) {

        if (estaVacia()) {
            
            
            cabeza = nodoNuevo;
            ultimo = nodoNuevo;
            
        } else if (cabeza == ultimo) {

            cabeza.sig = nodoNuevo;

            ultimo = nodoNuevo;

        } else {
            ultimo.sig = nodoNuevo;
            ultimo = nodoNuevo;

        }

    }

}
