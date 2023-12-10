package edu.eci.arsw.checkers.model;

/**
 * Representa una casilla en el tablero de juego.
 * Cada casilla puede contener una ficha y tiene una posición determinada en el tablero.
 */
public class Casilla {
    private int fila;
    private int columna;
    private Ficha ficha;

    /**
     * Constructor para crear una casilla con una fila, una columna y una ficha.
     * @param fila    La fila de la casilla.
     * @param columna La columna de la casilla.
     * @param ficha   La ficha asociada a la casilla.
     */
    public Casilla(int fila, int columna, Ficha ficha) {
        this.fila = fila;
        this.columna = columna;
        this.ficha = ficha;
    }

    /**
     * Obtiene la ficha asociada a la casilla.
     * @return La ficha asociada a la casilla, o null si la casilla está vacía.
     */
    public Ficha getFicha() {
        return ficha;
    }

    /**
     * Establece la ficha asociada a la casilla.
     *
     * @param ficha La ficha que se colocará en la casilla.
     */
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
     /**
     * Verifica si la casilla está vacía.
     *
     * @return true si la casilla está vacía, false de lo contrario.
     */
    public boolean estaVacia() {
        return ficha == null;
    }

    /**
     * Obtiene la fila de la casilla.
     *
     * @return La fila de la casilla.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Obtiene la columna de la casilla.
     *
     * @return La columna de la casilla.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Verifica si la casilla es de color blanco en el tablero.
     *
     * @return true si la casilla es blanca, false si es negra.
     */
    public boolean esCasillaBlanca() {
        return (fila + columna) % 2 == 0;
    }

    /**
     * Verifica si la casilla es de color negro en el tablero.
     *
     * @return true si la casilla es negra, false si es blanca.
     */
    public boolean esCasillaNegra() {
        return !esCasillaBlanca();
    }
}