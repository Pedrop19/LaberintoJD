/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

/**
 * Clase Adversidad 
 * @author manue
 *
 * Esta superclase representa a las adversidades que se encuentran en el mapa
 */
public abstract class Adversidad {

    private String nombre;
    private int salaAdversidad;

    /**
     * Constructor Parametrizado
     *
     * @param salaAdversidad sala en la que se encuentra la adversidad
     * @param nombre nombre de la adversidad
     */
    public Adversidad(int salaAdversidad, String nombre) {
        this.salaAdversidad = salaAdversidad;
        this.nombre = nombre;
    }

    /**
     * Devuelve la sala Actual
     *
     * @return int
     */
    public int getsalaAdversidad() {
        return salaAdversidad;
    }

    /**
     * Cambia la salaAdversidad
     *
     * @param salaAdversidad salaAdversidad
     */
    public void setsalaAdversidad(int salaAdversidad) {
        this.salaAdversidad = salaAdversidad;
    }

    /**
     * Devuelve el nombre de la Adversidad
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre
     *
     * @param nombre nombre de la adversidad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que sirve para atacar al personaje
     *
     * @param p personaje al que se ataca
     * @param m mapa en el que estan las adversidades
     *
     */
    public abstract String atacar(Personaje p, Mapa m);
}
