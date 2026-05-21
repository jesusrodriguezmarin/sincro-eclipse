package ejemplos.eliminar;

import java.awt.event.*;
import javax.swing.*;

public class FormularioEliminarSP extends JFrame implements ActionListener {

	/*
	 * Componentes gráficos
	 */
	private JTextField txtCodS, txtCodP;
	private JLabel titulo, lblListado, lblCodS, lblCodP;
	private JButton eliminar, borrar; 
	private JScrollPane sc;
	private JTable tabla;

	/** Conexión a la base de datos para acceder a la tabla SP */
	private ConexionEliminarSP con;

	/**
	 * Constructor
	 */
	public FormularioEliminarSP() {
		setLayout(null);

		titulo = new JLabel("Eliminar Registro de Envío (SP): ");
		titulo.setBounds(30, 20, 250, 25);
		add(titulo);

		lblCodS = new JLabel("Cod. Prov (sn): ");
		lblCodS.setBounds(30, 60, 110, 25);
		add(lblCodS);
		txtCodS = new JTextField();
		txtCodS.setBounds(150, 60, 100, 25);
		add(txtCodS);

		lblCodP = new JLabel("Cod. Pieza (pn): ");
		lblCodP.setBounds(30, 100, 110, 25);
		add(lblCodP);
		txtCodP = new JTextField();
		txtCodP.setBounds(150, 100, 100, 25);
		add(txtCodP);

		// --- BOTONES DE CONTROL ---
		eliminar = new JButton("Eliminar Envío");
		eliminar.setBounds(90, 150, 130, 25);
		eliminar.addActionListener(this);
		add(eliminar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(240, 150, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de envíos registrados: ");
		lblListado.setBounds(30, 200, 250, 25);
		add(lblListado);

		// Estructura de la tabla para envíos
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 240, 360, 150);
		add(sc);

		// Al arrancar: instanciamos objeto, conectamos, mostramos datos y cerramos
		con = new ConexionEliminarSP();
		con.obtenerConexion(); 
		con.mostrarSP(tabla);
		con.desconectar();
	}

	/** Método para limpiar los campos de texto */
	public void limpiar() {
		txtCodS.setText("");
		txtCodP.setText("");
	}

	/**
	 * Método que implementa la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// Recogemos las variables de la interfaz
			String codeS = txtCodS.getText();
			String codeP = txtCodP.getText();

			// --- BOTÓN ELIMINAR ---
			if (e.getSource() == eliminar) {
				if (codeS.isEmpty() || codeP.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Es obligatorio introducir tanto el código de Proveedor como el de Pieza", "Campos vacíos",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionEliminarSP();
					con.obtenerConexion(); 
					con.eliminarSP(codeS, codeP); 
					con.mostrarSP(tabla); 
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

		// Lanzamos la ventana de borrado de envíos
		FormularioEliminarSP pt = new FormularioEliminarSP();
		pt.setTitle("ELIMINAR ENVÍO (SP)");
		pt.setSize(440, 460); 
		pt.setLocationRelativeTo(null);
		pt.setVisible(true);
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}