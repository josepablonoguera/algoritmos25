/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendaonline.linkedlist;

/**
 *
 * @author pablonoguera
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import javax.swing.JFrame;



public class CrudFrame extends JFrame {

    private Lista lista = new Lista();

    private JTextField txtId = new JTextField(5);
    private JTextField txtNombre = new JTextField(15);
    private JTextField txtCorreo = new JTextField(15);
    private JTextArea txtSalida = new JTextArea(10, 30);

    public CrudFrame() {
        setTitle("CRUD Clientes - Lista Enlazada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));

        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Correo:"));
        panelFormulario.add(txtCorreo);

        add(panelFormulario, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnInsertar = new JButton("Insertar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnActualizar = new JButton("Actualizar");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnActualizar);

        add(panelBotones, BorderLayout.CENTER);

        // Área de salida
        txtSalida.setEditable(false);
        add(new JScrollPane(txtSalida), BorderLayout.SOUTH);

        // Eventos
        btnInsertar.addActionListener(e -> insertarCliente());
        btnMostrar.addActionListener(e -> mostrarLista());
        btnEliminar.addActionListener(e -> eliminarCliente());
        btnActualizar.addActionListener(e -> actualizarCliente());
    }

    private void insertarCliente() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String correo = txtCorreo.getText();

            NodoCliente nuevo = new NodoCliente(id, nombre, correo);
            lista.insertarOrdenadoId(nuevo);

            limpiarCampos();
            mostrarLista();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número entero.");
        }
    }

    private void mostrarLista() {
        txtSalida.setText("");
        NodoCliente actual = lista.cabeza;
        while (actual != null) {
            txtSalida.append(actual.toString() + "\n");
            actual = actual.sig;
        }
    }

    private void eliminarCliente() {
        try {
            int id = Integer.parseInt(txtId.getText());

            if (lista.estaVacia()) {
                JOptionPane.showMessageDialog(this, "La lista está vacía.");
                return;
            }

            NodoCliente actual = lista.cabeza;
            NodoCliente anterior = null;

            while (actual != null && actual.getId() != id) {
                anterior = actual;
                actual = actual.sig;
            }

            if (actual == null) {
                JOptionPane.showMessageDialog(this, "ID no encontrado.");
                return;
            }

            if (anterior == null) { // eliminar cabeza
                lista.cabeza = actual.sig;
            } else {
                anterior.sig = actual.sig;
            }

            if (actual == lista.ultimo) {
                lista.ultimo = anterior;
            }

            mostrarLista();
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void actualizarCliente() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nuevoNombre = txtNombre.getText();
            String nuevoCorreo = txtCorreo.getText();

            NodoCliente actual = lista.cabeza;

            while (actual != null) {
                if (actual.getId() == id) {
                    actual.setName(nuevoNombre);
                    actual.setCorreo(nuevoCorreo);
                    mostrarLista();
                    limpiarCampos();
                    return;
                }
                actual = actual.sig;
            }

            JOptionPane.showMessageDialog(this, "ID no encontrado.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido.");
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CrudFrame().setVisible(true));
    }
}
