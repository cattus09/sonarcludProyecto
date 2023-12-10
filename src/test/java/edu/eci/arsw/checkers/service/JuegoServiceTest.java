package edu.eci.arsw.checkers.service;

import edu.eci.arsw.checkers.dto.JuegoDTO;
import edu.eci.arsw.checkers.dto.TableroDTO;
import edu.eci.arsw.checkers.dto.CasillaDTO;
import edu.eci.arsw.checkers.model.Ficha;
import edu.eci.arsw.checkers.model.Juego;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de pruebas para la clase {@link JuegoService}.
 */
public class JuegoServiceTest {

    private JuegoService juegoService;

    /**
     * Configura el entorno de prueba.
     */
    @Before
    public void setUp() {
        juegoService = new JuegoService();
    }

    /**
     * Prueba para el método {@link JuegoService#generarTokenUnico()}.
     */
    @Test
    public void testGenerarTokenUnico() {
        String token = juegoService.generarTokenUnico();
        assertNotNull(token);
        assertEquals(36, token.length());
    }

    /**
     * Prueba para el método {@link JuegoService#moverFicha(String, int, int, int, int)}.
     */
    @Test
    public void testObtenerEstadoJuego() {
        String tokenPartida = juegoService.generarTokenUnico();
        juegoService.registrarUsuario("Jugador1", tokenPartida);
        juegoService.registrarUsuario("Jugador2", tokenPartida);
        JuegoDTO juegoDTO = juegoService.obtenerEstadoJuego();
        assertNotNull(juegoDTO);
        assertEquals("Jugador1", juegoDTO.getJugadorActual());
        TableroDTO tableroDTO = juegoDTO.getTablero();
        assertNotNull(tableroDTO);
        List<CasillaDTO> casillasDTO = tableroDTO.getCasillas();
        assertNotNull(casillasDTO);
    }

    /**
     * Prueba para el método {@link JuegoService#pulsarBoton(String)}.
     */
    @Test
    public void testMoverFicha() {
        String tokenPartida = juegoService.generarTokenUnico();
        juegoService.registrarUsuario("Jugador1", tokenPartida);
        juegoService.registrarUsuario("Jugador2", tokenPartida);
        juegoService.moverFicha("Jugador1", 2, 1, 3, 2);
        Juego juego = juegoService.getJuego();
        assertNotNull(juego);
        Ficha ficha = juego.getTablero().getCasilla(3, 2).getFicha();
        assertNotNull(ficha);
        assertEquals("Jugador1", ficha.getNombreJugador());
    }

    @Test
    public void testPulsarBoton() {
        String tokenPartida = juegoService.generarTokenUnico();
        juegoService.registrarUsuario("Jugador1", tokenPartida);
        juegoService.registrarUsuario("Jugador2", tokenPartida);
        juegoService.pulsarBoton("Jugador1");
        Juego juego = juegoService.getJuego();
        assertNotNull(juego);
        assertEquals("Jugador2", juego.getJugadorActual().getNombre());
    }
}