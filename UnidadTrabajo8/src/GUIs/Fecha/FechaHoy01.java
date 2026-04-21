package GUIs.Fecha;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FechaHoy01 extends JFrame {
	
	/**
	 * Componentes de la ventana
	 */
	private JLabel fecha;

	/**
	 * Constructor
	 */
	public FechaHoy01() {
		// Sacamos la fecha de hoy
		Date hoy = new Date();
		String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(hoy);	
		
		// Creamos componente JLabel
		fecha = new JLabel(fechaHoy);
		// Configuramos la fuente y tamaño
		fecha.setFont(new Font("Arial", Font.ITALIC, 50));
		// Centramos en ejes X Y
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Creamos y aplicamos el Layout
		setLayout(new BorderLayout(0,0));
		// Añadimos
		add(fecha, BorderLayout.CENTER);
	}
	
	/**
	 * Creamos y configuramos la ventana
	 */
	public static void main(String[] args) {
		
		// Creamos objeto FechaHoy01
		FechaHoy01 d = new FechaHoy01();
		
		// Configuramos
		d.setTitle("Fecha de hoy:");
		d.setSize(400, 150);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);

	}

}
