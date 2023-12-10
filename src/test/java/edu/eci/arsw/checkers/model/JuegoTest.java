package edu.eci.arsw.checkers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase Juego.
 */
public class JuegoTest {
    private Juego juego;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        juego = new Juego("Jugador1", "Jugador2", "tokenPartida");
    }

    /**
     * Prueba para el método cambiarTurno.
     */
    @Test
    public void testCambiarTurno() {
        assertEquals("Jugador1", juego.getJugadorActual().getNombre());
        juego.cambiarTurno();
        assertEquals("Jugador2", juego.getJugadorActual().getNombre());
        juego.cambiarTurno();
        assertEquals("Jugador1", juego.getJugadorActual().getNombre());
    }

    /**
     * Prueba para el método getTablero.
     */
    @Test
    public void testGetTablero() {
        assertNotNull(juego.getTablero());
        assertEquals(8, juego.getTablero().getFilas());
        assertEquals(8, juego.getTablero().getColumnas());
    }

    /**
     * Prueba para el método getJugadorActual.
     */
    @Test
    public void testGetJugadorActual() {
        assertEquals("Jugador1", juego.getJugadorActual().getNombre());
        juego.cambiarTurno();
        assertEquals("Jugador2", juego.getJugadorActual().getNombre());
    }

    /**
     * Prueba para el método getJugadorEspera.
     */
    @Test
    public void testGetJugadorEspera() {
        assertEquals("Jugador2", juego.getJugadorEspera().getNombre());
        juego.cambiarTurno();
        assertEquals("Jugador1", juego.getJugadorEspera().getNombre());
    }

    /**
     * Prueba para el método getFichas.
     */
    @Test
    public void testGetFichas() {
        assertNotNull(juego.getFichas(juego.getJugadorActual()));
        assertEquals(12, juego.getFichas(juego.getJugadorActual()).size());
    }
}
