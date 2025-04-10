/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaonline.linkedlist;

/**
 *
 * @author pablonoguera
 */
public class NodoCliente {

    private int id;
    private String name;
    private String correo;

    // puntero
    NodoCliente sig;

    public NodoCliente(int id, String name, String correo) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        sig = null;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "NodoCliente{" + "id=" + id + ", name=" + name + ", correo=" + correo + '}';
    }

   
   

    

}
