package MAC.nuevos.buscar;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBuscarCiudadRadio extends JFrame implements ActionListener {

	private JTextField txtCiudad;
	private JLabel lblTitulo, lblCiudad;
	private JRadioButton rbProveedores, rbPiezas, rbEnvios; // <-- Añadido rbEnvios
	private ButtonGroup grupoOpciones; 
	private JButton btnBuscar, btnBorrar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexBuscarCiudadRadio con;

	public FormBuscarCiudadRadio() {
		setLayout(null);

		lblTitulo = new JLabel("Buscador por Ciudad Inteligente (Exacto):");
		lblTitulo.setBounds(30, 20, 300, 25);
		add(lblTitulo);

		// --- AJUSTE DE COORDENADAS PARA TRES RADIO BUTTONS ---
		rbProveedores = new JRadioButton("Proveedores", true); 
		rbProveedores.setBounds(30, 60, 110, 25);
		add(rbProveedores);

		rbPiezas = new JRadioButton("Piezas");
		rbPiezas.setBounds(150, 60, 80, 25);
		add(rbPiezas);
		
		rbEnvios = new JRadioButton("Envíos (SP)");
		rbEnvios.setBounds(240, 60, 110, 25);
		add(rbEnvios);

		grupoOpciones = new ButtonGroup();
		grupoOpciones.add(rbProveedores);
		grupoOpciones.add(rbPiezas);
		grupoOpciones.add(rbEnvios); // <-- Integrado en el grupo excluyente

		lblCiudad = new JLabel("Introduce Ciudad Exacta: ");
		lblCiudad.setBounds(30, 110, 150, 25);
		add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(180, 110, 150, 25);
		add(txtCiudad);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(90, 160, 120, 25);
		btnBuscar.addActionListener(this);
		add(btnBuscar);

		btnBorrar = new JButton("Limpiar");
		btnBorrar.setBounds(230, 160, 120, 25);
		btnBorrar.addActionListener(this);
		add(btnBorrar);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 210, 380, 180);
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
					con = new ConexBuscarCiudadRadio();
					con.obtenerConexion();
					
					if (rbProveedores.isSelected()) {
						con.buscarProveedores(tabla, ciudadBuscada);
					} else if (rbPiezas.isSelected()) {
						con.buscarPiezas(tabla, ciudadBuscada);
					} else if (rbEnvios.isSelected()) {
						con.buscarEnvios(tabla, ciudadBuscada); // <-- Redirección al método de SP
					}
					
					con.desconectar();
				}
			}

			if (e.getSource() == btnBorrar) {
				txtCiudad.setText("");
				rbProveedores.setSelected(true); 
				tabla.setModel(new DefaultTableModel()); 
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormBuscarCiudadRadio f = new FormBuscarCiudadRadio();
		f.setTitle("CONSULTA FILTRADA POR RADIOBUTTON");
		f.setSize(450, 460); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}