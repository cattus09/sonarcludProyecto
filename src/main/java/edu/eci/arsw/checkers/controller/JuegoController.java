package edu.eci.arsw.checkers.controller;

import org.springframework.web.bind.annotation.*;
import edu.eci.arsw.checkers.dto.JuegoDTO;
import edu.eci.arsw.checkers.service.JuegoService;
import edu.eci.arsw.checkers.service.PlayerPowerThread;

import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Controlador que gestiona las operaciones relacionadas con el juego de damas.
 */
@CrossOrigin(origins = {"http://20.22.63.5", "http://20.22.63.5:8080", "http://checkers.eastus.cloudapp.azure.com" , "http://checkersplay.azurewebsites.net/", "http://172.178.33.192/" ,"http://scheckersplay.eastus.cloudapp.azure.com/"})
@RestController
@RequestMapping("/api/juego")
public class JuegoController {

    private final JuegoService juegoService;
    private final SimpMessagingTemplate messagingTemplate;
    private PlayerPowerThread PlayerPowerThread = new PlayerPowerThread(lock);
    private static Object lock = new Object();

     /**
     * Constructor del controlador.
     *
     * @param juegoService       Servicio encargado de la lógica del juego.
     * @param messagingTemplate Template de mensajería para enviar mensajes a través de WebSocket.
     */
    public JuegoController(JuegoService juegoService, SimpMessagingTemplate messagingTemplate) {
        this.juegoService = juegoService;
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Obtiene el número de jugadores en una partida.
     *
     * @param token Token único de la partida.
     * @return ResponseEntity con el número de jugadores.
     */
    @GetMapping("/verificar-jugadores")
    public ResponseEntity<Integer> verificarJugadores(@RequestParam String token) {
        int jugadores = juegoService.getCantidadJugadores(token);
        return ResponseEntity.ok(jugadores);
    }
    
    /**
     * Obtiene el estado actual del juego.
     *
     * @return El estado del juego en formato JuegoDTO.
     */
    @GetMapping("/estado")
    public JuegoDTO obtenerEstadoJuego() {
        return juegoService.obtenerEstadoJuego();
    }

    /**
     * Genera un token único para una partida.
     *
     * @return ResponseEntity con el nuevo token generado.
     */
    @GetMapping("/generar-token")
    public ResponseEntity<String> generarTokenUnico() {
        String nuevoToken = juegoService.generarTokenUnico();
        return ResponseEntity.ok(nuevoToken);
    }

    /**
     * Mueve una ficha en el tablero del juego.
     *
     * @param jugador        Nombre del jugador que realiza el movimiento.
     * @param filaOrigen     Fila de origen de la ficha.
     * @param columnaOrigen  Columna de origen de la ficha.
     * @param filaDestino    Fila de destino de la ficha.
     * @param columnaDestino Columna de destino de la ficha.
     * @return ResponseEntity con el estado actualizado del juego.
     */
    @PostMapping("/mover-ficha")
    public ResponseEntity<JuegoDTO> moverFicha(@RequestParam String jugador, @RequestParam int filaOrigen, @RequestParam int columnaOrigen, @RequestParam int filaDestino, @RequestParam int columnaDestino) {
        juegoService.moverFicha(jugador, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
        JuegoDTO estadoJuego = juegoService.obtenerEstadoJuego();
        
        messagingTemplate.convertAndSend("/topic/gamestate", estadoJuego);
        return ResponseEntity.ok(estadoJuego);
    }

    /**
     * Registra a un usuario en una partida.
     *
     * @param nombre Nombre del usuario.
     * @param token  Token único de la partida.
     * @return ResponseEntity con el resultado del registro.
     */
    @PostMapping("/registrar-usuario")
    public ResponseEntity<String> registrarUsuario(@RequestParam String nombre, @RequestParam String token) {
        String caracteresEsp = "^[a-zA-Z0-9]+$";
        System.out.println(token);
        if (!Pattern.matches(caracteresEsp, nombre) || !Pattern.matches(caracteresEsp, token)) {
            return ResponseEntity.badRequest().body("Datos de entrada inválidos.");
        }
        try {
            juegoService.registrarUsuario(nombre, token);
            return ResponseEntity.ok("Usuario registrado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Crea una nueva partida y envía su estado inicial a través de WebSocket.
     */
    @PostMapping("/crear-juego")
    public void crearJuego() {
        JuegoDTO estadoJuego = juegoService.obtenerEstadoJuego();
        messagingTemplate.convertAndSend("/topic/gamestate", estadoJuego);
    }

    /**
     * Inicia la ejecución de un poder especial asociado a un jugador.
     *
     * @param request Mapa que contiene el nombre del jugador.
     * @return ResponseEntity con un mensaje indicando que el poder fue usado exitosamente.
     */
    @PostMapping("/pulsar-boton")
    public ResponseEntity<?> pulsarBoton(@RequestBody Map<String, String> request) {
        messagingTemplate.convertAndSend("/topic/hidebutton", "hide");
        String jugador = request.get("jugador");
        System.out.println("jugador: " + jugador);
        PlayerPowerThread playerPowerThread = new PlayerPowerThread(lock);  
        playerPowerThread.run(jugador, juegoService);
        return ResponseEntity.ok("Poder usado exitosamente");
    }

    /**
     * Actualiza el estado del botón de un poder especial.
     *
     * @param request Mapa que contiene el estado del botón.
     * @return ResponseEntity con el estado del botón.
     */
    @PostMapping("/button-true")
    public ResponseEntity<?> buttonTrue(@RequestBody Map<String, Boolean> request) {
        Boolean button = request.get("button");
        return ResponseEntity.ok(button);
    }
}