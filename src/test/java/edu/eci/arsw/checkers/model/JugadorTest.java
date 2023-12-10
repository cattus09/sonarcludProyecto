package edu.eci.arsw.checkers.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase Jugador.
 */
public class JugadorTest {
    private Jugador jugador;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        jugador = new Jugador("Jugador1", "arriba");
    }

    /**
     * Prueba para el método getNombre.
     */
    @Test
    public void testGetNombre() {
        assertEquals("Jugador1", jugador.getNombre());
    }

    /**
     * Prueba para el método getPosicion.
     */
    @Test
    public void testGetPosicion() {
        assertEquals("arriba", jugador.getPosicion());
    }

    /**
     * Prueba para el método tieneTurno.
     */
    @Test
    public void testTieneTurno() {
        assertFalse(jugador.tieneTurno()); 
    }

    /**
     * Prueba para el método cambiarTurno.
     */
    @Test
    public void testCambiarTurno() {
        jugador.cambiarTurno();
        assertTrue(jugador.tieneTurno());
    }

    /**
     * Prueba para el método agregarFicha.
     */
    @Test
    public void testAgregarFicha() {
        Ficha ficha = new Ficha(0, 0, 0, null); 
        jugador.agregarFicha(ficha);
        assertTrue(jugador.getFichas().contains(ficha));
    }

    /**
     * Prueba para el método getFichas.
     */
    @Test
    public void testGetFichas() {
        Ficha ficha1 = new Ficha(0, 0, 0, null);
        Ficha ficha2 = new Ficha(0, 0, 0, null);
        jugador.agregarFicha(ficha1);
        jugador.agregarFicha(ficha2);
        assertEquals(2, jugador.getFichas().size());
    }
}
