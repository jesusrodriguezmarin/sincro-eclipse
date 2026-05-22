package MAC.nuevos.buscar.p;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormBuscarRadioP extends JFrame implements ActionListener {

	private JTextField txtBusqueda;
	private JLabel lblTitulo, lblBuscarPor, lblTexto;
	private JRadioButton rbCodigo, rbNombre, rbColor, rbPeso, rbCiudad;
	private ButtonGroup grupoCriterios; 
	private JButton btnBuscar, btnLimpiar; 
	private JScrollPane sc;
	private JTable tabla;
	
	private ConexBuscarRadioP con;

	public FormBuscarRadioP() {
		setLayout(null);

		lblTitulo = new JLabel("Buscador de Piezas por Coincidencia Exacta:");
		lblTitulo.setBounds(30, 20, 380, 25);
		add(lblTitulo);

		lblBuscarPor = new JLabel("Criterio:");
		lblBuscarPor.setBounds(30, 60, 60, 25);
		add(lblBuscarPor);

		rbCodigo = new JRadioButton("Código", true); 
		rbCodigo.setBounds(100, 60, 75, 25);
		add(rbCodigo);

		rbNombre = new JRadioButton("Nombre");
		rbNombre.setBounds(175, 60, 80, 25);
		add(rbNombre);

		rbColor = new JRadioButton("Color");
		rbColor.setBounds(255, 60, 65, 25);
		add(rbColor);

		rbPeso = new JRadioButton("Peso");
		rbPeso.setBounds(320, 60, 65, 25);
		add(rbPeso);

		rbCiudad = new JRadioButton("Ciudad");
		rbCiudad.setBounds(385, 60, 80, 25);
		add(rbCiudad);

		grupoCriterios = new ButtonGroup();
		grupoCriterios.add(rbCodigo);
		grupoCriterios.add(rbNombre);
		grupoCriterios.add(rbColor);
		grupoCriterios.add(rbPeso);
		grupoCriterios.add(rbCiudad);

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
					con = new ConexBuscarRadioP();
					con.obtenerConexion();
					
					String criterioActivo = "";
					if (rbCodigo.isSelected()) {
						criterioActivo = "Código";
					} else if (rbNombre.isSelected()) {
						criterioActivo = "Nombre";
					} else if (rbColor.isSelected()) {
						criterioActivo = "Color";
					} else if (rbPeso.isSelected()) {
						criterioActivo = "Peso";
					} else if (rbCiudad.isSelected()) {
						criterioActivo = "Ciudad";
					}
					
					con.buscarPiezaPorCriterio(tabla, criterioActivo, textoFiltro);
					
					con.desconectar();
				}
			}

			if (e.getSource() == btnLimpiar) {
				txtBusqueda.setText("");
				rbCodigo.setSelected(true); 
				tabla.setModel(new DefaultTableModel()); 
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormBuscarRadioP f = new FormBuscarRadioP();
		f.setTitle("BÚSQUEDA EXACTA DE PIEZAS");
		f.setSize(490, 450); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}