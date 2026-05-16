package repasoGUIs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class HolaMundo {

	/**
	 * Programa principal que crea y configura una ventana sin herencia
	 * Utilizamos imports
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Implementamos ventana
		JFrame ventana = new JFrame("Ventana: hola mundo!!!");

		// Inicializamos etiqueta
		JLabel etiqueta = new JLabel("Hola holita!!!");
		
		// Traemos el panel principal y añadimos la etiqueta al panel
		ventana.getContentPane().add(etiqueta);
		
		// Configuramos el tamaño de la ventana
		ventana.setSize(300,100);
		
		// Configuramos que se centre en la pantalla
		ventana.setLocationRelativeTo(null);
		
		// Configuramos que sea visible 
		ventana.setVisible(true);
		
		// Configuramos que al cerrar cierre también las funciones
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
