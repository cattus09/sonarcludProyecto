package edu.eci.arsw.checkers.controller;

import org.springframework.web.bind.annotation.*;
import edu.eci.arsw.checkers.dto.JuegoDTO;
import edu.eci.arsw.checkers.service.JuegoService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/juego")
public class JuegoController {

    private final JuegoService juegoService;
    private final SimpMessagingTemplate messagingTemplate;
    private int contadorMovimientos = 0;

    public JuegoController(JuegoService juegoService, SimpMessagingTemplate messagingTemplate) {
        this.juegoService = juegoService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/verificar-jugadores")
    public ResponseEntity<Integer> verificarJugadores(@RequestParam String token) {
        int jugadores = juegoService.getCantidadJugadores(token);
        return ResponseEntity.ok(jugadores);
    }
    
    @GetMapping("/estado")
    public JuegoDTO obtenerEstadoJuego() {
        return juegoService.obtenerEstadoJuego();
    }
    @GetMapping("/generar-token")
    public ResponseEntity<String> generarTokenUnico() {
        String nuevoToken = juegoService.generarTokenUnico();
        return ResponseEntity.ok(nuevoToken);
    }

    @PostMapping("/mover-ficha")
    public ResponseEntity<JuegoDTO> moverFicha(@RequestParam String jugador, @RequestParam int filaOrigen, @RequestParam int columnaOrigen, @RequestParam int filaDestino, @RequestParam int columnaDestino) {
        juegoService.moverFicha(jugador, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
        JuegoDTO estadoJuego = juegoService.obtenerEstadoJuego();
        contadorMovimientos++;
        messagingTemplate.convertAndSend("/topic/gamestate", estadoJuego);
        if (contadorMovimientos == 5) {
            messagingTemplate.convertAndSend("/topic/showbutton", "MostrarBoton");
            contadorMovimientos = 0; 
        }
        return ResponseEntity.ok(estadoJuego);
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<String> registrarUsuario(@RequestParam String nombre, @RequestParam String token) {
        System.out.println(token);
        try {
            juegoService.registrarUsuario(nombre, token);
            return ResponseEntity.ok("Usuario registrado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/crear-juego")
    public void crearJuego() {
        JuegoDTO estadoJuego = juegoService.obtenerEstadoJuego();
        messagingTemplate.convertAndSend("/topic/gamestate", estadoJuego);
    }

    @PostMapping("/pulsar-boton")
    public ResponseEntity<?> pulsarBoton(@RequestBody Map<String, String> request) {
        String jugador = request.get("jugador");
        juegoService.pulsarBoton(jugador);
        return ResponseEntity.ok("Poder usado exitosamente");
    }
}