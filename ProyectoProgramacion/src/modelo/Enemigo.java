package modelo;

// clase que representa a un enemigo en el juego, hereda de la clase Personaje
public class Enemigo extends Personaje {
    // Atributos específicos de la clase Enemigo
    private String dificultad;
    private int recompensa;

    // Constructor de la clase Enemigo
    public Enemigo(String nombre, int vida, int ataque, int defensa, Arma arma, String dificultad, int recompensa) {
        /*
         * Se inicializan los atributos que son heredados de la clase personaje
         * En Java, la palabra clave super se utiliza para referirse explícitamente a la
         * clase padre (superclase) desde una subclase.
         * Es muy útil en herencia para acceder a métodos, constructores o atributos que
         * han sido ocultados o sobrescritos.
         */
        // Llamada al constructor de la clase padre (Personaje) para inicializar los
        // atributos heredados
        super(nombre, vida, ataque, defensa, arma);
        this.dificultad = dificultad;
        this.recompensa = recompensa;
    }

    // Métodos getter y setter para los atributos dificultad y recompensa
    public String getDificultad() {
        return dificultad;

    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    // Método que devuelve información del enemigo, incluyendo su estado y
    // dificultad
    public String obtenerInformacion() {
        return obtenerEstado() + "\nDificultad del enemigo: " + dificultad;
    }

    // actualiza valores de ataque, defensa y daño del arma según la dificultad del
    // enemigo
    public void aplicarDificultad() {
        switch (dificultad.toLowerCase()) {
            case "fácil":
            case "facil":
                setAtaque(20);
                setDefensa(10);
                getArma().setDanioMinimo(1);
                getArma().setDanioMaximo(15);
                break;
            case "medio":
                setAtaque(35);
                setDefensa(25);
                getArma().setDanioMinimo(1);
                getArma().setDanioMaximo(30);
                break;
            case "difícil":
            case "dificil":
                setAtaque(40);
                setDefensa(20);
                getArma().setDanioMinimo(10);
                getArma().setDanioMaximo(35);
                break;
        }
    }
}
