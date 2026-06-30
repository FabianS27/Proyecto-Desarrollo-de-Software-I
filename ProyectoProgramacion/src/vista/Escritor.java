package vista;

import javax.swing.JOptionPane;

//clase que se encarga de mostrar mensajes en la interfaz grafica
public class Escritor {

	// metodo constructor, no requiere inicializar atributos
	public Escritor() {

	}

	// Muestra mensajes generales del juego
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// Muestra advertencias o errores de validación de datos
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	// Muestra el estado y estadísticas actuales de los personajes
	public void mostrarEstado(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
