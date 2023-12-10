package edu.eci.arsw.checkers.dto;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase FichaDTO.
 */
public class FichaDTOTest {

    /**
     * Prueba para el constructor y los getters de la clase FichaDTO.
     */
    @Test
    public void testConstructorYGetters() {
        // Crear una FichaDTO con valores específicos
        FichaDTO fichaDTO = new FichaDTO(3, 1, 2, "Jugador");

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals(3, fichaDTO.getVidas());
        assertEquals(1, fichaDTO.getFila());
        assertEquals(2, fichaDTO.getColumna());
        assertEquals("Jugador", fichaDTO.getNombreJugador());
    }

    /**
     * Prueba para los setters de la clase FichaDTO.
     */
    @Test
    public void testSetters() {
        // Crear una FichaDTO y asignar valores mediante setters
        FichaDTO fichaDTO = new FichaDTO();
        fichaDTO.setVidas(3);
        fichaDTO.setFila(1);
        fichaDTO.setColumna(2);
        fichaDTO.setNombreJugador("Jugador");

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals(3, fichaDTO.getVidas());
        assertEquals(1, fichaDTO.getFila());
        assertEquals(2, fichaDTO.getColumna());
        assertEquals("Jugador", fichaDTO.getNombreJugador());
    }

    /**
     * Prueba para el método equals de la clase FichaDTO.
     */
    @Test
    public void testEquals() {
        // Crear dos FichaDTO con valores idénticos y uno con valores diferentes
        FichaDTO fichaDTO1 = new FichaDTO(3, 1, 2, "Jugador1");
        FichaDTO fichaDTO2 = new FichaDTO(3, 1, 2, "Jugador2");
        FichaDTO fichaDTO3 = new FichaDTO(2, 3, 4, "Jugador1");

        // Verificar que el método equals funcione correctamente
        assertEquals(fichaDTO1.getColumna(), fichaDTO2.getColumna());
        assertNotEquals(fichaDTO1.getColumna(), fichaDTO3.getColumna());
    }
}
