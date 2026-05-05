package GUIs.listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DiseñoyCentradoLetrasFechaHoy extends JFrame {
	
	/**
	 * Componentes de la ventana
	 */
	private JLabel fecha;

	/**
	 * Constructor
	 */
	public DiseñoyCentradoLetrasFechaHoy() {
		// Sacamos la fecha de hoy
		Date hoy = new Date();
		String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(hoy);	
		
		// Creamos componente JLabel
		fecha = new JLabel(fechaHoy);
		// Configuramos la fuente y tamaño
		fecha.setFont(new Font("Arial", Font.ITALIC, 50));
		// Centramos en ejes X Y
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		// Centramos la letra
		fecha.setHorizontalAlignment(SwingConstants.CENTER);
		// Damos color a la letra
		fecha.setForeground(Color.LIGHT_GRAY);
		// Damos color al tema, al Pane
		getContentPane().setBackground(Color.DARK_GRAY);
		
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
		DiseñoyCentradoLetrasFechaHoy d = new DiseñoyCentradoLetrasFechaHoy();
		
		// Configuramos
		d.setTitle("Fecha de hoy:");
		d.setSize(400, 150);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);

	}

}
