package GUIs.posibles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AgendaTecladoCentro extends JFrame implements ActionListener {

	private JPanel panelDatos, panelLista, panelTeclado, contenedorTeclado;
	private JTextField campoNombre, campoTelefono;
	private JTextArea areaContactos;
	private JButton botonAñadir, botonLimpiar;

	public AgendaTecladoCentro() {
		setLayout(new BorderLayout(10, 10));
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// --- bloque superior (north): entrada de datos ---
		panelDatos = new JPanel(new GridLayout(0, 1, 0, 5));
		campoNombre = new JTextField();
		campoTelefono = new JTextField();

		panelDatos.add(new JLabel("nombre del contacto:"));
		panelDatos.add(campoNombre);
		panelDatos.add(new JLabel("teléfono / móvil:"));
		panelDatos.add(campoTelefono);
		
		botonAñadir = new JButton("añadir a la agenda");
		JPanel pBotonA = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBotonA.add(botonAñadir);
		panelDatos.add(pBotonA);

		add(panelDatos, BorderLayout.NORTH);

		// --- bloque central (center): area de contactos ---
		panelLista = new JPanel(new BorderLayout(0, 5));
		areaContactos = new JTextArea();
		areaContactos.setEditable(false);
		areaContactos.setBackground(new Color(245, 245, 245));
		JScrollPane scroll = new JScrollPane(areaContactos);
		
		panelLista.add(new JLabel("contactos guardados en el sistema:"), BorderLayout.NORTH);
		panelLista.add(scroll, BorderLayout.CENTER);
		
		botonLimpiar = new JButton("limpiar listado");
		JPanel pBotonL = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBotonL.add(botonLimpiar);
		panelLista.add(pBotonL, BorderLayout.SOUTH);

		add(panelLista, BorderLayout.CENTER);

		// --- bloque inferior (south): teclado virtual numérico ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		panelTeclado = new JPanel(new GridLayout(4, 3, 5, 5));
		panelTeclado.setPreferredSize(new Dimension(250, 180)); 
		
		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton("" + i);
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// Fila inferior con paneles vacíos para centrar el 0
		panelTeclado.add(new JPanel()); 
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 14));
		btn0.setFocusable(false);
		btn0.addActionListener(this);
		panelTeclado.add(btn0);
		
		panelTeclado.add(new JPanel());
		
		contenedorTeclado.add(panelTeclado);
		add(contenedorTeclado, BorderLayout.SOUTH);

		botonAñadir.addActionListener(this);
		botonLimpiar.addActionListener(this);

		setTitle("Agenda con Teclado Numérico");
		setSize(650, 750); 
		setMinimumSize(new Dimension(600, 700));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();

			// Si es un dígito virtual, se añade al teléfono
			if (textoBoton.length() == 1 && Character.isDigit(textoBoton.charAt(0))) {
				campoTelefono.setText(campoTelefono.getText() + textoBoton);
			}
		}

		if (e.getSource() == botonAñadir) {
			String n = campoNombre.getText();
			String t = campoTelefono.getText();
			
			if (n.isEmpty() || t.isEmpty()) {
				JOptionPane.showMessageDialog(this, "debes introducir nombre y teléfono");
			} else {
				areaContactos.append("contacto: " + n + " -> móvil: " + t + "\n");
				campoNombre.setText("");
				campoTelefono.setText("");
			}
		}

		if (e.getSource() == botonLimpiar) {
			areaContactos.setText("");
			campoNombre.setText("");
			campoTelefono.setText("");
		}
	}

	public static void main(String[] args) {
		new AgendaTecladoCentro();
	}
}