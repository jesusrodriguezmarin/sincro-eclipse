package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

public class JButtonArray extends JFrame implements ActionListener {

	private JPanel contentPane;
	// 1. Declaramos el array de botones como atributo
	private JButton[] misBotones = new JButton[6];

	public JButtonArray() {
		setTitle("Ventana con Array de Botones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		setLocationRelativeTo(null);
		
		// Usamos GridLayout para que los 6 botones queden perfectos
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 6, 5, 5)); // 1 fila, 6 columnas
		setContentPane(contentPane);

		// 2. Bucle para crear, configurar y añadir los botones
		for (int i = 0; i < misBotones.length; i++) {
			misBotones[i] = new JButton("B" + (i + 1)); // Texto: B1, B2...
			
			// Todos comparten el mismo listener
			misBotones[i].addActionListener(this);
			
			// Añadimos al panel
			contentPane.add(misBotones[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 3. TRUCO DE EXAMEN: ¿Cómo saber cuál se pulsó?
		
		// Opción A: Por el objeto exacto (si necesitas saber la posición)
		for (int i = 0; i < misBotones.length; i++) {
			if (e.getSource() == misBotones[i]) {
				System.out.println("Has pulsado el botón de la posición: " + i);
			}
		}

		// Opción B: Por el texto del botón (Ideal para el Ahorcado o calculadoras)
		if (e.getSource() instanceof JButton) {
			JButton botonPulsado = (JButton) e.getSource();
			String texto = botonPulsado.getText();
			
			JOptionPane.showMessageDialog(this, "Pulsaste: " + texto);
			
			// Ejemplo: Desactivar el botón tras pulsarlo
			botonPulsado.setEnabled(false);
			botonPulsado.setBackground(Color.LIGHT_GRAY);
		}
	}

	public static void main(String[] args) {
		new JButtonArray().setVisible(true);
	}
}