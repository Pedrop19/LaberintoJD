/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * Clase Mapa
 *
 * @author manue
 *
 * Esta clase es la que representa el mapa del juego
 */
public class Mapa {

    private int ancho;
    private int alto;
    private LinkedList<Pared> paredes;
    private Personaje harry;
    private LinkedList<Adversidad> adversidades;
    static int count;
    static String ruta = "C:/Users/Pedro Lazaro/Documents/NetBeansProjects/LaberintoJD/src/laberintojd/registro.log";

    /**
     * Constructor Parametrizado
     *
     * @param alto alto del mapa
     * @param ancho ancho del mapa
     */
    public Mapa(int alto, int ancho) {
        this.ancho = ancho;
        this.alto = alto;
        this.paredes = new LinkedList<>();
        this.adversidades = new LinkedList<>();
    }

    /**
     * Devuelve el ancho
     *
     * @return int
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Sirve para cambiar el ancho de manera externa
     *
     * @param ancho ancho del mapa
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Devuelve el alto
     *
     * @return int
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Sirve para cambiar el alto de manera externa
     *
     * @param alto alto del mapa
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Sirve para poner al personaje en el mapa
     *
     * @param harry personaje
     */
    public void setHarry(Personaje harry) {
        this.harry = harry;
    }

    /**
     * Permite anadir una pared a la lista paredes
     *
     * @param x coordenada x de la pared
     * @param y coordenada y de la pared
     */
    public void aniadirPared(int x, int y) {
        Pared p = new Pared(x, y);
        if (!hayPared(x, y)) {
            paredes.add(p);
        }
    }

    /**
     * Permite añadir una adversidad a la lista adversidades
     *
     * @param a adversidad que se añade a las adversidades del mapa
     */
    public void nuevaAdversidad(Adversidad a) {
        adversidades.add(a);
    }

    /**
     * Metodo para saber si hay una pared en el laberinto
     *
     * @param x coordenada x
     * @param y coordenada y
     * @return un booleano dependiendo de si hay o no pared
     */
    public boolean hayPared(int x, int y) {
        for (int i = 0; i < paredes.size(); i++) {
            if (paredes.get(i).getX() == x && paredes.get(i).getY() == y
                    || paredes.get(i).getX() == y && paredes.get(i).getY() == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para comprobar si hay una adversidad
     *
     * @return el mensaje para saber que harry ha sido atacado
     */
    public String hayAdversidad() {
        for (int i = 0; i < adversidades.size(); i++) {
            if (harry.getSalaActual() == adversidades.get(i).getsalaAdversidad()) 
                return adversidades.remove(i).atacar(harry, this);
        }
        return "";
    }

    /**
     * Este metodo sirve para dibujar el mapa con el personaje dentro y ademas va añadiendo la ejecucion a un nuevo fichero "registro.log"
     *
     */
    public void avanzarTurno() {
        try ( PrintWriter escritor = new PrintWriter(ruta, "UTF-8");) {
            String salida = "";
            salida += "COMIENZA LA BATALLA \n Turno: " + count + " Salud: " + harry.getSalud() + "\n" + toString() + "\n";
            do {
                harry.mover(this);
                count++;
                
                salida += "Turno: " + count + " Salud: " + harry.getSalud() + "\n";
                salida += hayAdversidad() + "\n";
                
                if (count % 9 == 0) 
                    harry.setSalud(harry.getSalud() - 20);
                
                salida += toString() + "\n";
                
                if (harry.getSalaActual() == getSalaFinal()) 
                    salida += "Harry ha ganado el juego :)";
                
                if (harry.getSalud() <= 0) {
                    salida += "Game Over: Harry se murio";
                    break;
                }
            } while (harry.getSalaActual() != getSalaFinal());

            System.out.println(salida);
            escritor.println(salida);
            count = 0;
        } catch (Exception e) {

        }
    }

    @Override
    /**
     * Dibuja el mapa
     *
     * @return el mapa
     */
    public String toString() {
        String mapa = "";

        for (int i = 0; i < ancho; i++) {
            mapa += " _";
        }

        mapa += '\n';

        for (int i = 0; i < alto; i++) {
            mapa += "|";
            for (int j = 0; j < ancho; j++) {
                int pos = i * ancho + j;
                if (pos == harry.getSalaActual()) {
                    mapa += "H";
                } else if (i == alto - 1) {
                    mapa += "_";
                } else {
                    if (hayPared(pos, pos + ancho)) {
                        mapa += "_";
                    } else {
                        mapa += " ";
                    }
                }
                if (j == ancho - 1) {
                    mapa += "|";
                } else {
                    if (hayPared(pos, pos + 1)) {
                        mapa += "|";
                    } else {
                        mapa += " ";
                    }
                }
            }
            mapa += '\n';
        }
        return mapa;
    }

    /**
     * Metodo para conseguir la salaInicial del mapa
     *
     * @return int
     */
    public int getSalaInicial() {
        return 0;
    }

    /**
     * Metodo para conseguir la salaFinal del mapa
     *
     * @return int
     */
    public int getSalaFinal() {
        return (alto * ancho) - 1;
    }
}
