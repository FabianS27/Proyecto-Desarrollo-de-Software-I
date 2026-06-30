package controlador;

//llamado de las clases necesarias para el funcionamiento del juego
import modelo.Arma;
import modelo.Combate;
import modelo.Enemigo;
import modelo.Protagonista;
import modelo.Tienda;
import vista.Escritor;
import vista.Lector;

// Clase principal del juego, donde se ejecuta el programa
public class Main {

    public static void main(String[] args) {
        // 1. Inicializar la vista
        Lector lector = new Lector();
        Escritor escritor = new Escritor();
        Tienda tienda = new Tienda();

        // 2. Mostrar la bienvenida
        escritor.mostrarMensaje("<html>"
                + "<div style='text-align: center; width: 320px; font-family: Dialog;'>"
                + "<div style='font-size: 22px; font-weight: bold;'>⚔️ ¡BIENVENIDO! ⚔️</div>"
                + "<br>"
                + "<div style='font-size: 18px; font-weight: bold;'>Honor de Sangre</div>"
                + "<div style='font-size: 14px; font-style: italic;'>El último juramento</div>"
                + "</div>"
                + "</html>");

        // 3. Pedir los datos iniciales para crear al protagonista
        String nombreProtagonista = lector.leerTexto("Digite el nombre del protagonista por favor: ");

        // 4. Pedir seleccionar el arma del protagonista
        int opcionArma = lector.leerOpcion(
                "Seleccione el arma de su protagonista:\n1. Filo del Juramento (Daño: 20 a 40) \n2. Navaja Vorpal (Daño: 20 a 50)\n3. Hacha de Lagrimas (Daño: 30 a 60) ",
                1, 3);

        // 5. Crear el arma del protagonista
        Arma armaProtagonista;

        switch (opcionArma) {
            case 1:
                armaProtagonista = new Arma("Filo del Juramento", 20, 40);
                break;
            case 2:
                armaProtagonista = new Arma("Navaja Vorpal", 20, 50);
                break;
            default:
                armaProtagonista = new Arma("Hacha de Lágrimas", 30, 60);
                break;
        }

        Protagonista protagonista = new Protagonista(nombreProtagonista, 100, 30, 5, armaProtagonista, 1000);

        // 6. Elegir la dificultad de la partida
        String menuDificultad = "Seleccioná la dificultad del juego:\n1. Fácil\n2. Medio\n3. Difícil";
        int opcionDificultad = lector.leerOpcion(menuDificultad, 1, 3);

        String dificultad;
        switch (opcionDificultad) {
            case 1:
                dificultad = "Fácil";
                break;
            case 2:
                dificultad = "Medio";
                break;
            default:
                dificultad = "Difícil";
                break;
        }

        // 7. Ingresar al menú principal del juego
        int opcionMenu;
        do {
            // menu principal
            String textoMenu = "=== MENÚ PRINCIPAL ===\n"
                    + "1. Iniciar combate\n"
                    + "2. Tienda\n"
                    + "3. Estado del protagonista\n"
                    + "4. Cambiar dificultad\n"
                    + "5. Salir del juego";

            opcionMenu = lector.leerOpcion(textoMenu, 1, 5);

            switch (opcionMenu) {
                // menú de combate, donde se crea un enemigo dependiendo de la dificultad
                // seleccionada,
                case 1:
                    Enemigo enemigo = null;
                    if (opcionDificultad == 1) {
                        Arma armaEnemigo = new Arma("Hacha siniestra", 0, 0);
                        enemigo = new Enemigo("Orco Oscuro", 100, 0, 0, armaEnemigo, dificultad, 250);
                        enemigo.aplicarDificultad();
                    } else if (opcionDificultad == 2) {
                        Arma armaEnemigo = new Arma("Tridente de las Penas", 0, 0);
                        enemigo = new Enemigo("Merfolk", 100, 0, 0, armaEnemigo, dificultad, 500);
                        enemigo.aplicarDificultad();
                    } else if (opcionDificultad == 3) {
                        Arma armaEnemigo = new Arma("Guadaña de la muerte", 0, 0);
                        enemigo = new Enemigo("Nigromante", 100, 0, 0, armaEnemigo, dificultad, 1000);
                        enemigo.aplicarDificultad();
                    }

                    // Esta validación inyecta las estadisticas de combate reales del enemigo según
                    // la dificultad
                    if (enemigo != null) {
                        enemigo.aplicarDificultad();
                    }

                    // Iniciar el combate entre el protagonista y el enemigo
                    Combate combate = new Combate(protagonista, enemigo, lector, escritor);
                    combate.iniciarCombate();

                    // Verificar si el protagonista ha sido derrotado y restaurar sus estadísticas
                    // si es necesario
                    if (!protagonista.estaVivo()) {
                        escritor.mostrarMensaje("=== ¡SISTEMA DE REANIMACIÓN! ===\n"
                                + "Has sido derrotado en batalla. Tus estadísticas han sido restauradas para el proximo combate.");

                        protagonista.restaurarProtagonista();
                    }
                    break;
                // menu de la tienda, donde se puede comprar armas y pociones
                case 2:
                    ControladorTienda tiendaControl = new ControladorTienda(tienda, protagonista, lector, escritor);
                    tiendaControl.iniciarTienda();
                    break;
                // opcion para mostrar las estadisticas del protagonista
                case 3:
                    String estadisticasActuales = " === ⚔️ ESTADO DEL PROTAGONISTA ⚔️ === \n"
                            + protagonista.obtenerEstadisticas();
                    escritor.mostrarEstado(estadisticasActuales);
                    break;
                // menu para cambiar la dificultad del juego
                case 4:
                    String menuDificultadCambio = "Seleccioná la dificultad del juego:\n1. Fácil\n2. Medio\n3. Difícil";
                    opcionDificultad = lector.leerOpcion(menuDificultadCambio, 1, 3);

                    switch (opcionDificultad) {
                        case 1:
                            dificultad = "Fácil";
                            break;
                        case 2:
                            dificultad = "Medio";
                            break;
                        default:
                            dificultad = "Difícil";
                            break;
                    }
                    escritor.mostrarMensaje("Has cambiado la dificultad a: " + dificultad);
                    break;
                // opcion para salir del juego
                case 5:
                    escritor.mostrarMensaje("Has abandonado el juego");
                    break;

            }

        } while (opcionMenu != 5);
        // 8. Se muestra una pequeña despedida al jugador cuando el combate termina
        escritor.mostrarMensaje("¡Gracias por jugar!");

    }
}
