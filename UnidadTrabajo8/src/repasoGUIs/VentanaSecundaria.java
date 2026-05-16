package repasoGUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaSecundaria extends JDialog implements ActionListener {

	/**
	 * Declaración de componentes
	 */
	private JPanel panelBotones;
	private JLabel mensaje;
	private JButton cerrar, salir;
	
	/**
	 * Constructor
	 */
	public VentanaSecundaria() {
		
		// Establecemos el layout border para el panel general
		setLayout(new BorderLayout(10,10));
		
		// Configuramos
		setTitle("SECUNDARIA");
		setSize(300, 150);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		// Inicializamos y centramos la etiqueta
		mensaje = new JLabel("YEEESSS", SwingConstants.CENTER);
		// Añadimos la etiqueta al centro del border
		add(mensaje, BorderLayout.CENTER);
		
		// Inicializamos un nuevo panel para los botones con un Flow
		panelBotones = new JPanel(new FlowLayout());
		
		// Metemos los botones en su panel específico
		cerrar = new JButton("CERRAR");
		cerrar.addActionListener(this);
		panelBotones.add(cerrar);
		
		salir = new JButton("SALIR");
		salir.addActionListener(this);
		panelBotones.add(salir);
		
		// Añadimos el panel de botones al sur del principal
		add(panelBotones, BorderLayout.SOUTH);
	}

	/**
	 * Método para cerrar la ventana al pulsar el botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == cerrar) {
			dispose();
		}
		if (e.getSource() == salir) {
			System.exit(0);
		}
		
	}
	

}
