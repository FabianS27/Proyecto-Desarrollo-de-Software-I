package modelo;

public class Enemigo extends Personaje {

	private String dificultad;

	public Enemigo(String nombre, int vida, int ataque, int defensa, Arma arma, String dificultad) {
		//Se inicializan los atributos que son heredados de la clase personaje
		//En Java, la palabra clave super se utiliza para referirse explícitamente a la clase padre (superclase) desde una subclase.
		//Es muy útil en herencia para acceder a métodos, constructores o atributos que han sido ocultados o sobrescritos.
		super(nombre, vida, ataque, defensa, arma);
		this.dificultad = dificultad;
	}

	public String getDificultad() {
		return dificultad;

	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String obtenerInformacion() {
		return obtenerEstado() + "\n Dificultad del enemigo: " + dificultad;

	}

}
