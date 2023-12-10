package edu.eci.arsw.checkers.dto;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase CasillaDTO.
 */
public class CasillaDTOTest {

    /**
     * Prueba para el constructor y los getters de la clase CasillaDTO.
     */
    @Test
    public void testConstructorYGetters() {
        // Crear una FichaDTO para usar en la CasillaDTO
        FichaDTO fichaDTO = new FichaDTO(1, 2, 3, "Jugador");

        // Crear una CasillaDTO con valores específicos
        CasillaDTO casillaDTO = new CasillaDTO(4, 5, true, fichaDTO);

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals(4, casillaDTO.getFila());
        assertEquals(5, casillaDTO.getColumna());
        assertTrue(casillaDTO.isVacia());
        assertEquals(fichaDTO, casillaDTO.getFicha());
    }

    /**
     * Prueba para el método equals de la clase CasillaDTO.
     */
    @Test
    public void testEquals() {
        // Crear dos FichaDTO con valores idénticos
        FichaDTO fichaDTO1 = new FichaDTO(1, 2, 3, "Jugador1");
        FichaDTO fichaDTO2 = new FichaDTO(1, 2, 3, "Jugador2");

        // Crear dos CasillaDTO con valores idénticos y uno con valores diferentes
        CasillaDTO casillaDTO1 = new CasillaDTO(4, 5, true, fichaDTO1);
        CasillaDTO casillaDTO2 = new CasillaDTO(4, 5, true, fichaDTO2);
        CasillaDTO casillaDTO3 = new CasillaDTO(6, 7, false, null);

        // Verificar que el método equals funcione correctamente
        assertEquals(casillaDTO1.getColumna(), casillaDTO2.getColumna());
        assertNotEquals(casillaDTO1.getColumna(), casillaDTO3.getColumna());
    }

}