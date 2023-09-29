/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

/**
 * Clase Viento
 *
 * @author manue
 * 
 * Esta clase representa a la adversidad Viento del juego
 */
public class Viento extends Adversidad{
 
     /**
      * Constructor parametrizado
      * 
      * @param nombre         del Viento
      * @param salaAdversidad sala en la que se encuentra el Viento
      */
     public Viento(String nombre, int salaAdversidad) {
         super(salaAdversidad, nombre);
     }
 
    
 
     /**
      * Metodo que sirve para atacar al personaje, en este caso hace que el personaje vuelva al inicio del mapa (Sala 0)
      * 
      * @param p personaje al que se ataca
      * @param m mapa en el que se encuentra la adversidad
      * 
      * @return "Adversidad" + nombre de la adversidad + "atacando a Harry"
      */
     @Override
     public String atacar(Personaje p, Mapa m) {
         p.setSalaActual(0);
         p.reiniciarRuta(m);
         return "Adversidad " + super.getNombre() + " atacando a Harry";
     }
}
