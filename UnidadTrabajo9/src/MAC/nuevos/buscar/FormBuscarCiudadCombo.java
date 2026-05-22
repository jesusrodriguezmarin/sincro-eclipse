package MAC.nuevos.buscar;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBuscarCiudadCombo extends JFrame implements ActionListener {

	private JTextField txtCiudad;
	private JLabel lblTitulo, lblCiudad, lblSelector;
	private JComboBox<String> comboTablas; 
	private JButton btnBuscar, btnBorrar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexBuscarCiudadCombo con;

	public FormBuscarCiudadCombo() {
		setLayout(null);

		lblTitulo = new JLabel("Buscador por Ciudad con Desplegable:");
		lblTitulo.setBounds(30, 20, 300, 25);
		add(lblTitulo);

		lblSelector = new JLabel("Buscar en:");
		lblSelector.setBounds(30, 60, 100, 25);
		add(lblSelector);

		comboTablas = new JComboBox<>();
		comboTablas.addItem("Proveedores");
		comboTablas.addItem("Piezas");
		comboTablas.addItem("Envíos (SP)"); // <-- Añadido SP al ComboBox
		comboTablas.setBounds(150, 60, 150, 25);
		add(comboTablas);

		lblCiudad = new JLabel("Introduce Ciudad Exacta: ");
		lblCiudad.setBounds(30, 100, 150, 25);
		add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(180, 100, 150, 25);
		add(txtCiudad);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(90, 150, 120, 25);
		btnBuscar.addActionListener(this);
		add(btnBuscar);

		btnBorrar = new JButton("Limpiar");
		btnBorrar.setBounds(230, 150, 120, 25);
		btnBorrar.addActionListener(this);
		add(btnBorrar);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 200, 380, 180);
		add(sc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String ciudadBuscada = txtCiudad.getText();

			if (e.getSource() == btnBuscar) {
				if (ciudadBuscada.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, escribe el nombre de una ciudad", "Falta criterio", JOptionPane.WARNING_MESSAGE);
				} else {
					con = new ConexBuscarCiudadCombo();
					con.obtenerConexion();
					
					String opcionSeleccionada = comboTablas.getSelectedItem().toString();
					
					if (opcionSeleccionada.equals("Proveedores")) {
						con.buscarProveedores(tabla, ciudadBuscada);
					} else if (opcionSeleccionada.equals("Piezas")) {
						con.buscarPiezas(tabla, ciudadBuscada);
					} else if (opcionSeleccionada.equals("Envíos (SP)")) {
						con.buscarEnvios(tabla, ciudadBuscada); // <-- Redirección al método de SP
					}
					
					con.desconectar();
				}
			}

			if (e.getSource() == btnBorrar) {
				txtCiudad.setText("");
				comboTablas.setSelectedIndex(0); 
				tabla.setModel(new DefaultTableModel()); 
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormBuscarCiudadCombo f = new FormBuscarCiudadCombo();
		f.setTitle("CONSULTA FILTRADA POR COMBOBOX");
		f.setSize(450, 450); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}