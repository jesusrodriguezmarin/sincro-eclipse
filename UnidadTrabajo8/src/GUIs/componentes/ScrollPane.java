package GUIs.componentes;

import javax.swing.*;

public class ScrollPane extends JFrame {

	// Componentes
	JTextArea area;
	JScrollPane scpanel;

	// Creamos una ventana con un JTextArea y un JScrollPane
	public ScrollPane() {
		
		setLayout(null);
		
		JTextArea area = new JTextArea();
		area.setLineWrap(true);
		
		JScrollPane scpanel = new JScrollPane(area);
		scpanel.setBounds(10, 10, 225, 150);
		add(scpanel);
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos el objeto
		ScrollPane s = new ScrollPane();
		
		s.setDefaultCloseOperation(EXIT_ON_CLOSE);
		s.setTitle("Ejemplo ScrollPanel");
		s.setBounds(10, 30, 300, 250);
		s.setVisible(true);
	}

}
