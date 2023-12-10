package edu.eci.arsw.checkers.dto;

public class CasillaDTO {
    private int fila;
    private int columna;
    private boolean vacia;
    private FichaDTO ficha;

    /**
     * Construye una nueva instancia de CasillaDTO.
     *
     * @param fila    La fila de la casilla en el tablero.
     * @param columna La columna de la casilla en el tablero.
     * @param vacia   Indica si la casilla está vacía.
     * @param ficha   La información de la ficha en la casilla.
     */
    public CasillaDTO(int fila, int columna, boolean vacia, FichaDTO ficha) {
        this.fila = fila;
        this.columna = columna;
        this.vacia = vacia;
        this.ficha = ficha;
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
     * Verifica si la casilla está vacía.
     *
     * @return {@code true} si la casilla está vacía, {@code false} de lo contrario.
     */
    public boolean isVacia() {
        return vacia;
    }

    /**
     * Obtiene la información de la ficha en la casilla.
     *
     * @return La información de la ficha en la casilla, o {@code null} si la casilla está vacía.
     */
    public FichaDTO getFicha() {
        return ficha;
    }
}