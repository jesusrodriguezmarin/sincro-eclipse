package GUIs.Fecha;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FechaHoy04 extends JFrame {

	/**
	 * Componentes de la ventana
	 */
	private JLabel fecha;
	private JLabel fecha1;
	private JLabel hora;

	/**
	 * Constructor
	 */
	public FechaHoy04() {
		// Sacamos la fecha de hoy
		Date hoy = new Date();

		// Para la fecha
		String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(hoy);

		// Para el día en letra
		String diaHoy = new SimpleDateFormat("EEEE").format(hoy);
		
		// Para la hora
		String horaHoy = new SimpleDateFormat("HH:mm:ss a").format(hoy);

		// Creamos componente JLabel
		fecha1 = new JLabel(diaHoy);
		// Configuramos la fuente y tamaño
		fecha1.setFont(new Font("Arial", Font.ITALIC, 50));
		// Centramos en ejes X Y
		fecha1.setHorizontalAlignment(SwingConstants.CENTER);


		// Creamos componente JLabel
		fecha = new JLabel(fechaHoy);
		// Configuramos la fuente y tamaño
		fecha.setFont(new Font("Arial", Font.ITALIC, 50));
		// Centramos en ejes X Y
		fecha.setHorizontalAlignment(SwingConstants.CENTER);

		
		

		// Creamos componente JLabel
		hora = new JLabel(horaHoy);
		// Configuramos la fuente y tamaño
		hora.setFont(new Font("Arial", Font.ITALIC, 50));
		// Centramos en ejes X Y
		hora.setHorizontalAlignment(SwingConstants.CENTER);

		setLayout(new GridLayout(0,1,0,25));
		add(fecha1);
		add(fecha);
		add(hora);

	}

	/**
	 * Creamos y configuramos la ventana
	 */
	public static void main(String[] args) {

		// Creamos objeto FechaHoy01
		FechaHoy04 d = new FechaHoy04();

		// Configuramos
		d.setTitle("Fecha de hoy:");

		// pack ajusta el texto al tamaño
		d.pack();

		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);
		d.setVisible(true);

	}

}
