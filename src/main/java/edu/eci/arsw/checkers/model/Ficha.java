package edu.eci.arsw.checkers.model;

/**
 * Representa una ficha en el juego de damas.
 * Cada ficha tiene una posición en el tablero, un número de vidas y pertenece a un jugador.
 */
public class Ficha {

    private int vidas;
    private int fila;
    private int columna;
    private String nombreJugador;

    /**
     * Constructor para crear una ficha con una fila, una columna, un número de vidas y el nombre del jugador al que pertenece.
     *
     * @param fila           La fila en la que se encuentra la ficha.
     * @param columna        La columna en la que se encuentra la ficha.
     * @param vidas          El número de vidas de la ficha.
     * @param nombreJugador  El nombre del jugador al que pertenece la ficha.
     */
    public Ficha(int fila, int columna, int vidas, String nombreJugador) {
        this.vidas = vidas;
        this.fila = fila;
        this.columna = columna;
        this.nombreJugador = nombreJugador;
    }

    /**
     * Obtiene la fila en la que se encuentra la ficha.
     *
     * @return La fila de la ficha.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Obtiene la columna en la que se encuentra la ficha.
     *
     * @return La columna de la ficha.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece la fila en la que se encuentra la ficha.
     *
     * @param fila La nueva fila de la ficha.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Establece la columna en la que se encuentra la ficha.
     *
     * @param columna La nueva columna de la ficha.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Obtiene el número de vidas de la ficha.
     *
     * @return El número de vidas de la ficha.
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Establece el nombre del jugador al que pertenece la ficha.
     *
     * @param nombreJugador El nuevo nombre del jugador al que pertenece la ficha.
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    /**
     * Obtiene el nombre del jugador al que pertenece la ficha.
     *
     * @return El nombre del jugador al que pertenece la ficha.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
     * Reduce el número de vidas de la ficha en una cantidad específica.
     *
     * @param cantidad La cantidad en la que se reducirán las vidas de la ficha.
     */
    public void reducirVidas(int cantidad) {
        vidas -= cantidad;
    }
}
