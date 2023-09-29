/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

/**
 * Clase Pared
 * @author manue
 * 
 * Esta clase es la que representa las paredes que se encuentran en el mapa
 */
public class Pared {

    private int x;
    private int y;

    /**
     * Constructor parametrizado
     *
     * @param x coordenada x
     * @param y coordenada y
     */
    public Pared(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna la coordenada X
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Sirve para cambiar la coordenada X
     *
     * @param x coordenada x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retorna la coordenada Y
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Sirve para cambiar la coordenada Y
     *
     * @param y coordenada y
     */
    public void setY(int y) {
        this.y = y;
    }
}
