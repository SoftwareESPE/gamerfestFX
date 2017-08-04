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
    private String nom_usu;
    private String apellido_usu;
    private String ced_usu;

<<<<<<< HEAD
    public Inscripciones(int ID, String nombre, String apellido, String fecha, int usu_id, int juego_id, String juego, String valor, String nom_usu, String apellido_usu, String ced_usu) {
=======
    public Inscripciones(int ID, String nombre, String apellido, String fecha, int usu_id, int juego_id, String juego, String valor) {
>>>>>>> bc20be74474d48dedc416db88635905ae4c038d4
>>>>>>> 7bc4b361e1ffa62325638d47d8bdf260e0b2b125
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.usu_id = usu_id;
        this.juego_id = juego_id;
        this.juego = juego;
        this.valor = valor;
        this.nom_usu = nom_usu;
        this.apellido_usu = apellido_usu;
        this.ced_usu = ced_usu;
    }

<<<<<<< HEAD
    public int getID() {
        return ID;
=======
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
>>>>>>> 7bc4b361e1ffa62325638d47d8bdf260e0b2b125
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

    public int getUsu_id() {
        return usu_id;
    }

    public int getJuego_id() {
        return juego_id;
    }

    public String getJuego() {
        return juego;
    }

    public String getValor() {
        return valor;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public String getApellido_usu() {
        return apellido_usu;
    }

    public String getCed_usu() {
        return ced_usu;
    }
    
}
