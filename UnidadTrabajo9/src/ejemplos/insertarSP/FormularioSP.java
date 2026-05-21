package ejemplos.insertarSP;

import java.awt.event.*;
import javax.swing.*;

public class FormularioSP extends JFrame implements ActionListener {

	/*
	 * Componentes gráficos
	 */
	private JTextField txtCodS, txtCodP, txtCantidad;
	private JLabel lblNueva, lblListado, lblCodS, lblCodP, lblCantidad; // <-- CORREGIDO AQUÍ
	private JButton guardar, borrar; 
	private JScrollPane sc;
	private JTable tabla;

	/** Conexión a la base de datos para acceder a la tabla SP */
	private ConexionSP con;

	/**
	 * Constructor
	 */
	public FormularioSP() {
		setLayout(null);

		lblNueva = new JLabel("Introduce un nuevo envío (SP): ");
		lblNueva.setBounds(30, 20, 250, 25);
		add(lblNueva);

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

		lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(30, 140, 110, 25);
		add(lblCantidad);
		txtCantidad = new JTextField();
		txtCantidad.setBounds(150, 140, 100, 25);
		add(txtCantidad);

		// --- BOTONES DE CONTROL ---
		guardar = new JButton("Guardar");
		guardar.setBounds(90, 200, 130, 25);
		guardar.addActionListener(this);
		add(guardar);

		borrar = new JButton("Borrar");
		borrar.setBounds(250, 200, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de envíos registrados (SP): ");
		lblListado.setBounds(30, 260, 250, 25);
		add(lblListado);

		// Estructura de la tabla para envíos
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 300, 360, 130);
		add(sc);

		// Al arrancar: instanciamos objeto, conectamos, mostramos datos y cerramos
		con = new ConexionSP();
		con.obtenerConexion(); 
		con.mostrarSP(tabla);
		con.desconectar();
	}

	/** Método para limpiar los campos de texto */
	public void limpiar() {
		txtCodS.setText("");
		txtCodP.setText("");
		txtCantidad.setText("");
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
			String qty = txtCantidad.getText();

			// --- BOTÓN GUARDAR ---
			if (e.getSource() == guardar) {
				if (codeS.isEmpty() || codeP.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los campos de Código de Proveedor y Código de Pieza son obligatorios", "Campos vacíos",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionSP();
					con.obtenerConexion(); 
					con.insertarSP(codeS, codeP, qty); 
					con.mostrarSP(tabla); 
					con.desconectar(); 
					limpiar();
				}
			}

			// --- BOTÓN BORRAR ---
			if (e.getSource() == borrar) {
				limpiar();
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Los valores introducidos no son correctos", "Error en la aplicación",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Evitamos que salgan los errores de HSQLDB por consola
		System.setErr(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
		
		// Lanzamos la ventana de envíos
		FormularioSP pt = new FormularioSP();
		pt.setTitle("ENVÍOS (SP)");
		pt.setSize(440, 500); 
		pt.setLocationRelativeTo(null);
		pt.setVisible(true);
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}