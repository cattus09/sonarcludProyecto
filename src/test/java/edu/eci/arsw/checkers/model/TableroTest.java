package edu.eci.arsw.checkers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase Tablero.
 */
public class TableroTest {
    private Tablero tablero;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        tablero = new Tablero(8, 8, "Jugador1", "Jugador2", "tokenPartida");
        tablero.inicializarTablero();
    }

    /**
     * Prueba para el método getJugador1.
     */
    @Test
    public void testGetJugador1() {
        assertEquals("Jugador1", tablero.getJugador1().getNombre());
    }

    /**
     * Prueba para el método getJugador2.
     */
    @Test
    public void testGetJugador2() {
        assertEquals("Jugador2", tablero.getJugador2().getNombre());
    }

    /**
     * Prueba para el método getFilas.
     */
    @Test
    public void testGetFilas() {
        assertEquals(8, tablero.getFilas());
    }

    /**
     * Prueba para el método getColumnas.
     */
    @Test
    public void testGetColumnas() {
        assertEquals(8, tablero.getColumnas());
    }

    /**
     * Prueba para el método getCasilla.
     */
    @Test
    public void testGetCasilla() {
        assertNotNull(tablero.getCasilla(0, 0));
        assertNull(tablero.getCasilla(-1, 0));
        assertNull(tablero.getCasilla(0, -1));
        assertNull(tablero.getCasilla(8, 0));
        assertNull(tablero.getCasilla(0, 8));
    }

    /**
     * Prueba para el método setCasilla.
     */
    @Test
    public void testSetCasilla() {
        Casilla nuevaCasilla = new Casilla(0, 0, null);
        tablero.setCasilla(nuevaCasilla, 0, 0);
        assertEquals(nuevaCasilla, tablero.getCasilla(0, 0));
    }

    /**
     * Prueba para el método getCasillaByFicha.
     */
    @Test
    public void testGetCasillaByFicha() {
        Ficha ficha = tablero.getJugador1().getFichas().get(0);
        Casilla casilla = tablero.getCasilla(ficha);
        assertNotNull(casilla);
        assertEquals(ficha, casilla.getFicha());
    }
}
