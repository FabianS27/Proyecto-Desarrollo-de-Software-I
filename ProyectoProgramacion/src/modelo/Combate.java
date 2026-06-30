package modelo;

import controlador.ControladorTienda;
import vista.Escritor;
import vista.Lector;

// Clase que representa un combate entre un protagonista y un enemigo
public class Combate {
    // Atributos de la clase Combate
    private Protagonista protagonista;
    private Enemigo enemigo;
    private Escritor escritor;
    private Lector lector;
    private ControladorTienda controladorTienda;

    // Constructor de la clase Combate
    public Combate(Protagonista protagonista, Enemigo enemigo, Lector lector, Escritor escritor) {
        this.protagonista = protagonista;
        this.enemigo = enemigo;
        this.lector = lector;
        this.escritor = escritor;
    }

    // Método que inicia el combate entre el protagonista y el enemigo
    public void iniciarCombate() {
        escritor.mostrarMensaje("¡Te adentras en lo desconocido y te topas con un " + enemigo.getNombre() + "!");

        boolean jugadorRendido = false;

        // Bucle principal del combate
        while (!combateTerminado() && !jugadorRendido) {

            // Se muestra el estado actual del combate
            int accion = lector.leerOpcion("TURNO DEL JUGADOR: " + protagonista.getNombre()
                    + "\n" + "Seleccione una opción:\n"
                    + "1. Atacar\n2. Usar poción\n3. Ver estado\n4. Rendirse", 1, 4);

            // se ejecuta la acción seleccionada por el jugador
            switch (accion) {

                case 1:
                    // Se ejecuta el ataque del protagonista y del enemigo
                    int danioAEnemigo = atacarEnemigo();
                    int danioAlJugador = turnoEnemigo();
                    escritor.mostrarMensaje(
                            "RESULTADO DEL ATAQUE \n\n"
                                    + "Tu ataque causó " + danioAEnemigo + " puntos de daño al enemigo.\n"
                                    + "El enemigo te atacó causando " + danioAlJugador + " puntos de daño.\n\n"
                                    + "Tu vida: " + protagonista.getVida()
                                    + "\nVida del enemigo: " + enemigo.getVida());
                    break;

                case 2:
                    // Se ejecuta el uso de poción

                    int tipoPocion = lector.leerOpcion("¿Que poción deseas usar?\n1. Poción de vitalidad (Tienes: "
                            + protagonista.getCantidadPocionVitalidad() + ")\n2. Poción de Resistencia (Tienes: "
                            + protagonista.getCantidadPocionResistencia() + ")", 1, 2);

                    if (tipoPocion == 1) {
                        if (protagonista.getCantidadPocionVitalidad() <= 0) {
                            escritor.mostrarError("¡No te quedan pociones de vitalidad disponibles!");
                        } else if (protagonista.getVida() >= 100) {
                            escritor.mostrarMensaje("No puedes usar una poción de vitalidad. \n\n"
                                    + "Tu vida ya está al máximo: " + protagonista.getVida());
                        } else {
                            protagonista.usarPocionVitalidad(20);

                            // Forzamos un tope de 100 puntos de vida máximos si la suma se pasa
                            if (protagonista.getVida() > 100) {
                                protagonista.setVida(100);
                            }
                            // Se muestra un mensaje indicando que se ha usado la poción y la vida actual
                            // del protagonista
                            escritor.mostrarMensaje(
                                    "POCIÓN USADA \n\n"
                                            + "Recuperaste 20 puntos de vida.\n"
                                            + "Tu vida actual: " + protagonista.getVida()
                                            + "\nPociones de vitalidad restantes: "
                                            + protagonista.getCantidadPocionVitalidad());
                        }
                    } else if (tipoPocion == 2) {
                        // Lógica para poción resistencia
                        if (protagonista.getCantidadPocionResistencia() <= 0) {
                            escritor.mostrarError("¡No te quedan pociones de resistencia disponibles!");

                        } else {
                            protagonista.usarPocionResistencia();

                            // Aumenta la defensa del protagonista

                            protagonista.setDefensa(protagonista.getDefensa() + 10);
                            // Se muestra un mensaje indicando que se ha usado la poción y la defensa actual
                            // del protagonista
                            escritor.mostrarMensaje(
                                    "POCIÓN DE RESISTENCIA USADA\n\nTu defensa ha aumentado en 10 puntos.\n"
                                            + "Defensa actual: " + protagonista.getDefensa()
                                            + "\nPociones de resistencia restantes: "
                                            + protagonista.getCantidadPocionResistencia());

                        }
                    }
                    break;

                case 3:
                    // Se muestra el estado actual del combate sin consumir un turno
                    escritor.mostrarEstado(obtenerEstadoCombate());
                    continue; // No consume turno, vuelve al inicio del while

                case 4:
                    // Se establece que el jugador se ha rendido y se termina el combate
                    jugadorRendido = true;
                    protagonista.setDerrotasTotales();
                    break;
            }

        }

        // Se asigna si se ganó o perdió con el método verificarGanador
        if (jugadorRendido) {
            escritor.mostrarMensaje("Te has rendido cobardemente, ¡Fin del juego!");
        } else {
            String resultado = verificarGanador(); // Retorna "Ronda ganada" o "Ronda perdida"
            if (resultado.equalsIgnoreCase("Ronda ganada")) {
                protagonista.setVictoriasTotales();
                // Se obtiene la recompensa del enemigo y se entrega al protagonista
                int montoGanado = enemigo.getRecompensa();

                protagonista.recibirRecompensa(montoGanado);
                // Se muestra un mensaje indicando que se ha ganado el combate y la recompensa
                // obtenida
                escritor.mostrarMensaje("¡Felicidades! ¡Has ganado el combate!" + "\n\n"
                        + "Has obtenido la siguiente recompensa: ¥"
                        + montoGanado + " por derrotar a "
                        + enemigo.getNombre() + "!\n"
                        + "Tu saldo actual es: ¥" + protagonista.getDinero());
            } else {
                // Se incrementa el contador de derrotas del protagonista y se muestra un
                // mensaje indicando que se ha perdido el combate
                protagonista.setDerrotasTotales();
                escritor.mostrarMensaje("Has perdido... Fin del juego.");
            }
        }
    }

    // Método que realiza el ataque del enemigo al protagonista y devuelve el daño
    // real causado
    public int atacarProtagonista() {
        // 1. Calculamos el daño crudo (Ataque base + daño aleatorio del arma)
        int danioCrudo = enemigo.getAtaque() + enemigo.getArma().generarDanio();

        // 2. Restamos la defensa del protagonista para sacar el daño real
        int danioReal = danioCrudo - protagonista.getDefensa();
        if (danioReal < 0) {
            danioReal = 0;
        }

        // 3. Pasamos el daño neto al protagonista para que reduzca su salud
        protagonista.recibirDanio(danioReal);

        // 4. Retornamos el daño exacto que se aplicó a la barra de vida
        return danioReal;
    }

    // Método que realiza el ataque del protagonista al enemigo y devuelve el daño
    // real causado
    public int atacarEnemigo() {
        // 1. Calculamos el daño crudo (Ataque base + daño aleatorio del arma)
        int danioCrudo = protagonista.getAtaque() + protagonista.getArma().generarDanio();

        // 2. Restamos la defensa del enemigo para sacar el daño real
        int danioReal = danioCrudo - enemigo.getDefensa();
        if (danioReal < 0) {
            danioReal = 0;
        }

        // 3. Pasamos el daño neto al enemigo para que reduzca su salud
        enemigo.recibirDanio(danioReal);

        // 4. Retornamos el daño exacto que se aplicó a la barra de vida
        return danioReal;
    }

    // Método que realiza el turno del enemigo y devuelve el daño causado al
    // protagonista
    public int turnoEnemigo() {
        if (enemigo.estaVivo()) {
            return atacarProtagonista();
        }
        return 0;
    }

    // Método que verifica si el combate ha terminado, ya sea porque el protagonista
    // o el enemigo han muerto
    public boolean combateTerminado() {
        return !protagonista.estaVivo() || !enemigo.estaVivo();

    }

    // Método que verifica quién ha ganado el combate y devuelve un mensaje
    // indicando el resultado
    public String verificarGanador() {
        if (protagonista.estaVivo() && !enemigo.estaVivo()) {
            return "Ronda ganada";
        } else if (!protagonista.estaVivo()) {
            return "Ronda perdida";
        } else {

        }
        return "El combate continua";

    }

    // Método que obtiene el estado actual del combate, incluyendo las estadísticas
    // del protagonista y la información del enemigo
    public String obtenerEstadoCombate() {
        return "----- ESTADO DE PROTAGONISTA ----- \n" + protagonista.obtenerEstadisticas()
                + "\n\n ----- ESTADO DEL ENEMIGO ----- \n"
                + enemigo.obtenerInformacion();

    }
}
