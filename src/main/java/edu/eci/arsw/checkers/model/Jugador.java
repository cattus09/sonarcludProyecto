package edu.eci.arsw.checkers.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un jugador en el juego de damas.
 */
public class Jugador {

    private String nombre;
    private String posicion; // arriba o abajo
    private boolean turno;
    private List<Ficha> fichas;

    /**
     * Constructor para crear un jugador con un nombre y una posición específica.
     *
     * @param nombre   El nombre del jugador.
     * @param posicion La posición del jugador (arriba o abajo).
     */
    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.turno = false;
        fichas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la posición del jugador.
     *
     * @return La posición del jugador (arriba o abajo).
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * Verifica si es el turno del jugador.
     *
     * @return true si es el turno del jugador, false de lo contrario.
     */
    public boolean tieneTurno() {
        return turno;
    }

    /**
     * Cambia el turno del jugador.
     */
    public void cambiarTurno() {
        turno = !turno;
    }

    /**
     * Agrega una ficha al conjunto de fichas del jugador.
     *
     * @param ficha La ficha a agregar.
     */
    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }

    /**
     * Obtiene la lista de fichas del jugador.
     *
     * @return Lista de fichas del jugador.
     */
    public List<Ficha> getFichas() {
        return fichas;
    }
}
