package GUIs.ejemplos.Absoluto;

import javax.swing.*;

public class TexrAreaBasico extends JFrame {

	// Componentes
	JTextArea area;
	JScrollPane scpanel;
	JLabel etiqueta;

	// Creamos una ventana con un JTextArea y un JScrollPane
	public TexrAreaBasico() {
		
		setLayout(null);
		
		JLabel etiqueta = new JLabel("Escribe tus comentarios:");
		add(etiqueta);
		
		JTextArea area = new JTextArea();
		area.setLineWrap(true);
		
		JScrollPane scpanel = new JScrollPane(area);
		scpanel.setBounds(10, 10, 225, 150);
		add(scpanel);
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos el objeto
		TexrAreaBasico s = new TexrAreaBasico();
		
		
		s.setDefaultCloseOperation(EXIT_ON_CLOSE);
		s.setTitle("Comentarios:");
		s.setBounds(10, 30, 300, 250);
		s.setVisible(true);
	}

}
