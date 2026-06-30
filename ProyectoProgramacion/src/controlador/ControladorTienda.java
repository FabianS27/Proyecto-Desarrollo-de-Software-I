package controlador;

// importacion de clases necesarias
import modelo.Protagonista;
import modelo.Tienda;
import vista.Escritor;
import vista.Lector;

// Clase ControladorTienda que se encarga de manejar la lógica de la tienda
public class ControladorTienda {
    private Tienda tienda;
    private Protagonista protagonista;
    private Lector lector;
    private Escritor escritor;

    // Constructor de la clase ControladorTienda que recibe una instancia de Tienda,
    // Protagonista, Lector y Escritor
    public ControladorTienda(Tienda tienda, Protagonista protagonista, Lector lector, Escritor escritor) {
        this.tienda = tienda;
        this.protagonista = protagonista;
        this.lector = lector;
        this.escritor = escritor;
    }

    // Método iniciarTienda que muestra el menú de la tienda y permite al jugador
    // comprar pociones o ver su inventario
    public void iniciarTienda() {
        // Bucle que se ejecuta mientras el jugador no decida salir de la tienda
        boolean salir = false;
        while (!salir) {
            // Muestra el menú de la tienda y leer la opción seleccionada por el jugador
            int opcionTienda = lector.leerOpcion(
                    "🛒 TIENDA 🛒\n" + "Tienes ¥" + protagonista.getDinero() + "\n1. Poción de vitalidad (¥1000)"
                            + " Cantidad disponible:" + tienda.getCantidadPocionesVitalidadTienda()
                            + "\n2. Poción de Resistencia (¥1500)" + "Cantidad disponible: "
                            + tienda.getCantidadPocionesResistenciaTienda() + "\n3. Ver inventario" + "\n4. Salir",
                    1, 4);
            // Evaluar la opción seleccionada por el jugador y realizar la acción
            // correspondiente
            switch (opcionTienda) {
                case 1:
                    // Verificar si hay pociones de vitalidad disponibles en la tienda y si el
                    // jugador tiene suficiente dinero para comprarlas
                    if (tienda.getCantidadPocionesVitalidadTienda() == 0) {
                        escritor.mostrarMensaje("La tienda ya no tiene pociones de vitalidad disponibles para comprar");
                        // Si hay pociones disponibles y el jugador tiene suficiente dinero, se realiza
                        // la compra y se actualiza el inventario del jugador y la tienda
                    } else if (protagonista.getDinero() >= tienda.PRECIO_POCION_VITALIDAD) {
                        protagonista.setDinero(protagonista.getDinero() - tienda.PRECIO_POCION_VITALIDAD);
                        protagonista.setCantidadPocionVitalidad(protagonista.getCantidadPocionVitalidad() + 1);
                        tienda.setCantidadPocionesVitalidadTienda(tienda.getCantidadPocionesVitalidadTienda() - 1);
                        escritor.mostrarMensaje("Se te ha añadido una poción de vitalidad, revisa tu inventario");
                    } else {
                        // Si el jugador no tiene suficiente dinero, se muestra un mensaje indicando que
                        // no puede realizar la compra
                        escritor.mostrarMensaje("No tienes suficiente dinero para comprar pociones de vitalidad");
                    }
                    break;

                case 2:
                    // Verificar si hay pociones de resistencia disponibles en la tienda y si el
                    // jugador tiene suficiente dinero para comprarlas
                    if (tienda.getCantidadPocionesResistenciaTienda() == 0) {
                        escritor.mostrarMensaje(
                                "La tienda ya no tiene pociones de resistencia disponibles para comprar");
                        // Si hay pociones disponibles y el jugador tiene suficiente dinero, se realiza
                        // la compra y se actualiza el inventario del jugador y la tienda
                    } else if (protagonista.getDinero() >= tienda.PRECIO_POCION_RESISTENCIA) {
                        protagonista.setDinero(protagonista.getDinero() - tienda.PRECIO_POCION_RESISTENCIA);
                        protagonista.setCantidadPocionResistencia(protagonista.getCantidadPocionResistencia() + 1);
                        tienda.setCantidadPocionesResistenciaTienda(tienda.getCantidadPocionesResistenciaTienda() - 1);
                        escritor.mostrarMensaje("Se te ha añadido una poción de resistencia, revisa tu inventario");
                    } else {
                        // Si el jugador no tiene suficiente dinero, se muestra un mensaje indicando que
                        // no puede realizar la compra
                        escritor.mostrarMensaje("No tienes suficiente dinero para comprar pociones de resistencia");
                    }
                    break;

                case 3:
                    // Mostrar el inventario del jugador, incluyendo la cantidad de pociones de
                    // vitalidad y resistencia que posee
                    escritor.mostrarMensaje("=== INVENTARIO ===" + "\n" + "Tienes:" + "\n" + "Poción de vitalidad: "
                            + protagonista.getCantidadPocionVitalidad() + " pociones" + "\n" + "Poción de resistencia: "
                            + protagonista.getCantidadPocionResistencia() + " pociones");
                    break;

                case 4:
                    // Salir de la tienda y mostrar un mensaje indicando que el jugador ha
                    // abandonado la tienda
                    escritor.mostrarMensaje("Has abandonado la tienda");
                    salir = true;
                    break;
            }

        }
    }

}
