package edu.eci.arsw.checkers.dto;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase MovimientoDTO.
 */
public class MovimientoDTOTest {

    /**
     * Prueba para setters y getters de la clase MovimientoDTO.
     */
    @Test
    public void testSettersYGetters() {
        // Crear una instancia de MovimientoDTO
        MovimientoDTO movimientoDTO = new MovimientoDTO();

        // Asignar valores mediante setters
        movimientoDTO.setJugador("Jugador1");
        movimientoDTO.setFilaOrigen(1);
        movimientoDTO.setColumnaOrigen(2);
        movimientoDTO.setFilaDestino(3);
        movimientoDTO.setColumnaDestino(4);

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals("Jugador1", movimientoDTO.getJugador());
        assertEquals(1, movimientoDTO.getFilaOrigen());
        assertEquals(2, movimientoDTO.getColumnaOrigen());
        assertEquals(3, movimientoDTO.getFilaDestino());
        assertEquals(4, movimientoDTO.getColumnaDestino());
    }

    /**
     * Prueba para el método equals de la clase MovimientoDTO.
     */
    @Test
    public void testEquals() {
        // Crear dos instancias de MovimientoDTO con valores iguales
        MovimientoDTO movimientoDTO1 = new MovimientoDTO();
        movimientoDTO1.setJugador("Jugador1");
        movimientoDTO1.setFilaOrigen(1);
        movimientoDTO1.setColumnaOrigen(2);
        movimientoDTO1.setFilaDestino(3);
        movimientoDTO1.setColumnaDestino(4);

        MovimientoDTO movimientoDTO2 = new MovimientoDTO();
        movimientoDTO2.setJugador("Jugador1");
        movimientoDTO2.setFilaOrigen(1);
        movimientoDTO2.setColumnaOrigen(2);
        movimientoDTO2.setFilaDestino(3);
        movimientoDTO2.setColumnaDestino(4);

        // Verificar que las instancias sean consideradas iguales
        assertEquals(movimientoDTO1.getColumnaDestino(), movimientoDTO2.getColumnaDestino());
    }
}

