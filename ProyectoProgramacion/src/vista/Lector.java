package vista;

import javax.swing.JOptionPane;

//class Lector: Esta clase se encarga de leer datos desde la entrada estándar (JOptionPane) y validar la entrada del usuario. Proporciona métodos para leer texto, enteros y opciones dentro de un rango específico.
public class Lector {
	// Método para leer un texto desde la entrada estándar. Muestra un mensaje al
	// usuario y valida que la entrada no sea nula ni vacía.
	public String leerTexto(String mensaje) {
		String texto;
		// Bucle que se ejecuta hasta que el usuario ingrese un texto válido (no nulo ni
		// vacío).
		do {
			texto = JOptionPane.showInputDialog(mensaje);

			// Si el usuario presiona cancelar, sale de inmediato devolviendole un nombre
			// por defecto
			if (texto == null) {
				return "Jugador 1";
			}

			if (texto.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puede dejar el espacio vacío.");
			}

		} while (texto.trim().isEmpty());

		return texto.trim();
	}

	// Método para leer un número entero desde la entrada estándar. Muestra un
	// mensaje al usuario y valida que la entrada sea un número válido.
	public int leerEntero(String mensaje) {
		String texto;
		// Bucle que se ejecuta hasta que el usuario ingrese un número válido (no nulo,
		// no vacío y compuesto solo por dígitos).
		do {
			texto = JOptionPane.showInputDialog(mensaje);

			// Si presionó Cancelar. salimos inmediatamente del método devolviendo -1
			if (texto == null) {
				return -1;
			}

			// Si no es nulo, hacemos las validaciones normales de texto
			if (texto.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
			} else if (!texto.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar solo números enteros positivos.");
			}

		} while (texto.isEmpty() || !texto.matches("[0-9]+"));

		return Integer.parseInt(texto);
	}

	// Método para leer una opción dentro de un rango específico. Muestra un mensaje
	// al usuario y valida que la entrada sea un número entero dentro del rango
	// definido por los parámetros mínimo y máximo.
	public int leerOpcion(String mensaje, int minimo, int maximo) {
		int opcion;
		// Bucle que se ejecuta hasta que el usuario ingrese una opción válida (dentro
		// del rango definido).
		do {
			opcion = leerEntero(mensaje);

			// Si retorna -1, significa que el usuario presionó cancelar
			if (opcion == -1) {
				return -1; // Devuelve el -1 para que la clase que llamó al lector se entere de la
							// cancelación
			}

			if (opcion < minimo || opcion > maximo) {
				JOptionPane.showMessageDialog(null,
						"Debe ingresar una opción entre " + minimo + " y " + maximo);
			}

		} while (opcion < minimo || opcion > maximo);

		return opcion;
	}
}
