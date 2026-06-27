package modelo;

public class Arma {

    private String nombre;
    private int danioMinimo;
    private int danioMaximo;

    public Arma(String nombre, int danioMinimo, int danioMaximo) {
        this.nombre = nombre;
        this.danioMinimo = danioMinimo;
        this.danioMaximo = danioMaximo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getDanioMinimo() {
        return danioMinimo;

    }

    public void setDanioMinimo(int danioMinimo) {
        this.danioMinimo = danioMinimo;
    }

    public int getDanioMaximo() {
        return danioMaximo;

    }

    public void setDanioMaximo(int danioMaximo) {
        this.danioMaximo = danioMaximo;
    }

    //Metodo que hace que el arma en si genere un daño aleatorio entre danioMinimo y danioMaximo
    public int generarDanio() {
        return (int) (Math.random() * (danioMinimo - danioMaximo + 1)) + danioMinimo;

    }

}
