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
            System.out.println(aux.toString());
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

    public void insertarOrdenadoId(NodoCliente nodoNuevo) {

        if (estaVacia()) {

            cabeza = nodoNuevo;
            ultimo = nodoNuevo;
        } else {

            if (cabeza == ultimo) {// caso cuando ya existe un nodo en la lista y vamos a insertar el segundo nodo

                if (nodoNuevo.getId() > cabeza.getId()) {
                    insertarFinal(nodoNuevo);
                } else if (nodoNuevo.getId() < cabeza.getId()) {
                    insertarInicio(nodoNuevo);
                } else {

                    System.out.println("Ya existe el Id= " + nodoNuevo.getId() + " en la cabeza de la lista");
                    return;
                }

            } else {

                boolean bandera = esPosible(nodoNuevo);

                if (cabeza.getId() > nodoNuevo.getId()) {
                    insertarInicio(nodoNuevo);
                    return;
                } else if (cabeza.getId() == nodoNuevo.getId()) {
                    System.out.println("Id repetido");
                    return;
                }

                if (bandera) {

                    NodoCliente aux1 = cabeza;
                    NodoCliente aux2 = cabeza.sig;
                    int idNuevo = nodoNuevo.getId();
                    while (aux1 != null) {

                        if (idNuevo > aux1.getId() && idNuevo < aux2.getId()) {
                            aux1.sig = nodoNuevo;
                            nodoNuevo.sig = aux2;
                            return;
                        }

                        aux1 = aux1.sig;
                        aux2 = aux2.sig;

                        if (aux2 == null) {
                            aux1.sig = nodoNuevo;
                            return;

                        }

                    }

                } else {
                    System.out.println("No es posible la insercion por que ya existe el id");
                }

            }

        }

    }

    private boolean esPosible(NodoCliente nodoNuevo) {

        boolean band = false;
        NodoCliente aux1 = cabeza;
        NodoCliente aux2 = cabeza.sig;
        int idNuevo = nodoNuevo.getId();

        while (aux1 != null) {

            if (idNuevo > aux1.getId() && idNuevo < aux2.getId()) {
                return true;
            } else if (idNuevo == aux1.getId() || idNuevo == aux2.getId()) {
                return false;
            }
            aux1 = aux1.sig;
            aux2 = aux2.sig;

            if (aux2 == null) {
                aux2 = aux1;
                return true;
            }

        }

        return band;
    }

}
