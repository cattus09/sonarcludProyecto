package edu.eci.arsw.checkers.dto;

/**
 * Representa un movimiento realizado por un jugador en el juego de damas.
 */
public class MovimientoDTO {
    private String jugador;
    private int filaOrigen;
    private int columnaOrigen;
    private int filaDestino;
    private int columnaDestino;
    /**
     * Obtiene el nombre del jugador que realiza el movimiento.
     *
     * @return El nombre del jugador que realiza el movimiento.
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * Establece el nombre del jugador que realiza el movimiento.
     *
     * @param jugador El nuevo nombre del jugador que realiza el movimiento.
     */
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    /**
     * Obtiene la fila de origen del movimiento.
     *
     * @return La fila de origen del movimiento.
     */
    public int getFilaOrigen() {
        return filaOrigen;
    }

    /**
     * Establece la fila de origen del movimiento.
     *
     * @param filaOrigen La nueva fila de origen del movimiento.
     */
    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }

    /**
     * Obtiene la columna de origen del movimiento.
     *
     * @return La columna de origen del movimiento.
     */
    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    /**
     * Establece la columna de origen del movimiento.
     *
     * @param columnaOrigen La nueva columna de origen del movimiento.
     */
    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }

    /**
     * Obtiene la fila de destino del movimiento.
     *
     * @return La fila de destino del movimiento.
     */
    public int getFilaDestino() {
        return filaDestino;
    }

    /**
     * Establece la fila de destino del movimiento.
     *
     * @param filaDestino La nueva fila de destino del movimiento.
     */
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    /**
     * Obtiene la columna de destino del movimiento.
     *
     * @return La columna de destino del movimiento.
     */
    public int getColumnaDestino() {
        return columnaDestino;
    }

    /**
     * Establece la columna de destino del movimiento.
     *
     * @param columnaDestino La nueva columna de destino del movimiento.
     */
    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }
}