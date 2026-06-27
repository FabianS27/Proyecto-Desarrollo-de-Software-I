package vista;

import javax.swing.JOptionPane;

public class Escritor {


	// inicilizar (construir el objeto) con new
	public Escritor() { // metodo constructor

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarEstado(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}

