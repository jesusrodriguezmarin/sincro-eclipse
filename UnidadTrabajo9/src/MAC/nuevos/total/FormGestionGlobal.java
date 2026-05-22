package MAC.nuevos.total;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormGestionGlobal extends JFrame implements ActionListener {

	private JLabel lblTitulo, lblSelector;
	private JComboBox<String> comboTablas; 
	private JButton btnInsertar, btnEliminar, btnContar, btnLimpiar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexGestionGlobal con;

	public FormGestionGlobal() {
		setLayout(null);

		lblTitulo = new JLabel("Consola Avanzada de Gestión de Base de Datos (S, P, SP):");
		lblTitulo.setBounds(30, 20, 450, 25);
		add(lblTitulo);

		lblSelector = new JLabel("Seleccionar Tabla:");
		lblSelector.setBounds(30, 60, 130, 25);
		add(lblSelector);

		comboTablas = new JComboBox<>();
		comboTablas.addItem("Proveedores (S)");
		comboTablas.addItem("Piezas (P)");
		comboTablas.addItem("Envíos (SP)");
		comboTablas.setBounds(160, 60, 160, 25);
		comboTablas.addActionListener(this); 
		add(comboTablas);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(30, 110, 100, 25);
		btnInsertar.addActionListener(this);
		add(btnInsertar);

		btnEliminar = new JButton("Eliminar Fila");
		btnEliminar.setBounds(140, 110, 110, 25);
		btnEliminar.addActionListener(this);
		add(btnEliminar);

		btnContar = new JButton("Contar Filas");
		btnContar.setBounds(260, 110, 110, 25);
		btnContar.addActionListener(this);
		add(btnContar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(380, 110, 90, 25);
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 160, 440, 220);
		add(sc);

		// Cargamos los datos por defecto al iniciar
		recargarVistaTabla();
	}

	private void recargarVistaTabla() {
		con = new ConexGestionGlobal();
		con.obtenerConexion();
		con.mostrarTabla(tabla, comboTablas.getSelectedItem().toString());
		con.desconectar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String tablaActiva = comboTablas.getSelectedItem().toString();

		try {
			if (e.getSource() == comboTablas) {
				recargarVistaTabla();
			}

			if (e.getSource() == btnContar) {
				con = new ConexGestionGlobal();
				con.obtenerConexion();
				con.contarFilas(tablaActiva);
				con.desconectar();
			}

			if (e.getSource() == btnEliminar) {
				con = new ConexGestionGlobal();
				con.obtenerConexion();
				con.eliminarRegistroSeleccionado(tabla, tablaActiva);
				con.desconectar();
			}

			if (e.getSource() == btnInsertar) {
				con = new ConexGestionGlobal();
				con.obtenerConexion();

				if (tablaActiva.equals("Proveedores (S)")) {
					String sn = JOptionPane.showInputDialog(this, "Introduce Código Proveedor (sn):");
					String nom = JOptionPane.showInputDialog(this, "Introduce Nombre:");
					String est = JOptionPane.showInputDialog(this, "Introduce Estado (Número):");
					String ciu = JOptionPane.showInputDialog(this, "Introduce Ciudad:");
					if(sn != null && nom != null && est != null && ciu != null) {
						con.insertarRegistro(tabla, tablaActiva, sn, nom, est, ciu, null);
					}
				} else if (tablaActiva.equals("Piezas (P)")) {
					String pn = JOptionPane.showInputDialog(this, "Introduce Código Pieza (pn):");
					String nom = JOptionPane.showInputDialog(this, "Introduce Nombre:");
					String col = JOptionPane.showInputDialog(this, "Introduce Color:");
					String pes = JOptionPane.showInputDialog(this, "Introduce Peso (Número):");
					String ciu = JOptionPane.showInputDialog(this, "Introduce Ciudad:");
					if(pn != null && nom != null && col != null && pes != null && ciu != null) {
						con.insertarRegistro(tabla, tablaActiva, pn, nom, col, pes, ciu);
					}
				} else {
					String sn = JOptionPane.showInputDialog(this, "Introduce Código Proveedor Existente (sn):");
					String pn = JOptionPane.showInputDialog(this, "Introduce Código Pieza Existente (pn):");
					String cant = JOptionPane.showInputDialog(this, "Introduce Cantidad (Número):");
					if(sn != null && pn != null && cant != null) {
						con.insertarRegistro(tabla, tablaActiva, sn, pn, cant, null, null);
					}
				}
				con.desconectar();
			}

			if (e.getSource() == btnLimpiar) {
				comboTablas.setSelectedIndex(0);
				tabla.setModel(new DefaultTableModel());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormGestionGlobal f = new FormGestionGlobal();
		f.setTitle("CONSOLA GENERAL GESTIÓN BASE DE DATOS - EXAMEN");
		f.setSize(510, 440);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}