package MAC.eliminar;

import java.awt.event.*;
import javax.swing.*;

public class FormularioEliminarP extends JFrame implements ActionListener {

	/*
	 * Componentes gráficos
	 */
	private JTextField codigo;
	private JLabel titulo, lblListado, cod;
	private JButton eliminar, borrar; 
	private JScrollPane sc;
	private JTable tabla;

	/** Conexión a la base de datos para acceder a la tabla P */
	private ConexionEliminarP con;

	/**
	 * Constructor
	 */
	public FormularioEliminarP() {
		setLayout(null);

		titulo = new JLabel("Eliminar Pieza: ");
		titulo.setBounds(30, 20, 200, 25);
		add(titulo);

		cod = new JLabel("Código (pn): ");
		cod.setBounds(30, 60, 80, 25);
		add(cod);
		codigo = new JTextField();
		codigo.setBounds(110, 60, 100, 25);
		add(codigo);

		// --- BOTONES DE CONTROL ---
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(90, 110, 130, 25);
		eliminar.addActionListener(this);
		add(eliminar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(240, 110, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de piezas: ");
		lblListado.setBounds(30, 160, 200, 25);
		add(lblListado);

		// Estructura de la tabla para piezas
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 200, 360, 150);
		add(sc);

		// Al arrancar: instanciamos objeto, conectamos, mostramos datos y cerramos
		con = new ConexionEliminarP();
		con.obtenerConexion(); 
		con.mostrarP(tabla);
		con.desconectar();
	}

	/** Método para limpiar el campo de texto */
	public void limpiar() {
		codigo.setText("");
	}

	/**
	 * Método que implementa la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// Recogemos la variable de la interfaz
			String code = codigo.getText();

			// --- BOTÓN ELIMINAR ---
			if (e.getSource() == eliminar) {
				if (code.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce el Código de la pieza que deseas eliminar", "Falta código",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionEliminarP();
					con.obtenerConexion(); 
					con.eliminarP(code); 
					con.mostrarP(tabla); 
					con.desconectar(); 
					limpiar();
				}
			}

			// --- BOTÓN BORRAR CAMPOS ---
			if (e.getSource() == borrar) {
				limpiar();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los valores introducidos no son correctos", "Error en la aplicación",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Lanzamos la ventana de borrado de piezas
		FormularioEliminarP pt = new FormularioEliminarP();
		pt.setTitle("ELIMINAR PIEZA (P)");
		pt.setSize(440, 420); 
		pt.setLocationRelativeTo(null);
		pt.setVisible(true);
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}