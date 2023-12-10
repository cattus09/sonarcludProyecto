package edu.eci.arsw.checkers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase Casilla.
 */
public class CasillaTest {
    private Casilla casilla;
    private Ficha ficha;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        ficha = new Ficha(0, 0, 0, null); 
        casilla = new Casilla(1, 1, ficha);
    }

    /**
     * Prueba para el método getFicha.
     */
    @Test
    public void testGetFicha() {
        assertEquals(ficha, casilla.getFicha());
    }

    /**
     * Prueba para el método setFicha.
     */
    @Test
    public void testSetFicha() {
        Ficha nuevaFicha = new Ficha(0, 0, 0, null);
        casilla.setFicha(nuevaFicha);
        assertEquals(nuevaFicha, casilla.getFicha());
    }

    /**
     * Prueba para el método estaVacia.
     */
    @Test
    public void testEstaVacia() {
        assertFalse(casilla.estaVacia());
        casilla.setFicha(null);
        assertTrue(casilla.estaVacia());
    }

    /**
     * Prueba para el método getFila.
     */
    @Test
    public void testGetFila() {
        assertEquals(1, casilla.getFila());
    }

    /**
     * Prueba para el método getColumna.
     */
    @Test
    public void testGetColumna() {
        assertEquals(1, casilla.getColumna());
    }

    /**
     * Prueba para el método esCasillaBlanca.
     */
    @Test
    public void testEsCasillaBlanca() {
        Casilla casillaBlanca = new Casilla(2, 2, ficha); 
        assertTrue(casillaBlanca.esCasillaBlanca());
    }

    /**
     * Prueba para el método esCasillaNegra.
     */
    @Test
    public void testEsCasillaNegra() { 
        Casilla casillaBlanca = new Casilla(2, 2, ficha); 
        assertFalse(casillaBlanca.esCasillaNegra());
    }
}
