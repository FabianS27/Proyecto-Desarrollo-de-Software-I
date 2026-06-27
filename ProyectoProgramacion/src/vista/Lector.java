package vista;

import javax.swing.JOptionPane;

public class Lector {

	public String leerTexto(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}

	public int leerEntero(String mensaje) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}

	public int leerOpcion(String mensaje, int minimo, int maximo) {
		int opcion;

		do {
			opcion = leerEntero(mensaje);

			if (opcion < minimo || opcion > maximo) {
				JOptionPane.showMessageDialog(null, "Debe ingresar una opcion entre " + minimo + " y " + maximo);
			}

		} while (opcion < minimo || opcion > maximo);
		return opcion;
	}
}


