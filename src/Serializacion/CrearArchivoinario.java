/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Kernel-2018
 */
public class CrearArchivoinario {

    private ObjectOutput salida;

    public void abrirArchiv() {

        try {
            salida = new ObjectOutputStream(new FileOutputStream("Y:\\escritos\\personas.ser"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void agregarRegistro() {

        Persona objPersona;
        String nombre;
        String direccion;
        String nacionalidad;
        int edad;
        double salario;

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce los datos de la persona,  \n para terminar escribe el indicados"
                + "de final de archivo \n Para linux o Mac presiona CTRL + D e intro"
                + "para Windows escribe \n CTRL + z e intro \n\n");

        System.out.println("Escribe el nombre, la direccion,  la nacionalidad, \n"
                + "la edad  y el salario  de la persona");

        while (entrada.hasNext()) {
            try {
                nombre = entrada.next();
                direccion = entrada.next();
                nacionalidad = entrada.next();
                edad = entrada.nextInt();
                salario = entrada.nextDouble();

                objPersona = new Persona(nombre, direccion, nacionalidad, edad, salario);
                salida.writeObject(objPersona);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Escribe el nombre, la direccion,  la nacionalidad, \n"
                    + "la edad  y el salario  de la persona");

        }

    }

    public void cerrarArchivo() {

        try {
            if (salida != null) {
                salida.close();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CrearArchivoinario aplicacion = new CrearArchivoinario();

        aplicacion.abrirArchiv();
        aplicacion.agregarRegistro();
        aplicacion.cerrarArchivo(); 
    }

}
