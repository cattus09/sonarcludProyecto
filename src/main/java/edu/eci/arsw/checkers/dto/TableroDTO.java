package edu.eci.arsw.checkers.dto;

import java.util.List;

/**
 * Representa el estado del tablero de juego en el juego de damas.
*/
public class TableroDTO {
    private int filas;
    private int columnas;
    private List<CasillaDTO> casillas;
    
    /**
     * Constructor para la clase `TableroDTO`.
     *
     * @param filas El número de filas del tablero.
     * @param columnas El número de columnas del tablero.
     * @param casillas La lista de casillas que conforman el tablero.
     */
    public TableroDTO(int filas, int columnas, List<CasillaDTO> casillas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = casillas;
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
     * Obtiene la lista de casillas que conforman el tablero.
     *
     * @return La lista de casillas que conforman el tablero.
     */
    public List<CasillaDTO> getCasillas() {
        return casillas;
    }
}