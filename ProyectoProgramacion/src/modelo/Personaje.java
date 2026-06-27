package modelo;

public class Personaje {

	// Atributos privados del personaje
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	private Arma arma;

	//Constructor de parametros
	public Personaje(String nombre, int vida, int ataque, int defensa, Arma arma) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.arma = arma;
	}

	//Getter del nombre
	public String getNombre() {
		return nombre;
	}

	//Setter del nombre
	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	//Getter de la vida
	public int getVida() {
		return vida;
	}

	//Setter de la vida
	//Evita que el daño sea menor a 0
	public void setVida(int vida) {
		if (vida < 0) {
			this.vida = 0;
		} else {
			this.vida = vida;
		}
	}

	//Getter del ataque
	public int getAtaque() {
		return ataque;

	}

	//Setter del ataque
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}


	//Getter de la defensa
	public int getDefensa() {
		return defensa;

	}

	//Setter de la defensa
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	//Getter del arma
	public Arma getArma() {
		return arma;

	}

	//Setter del arma
	public void setArma(Arma arma) {
		this.arma = arma;
	}


	//Reduce la vida del personaje
	public void recibirDanio(int danio) {

		// Calcula el daño total dependiendo de la defensa
		int danioOtorgado = danio - defensa;

		//Evita que el daño llegue a ser negativo
		if (danioOtorgado < 0) {
			danioOtorgado = 0;
		}

		//Resta el daño a la vida
		vida = danioOtorgado - vida;

		//Evita que la vida este en un valor negativo
		if (vida < 0) {
			vida = 0;
		}

	}

	public boolean estaVivo() {
		return vida > 0;
	}

	//Otorga datos del personaje funcion similar a un toString

	public String obtenerEstado() {
		return "Nombre: " + nombre + "\nVida: " + vida + "\nAtaque: " + ataque + "\nDefensa: " + defensa + "\nArma: " + arma.getNombre();
	}


}
