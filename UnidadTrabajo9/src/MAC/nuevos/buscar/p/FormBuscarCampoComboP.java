package MAC.nuevos.buscar.p;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBuscarCampoComboP extends JFrame implements ActionListener {

	private JTextField txtBusqueda;
	private JLabel lblTitulo, lblBuscarPor, lblTexto;
	private JComboBox<String> comboCampos; 
	private JButton btnBuscar, btnLimpiar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexBuscarCampoComboP con;

	public FormBuscarCampoComboP() {
		setLayout(null);

		lblTitulo = new JLabel("Buscador Avanzado de Piezas:");
		lblTitulo.setBounds(30, 20, 300, 25);
		add(lblTitulo);

		lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(30, 60, 100, 25);
		add(lblBuscarPor);

		comboCampos = new JComboBox<>();
		comboCampos.addItem("Código");
		comboCampos.addItem("Nombre");
		comboCampos.addItem("Color"); 
		comboCampos.addItem("Peso"); 
		comboCampos.addItem("Ciudad");
		comboCampos.setBounds(140, 60, 150, 25);
		add(comboCampos);

		lblTexto = new JLabel("Introducir valor exacto:");
		lblTexto.setBounds(30, 100, 140, 25);
		add(lblTexto);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(180, 100, 150, 25);
		add(txtBusqueda);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(90, 150, 120, 25);
		btnBuscar.addActionListener(this);
		add(btnBuscar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(230, 150, 120, 25);
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 200, 380, 180);
		add(sc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String textoFiltro = txtBusqueda.getText();

			if (e.getSource() == btnBuscar) {
				if (textoFiltro.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un valor para poder realizar la búsqueda", "Campo vacío", JOptionPane.WARNING_MESSAGE);
				} else {
					con = new ConexBuscarCampoComboP();
					con.obtenerConexion();
					
					String campoSeleccionado = comboCampos.getSelectedItem().toString();
					con.buscarPiezaPorCriterio(tabla, campoSeleccionado, textoFiltro);
					
					con.desconectar();
				}
			}

			if (e.getSource() == btnLimpiar) {
				txtBusqueda.setText("");
				comboCampos.setSelectedIndex(0);
				tabla.setModel(new DefaultTableModel()); 
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormBuscarCampoComboP f = new FormBuscarCampoComboP();
		f.setTitle("BÚSQUEDA FILTRADA POR COLUMNA");
		f.setSize(450, 450); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}