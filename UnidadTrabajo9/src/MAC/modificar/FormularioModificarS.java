package MAC.modificar;

import java.awt.event.*;
import javax.swing.*;

public class FormularioModificarS extends JFrame implements ActionListener {

	private JTextField codigo, nombre, estado, ciudad;
	private JLabel titulo, lblListado, cod, nom, est, ciu;
	private JButton modificar, borrar; 
	private JScrollPane sc;
	private JTable tabla;
	private ConexionModificarS con;

	public FormularioModificarS() {
		setLayout(null);

		titulo = new JLabel("Modificar Proveedor (Introduce código y nuevos datos):");
		titulo.setBounds(30, 20, 380, 25);
		add(titulo);

		cod = new JLabel("Código (sn): ");
		cod.setBounds(30, 60, 90, 25);
		add(cod);
		codigo = new JTextField();
		codigo.setBounds(130, 60, 100, 25);
		add(codigo);

		nom = new JLabel("Nuevo Nombre: ");
		nom.setBounds(30, 100, 100, 25);
		add(nom);
		nombre = new JTextField();
		nombre.setBounds(130, 100, 150, 25);
		add(nombre);

		est = new JLabel("Nuevo Estado: ");
		est.setBounds(30, 140, 100, 25);
		add(est);
		estado = new JTextField();
		estado.setBounds(130, 140, 100, 25);
		add(estado);

		ciu = new JLabel("Nueva Ciudad: ");
		ciu.setBounds(30, 180, 100, 25);
		add(ciu);
		ciudad = new JTextField();
		ciudad.setBounds(130, 180, 150, 25);
		add(ciudad);

		modificar = new JButton("Modificar");
		modificar.setBounds(90, 230, 130, 25);
		modificar.addActionListener(this);
		add(modificar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(240, 230, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de proveedores:");
		lblListado.setBounds(30, 280, 200, 25);
		add(lblListado);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 310, 380, 130);
		add(sc);

		con = new ConexionModificarS();
		con.obtenerConexion(); 
		con.mostrarS(tabla);
		con.desconectar();
	}

	public void limpiar() {
		codigo.setText("");
		nombre.setText("");
		estado.setText("");
		ciudad.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String code = codigo.getText();
			String name = nombre.getText();
			String state = estado.getText();
			String city = ciudad.getText();

			if (e.getSource() == modificar) {
				if (code.isEmpty() || name.isEmpty() || city.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Código, Nombre y Ciudad son obligatorios", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionModificarS();
					con.obtenerConexion(); 
					con.modificarS(code, name, state, city); 
					con.mostrarS(tabla); 
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
		FormularioModificarS f = new FormularioModificarS();
		f.setTitle("MODIFICAR PROVEEDOR");
		f.setSize(460, 500); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}