package edu.eci.arsw.checkers.service;

/**
 * Hilo que gestiona el poder especial de los jugadores en el juego de damas.
 */
public class PlayerPowerThread extends Thread {

    private String jugadorPoder;
    private Object lock;
    private JuegoService juego;
    

    /**
     * Constructor de la clase `PlayerPowerThread`.
     *
     * @param lock Objeto de bloqueo para la sincronización.
     */
    public PlayerPowerThread(Object lock) {
        this.jugadorPoder = null;
        this.lock = lock;
        this.juego = null;
    }

    /**
     * Método que se ejecuta cuando el hilo comienza.
     *
     * @param jugadorPoder El nombre del jugador con el poder especial.
     * @param juego Servicio del juego utilizado para realizar acciones en el juego.
     */
    public void run(String jugadorPoder, JuegoService juego) {
        synchronized (lock) {
            this.juego = juego;
            if (this.jugadorPoder == null) {
                this.jugadorPoder = jugadorPoder;
                System.out.println("Jugador con poder: " + jugadorPoder);
                System.out.println(juego.getJuego().getJugadorActual().getNombre());
            }
            if (!juego.getJuego().getJugadorActual().getNombre().equals(jugadorPoder) && this.jugadorPoder != null) {
                juego.pulsarBoton(jugadorPoder);
                System.out.println("Se usó el poder del jugador: " + jugadorPoder);
                this.jugadorPoder = null;
            }
        }
    }
}
