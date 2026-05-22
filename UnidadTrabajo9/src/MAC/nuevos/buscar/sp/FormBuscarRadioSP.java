package MAC.nuevos.buscar.sp;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBuscarRadioSP extends JFrame implements ActionListener {

	private JTextField txtBusqueda;
	private JLabel lblTitulo, lblBuscarPor, lblTexto;
	private JRadioButton rbCodProv, rbCodPieza, rbCantidad;
	private ButtonGroup grupoCriterios; 
	private JButton btnBuscar, btnLimpiar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexBuscarRadioSP con;

	public FormBuscarRadioSP() {
		setLayout(null);

		lblTitulo = new JLabel("Buscador de Envíos (SP) por Coincidencia Exacta:");
		lblTitulo.setBounds(30, 20, 380, 25);
		add(lblTitulo);

		lblBuscarPor = new JLabel("Criterio:");
		lblBuscarPor.setBounds(30, 60, 60, 25);
		add(lblBuscarPor);

		rbCodProv = new JRadioButton("Código Prov.", true); 
		rbCodProv.setBounds(100, 60, 110, 25);
		add(rbCodProv);

		rbCodPieza = new JRadioButton("Código Pieza");
		rbCodPieza.setBounds(215, 60, 110, 25);
		add(rbCodPieza);

		rbCantidad = new JRadioButton("Cantidad");
		rbCantidad.setBounds(330, 60, 90, 25);
		add(rbCantidad);

		grupoCriterios = new ButtonGroup();
		grupoCriterios.add(rbCodProv);
		grupoCriterios.add(rbCodPieza);
		grupoCriterios.add(rbCantidad);

		lblTexto = new JLabel("Introducir valor exacto:");
		lblTexto.setBounds(30, 105, 140, 25);
		add(lblTexto);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(180, 105, 150, 25);
		add(txtBusqueda);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(100, 155, 120, 25);
		btnBuscar.addActionListener(this);
		add(btnBuscar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(240, 155, 120, 25);
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 205, 420, 180);
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
					con = new ConexBuscarRadioSP();
					con.obtenerConexion();
					
					String criterioActivo = "";
					if (rbCodProv.isSelected()) {
						criterioActivo = "Código Prov.";
					} else if (rbCodPieza.isSelected()) {
						criterioActivo = "Código Pieza";
					} else if (rbCantidad.isSelected()) {
						criterioActivo = "Cantidad";
					}
					
					con.buscarEnvioPorCriterio(tabla, criterioActivo, textoFiltro);
					
					con.desconectar();
				}
			}

			if (e.getSource() == btnLimpiar) {
				txtBusqueda.setText("");
				rbCodProv.setSelected(true); 
				tabla.setModel(new DefaultTableModel()); 
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormBuscarRadioSP f = new FormBuscarRadioSP();
		f.setTitle("BÚSQUEDA EXACTA DE ENVÍOS SP");
		f.setSize(490, 450); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}