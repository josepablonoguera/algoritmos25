/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaonline.linkedlist;

/**
 *
 * @author pablonoguera
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.mostrarLista();
        lista.insertarInicio(new NodoCliente("1", "Maria", "correo@correo.com"));
        lista.insertarInicio(new NodoCliente("2", "Juan", "correo@correo.com"));
        lista.insertarFinal(new NodoCliente("3", "Pedro", "correo@correo.com"));
        lista.insertarFinal(new NodoCliente("4", "Mateo", "correo@correo.com"));
        lista.insertarFinal(new NodoCliente("5", "Camila", "correo@correo.com"));
        lista.insertarInicio(new NodoCliente("6", "Karina", "correo@correo.com"));

        lista.mostrarLista();

    }

}
