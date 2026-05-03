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
	 * Declaración de todos los componentes que vamos a usar en el Frame
	 */
	private JLabel etiqueta1, etiqueta2;
	private JTextArea area;
	private JScrollPane scroll;
	private JTextField campo;
	private JButton boton;

	/**
	 * Constructor
	 * Inicialización de todos los componentes declarados para este Frame
	 */
	public ActionListenerBuscarPalabra() {
		// Posicionamiento absoluto
		setLayout(null);

		// Añadimos etiqueta para el texto
		etiqueta1 = new JLabel("Escribe el texto: ");
		// Tamaño
		etiqueta1.setBounds(20, 15, 120, 25);
		add(etiqueta1);

		// Añadimos el JTextArea
		area = new JTextArea();
		area.setLineWrap(true);
		// Añadimos la opción scroll en el TextArea
		scroll = new JScrollPane(area);
		scroll.setBounds(20, 45, 380, 100);
		add(scroll);

		// Añadimos la etiqueta para el campo de texto
		etiqueta2 = new JLabel("Palabra a buscar: ");
		etiqueta2.setBounds(20, 170, 120, 25);
		add(etiqueta2);

		// Añadimos el campo de texto
		campo = new JTextField(16);
		campo.setBounds(130, 170, 160, 25);
		add(campo);

		// Añadimos el botón para buscar
		boton = new JButton("Buscar");
		boton.setBounds(300, 170, 100, 25);
		add(boton);
		boton.addActionListener(this);
	}

	/**
	 * Función que relaciona la acción con el botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Para la acción del botón
		if (e.getSource()==boton) {
			
			// Variables para capturar el texto de los campos
			String texto = area.getText();
			String palabra = campo.getText();
			
			// Si pulsamos sin introducir palabra
			if (palabra.length()==0) {
				setTitle("Introduce la palabra a buscar");
			} else {
				// Si hay palabra, verificamos si es igual a -1 no se encuentra
				if (texto.indexOf(palabra)==-1) {
					setTitle("No se ha encontrado la palabra en el texto");	
				} else {
					// Si es diferente de -1 si se encuentra
					setTitle("Se ha encontrado la palabra en el texto");
				}
			}
		}
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos una instancia de buscar palabra
		ActionListenerBuscarPalabra b = new ActionListenerBuscarPalabra();
		
		// Configuramos
		b.setTitle("Buscador");
		b.setSize(500, 250);
		b.setLocationRelativeTo(null);
		b.setDefaultCloseOperation(EXIT_ON_CLOSE);
		b.setVisible(true);
	}

}
