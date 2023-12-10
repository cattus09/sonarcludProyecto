package edu.eci.arsw.checkers.dto;

/**
 * Representa la información de una ficha en el sistema de juego de damas.
 */
public class FichaDTO {
    private int vidas;
    private int fila;
    private int columna;
    private String nombreJugador;
    /**
     * Construye una nueva instancia de FichaDTO sin inicializar atributos.
     */
    public FichaDTO() {
    }

    /**
     * Construye una nueva instancia de FichaDTO con información específica.
     *
     * @param vidas          La cantidad de vidas de la ficha.
     * @param fila           La fila en la que se encuentra la ficha en el tablero.
     * @param columna        La columna en la que se encuentra la ficha en el tablero.
     * @param nombreJugador  El nombre del jugador al que pertenece la ficha.
     */
    public FichaDTO(int vidas, int fila, int columna, String nombreJugador) {
        this.vidas = vidas;
        this.fila = fila;
        this.columna = columna;
        this.nombreJugador = nombreJugador;
    }

    /**
     * Obtiene la cantidad de vidas de la ficha.
     *
     * @return La cantidad de vidas de la ficha.
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Establece la cantidad de vidas de la ficha.
     *
     * @param vidas La nueva cantidad de vidas de la ficha.
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * Obtiene la fila en la que se encuentra la ficha.
     *
     * @return La fila en la que se encuentra la ficha en el tablero.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece la fila en la que se encuentra la ficha.
     *
     * @param fila La nueva fila en la que se encuentra la ficha.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Obtiene la columna en la que se encuentra la ficha.
     *
     * @return La columna en la que se encuentra la ficha en el tablero.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece la columna en la que se encuentra la ficha.
     *
     * @param columna La nueva columna en la que se encuentra la ficha.
     */
    public void setColumna(int columna) {
        this.columna = columna;
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
     * Establece el nombre del jugador al que pertenece la ficha.
     *
     * @param nombreJugador El nuevo nombre del jugador al que pertenece la ficha.
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
}