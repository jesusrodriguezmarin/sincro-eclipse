package repasoGUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.WindowConstants;

public class VentanaPrincipal extends JFrame implements ActionListener {

	/**
	 * Declaración de componentes
	 */
	private JPanel panelBoton;
	private JButton boton;
	
	/**
	 * Constructor
	 */
	public VentanaPrincipal() {
		
		// Establecemos un border general para meter el panelBoton al centro
		setLayout(new BorderLayout());
		
		// Inicializamos el panel para el botón con un flow
		panelBoton = new JPanel(new FlowLayout());

		// Centramos el boton
		panelBoton.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		// Inicializamos y añadimos botón
		boton = new JButton("CLICK");
		boton.addActionListener(this);
		panelBoton.add(boton);
		
		// Añadimos el panel del botón
		add(panelBoton, BorderLayout.CENTER);
	}
	
	/**
	 * Método que activa la aparición de una ventana secundaria con el click del botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == boton) {
			
			// Instanciamos la ventana secundaria previamente creada
			VentanaSecundaria secundaria = new VentanaSecundaria();
			
			// Damos propiedades básicas
			secundaria.setLocationRelativeTo(this);
			
			// Hacemos visible
			secundaria.setVisible(true);
			
		}
		
	}
	
	/**
	 * Programa principal que llama a una ventana secundaria
	 * @param args
	 */
	public static void main(String[] args) {
		
		VentanaPrincipal principal = new VentanaPrincipal();
		
		principal.setTitle("VENTANA PRINCIPAL");
		principal.setSize(600,300);
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

	}


}
