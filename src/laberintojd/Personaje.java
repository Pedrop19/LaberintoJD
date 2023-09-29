/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberintojd;

import java.util.LinkedList;

/**
 * Clase Personaje
 * @author manue
 */
public class Personaje {

    private int salaActual;
    private LinkedList<Direccion> ruta;
    private int salud;

    /**
     * Constructor parametrizado
     *
     */
    public Personaje(Mapa m) {
        salaActual = m.getSalaInicial();
        ruta = new LinkedList<Direccion>();
        calcularRuta(m, new LinkedList<Integer>());
        m.setHarry(this);
        salud = 100;
    }

    /**
     * Retorna la SalaActual
     *
     * @return int
     */
    public int getSalaActual() {
        return salaActual;
    }

    /**
     * Sirve para cambiar la SalaActual
     *
     * @param salaActual salaActual
     */
    public void setSalaActual(int salaActual) {
        this.salaActual = salaActual;
    }

    /**
     * Devuelve la salud
     *
     * @return int salud del personaje
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Metodo para cambiar la salud
     *
     * @param salud salud del Personaje
     */
    public void setSalud(int salud) {
        this.salud = salud;
    }

    /**
     * Metodo que sirve para reiniciar la ruta del personaje
     *
     */
    public void reiniciarRuta(Mapa m) {
        salaActual = 0;
        if (salaActual == 0) {
            ruta.clear();
            calcularRuta(m, new LinkedList<Integer>());
        }
    }

    /**
     * Metodo para conseguir la ruta que va a seguir el personaje
     *
     * @param salasVisitadas una nueva LinkedList para saber las salas que se
     * han visitado
     * @return un booleano dependiendo de si puede seguir adelante o no
     */
    public boolean calcularRuta(Mapa m, LinkedList<Integer> salasVisitadas) {
        if (salaActual == m.getSalaFinal()) {
            salaActual = 0;
            return true;
        } else {
            int x = salaActual % m.getAncho();
            int y = salaActual / m.getAncho();
            if (y < m.getAlto() - 1 && !m.hayPared(salaActual, salaActual + m.getAncho())
                    && !salasVisitadas.contains(salaActual + m.getAncho())) {
                salasVisitadas.add(salaActual + m.getAncho());
                ruta.add(Direccion.S);
                salaActual = salaActual + m.getAncho();
                if (!calcularRuta(m, salasVisitadas)) {
                    salaActual = salaActual - m.getAncho();
                    ruta.removeLast();
                } else {
                    return true;
                }
            }
            if (x < m.getAncho() - 1 && !m.hayPared(salaActual, salaActual + 1)
                    && !salasVisitadas.contains(salaActual + 1)) {
                salasVisitadas.add(salaActual + 1);
                ruta.add(Direccion.E);
                salaActual = salaActual + 1;
                if (!calcularRuta(m, salasVisitadas)) {
                    salaActual = salaActual - 1;
                    ruta.removeLast();
                } else {
                    return true;
                }
            }
            if (x > 0 && !m.hayPared(salaActual, salaActual - 1) && !salasVisitadas.contains(salaActual - 1)) {
                salasVisitadas.add(salaActual - 1);
                ruta.add(Direccion.O);
                salaActual = salaActual - 1;
                if (!calcularRuta(m, salasVisitadas)) {
                    salaActual = salaActual + 1;
                    ruta.removeLast();
                } else {
                    return true;
                }
            }
            if (y > 0 && !m.hayPared(salaActual, salaActual - m.getAncho())
                    && !salasVisitadas.contains(salaActual - m.getAncho())) {
                salasVisitadas.add(salaActual - m.getAncho());
                ruta.add(Direccion.N);
                salaActual = salaActual - m.getAncho();
                if (!calcularRuta(m, salasVisitadas)) {
                    salaActual = salaActual + m.getAncho();
                    ruta.removeLast();
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que sirve para mover al personaje dependiendo de la ruta
     *
     */
    public void mover(Mapa m) {
        Direccion d = ruta.remove();
        switch (d) {
            case S:
                salaActual = salaActual + m.getAncho();
                break;
            case E:
                salaActual = salaActual + 1;
                break;
            case O:
                salaActual = salaActual - 1;
                break;
            case N:
                salaActual = salaActual - m.getAncho();
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
