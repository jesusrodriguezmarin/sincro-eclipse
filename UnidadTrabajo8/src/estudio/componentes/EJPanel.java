package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class EJPanel extends JFrame {

	private JPanel contentPane;
	private JPanel panelInterno; // El sub-panel que vamos a crear

	public EJPanel() {
		// 1. Configuración de la ventana principal
		setTitle("Ventana con Sub-Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		
		// 2. El contenedor principal
		contentPane = new JPanel();
		contentPane.setLayout(null); 
		setContentPane(contentPane);

		// 3. Creación del Sub-Panel (el "recuadro" interno)
		panelInterno = new JPanel();
		panelInterno.setLayout(null); // Para colocar cosas dentro de este panel
		
		// Color de fondo y posición dentro de la ventana
		panelInterno.setBackground(new Color(230, 230, 250)); // Un lila suave
		panelInterno.setBounds(50, 50, 380, 250);
		
		// El Borde: Muy útil para organizar secciones en el examen
		panelInterno.setBorder(new TitledBorder("Sección de Datos"));
		
		// Añadimos el sub-panel al panel principal
		contentPane.add(panelInterno);
	}

	public static void main(String[] args) {
		EJPanel frame = new EJPanel();
		frame.setVisible(true);
	}
}