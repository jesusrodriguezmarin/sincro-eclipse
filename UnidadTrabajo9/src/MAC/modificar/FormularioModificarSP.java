package MAC.modificar;

import java.awt.event.*;
import javax.swing.*;

public class FormularioModificarSP extends JFrame implements ActionListener {

	private JTextField txtCodS, txtCodP, txtCantidad;
	private JLabel titulo, lblListado, lblCodS, lblCodP, lblCantidad;
	private JButton modificar, borrar; 
	private JScrollPane sc;
	private JTable tabla;
	private ConexionModificarSP con;

	public FormularioModificarSP() {
		setLayout(null);

		titulo = new JLabel("Modificar Cantidad de Envío (Clave compuesta SP):");
		titulo.setBounds(30, 20, 380, 25);
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

		lblCantidad = new JLabel("Nueva Cantidad: ");
		lblCantidad.setBounds(30, 140, 110, 25);
		add(lblCantidad);
		txtCantidad = new JTextField();
		txtCantidad.setBounds(150, 140, 100, 25);
		add(txtCantidad);

		modificar = new JButton("Modificar Cant.");
		modificar.setBounds(90, 190, 130, 25);
		modificar.addActionListener(this);
		add(modificar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(240, 190, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de envíos registrados:");
		lblListado.setBounds(30, 240, 250, 25);
		add(lblListado);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 270, 380, 140);
		add(sc);

		con = new ConexionModificarSP();
		con.obtenerConexion(); 
		con.mostrarSP(tabla);
		con.desconectar();
	}

	public void limpiar() {
		txtCodS.setText("");
		txtCodP.setText("");
		txtCantidad.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String codeS = txtCodS.getText();
			String codeP = txtCodP.getText();
			String qty = txtCantidad.getText();

			if (e.getSource() == modificar) {
				if (codeS.isEmpty() || codeP.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Los códigos de Proveedor y Pieza son obligatorios", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionModificarSP();
					con.obtenerConexion(); 
					con.modificarSP(codeS, codeP, qty); 
					con.mostrarSP(tabla); 
					con.desconectar(); 
					limpiar();
				}
			}
			if (e.getSource() == borrar) {
				limpiar();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FormularioModificarSP f = new FormularioModificarSP();
		f.setTitle("MODIFICAR ENVÍO (SP)");
		f.setSize(460, 470); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}