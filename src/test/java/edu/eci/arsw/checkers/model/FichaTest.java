package edu.eci.arsw.checkers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Clase de prueba para la clase Ficha.
 */
public class FichaTest {
    private Ficha ficha;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        ficha = new Ficha(1, 1, 3, "Jugador1");
    }

    /**
     * Prueba para el método getFila.
     */
    @Test
    public void testGetFila() {
        assertEquals(1, ficha.getFila());
    }

    /**
     * Prueba para el método getColumna.
     */
    @Test
    public void testGetColumna() {
        assertEquals(1, ficha.getColumna());
    }

    /**
     * Prueba para el método setFila.
     */
    @Test
    public void testSetFila() {
        ficha.setFila(2);
        assertEquals(2, ficha.getFila());
    }

    /**
     * Prueba para el método setColumna.
     */
    @Test
    public void testSetColumna() {
        ficha.setColumna(2);
        assertEquals(2, ficha.getColumna());
    }

    /**
     * Prueba para el método getVidas.
     */
    @Test
    public void testGetVidas() {
        assertEquals(3, ficha.getVidas());
    }

    /**
     * Prueba para el método setNombreJugador.
     */
    @Test
    public void testSetNombreJugador() {
        ficha.setNombreJugador("NuevoJugador");
        assertEquals("NuevoJugador", ficha.getNombreJugador());
    }

    /**
     * Prueba para el método getNombreJugador.
     */
    @Test
    public void testGetNombreJugador() {
        assertEquals("Jugador1", ficha.getNombreJugador());
    }

    /**
     * Prueba para el método reducirVidas.
     */
    @Test
    public void testReducirVidas() {
        ficha.reducirVidas(2);
        assertEquals(1, ficha.getVidas());
    }
}