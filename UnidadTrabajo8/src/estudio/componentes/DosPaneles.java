package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class DosPaneles extends JFrame {

	private JPanel contentPane;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;

	public DosPaneles() {
		// 1. Configuración de la ventana
		setTitle("Ventana con Paneles Divididos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		
		// 2. Contenedor principal
		contentPane = new JPanel();
		contentPane.setLayout(null); 
		setContentPane(contentPane);

		// 3. PANEL IZQUIERDO (Ocupa la mitad izquierda)
		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(null);
		panelIzquierdo.setBounds(20, 20, 260, 300); // x, y, ancho, alto
		panelIzquierdo.setBorder(new TitledBorder("Panel Izquierdo"));
		panelIzquierdo.setBackground(new Color(240, 240, 240));
		contentPane.add(panelIzquierdo);

		// 4. PANEL DERECHO (Ocupa la mitad derecha)
		panelDerecho = new JPanel();
		panelDerecho.setLayout(null);
		panelDerecho.setBounds(300, 20, 260, 300); // x empieza donde acaba el otro + margen
		panelDerecho.setBorder(new TitledBorder("Panel Derecho"));
		panelDerecho.setBackground(new Color(220, 230, 240));
		contentPane.add(panelDerecho);
	}

	public static void main(String[] args) {
		DosPaneles frame = new DosPaneles();
		frame.setVisible(true);
	}
}