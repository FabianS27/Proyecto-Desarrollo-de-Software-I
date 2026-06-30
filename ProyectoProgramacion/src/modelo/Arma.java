package modelo;

//Clase Arma que contiene los atributos y metodos de las armas que se pueden elegir en el juego
public class Arma {
    // Atributos de la clase Arma
    private String nombre;
    private int danioMinimo;
    private int danioMaximo;

    // Constructor de la clase Arma que recibe los parametros nombre, danioMinimo y
    // danioMaximo
    public Arma(String nombre, int danioMinimo, int danioMaximo) {
        setNombre(nombre);
        this.danioMinimo = danioMinimo;
        this.danioMaximo = danioMaximo;
    }

    // Getters y Setters de los atributos de la clase Arma
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            this.nombre = "Filo del Juramento";
        }
    }

    public int getDanioMinimo() {
        return danioMinimo;

    }

    public void setDanioMinimo(int danioMinimo) {
        // Validación de seguridad: evita lógicas con daños negativos
        if (danioMinimo < 0) {
            this.danioMinimo = 0;
        } else {
            this.danioMinimo = danioMinimo;
        }
    }

    public int getDanioMaximo() {
        return danioMaximo;

    }

    public void setDanioMaximo(int danioMaximo) {
        // El daño máximo nunca puede ser menor al daño mínimo
        if (danioMaximo < this.danioMinimo) {
            this.danioMaximo = this.danioMinimo;
        } else {
            this.danioMaximo = danioMaximo;
        }
    }

    // Metodo que hace que el arma en si genere un daño aleatorio entre danioMinimo
    // y danioMaximo
    public int generarDanio() {
        return (int) (Math.random() * (danioMaximo - danioMinimo + 1)) + danioMinimo;
    }

    // Metodo que hace llamado al arma elegida, de tipo void para modificar la
    // informacion cuando se ejecute
    public void configurarTipoArma(int opcionArma) {
        switch (opcionArma) {
            case 1:
                setNombre("Filo del Juramento");
                setDanioMinimo(20);
                setDanioMaximo(40);
                break;

            case 2:
                setNombre("Navaja Vorpal");
                setDanioMinimo(20);
                setDanioMaximo(50);
                break;

            case 3:
                setNombre("Hacha de Lagrimas");
                setDanioMinimo(30);
                setDanioMaximo(60);
                break;
        }
    }

}