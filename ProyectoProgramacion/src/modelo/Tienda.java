package modelo;

// clase que representa la tienda del juego, donde se pueden comprar pociones de vitalidad y resistencia
public class Tienda {
	// atributos de la tienda
	private int cantidadPocionesVitalidadTienda;
	public static final int PRECIO_POCION_VITALIDAD = 1000;

	private int cantidadPocionResistencia;
	public static final int PRECIO_POCION_RESISTENCIA = 1500;

	// constructor de la tienda
	public Tienda() {
		cantidadPocionesVitalidadTienda = 10;
		cantidadPocionResistencia = 10;
	}

	// getters y setters de los atributos de la tienda
	public int getCantidadPocionesVitalidadTienda() {
		return cantidadPocionesVitalidadTienda;
	}

	public void setCantidadPocionesVitalidadTienda(int cantidadPocionesVitalidadTienda) {
		this.cantidadPocionesVitalidadTienda = cantidadPocionesVitalidadTienda;
	}

	public int getCantidadPocionesResistenciaTienda() {
		return cantidadPocionResistencia;
	}

	public void setCantidadPocionesResistenciaTienda(int cantidadPocionResistencia) {
		this.cantidadPocionResistencia = cantidadPocionResistencia;
	}
}
