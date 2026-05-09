package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JButtonSimple extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnPrincipal;

	public JButtonSimple() {
		// 1. Configuración de la ventana
		setTitle("Ventana con Botón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setLocationRelativeTo(null);
		
		// 2. Configuración del panel contenedor
		contentPane = new JPanel();
		contentPane.setLayout(null); 
		setContentPane(contentPane);

		// 3. El Botón
		btnPrincipal = new JButton("Púlsame");
		btnPrincipal.setFont(new Font("Arial", Font.BOLD, 14));
		
		// Posición y tamaño (x, y, ancho, alto)
		btnPrincipal.setBounds(125, 100, 150, 40);
		
		// IMPORTANTE: Registrar el escuchador de eventos
		btnPrincipal.addActionListener(this);
		
		// Añadir al panel
		contentPane.add(btnPrincipal);
	}

	// 4. Método que se ejecuta al pulsar el botón
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrincipal) {
			// Lógica del examen aquí
			JOptionPane.showMessageDialog(this, "¡Botón pulsado correctamente!");
		}
	}

	public static void main(String[] args) {
		JButtonSimple frame = new JButtonSimple();
		frame.setVisible(true);
	}
}