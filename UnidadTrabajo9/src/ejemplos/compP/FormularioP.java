package ejemplos.compP;

import java.awt.event.*;
import javax.swing.*;

public class FormularioP extends JFrame implements ActionListener {

	/*
	 * Componentes gráficos
	 */
	private JTextField codigo, nombre, color, peso, ciudad;
	private JLabel nueva, listado, cod, nom, col, pes, ciu;
	private JButton guardar, modificar, eliminar, borrar; 
	private JScrollPane sc;
	private JTable tabla;

	/** Conexión a la base de datos para acceder a la tabla P */
	private ConexionP con;

	/**
	 * Constructor
	 */
	public FormularioP() {
		setLayout(null);

		nueva = new JLabel("Introduce una nueva pieza: ");
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

		col = new JLabel("Color: ");
		col.setBounds(30, 140, 60, 25);
		add(col);
		color = new JTextField();
		color.setBounds(90, 140, 100, 25);
		add(color);

		pes = new JLabel("Peso: ");
		pes.setBounds(220, 100, 60, 25);
		add(pes);
		peso = new JTextField();
		peso.setBounds(280, 100, 100, 25);
		add(peso);

		ciu = new JLabel("Ciudad: ");
		ciu.setBounds(220, 140, 60, 25);
		add(ciu);
		ciudad = new JTextField();
		ciudad.setBounds(280, 140, 100, 25);
		add(ciudad);

		// --- FILA 1 DE BOTONES ---
		guardar = new JButton("Guardar");
		guardar.setBounds(30, 185, 170, 25);
		guardar.addActionListener(this);
		add(guardar);

		modificar = new JButton("Modificar");
		modificar.setBounds(220, 185, 170, 25);
		modificar.addActionListener(this);
		add(modificar);

		// --- FILA 2 DE BOTONES ---
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(30, 220, 170, 25);
		eliminar.addActionListener(this);
		add(eliminar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(220, 220, 170, 25);
		borrar.addActionListener(this);
		add(borrar);

		listado = new JLabel("Listado de piezas: ");
		listado.setBounds(30, 265, 200, 25);
		add(listado);

		// Estructura de la tabla
		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 300, 360, 140);
		add(sc);

		// Al arrancar: creamos objeto, conectamos, mostramos datos y cerramos
		con = new ConexionP();
		con.obtenerConexion(); 
		con.mostrarP(tabla);
		con.desconectar();
	}

	/** Método para limpiar los campos de texto */
	public void limpiar() {
		codigo.setText("");
		nombre.setText("");
		color.setText("");
		peso.setText("");
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
			String colour = color.getText();
			String weight = peso.getText();
			String city = ciudad.getText();

			// --- BOTÓN GUARDAR ---
			if (e.getSource() == guardar) {
				if (code.isEmpty() || name.isEmpty() || city.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los campos código, nombre y ciudad son obligatorios", "Campos vacíos",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionP();
					con.obtenerConexion(); 
					con.insertarP(code, name, colour, weight, city); 
					con.mostrarP(tabla); 
					con.desconectar(); 
					limpiar();
				}
			}

			// --- BOTÓN MODIFICAR ---
			if (e.getSource() == modificar) {
				if (code.isEmpty() || name.isEmpty() || city.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Para modificar, necesitas rellenar mínimo código, nombre y ciudad", "Campos vacíos",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionP();
					con.obtenerConexion(); 
					con.modificarP(code, name, colour, weight, city); 
					con.mostrarP(tabla); 
					con.desconectar(); 
					limpiar();
				}
			}

			// --- BOTÓN ELIMINAR ---
			if (e.getSource() == eliminar) {
				if (code.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce el Código de la pieza que deseas eliminar", "Falta código",
							JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionP();
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
			JOptionPane.showMessageDialog(null, "Los valores introducidos no son correctos", "Error en la aplicación",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Evitamos que salgan los errores sucios de HSQLDB por consola
		System.setErr(new java.io.PrintStream(java.io.OutputStream.nullOutputStream()));
		
		// Lanzamos la ventana
		FormularioP pt = new FormularioP();
		pt.setTitle("PIEZAS");
		pt.setSize(440, 500); 
		pt.setLocationRelativeTo(null);
		pt.setVisible(true);
		pt.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}