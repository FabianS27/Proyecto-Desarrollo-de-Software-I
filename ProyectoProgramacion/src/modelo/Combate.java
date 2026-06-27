package modelo;

import vista.Escritor;
import vista.Lector;

public class Combate {

    private Protagonista protagonista;
    private Enemigo enemigo;
    private Escritor escritor;
    private Lector lector;

    public Combate(Protagonista protagonista, Enemigo enemigo, Lector lector, Escritor escritor) {
        this.protagonista = protagonista;
        this.enemigo = enemigo;
        this.lector = lector;
        this.escritor = escritor;
    } 

    // Creo que hay que borrarlos porque los get y sets del protagonista y enemigo están dentro de sus propias clases
    /*public Protagonista getProtagonista() {
        return protagonista;

    }


    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }

    public Enemigo getEnemigo() {
        return enemigo;

    }

    public void setEnemigo(Enemigo enemigo) {
        this.enemigo = enemigo;

    }*/

    public void iniciarCombate() {
        escritor.mostrarMensaje("MENSAJE DE INTRODUCCIÓN ENEMIGO");
        boolean jugadorRendido = false;

        // El bucle por turnos corre aquí adentro
        while (!combateTerminado() && !jugadorRendido) { 
            
            int accion = lector.leerOpcion("TURNO DEL JUGADOR " + protagonista.getNombre() 
            + "\n" + "Seleccione una opción:\n" 
            + "1. Atacar\n2. Usar poción\n3.Ver estado\n4. Rendirse", 1, 4);

            switch (accion) {
                case 1:
                    atacarEnemigo();
                    escritor.mostrarMensaje("¡Has atacado al enemigo!");
                break;

                case 2:
                    if(protagonista.getCantidadPociones() >0){
                        protagonista.usarPocion();
                        escritor.mostrarMensaje("¡Has usado una poción y recuperaste vida!");
                    } else {
                        escritor.mostrarError("¡No te quedan pociones disponibles!");
                        continue; //Repite el turno del jugador sin avanzar,  vuelve al inicio del while
                    }
                break;

                case 3:
                    escritor.mostrarEstado(obtenerEstadoCombate());
                    continue; // No consume turno, vuelve al inicio del while

                case 4:
                    jugadorRendido = true;
                break;
            }

            // Turno del enemigo (solo si el jugador no se rindió y el enemigo sigue vivo)
            if(!jugadorRendido) {
                turnoEnemigo();
                if(enemigo.estaVivo()) {
                    escritor.mostrarMensaje("El enemigo ha contraatacado");
                }
            }
            
        }   

    // Se asigna si se ganó o perdió con el método verificarGanador
    if(jugadorRendido) {
        escritor.mostrarMensaje("Te has rendido cobardemente, ¡Fín del juego!");
    } else {
        String resultado = verificarGanador(); // Retorna "Ronda ganada" o "Ronda perdida"
        if(resultado.equalsIgnoreCase("Ronda ganada")) {
            escritor.mostrarMensaje("¡Felicidades! ¡Has ganado el combate!");
        } else {
            escritor.mostrarMensaje("Has perdido... Fin del juego.");
        }
    }
}

    public void atacarProtagonista() {
        int danio = enemigo.getAtaque() + enemigo.getArma().generarDanio();
        protagonista.recibirDanio(danio);

    }

    public void atacarEnemigo() {
        int danio = protagonista.getAtaque() + protagonista.getArma().generarDanio();
        enemigo.recibirDanio(danio);
    }

    public void turnoEnemigo() {
        if (enemigo.estaVivo()) {
            atacarProtagonista();
        }
    }

    public boolean combateTerminado() {
        return !protagonista.estaVivo() || !enemigo.estaVivo();

    }

    public String verificarGanador() {
        if (protagonista.estaVivo() && !enemigo.estaVivo()) {
            return "Ronda ganada";
        } else if (!protagonista.estaVivo()) {
            return "Ronda perdida";
        } else {

        }
        return "El combate continua";

    }

    public String obtenerEstadoCombate() {
        return "Estado protagonista: \n" + protagonista.obtenerEstadisticas() + "\n Estado del villano : \n" + enemigo.obtenerInformacion();

    }


}
