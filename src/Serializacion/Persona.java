/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializacion;

import java.io.Serializable;


public class Persona implements Serializable{
    
    private String nombre;
    private String direccion;
    private String naciodalidad;
    int edad;
    double salario;

    public Persona(String nombre, String direccion, String naciodalidad, int edad, double salario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.naciodalidad = naciodalidad;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNaciodalidad() {
        return naciodalidad;
    }

    public void setNaciodalidad(String naciodalidad) {
        this.naciodalidad = naciodalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
}
