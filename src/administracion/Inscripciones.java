/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracion;

import java.io.Serializable;

/**
 *
 * @author ZM JOHANN
 */
public class Inscripciones implements Serializable{
    private int ID;
    private String nombre;
    private String apellido;
    private String fecha;
    private int usu_id;
    private int juego_id;
    private String juego;
<<<<<<< HEAD
    private float valor;

    public Inscripciones(int ID, String nombre, String apellido, String fecha, int usu_id, int juego_id, String juego, float valor) {
=======
    private String valor;

    public Inscripciones(int ID, String nombre, String apellido, String fecha, int usu_id, int juego_id, String juego, String valor) {
>>>>>>> bc20be74474d48dedc416db88635905ae4c038d4
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.usu_id = usu_id;
        this.juego_id = juego_id;
        this.juego = juego;
        this.valor = valor;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

<<<<<<< HEAD
    public void setValor(float valor) {
=======
    public void setValor(String valor) {
>>>>>>> bc20be74474d48dedc416db88635905ae4c038d4
        this.valor = valor;
    }
    
    

<<<<<<< HEAD
    public float getValor() {
=======
    public String getValor() {
>>>>>>> bc20be74474d48dedc416db88635905ae4c038d4
        return valor;
    }
    
    

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public void setJuego_id(int juego_id) {
        this.juego_id = juego_id;
    }

    public int getID() {
        return ID;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public int getJuego_id() {
        return juego_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
