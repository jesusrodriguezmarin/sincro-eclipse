package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAbrir;

	public VentanaPrincipal() {
		// 1. Configuración básica de la ventana principal
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null); // La centra en la pantalla
		
		// 2. Panel contenedor
		contentPane = new JPanel();
		contentPane.setLayout(null); // Layout absoluto para colocar el botón a mano
		setContentPane(contentPane);

		// 3. Botón para abrir la ventana secundaria
		btnAbrir = new JButton("Abrir Ventana Secundaria");
		btnAbrir.setBounds(100, 110, 250, 40);
		btnAbrir.addActionListener(this); // Importante: registrar el listener
		contentPane.add(btnAbrir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAbrir) {
			// Lógica para abrir la ventana secundaria
			// 'this' indica que esta ventana es la madre
			// 'true' indica que es modal (bloquea la de atrás)
			VentanaSecundaria secundaria = new VentanaSecundaria(this, true);
			secundaria.setVisible(true);
		}
	}

	public static void main(String[] args) {
		// Punto de arranque de la aplicación
		VentanaPrincipal frame = new VentanaPrincipal();
		frame.setVisible(true);
	}
}