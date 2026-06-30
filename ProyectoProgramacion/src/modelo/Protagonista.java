package modelo;

// clase que representa al protagonista del juego, hereda de la clase Personaje
public class Protagonista extends Personaje {
    // Atributos propios del protagonista
    private int victoriasTotales;
    private int derrotasTotales;
    private int cantidadPocionVitalidad;
    private int cantidadPocionResistencia;
    private int dinero;

    // Constructor de la clase Protagonista
    public Protagonista(String nombre, int vida, int ataque, int defensa, Arma arma, int dinero) {
        // Se inicializan los atributos que son heredados de la clase personaje
        // En Java, la palabra clave super se utiliza para referirse explícitamente a la
        // clase padre (superclase) desde una subclase.
        // Es muy útil en herencia para acceder a métodos, constructores o atributos que
        // han sido ocultados o sobrescritos.
        // En este caso, se está llamando al constructor de la clase padre Personaje
        // para inicializar los atributos heredados.
        super((nombre != null && !nombre.trim().isEmpty()) ? nombre : "Jugador 1", vida, ataque, defensa, arma);
        // Parametro del propio protagonista
        this.cantidadPocionVitalidad = 1;
        this.cantidadPocionResistencia = 1;
        this.victoriasTotales = 0;
        this.derrotasTotales = 0;
        this.dinero = dinero;
    }

    // Getters y Setters para los atributos propios del protagonista
    public int getCantidadPocionVitalidad() {
        return cantidadPocionVitalidad;
    }

    public void setCantidadPocionVitalidad(int cantidadPocionVitalidad) {
        if (cantidadPocionVitalidad < 0) {
            this.cantidadPocionVitalidad = 0;
        } else {
            this.cantidadPocionVitalidad = cantidadPocionVitalidad;
        }
    }

    public int getCantidadPocionResistencia() {
        return cantidadPocionResistencia;
    }

    public void setCantidadPocionResistencia(int cantidadPocionResistencia) {
        if (cantidadPocionResistencia < 0) {
            this.cantidadPocionResistencia = 0;
        } else {
            this.cantidadPocionResistencia = cantidadPocionResistencia;
        }
    }

    public int getVictoriasTotales() {
        return victoriasTotales;
    }

    public void setVictoriasTotales() {
        this.victoriasTotales++;
    }

    public int getDerrotasTotales() {
        return derrotasTotales;
    }

    public void setDerrotasTotales() {
        this.derrotasTotales++;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        if (dinero < 0) {
            this.dinero = 0;
        } else {
            this.dinero = dinero;
        }
    }

    // Método para obtener las estadísticas del protagonista
    public String obtenerEstadisticas() {
        return obtenerEstado() + "\nPociones de Vitalidad: " + cantidadPocionVitalidad + "\nPociones de Resistencia: "
                + cantidadPocionResistencia + "\nDinero actual: ¥" + dinero + "\nVictorias totales: " + victoriasTotales
                + " combates" + "\nDerrotas totales: " + derrotasTotales + " combates";

    }

    // Método para restaurar la salud y el inventario del protagonista
    public void restaurarProtagonista() {
        this.setVida(100); // Restaura la salud inicial
        this.cantidadPocionVitalidad = 1; // Restaura el inventario de la poción de vitalidad y resistencia
        this.cantidadPocionResistencia = 1;
    }

    // Método para usar una poción de vitalidad, que aumenta la vida del
    // protagonista y disminuye la cantidad de pociones disponibles
    public void usarPocionVitalidad(int aumento) {
        setVida(getVida() + aumento);
        setCantidadPocionVitalidad(getCantidadPocionVitalidad() - 1);

    }

    /*
     * El método usarPocionIntercambio se enecarga de restarle
     * al atributo cantidadDePocionIntercambio una poción cada vez que se usa el
     * método.
     */
    public void usarPocionResistencia() {
        this.setCantidadPocionResistencia(getCantidadPocionResistencia() - 1);
    }

    // Método para recibir una recompensa en forma de dinero, que aumenta la
    // cantidad de dinero del protagonista
    public void recibirRecompensa(int cantidad) {
        this.setDinero(this.getDinero() + cantidad);
    }

}
