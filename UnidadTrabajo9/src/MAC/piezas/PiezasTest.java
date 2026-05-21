package MAC.piezas;

import MAC.piezasTabla.Piezas;

public class PiezasTest {

	public static void main(String[] args) {

		// Comando para evitar que salgan los errores en consola
		System.setErr(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));

		// Instanciamos um objeto Piezas
		Piezas p = new Piezas();

		// Utilizamos el método para obtener conexión
		p.obtenerConexion();

		// Utilizamos el método para mostrar por consola
		p.mostrar();

		// Utilizamos el método para desconectar
		p.desconectar();
	}

}
