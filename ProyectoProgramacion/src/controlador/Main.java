package controlador;

import modelo.Arma;
import modelo.Combate;
import modelo.Enemigo;
import modelo.Protagonista;
import vista.Lector;
import vista.Escritor;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar la vista
        Lector lector = new Lector();
        Escritor escritor = new Escritor();

        // 2. Mostrar la bienvenida
        escritor.mostrarMensaje("BIENVENIDO AL MINI RPG");

        // 3. Pedir los datos iniciales para crear al heroe
        String nombreProtagonista = lector.leerTexto("Digite el nombre del protagonista por favor: ");

        // Crear el arma del protagonista
        Arma armaProtagonista = new Arma(nombreProtagonista, 0, 0);

        // 4. Crear los personajes (Protagonista y Enemigo)
        Protagonista protagonista = new Protagonista(nombreProtagonista, 0, 0, 0, armaProtagonista, 0);
        Arma armaEnemigo = new Arma(nombreProtagonista, 0, 0);
        Enemigo enemigo = new Enemigo(nombreProtagonista, 0, 0, 0, armaEnemigo, nombreProtagonista);

        // 5. Crear el objeto Combate
        Combate combate = new Combate(protagonista, enemigo, lector, escritor);

        //7. Se muestra una pequeña despedida al jugador cuaando el combate termina
        escritor.mostrarMensaje("¡Gracias por jugar!");

    }

}
