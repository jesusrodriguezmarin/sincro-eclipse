package boletin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaSecundariaInfo extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JPanel panelPrincipal, subPanel;
	private JLabel mensaje;
	private JButton cerrar;
	
	/**
	 * Constructor
	 */
	public VentanaSecundariaInfo () {
		
		// Configuramos la ventana
		setTitle("Información");
		
		// Panel para albergar los componentes
		panelPrincipal = new JPanel(new BorderLayout(15,15));
		// Añadimos el panel al Frame
		setContentPane(panelPrincipal);
		
		// Añadimos la etiqueta para el mensaje centrado
		mensaje = new JLabel("Genera tus números", SwingConstants.CENTER);
		// Aplicamos la fuente 
		mensaje.setFont(new Font("Arial", Font.PLAIN, 13));
		// Añadimos al panel creado, centrado con BorderLayout
		panelPrincipal.add(mensaje, BorderLayout.CENTER);
		
		// Añadimos botón para cerrar la ventana
		cerrar = new JButton("Cerrar");
		// Conectamos el botón con el método
		cerrar.addActionListener(this);
		
		// Creamos otro panel para el botón para restringir el ancho de este
		subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// Añadimos el botón al panel
		subPanel.add(cerrar);
		// Añadimos el subpanel al panel principal en el sur de este
		panelPrincipal.add(subPanel, BorderLayout.SOUTH);
		
		// Establecemos un tamaño preferido
		panelPrincipal.setPreferredSize(new Dimension(350, 150));
		// Ajustamos al tamaño del contenido
		pack();
		// Restringimos la amplización
		setResizable(false);
		
	}
	
	/**
	 * Método de acción del botón cerrar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Ordenamos el cierre de la ventana
		dispose();
	}

}
