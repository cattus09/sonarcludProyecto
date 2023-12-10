package edu.eci.arsw.checkers.model;

import java.util.List;


/**
 * Representa un juego de damas que contiene un tablero y jugadores.
 */
public class Juego {
    private Tablero tablero;
    private Jugador jugadorActual;

    /**
     * Constructor para crear un juego vacío.
     */
    public Juego() {
    }

    /**
     * Constructor para crear un juego con jugadores y un tablero inicializado.
     *
     * @param nameJugador1 El nombre del primer jugador.
     * @param nameJugador2 El nombre del segundo jugador.
     * @param tokenPartida El token único para identificar la partida.
     */
    public Juego(String nameJugador1, String nameJugador2, String tokenPartida) {
        tablero = new Tablero(8, 8, nameJugador1, nameJugador2, tokenPartida);
        jugadorActual = tablero.getJugador1();
        tablero.inicializarTablero();
    }

    /**
     * Mueve una ficha en el tablero desde una posición de origen a una posición de destino.
     *
     * @param jugador         El jugador que realiza el movimiento.
     * @param filaOrigen      La fila de la posición de origen.
     * @param columnaOrigen   La columna de la posición de origen.
     * @param filaDestino     La fila de la posición de destino.
     * @param columnaDestino  La columna de la posición de destino.
     */
    public void moverFicha(String jugador, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        
        if (!jugador.equalsIgnoreCase(jugadorActual.getNombre())) {
            System.out.println("es turno de: " + jugadorActual.getNombre()+" usted es "+ jugador);
            return;
        }
    
        Casilla casillaOrigen = tablero.getCasilla(filaOrigen, columnaOrigen);
        Casilla casillaDestino = tablero.getCasilla(filaDestino, columnaDestino);
    
        if (casillaOrigen == null || casillaDestino == null) {
            return;
        }
    
        Ficha ficha = casillaOrigen.getFicha();
    
        int difFilas = Math.abs(filaDestino - filaOrigen);
        int difColumnas = Math.abs(columnaDestino - columnaOrigen);
    
        if (difFilas == 1 && difColumnas == 1) {
            if (casillaDestino.estaVacia()) {
                tablero.getCasilla(filaOrigen, columnaOrigen).setFicha(null);
                tablero.getCasilla(filaDestino, columnaDestino).setFicha(ficha);
                ficha.setFila(filaDestino);
                ficha.setColumna(columnaDestino);
    
                cambiarTurno();
            }
        } else if (difFilas == 2 && difColumnas == 2) {
            int filaIntermedia = (filaOrigen + filaDestino) / 2;
            int columnaIntermedia = (columnaOrigen + columnaDestino) / 2;
    
            Casilla casillaIntermedia = tablero.getCasilla(filaIntermedia, columnaIntermedia);
    
            if (!casillaIntermedia.estaVacia() && casillaIntermedia.getFicha().getNombreJugador().equals(getJugadorEspera().getNombre())) {
                tablero.getCasilla(filaOrigen, columnaOrigen).setFicha(null);
                tablero.getCasilla(filaDestino, columnaDestino).setFicha(ficha);
                ficha.setFila(filaDestino);
                ficha.setColumna(columnaDestino);
    
                Ficha fichaCapturada = casillaIntermedia.getFicha();
                fichaCapturada.reducirVidas(1);
    
                if (fichaCapturada.getVidas() <= 0) {
                    casillaIntermedia.setFicha(null);
                }
    
                cambiarTurno();
            }
        }
    }

    /**
     * Cambia el turno de juego al siguiente jugador.
     */
    public void cambiarTurno() {
        if (jugadorActual == tablero.getJugador1()) {
            jugadorActual = tablero.getJugador2();
        } else {
            jugadorActual = tablero.getJugador1();
        }
    }

    /**
     * Obtiene el tablero del juego.
     *
     * @return El tablero del juego.
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Obtiene el jugador actual en el turno de juego.
     *
     * @return El jugador actual en el turno de juego.
     */
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    /**
     * Obtiene el jugador que espera su turno de juego.
     *
     * @return El jugador que espera su turno de juego.
     */
    public Jugador getJugadorEspera(){
        if (jugadorActual == tablero.getJugador1()) {
            return tablero.getJugador2();
        } else {
            return tablero.getJugador1();
        }
         
    }

    /**
     * Obtiene las fichas de un jugador específico.
     *
     * @param jugador El jugador del cual obtener las fichas.
     * @return Lista de fichas del jugador.
     */
    public List<Ficha> getFichas(Jugador jugador) {
        return jugador.getFichas();
    }


}
