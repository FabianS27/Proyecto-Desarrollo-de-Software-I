package modelo;

public class Protagonista extends Personaje {

    private int cantidadPociones;

    public Protagonista(String nombre, int vida, int ataque, int defensa, Arma arma, int cantidadPociones) {
        //Se inicializan los atributos que son heredados de la clase personaje
        //En Java, la palabra clave super se utiliza para referirse explícitamente a la clase padre (superclase) desde una subclase.
        //Es muy útil en herencia para acceder a métodos, constructores o atributos que han sido ocultados o sobrescritos.
        super(nombre, vida, ataque, defensa, arma);

        //Parametro del propio protagonista
        this.cantidadPociones = cantidadPociones;

    }

    public int getCantidadPociones() {
        return cantidadPociones;

    }

    public void setCantidadPociones(int cantidadPociones) {
        if (cantidadPociones < 0) {
            this.cantidadPociones = 0;
        } else {
            this.cantidadPociones = cantidadPociones;
        }
    }

    public void usarPocion() {
        if (cantidadPociones > 0) {
            setVida(getVida() + 20);
            cantidadPociones--;
            //}else {
            //Mostrar mensaje, hacer cuando ya este muy desarrollado el JOptionPane
            //JOptionPane.showMessageDialog("CANTIDAD INSUFICIENTE");
        }
    }

    public String obtenerEstadisticas() {
        return obtenerEstado() + "\n Pociones disponibles: " + cantidadPociones;

    }


}
