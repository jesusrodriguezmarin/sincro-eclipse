package GUIs.Fecha;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FechaHoy02 extends JFrame {
	
	/**
	 * Componentes de la ventana
	 */
	private JLabel fecha;

	/**
	 * Constructor
	 */
	public FechaHoy02() {
		// Sacamos la fecha de hoy
		Date hoy = new Date();
		String fechaHoy = new SimpleDateFormat("EEEE dd/MM/yyyy").format(hoy);	
		
		
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
		FechaHoy02 d = new FechaHoy02();
		
		// Configuramos
		d.setTitle("Fecha de hoy:");
		
		// pack ajusta el texto al tamaño
		d.pack();
		
		// Resto de configuración
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);

	}

}
