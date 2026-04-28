package GUIs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListenerBuscarPalabra extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JLabel etiqueta1, etiqueta2;
	private JTextArea area;
	private JScrollPane scroll;
	private JTextField campo;
	private JButton boton;

	/**
	 * Constructor
	 */
	public ActionListenerBuscarPalabra() {
		// Posicionamiento absoluto
		setLayout(null);

		// Añadimos los componentes a la ventana
		etiqueta1 = new JLabel("Escribe el texto: ");
		etiqueta1.setBounds(20, 15, 120, 25);
		add(etiqueta1);

		area = new JTextArea();
		area.setLineWrap(true);
		scroll = new JScrollPane(area);
		scroll.setBounds(20, 45, 380, 100);
		add(scroll);

		etiqueta2 = new JLabel("Palabra a buscar: ");
		etiqueta2.setBounds(20, 170, 120, 25);
		add(etiqueta2);

		campo = new JTextField(16);
		campo.setBounds(130, 170, 160, 25);
		add(campo);

		boton = new JButton("Buscar");
		boton.setBounds(300, 170, 100, 25);
		add(boton);
		boton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==boton) {
			String texto = area.getText();
			String palabra = campo.getText();
			
			if (palabra.length()==0) {
				setTitle("Introduce la palabra a buscar");
			} else {
				if (texto.indexOf(palabra)==-1) {
					setTitle("No se ha encontrado la palabra en el texto");	
				} else {
					setTitle("Se ha encontrado la palabra en el texto");
				}
			}
		}
	}

	// Programa principal
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
