package ejemplos.insertarS;

import java.awt.event.*;
import javax.swing.*;

public class FormularioS extends JFrame implements ActionListener {

	/*
	 * Componentes gráficos
	 */
	private JTextField codigo, nombre, estado, ciudad;
	private JLabel nueva, listado, cod, nom, est, ciu;
	private JButton guardar, borrar; 
	private JScrollPane sc;
	private JTable tabla;

	/** Conexión a la base de datos para acceder a la tabla S */
	private ConexionS con;

	/**
	 * Constructor
	 */
	public FormularioS() {
		setLayout(null);

		nueva = new JLabel("Introduce un nuevo proveedor: ");
		nueva.setBounds(30, 20, 200, 25);
		add(nueva);

		cod = new JLabel("Código: ");
		cod.setBounds(30, 60, 60, 25);
		add(cod);
		codigo = new JTextField();
		codigo.setBounds(90, 60, 100, 25);
		add(codigo);

		nom = new JLabel("Nombre: ");
		nom.setBounds(30, 100, 60, 25);
		add(nom);
		nombre = new JTextField();
		nombre.setBounds(90, 100, 100, 25);
		add(nombre);

		est = new JLabel("Estado: ");
		est.setBounds(30, 140, 60, 25);
		add(est);
		estado = new JTextField();
		estado.setBounds(90, 140, 100, 25);
		add(estado);

		ciu = new JLabel("Ciudad: ");
		ciu.setBounds(220, 140, 60, 25);
		add(ciu);
		ciudad = new JTextField();
		ciudad.setBounds(280, 140, 100, 25);
		add(ciudad);

		// --- DOS BOTONES DE CONTROL ---
		guardar = new JButton("Guardar");
		guardar.setBounds(90, 200, 130, 25);
		guardar.addActionListener(this);
		add(guardar);

		borrar = new JButton("Borrar");
		borrar.setBounds(250, 200, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		listado = new JLabel("Listado de proveedores: ");
		listado.setBounds(30, 260, 200, 25);
		add(listado);

		// Estructura de la tabla para proveedores
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 300, 360, 130);
		add(sc);

		// Al arrancar: instanciamos objeto, conectamos, mostramos datos y cerramos
		con = new ConexionS();
		con.obtenerConexion(); 
		con.mostrarS(tabla);
		con.desconectar();
	}

	/** Método para limpiar los campos de texto */
	public void limpiar() {
		codigo.setText("");
		nombre.setText("");
		estado.setText("");
		ciudad.setText("");
	}

	/**
	 * Método que implementa la acción de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// Recogemos las variables de la interfaz
			String code = codigo.getText();
			String name = nombre.getText();
			String state = estado.getText();
			String city = ciudad.getText();

			// --- BOTÓN GUARDAR ---
			if (e.getSource() == guardar) {
				if (code.isEmpty() || name.isEmpty() || city.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los campos código, nombre y ciudad son obligatorios", "Campos vacíos",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionS();
					con.obtenerConexion(); 
					con.insertarS(code, name, state, city); 
					con.mostrarS(tabla); 
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
		
		// Lanzamos la ventana de proveedores
		FormularioS pt = new FormularioS();
		pt.setTitle("PROVEEDORES");
		pt.setSize(440, 500); 
		pt.setLocationRelativeTo(null);
		pt.setVisible(true);
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}