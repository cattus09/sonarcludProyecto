package edu.eci.arsw.checkers.service;

import edu.eci.arsw.checkers.dto.JuegoDTO;
import edu.eci.arsw.checkers.dto.TableroDTO;
import edu.eci.arsw.checkers.dto.CasillaDTO;
import edu.eci.arsw.checkers.dto.FichaDTO;
import edu.eci.arsw.checkers.model.Casilla;
import edu.eci.arsw.checkers.model.Ficha;
import edu.eci.arsw.checkers.model.Juego;
import edu.eci.arsw.checkers.model.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar la lógica del juego de damas.
 */
@Service
public class JuegoService {
    private Juego juego;
    private Map<String, List<String>> partidasTokens = new HashMap<>();
    private int contadorMovimientos = 1;

    /**
     * Constructor por defecto de la clase `JuegoService`.
     * Genera un token único para una nueva partida y lo asocia con una lista de jugadores vacía.
     */
    public JuegoService() {
        String tokenPartida = generarTokenUnico();  // Genera un token único
        partidasTokens.put(tokenPartida, new ArrayList<>()); 
    }

    /**
     * Genera un token único utilizando UUID.
     *
     * @return El token único generado.
     */
    public String generarTokenUnico() {
        String token = UUID.randomUUID().toString();
        System.out.println("\n\n"+token+"\n\n");
        return token;
    }

    /**
     * Constructor de la clase `JuegoService` que toma un juego existente como parámetro.
     *
     * @param juego El juego existente.
     */
    public JuegoService(Juego juego) {
        this.juego = juego;
    }

    /**
     * Obtiene el estado actual del juego en formato `JuegoDTO`.
     *
     * @return El estado actual del juego.
     */
    public JuegoDTO obtenerEstadoJuego() {
        String jugadorActual = juego.getJugadorActual().getNombre();
        TableroDTO tableroDTO = crearTableroDTO(juego.getTablero());
        contadorMovimientos++;
        if (contadorMovimientos % 5 == 0) {
            return new JuegoDTO(jugadorActual, tableroDTO,true);
        }
        return new JuegoDTO(jugadorActual, tableroDTO,false);
    }

    /**
     * Obtiene la cantidad de jugadores en una partida identificada por el token.
     *
     * @param tokenPartida El token de la partida.
     * @return La cantidad de jugadores en la partida.
     */
    public int getCantidadJugadores(String tokenPartida){
        List<String> jugadores = partidasTokens.get(tokenPartida);
        if (jugadores != null) {
            return jugadores.size();
        } else {
            System.out.println("el token es " + tokenPartida);
            return 0;
        }
    }
    
    /**
     * Crea un `TableroDTO` a partir de un `Tablero`.
     *
     * @param tablero El tablero del juego.
     * @return El `TableroDTO` creado.
     */
    private TableroDTO crearTableroDTO(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        List<CasillaDTO> casillasDTO = new ArrayList<>();
    
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Casilla casilla = tablero.getCasilla(fila, columna);
                CasillaDTO casillaDTO = crearCasillaDTO(casilla);
                casillasDTO.add(casillaDTO);
            }
        }
    
        return new TableroDTO(filas, columnas, casillasDTO);
    }
    
    /**
     * Crea un `CasillaDTO` a partir de una `Casilla`.
     *
     * @param casilla La casilla del tablero.
     * @return El `CasillaDTO` creado.
     */
    private CasillaDTO crearCasillaDTO(Casilla casilla) {
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        boolean vacia = casilla.estaVacia();
        FichaDTO fichaDTO = null;
    
        if (!vacia) {
            Ficha ficha = casilla.getFicha();
            fichaDTO = crearFichaDTO(ficha);
        }
    
        return new CasillaDTO(fila, columna, vacia, fichaDTO);
    }
    
    /**
     * Registra un nuevo usuario en una partida identificada por el token.
     *
     * @param nombreUsuario El nombre del nuevo usuario.
     * @param tokenPartida El token de la partida.
     */
    public void registrarUsuario(String nombreUsuario, String tokenPartida) {
        if(partidasTokens.get(tokenPartida) == null){
            partidasTokens.put(tokenPartida, new ArrayList<>());
        }
        List<String> jugadores = partidasTokens.get(tokenPartida);
        
 
        if (jugadores != null && jugadores.size() < 2) {
            jugadores.add(nombreUsuario);
            if (jugadores.size() == 2){
                juego = new Juego(jugadores.get(0), jugadores.get(1), tokenPartida);
            }
        } else {
            throw new RuntimeException("El token de la partida no es válido o la partida está llena.");
        }
    }

    /**
     * Crea un `FichaDTO` a partir de una `Ficha`.
     *
     * @param ficha La ficha del juego.
     * @return El `FichaDTO` creado.
     */
    private FichaDTO crearFichaDTO(Ficha ficha) {
        int vidas = ficha.getVidas();
        int fila = ficha.getFila();
        int columna = ficha.getColumna();
        String nombreJugador = ficha.getNombreJugador();
    
        return new FichaDTO(vidas, fila, columna, nombreJugador);
    }

    
    /**
     * Mueve una ficha en el juego.
     *
     * @param jugador El nombre del jugador que realiza el movimiento.
     * @param filaOrigen La fila de origen de la ficha.
     * @param columnaOrigen La columna de origen de la ficha.
     * @param filaDestino La fila de destino de la ficha.
     * @param columnaDestino La columna de destino de la ficha.
     */
    public void moverFicha(String jugador, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        juego.moverFicha(jugador, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
    }

    /**
     * Cambia el turno del juego.
     *
     * @param jugador El nombre del jugador que cambia el turno.
     */
    public void pulsarBoton(String jugador) {
            juego.cambiarTurno();
        System.out.println("Nuevo turno para " + jugador );
    }

    /**
     * Obtiene el juego actual.
     *
     * @return El juego actual.
     */
    public Juego getJuego() {
        return juego;
    }


}