package GUIs.dados;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DadoImagenesArrayMac extends JFrame implements ActionListener {

	// Atributos
	private JButton boton;
	// Creamos un array para guardar las 6 imágenes y no cargarlas cada vez
	private ImageIcon[] carasDado = new ImageIcon[6];

	/**
	 * Constructor
	 */
	public DadoImagenesArrayMac() {
		
		// 1. Cargamos las imágenes en el array (ajusta la ruta si es necesario)
		// He usado una lógica de bucle para ahorrar líneas
		String rutaBase = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dado/dados/";
		carasDado[0] = new ImageIcon(rutaBase + "uno.png");
		carasDado[1] = new ImageIcon(rutaBase + "dos.png");
		carasDado[2] = new ImageIcon(rutaBase + "tres.png");
		carasDado[3] = new ImageIcon(rutaBase + "cuatro.png");
		carasDado[4] = new ImageIcon(rutaBase + "cinco.png");
		carasDado[5] = new ImageIcon(rutaBase + "seis.png");

		// 2. Configuramos el botón con la primera cara
		boton = new JButton(carasDado[0]);
		boton.addActionListener(this);

		// 3. Diseño de la ventana
		setLayout(new GridLayout(1, 1));
		add(boton);

		// 4. Configuración del Frame (metida aquí para limpiar el main)
		setTitle("Dado");
		setSize(150, 150);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Lógica del clic
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) {
			// Generamos número del 0 al 5 (para que coincida con los índices del array)
			int indiceAleatorio = (int) (Math.random() * 6);
			
			// Cambiamos el icono usando el array (mucho más rápido que leer el disco)
			boton.setIcon(carasDado[indiceAleatorio]);
		}
	}

	// Programa principal reducido al mínimo
	public static void main(String[] args) {
		// Simplemente lanzamos la aplicación
		new DadoImagenesArrayMac();
	}
}
