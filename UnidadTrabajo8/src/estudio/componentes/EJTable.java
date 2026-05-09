package estudio.componentes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EJTable extends JFrame {

	public EJTable() {
		setTitle("Plantilla Tabla");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 1. Cabecera y Datos iniciales
		String[] columnas = {"Nombre", "Puntuación"};
		Object[][] datos = {
			{"Jugador 1", "100"},
			{"Jugador 2", "250"}
		};

		// 2. Modelo de la tabla (para poder añadir filas después)
		DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		JTable tabla = new JTable(modelo);

		// 3. ¡IMPORTANTE! La tabla SIEMPRE debe ir en un JScrollPane
		JScrollPane scroll = new JScrollPane(tabla);
		getContentPane().add(scroll); // Aquí usamos el BorderLayout por defecto del Frame

		// Para añadir una fila nueva por código:
		modelo.addRow(new Object[]{"Jugador 3", "500"});
	}

	public static void main(String[] args) { new EJTable().setVisible(true); }
}