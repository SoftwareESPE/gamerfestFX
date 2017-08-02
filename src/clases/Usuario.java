/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author josue
 */
public class Usuario {
    private String nombre, apellido, cedula, contraseña;
    private int tipo, id;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cedula, String contraseña, int tipo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.tipo = tipo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getTipo() {
        return tipo;
    }
    
    
    
    
}
