package edu.eci.arsw.checkers.dto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase JuegoDTO.
 */
public class JuegoDTOTest {

    /**
     * Prueba para el constructor y los getters de la clase JuegoDTO.
     */
    @Test
    public void testConstructorYGetters() {
        // Crear un TableroDTO con valores específicos
        TableroDTO tableroDTO = new TableroDTO(8, 8, null);

        // Crear un JuegoDTO con valores específicos
        JuegoDTO juegoDTO = new JuegoDTO("Jugador1", tableroDTO, true);

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals("Jugador1", juegoDTO.getJugadorActual());
        assertEquals(tableroDTO, juegoDTO.getTablero());
        assertTrue(juegoDTO.getButton());
    }

    /**
     * Prueba para los setters de la clase JuegoDTO.
     */
    @Test
    public void testSetters() {
        // Crear un TableroDTO con valores específicos
        TableroDTO tableroDTO = new TableroDTO(8, 8, null);

        // Crear un JuegoDTO con valores iniciales
        JuegoDTO juegoDTO = new JuegoDTO("Jugador1", null, false);

        // Asignar nuevos valores mediante setters
        juegoDTO.setJugadorActual("Jugador2");
        juegoDTO.setTablero(tableroDTO);
        juegoDTO.setButton(true);

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals("Jugador2", juegoDTO.getJugadorActual());
        assertEquals(tableroDTO, juegoDTO.getTablero());
        assertTrue(juegoDTO.getButton());
    }
}
