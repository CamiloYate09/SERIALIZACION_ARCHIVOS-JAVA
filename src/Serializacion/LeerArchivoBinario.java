/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kernel-2018
 */
public class LeerArchivoBinario extends JFrame {

    private ObjectInputStream entrada;
    private DefaultTableModel modelo;

    public LeerArchivoBinario() {

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Edad");
        modelo.addColumn("Sueldo");

        JTable table = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(table);
        JButton boton = new JButton("Cargar info");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                abrirArchivo();
                leerRegistro();
                cerrarArchivo();

            }
        });

        this.add(scroll);
        this.add(boton);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    public void abrirArchivo() {

        try {
            entrada = new ObjectInputStream(new FileInputStream("Y:\\escritos\\personas.ser"));

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el arhivo");
        }

    }

    public void leerRegistro() {
        Persona objPersona;

        try {
            while (true) {
                objPersona = (Persona) entrada.readObject();
                String nombre = objPersona.getNombre();
                String direccion = objPersona.getDireccion();
                String nacionalidad = objPersona.getNaciodalidad();
                int edad = objPersona.getEdad();
                double salario = objPersona.getSalario();

                String[] datospersona = {nombre, direccion, nacionalidad, String.valueOf(edad), String.valueOf(salario)};
                modelo.addRow(datospersona);
            }
        } catch (EOFException endEOFException) {
            return;

        } catch (IOException ex) {
            System.err.println("Error al leer el arhivo");

        } catch (ClassNotFoundException ex) {

            System.err.println("No se pudo crear el  arhivo");

        }

    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();

            }
        } catch (Exception ex) {
            System.err.println("Error al cerrar el arhivo");
        }

    }

    public static void main(String[] args) {
        LeerArchivoBinario leer = new LeerArchivoBinario();
    }

}
