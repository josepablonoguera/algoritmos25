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

    NodoCliente primero;

    public Lista() {
        this.primero = null;
    }

    public boolean estaVacia() {

        if (primero == null) {
            return true;
        }
        return false;
    }

    public void insertarInicio(NodoCliente nodoNuevo) {

        if (estaVacia()) {

            nodoNuevo.sig = primero;
            primero = nodoNuevo;

            System.out.println(nodoNuevo.getName() + " es el primero en ingresar en la lista");

        } else {
            nodoNuevo.sig = primero;
            primero = nodoNuevo;
        }

    }

    public void mostrarLista() {

        if (estaVacia()) {
            System.out.println("Lista Vacia");
        }

        NodoCliente aux = primero;

        while (aux != null) {
            System.out.println(aux.getName());
            aux = aux.sig;

        }

    }
    
    public void insertarFinal(NodoCliente nodoNuevo) {

        if (estaVacia()) {

            nodoNuevo.sig = primero;
            primero = nodoNuevo;

            

        } 
        NodoCliente aux = primero;
          while (aux != null) {
              if (aux.sig == null) {
                  aux.sig=nodoNuevo;
                  return;
              }
            aux = aux.sig;

        }

    }

}
