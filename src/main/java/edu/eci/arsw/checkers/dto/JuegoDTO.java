package edu.eci.arsw.checkers.dto;

/**
 * Representa el estado del juego de damas en el sistema.
 */
public class JuegoDTO {

    private String jugadorActual;
    private TableroDTO tablero;
    private boolean button;

    /**
     * Construye una nueva instancia de JuegoDTO con información específica.
     *
     * @param jugadorActual El nombre del jugador actual.
     * @param tablero       El estado actual del tablero del juego.
     * @param button        El estado del botón de poder del jugador actual.
     */
    public JuegoDTO(String jugadorActual, TableroDTO tablero, boolean button) {
        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.button = button;
    }

    /**
     * Obtiene el nombre del jugador actual.
     *
     * @return El nombre del jugador actual.
     */
    public String getJugadorActual() {
        return jugadorActual;
    }

    /**
     * Establece el nombre del jugador actual.
     *
     * @param jugadorActual El nuevo nombre del jugador actual.
     */
    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    /**
     * Obtiene el estado actual del tablero del juego.
     *
     * @return El estado actual del tablero del juego.
     */
    public TableroDTO getTablero() {
        return tablero;
    }

    /**
     * Establece el estado actual del tablero del juego.
     *
     * @param tablero El nuevo estado actual del tablero del juego.
     */
    public void setTablero(TableroDTO tablero) {
        this.tablero = tablero;
    }

    /**
     * Obtiene el estado del botón de poder del jugador actual.
     *
     * @return El estado del botón de poder del jugador actual.
     */
    public boolean getButton() {
        return button;
    }

    /**
     * Establece el estado del botón de poder del jugador actual.
     *
     * @param button El nuevo estado del botón de poder del jugador actual.
     */
    public void setButton(boolean button) {
        this.button = button;
    }
}
