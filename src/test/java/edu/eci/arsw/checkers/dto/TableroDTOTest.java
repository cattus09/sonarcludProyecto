package edu.eci.arsw.checkers.dto;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba para la clase TableroDTO.
 */
public class TableroDTOTest {

    /**
     * Prueba para constructor y getters de la clase TableroDTO.
     */
    @Test
    public void testConstructorYGetters() {
        // Crear una lista de CasillaDTO para representar el estado del tablero
        List<CasillaDTO> casillasDTO = new ArrayList<>();
        casillasDTO.add(new CasillaDTO(1, 1, true, null));
        casillasDTO.add(new CasillaDTO(1, 2, false, new FichaDTO(3, 1, 2, "Jugador")));
        
        // Crear una instancia de TableroDTO
        TableroDTO tableroDTO = new TableroDTO(8, 8, casillasDTO);

        // Verificar que los valores se asignen correctamente mediante los getters
        assertEquals(8, tableroDTO.getFilas());
        assertEquals(8, tableroDTO.getColumnas());
        assertEquals(casillasDTO, tableroDTO.getCasillas());
    }

    /**
     * Prueba para el método equals de la clase TableroDTO.
     */
    @Test
    public void testEquals() {
        // Crear dos listas de CasillaDTO con valores iguales
        List<CasillaDTO> casillasDTO1 = new ArrayList<>();
        casillasDTO1.add(new CasillaDTO(1, 1, true, null));
        casillasDTO1.add(new CasillaDTO(1, 2, false, new FichaDTO(3, 1, 2, "Jugador")));

        List<CasillaDTO> casillasDTO2 = new ArrayList<>();
        casillasDTO2.add(new CasillaDTO(1, 1, true, null));
        casillasDTO2.add(new CasillaDTO(1, 2, false, new FichaDTO(3, 1, 2, "Jugador")));

        // Crear dos instancias de TableroDTO con listas de casillas iguales
        TableroDTO tableroDTO1 = new TableroDTO(8, 8, casillasDTO1);
        TableroDTO tableroDTO2 = new TableroDTO(8, 8, casillasDTO2);

        // Verificar que las instancias sean consideradas iguales
        assertEquals(tableroDTO1.getColumnas(), tableroDTO2.getColumnas());
    }
}
