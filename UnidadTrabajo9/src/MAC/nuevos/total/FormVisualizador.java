package MAC.nuevos.total;

import java.awt.event.*;
import javax.swing.*;

public class FormVisualizador extends JFrame implements ActionListener {

	private JLabel lblSelector;
	private JComboBox<String> comboTablas; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexVisualizador con;

	public FormVisualizador() {
		setLayout(null);

		lblSelector = new JLabel("Seleccionar tabla a visualizar:");
		lblSelector.setBounds(30, 25, 200, 25);
		add(lblSelector);

		comboTablas = new JComboBox<>();
		comboTablas.addItem("Proveedores (S)");
		comboTablas.addItem("Piezas (P)");
		comboTablas.addItem("Envíos (SP)");
		comboTablas.setBounds(230, 25, 180, 25);
		comboTablas.addActionListener(this); // Refresco automático al cambiar la opción
		add(comboTablas);

		// Componente visual de la tabla (sin botones alrededor)
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 75, 440, 260);
		add(sc);

		// Carga inicial al arrancar el programa
		actualizarContenedorTabla();
	}

	/**
	 * Método encargado de refrescar el contenido de la JTable abriendo y cerrando la conexión
	 */
	private void actualizarContenedorTabla() {
		con = new ConexVisualizador();
		con.obtenerConexion();
		con.cargarTablaDinamica(tabla, comboTablas.getSelectedItem().toString());
		con.desconectar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Detección automática del cambio en el JComboBox
		if (e.getSource() == comboTablas) {
			actualizarContenedorTabla();
		}
	}

	public static void main(String[] args) {
		FormVisualizador f = new FormVisualizador();
		f.setTitle("VISUALIZADOR DE TABLAS HSQLDB");
		f.setSize(510, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}