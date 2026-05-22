package MAC.modificar;

import java.awt.event.*;
import javax.swing.*;

public class FormularioModificarP extends JFrame implements ActionListener {

	private JTextField codigo, nombre, color, peso, ciudad;
	private JLabel titulo, lblListado, cod, nom, col, pes, ciu;
	private JButton modificar, borrar; 
	private JScrollPane sc;
	private JTable tabla;
	private ConexionModificarP con;

	public FormularioModificarP() {
		setLayout(null);

		titulo = new JLabel("Modificar Pieza (Introduce código y nuevos datos):");
		titulo.setBounds(30, 20, 380, 25);
		add(titulo);

		cod = new JLabel("Código (pn): ");
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

		col = new JLabel("Nuevo Color: ");
		col.setBounds(30, 140, 100, 25);
		add(col);
		color = new JTextField();
		color.setBounds(130, 140, 150, 25);
		add(color);

		pes = new JLabel("Nuevo Peso: ");
		pes.setBounds(30, 180, 100, 25);
		add(pes);
		peso = new JTextField();
		peso.setBounds(130, 180, 100, 25);
		add(peso);

		ciu = new JLabel("Nueva Ciudad: ");
		ciu.setBounds(30, 220, 100, 25);
		add(ciu);
		ciudad = new JTextField();
		ciudad.setBounds(130, 220, 150, 25);
		add(ciudad);

		modificar = new JButton("Modificar");
		modificar.setBounds(90, 270, 130, 25);
		modificar.addActionListener(this);
		add(modificar);

		borrar = new JButton("Borrar campos");
		borrar.setBounds(240, 270, 130, 25);
		borrar.addActionListener(this);
		add(borrar);

		lblListado = new JLabel("Listado de piezas:");
		lblListado.setBounds(30, 310, 200, 25);
		add(lblListado);

		tabla = new JTable();
		sc = new JScrollPane(tabla);
		sc.setBounds(30, 340, 380, 120);
		add(sc);

		con = new ConexionModificarP();
		con.obtenerConexion(); 
		con.mostrarP(tabla);
		con.desconectar();
	}

	public void limpiar() {
		codigo.setText("");
		nombre.setText("");
		color.setText("");
		peso.setText("");
		ciudad.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String code = codigo.getText();
			String name = nombre.getText();
			String clr = color.getText();
			String weight = peso.getText();
			String city = ciudad.getText();

			if (e.getSource() == modificar) {
				if (code.isEmpty() || name.isEmpty() || city.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Código, Nombre y Ciudad son obligatorios", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
				} else {
					con = new ConexionModificarP();
					con.obtenerConexion(); 
					con.modificarP(code, name, clr, weight, city); 
					con.mostrarP(tabla); 
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
		FormularioModificarP f = new FormularioModificarP();
		f.setTitle("MODIFICAR PIEZA");
		f.setSize(460, 530); 
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}