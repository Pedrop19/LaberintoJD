/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberintojd;


/**
 * Clase principal
 *
 * @author manue Esta clase es la que tiene el metodo Main para poder ejecutar
 * el programa
 *
 */
public class LaberintoJD {

    private static Mapa m;
    private static Personaje harry;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        m = new Mapa(4, 4);
        // Paredes
        m.aniadirPared(0, 4);
        m.aniadirPared(3, 7);
        m.aniadirPared(5, 6);
        m.aniadirPared(5, 9);
        m.aniadirPared(8, 9);
        m.aniadirPared(8, 12);
        m.aniadirPared(10, 11);
        m.aniadirPared(10, 14);
        m.aniadirPared(11, 15);
        // Adversidades
        m.nuevaAdversidad(new Viento("Viento Norte", 2));
        m.nuevaAdversidad(new Viento("Viento Sur", 13));
        m.nuevaAdversidad(new Dementor(6));
        m.nuevaAdversidad(new Dementor(10));
        harry = new Personaje(m);

        m.avanzarTurno();
        //Paredes
        m = new Mapa(7, 5);
        m.aniadirPared(0, 5);
        m.aniadirPared(2, 3);
        m.aniadirPared(3, 8);
        m.aniadirPared(6, 7);
        m.aniadirPared(6, 11);
        m.aniadirPared(7, 12);
        m.aniadirPared(8, 13);
        m.aniadirPared(13, 14);
        m.aniadirPared(13, 18);
        m.aniadirPared(15, 16);
        m.aniadirPared(15, 20);
        m.aniadirPared(16, 17);
        m.aniadirPared(17, 22);
        m.aniadirPared(18, 19);
        m.aniadirPared(19, 20);
        m.aniadirPared(19, 24);
        m.aniadirPared(20, 25);
        m.aniadirPared(22, 23);
        m.aniadirPared(22, 27);
        m.aniadirPared(23, 24);
        m.aniadirPared(25, 30);
        m.aniadirPared(26, 27);
        m.aniadirPared(27, 32);
        m.aniadirPared(28, 29);
        m.aniadirPared(28, 33);
        // Adversidades
        m.nuevaAdversidad(new Viento("Viento Norte", 2));
        m.nuevaAdversidad(new Viento("Viento Sur", 32));
        m.nuevaAdversidad(new Dementor(10));
        m.nuevaAdversidad(new Dementor(21));
        m.nuevaAdversidad(new Dementor(26));
        m.nuevaAdversidad(new Dementor(19));
        harry = new Personaje(m);

        m.avanzarTurno();
    }

}
