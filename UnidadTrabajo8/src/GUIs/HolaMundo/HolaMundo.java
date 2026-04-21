package GUIs.HolaMundo;

// Importamos toda la libreria de javax.swing
import javax.swing.*;

public class HolaMundo {

	// Programa principal con todo dentro del main
	public static void main(String[] args) {

		// Creamos un objeto Ventana con titulo
		JFrame ventana = new JFrame("Ventana HolaMundo");	// Titulo de la ventana
		
		// Contenido
		JLabel etiqueta = new JLabel("Holita Mundito");
		ventana.getContentPane().add(etiqueta);
		
		ventana.setSize(300, 100);
		ventana.pack();
		//ventana.setBounds(0, 300, 300, 0);
		ventana.setLocationRelativeTo(null);
		
		// Al estar en false, no permite extender la ventana manualmente 
		ventana.setResizable(false);
		
		// Estos dos métodos deben ser las últimas dos líneas
		ventana.setVisible(true);	
		// Cierra ventana y aplicación
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}
