package edu.eci.arsw.checkers.dto;


public class JuegoDTO {
    private String jugadorActual;
    private TableroDTO tablero; 

    public JuegoDTO(String jugadorActual, TableroDTO tablero) {
        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }


    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    public void setTablero(TableroDTO tablero) {
        this.tablero = tablero;
    }

}