package MAC.piezasTabla;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PiezasTabla extends JFrame {

	// --- Creamos la tabla y la añadimos a la ventana ---

	/**
	 * Constructor para crear la tabla y la ventana
	 */
	public PiezasTabla() {

		// Establecemos la estructura
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

		// Declaramos un array de String con los titulos de las columnas
		String atributos[] = { "Código", "Nombre", "Color", "Peso", "Ciudad" };

		// Creamos el modelo
		DefaultTableModel modelo = new DefaultTableModel();
		// Inicializamos el objeto DefaultTableModel para usar con JTable
		modelo.setColumnIdentifiers(atributos);

		// Creamos la tabla con el modelo DefaultTableModel
		JTable tabla = new JTable();
		// Establecemos con el modelo
		tabla.setModel(modelo);

		// Creamos un scroll para la tabla y la insertamos
		JScrollPane sc = new JScrollPane(tabla);
		// Añadimos a la ventana
		add(sc);

		// --- Insertamos los datos en la pieza ---

		// Instanciamos el objeto Piezas
		Piezas p = new Piezas();

		// Usamos los métodos
		p.obtenerConexion();
		p.mostrarTabla(modelo);
		p.desconectar();

	}

	// Programa principal
	public static void main(String[] args) {

		// Comando para evitar que salgan los errores en consola
		System.setErr(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));

		// Instanciamos la ventana
		PiezasTabla pt = new PiezasTabla();

		// Configuramos
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pt.setTitle("PIEZAS");
		pt.pack();
		pt.setVisible(true);
		pt.setLocationRelativeTo(null);
		;
	}

}
