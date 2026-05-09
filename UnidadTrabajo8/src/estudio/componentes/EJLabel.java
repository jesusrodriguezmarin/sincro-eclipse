package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class EJLabel extends JFrame {

	private JPanel contentPane;
	private JLabel lblPrincipal;

	public EJLabel() {
		// 1. Configuración de la ventana
		setTitle("Ventana con Etiqueta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		
		// 2. Configuración del panel contenedor
		contentPane = new JPanel();
		contentPane.setLayout(null); // Layout absoluto para mover la etiqueta libremente
		setContentPane(contentPane);

		// 3. La Etiqueta
		lblPrincipal = new JLabel("¡Hola Mundo!", SwingConstants.CENTER);
		lblPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrincipal.setForeground(Color.BLUE);
		
		// Posición y tamaño (x, y, ancho, alto)
		lblPrincipal.setBounds(50, 100, 300, 40);
		
		// Añadir al panel
		contentPane.add(lblPrincipal);
	}

	public static void main(String[] args) {
		EJLabel frame = new EJLabel();
		frame.setVisible(true);
	}
}