/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

/**
 * Clase Dementor
 * @author manue
 */
public class Dementor extends Adversidad {

    /**
     * Constructor parametrizado
     *
     * @param salaAdversidad sala en la que se encuentra el Dementor
     */
    public Dementor(int salaAdversidad) {
        super(salaAdversidad, "Dementor");
    }

    /**
     * Metodo que sirve para atacar al personaje, en este caso se le resta 30 a
     * la vida del personaje
     *
     * @param p personaje al que se ataca
     * @param m mapa en el que estan las adversidades
     *
     * @return "Adversidad" + nombre de la adversidad + "atacando a Harry"
     */
    @Override
    public String atacar(Personaje p, Mapa m) {
        p.setSalud(p.getSalud() - 30);
        return "Adversidad " + super.getNombre() + " atacando a Harry";
    }
}
