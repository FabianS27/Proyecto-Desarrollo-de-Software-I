package modelo;

public class Combate {

    private Protagonista protagonista;
    private Enemigo enemigo;

    public Combate(Protagonista protagonista, Enemigo enemigo) {
        this.protagonista = protagonista;
        this.enemigo = enemigo;
    }

    public Protagonista getProtagonista() {
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

    public boolean combateTermiando() {
        return !protagonista.estaVivo() || !enemigo.estaVivo();

    }

    public String verificarGanador() {
        if (protagonista.estaVivo() && !enemigo.estaVivo()) {
            return "Ronda Ganada";
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
