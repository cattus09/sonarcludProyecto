package edu.eci.arsw.checkers.model;

/**
 * Representa el tablero de juego en el juego de damas.
 */
public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private Jugador jugador1;
    private Jugador jugador2;

    /**
     * Constructor para crear un tablero de juego con un número específico de filas y columnas,
     * así como los nombres de los jugadores y el token de la partida.
     *
     * @param filas           Número de filas del tablero.
     * @param columnas        Número de columnas del tablero.
     * @param nameJugador1    Nombre del primer jugador.
     * @param nameJugador2    Nombre del segundo jugador.
     * @param tokenPartida    Token único de la partida.
     */
    public Tablero(int filas, int columnas, String nameJugador1, String nameJugador2, String tokenPartida) {
        this.filas = filas;
        this.columnas = columnas;
        jugador1 = new Jugador(nameJugador1, "abajo");
        jugador2 = new Jugador(nameJugador2, "arriba");
        casillas = new Casilla[filas][columnas];
    }

    /**
     * Inicializa el tablero colocando las fichas en las posiciones iniciales.
     */
    public void inicializarTablero(){
        for (int fila = 0; fila < getFilas(); fila++) {
            for (int columna = 0; columna < getColumnas(); columna++) {
                Casilla casilla = new  Casilla(fila, columna, null);
                setCasilla(casilla, fila, columna);
                
                if (!casilla.esCasillaNegra()) {
                    continue;
                }

                if (fila < 3) {
                    Ficha ficha = new Ficha(fila, columna, 1,jugador1.getNombre());
                    getCasilla(fila, columna).setFicha(ficha);
                    jugador1.agregarFicha(ficha);
                }

                if (fila >= getFilas() - 3) {
                    Ficha ficha = new Ficha(fila, columna, 1, jugador2.getNombre());
                    getCasilla(fila, columna).setFicha(ficha);
                    jugador2.agregarFicha(ficha);
                }
            }
        }
    }

    /**
     * Obtiene el jugador 1.
     *
     * @return El jugador 1.
     */
    public Jugador getJugador1(){
        return jugador1;
    }

    /**
     * Obtiene el jugador 2.
     *
     * @return El jugador 2.
     */
    public Jugador getJugador2(){
        return jugador2;
    }

    /**
     * Obtiene el número de filas del tablero.
     *
     * @return El número de filas del tablero.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Obtiene el número de columnas del tablero.
     *
     * @return El número de columnas del tablero.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Obtiene la casilla en una posición específica del tablero.
     *
     * @param fila    La fila de la casilla.
     * @param columna La columna de la casilla.
     * @return La casilla en la posición especificada.
     */
    public Casilla getCasilla(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return casillas[fila][columna];
        } else {
            return null;
        }
    }

    /**
     * Establece una casilla en una posición específica del tablero.
     *
     * @param casilla La casilla a establecer.
     * @param fila    La fila de la casilla.
     * @param columna La columna de la casilla.
     */
    public void setCasilla(Casilla casilla, int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            casillas[fila][columna] = casilla;
        }
    }

    /**
     * Obtiene la casilla que contiene una ficha específica.
     *
     * @param ficha La ficha a buscar.
     * @return La casilla que contiene la ficha especificada.
     */
    public Casilla getCasilla(Ficha ficha) {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Casilla casilla = casillas[fila][columna];
                if (casilla.getFicha() == ficha) {
                    return casilla;
                }
            }
        }
        return null;
    }

}