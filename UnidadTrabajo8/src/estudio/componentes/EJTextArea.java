package estudio.componentes;

import javax.swing.*;

public class EJTextArea extends JFrame {

	private JTextArea areaTexto;
	private JScrollPane scroll;

	public EJTextArea() {
		setTitle("Plantilla JTextArea");
		setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		areaTexto = new JTextArea();
		areaTexto.setLineWrap(true); // Salto de línea automático
		areaTexto.setWrapStyleWord(true); // No corta palabras a la mitad

		// CREAR EL SCROLL Y METER EL AREA DENTRO
		scroll = new JScrollPane(areaTexto);
		scroll.setBounds(20, 20, 340, 200);
		getContentPane().add(scroll);
		
		// Para escribir desde código:
		areaTexto.append("Línea 1...\n");
		areaTexto.append("Línea 2 agregada con append.");
	}

	public static void main(String[] args) { new EJTextArea().setVisible(true); }
}