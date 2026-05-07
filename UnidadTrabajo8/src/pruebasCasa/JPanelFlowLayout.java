package pruebasCasa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelFlowLayout extends JFrame {

	/**
	 * Constructor
	 */
	public JPanelFlowLayout() {

		// Establecemos disposicion general
		setLayout(new GridLayout());

		for (int i = 1; i <= 5; i++) {
			// Instanciamos el JPanel
			JPanel panelTemporal = new JPanel();

			// Le damos color
			panelTemporal.setBackground(Color.BLUE);

			// Le damos un tamaño preferido
			panelTemporal.setPreferredSize(new Dimension(50, 50));

			// Añadimos el panel
			add(panelTemporal);
		}
	}

	public static void main(String[] args) {

		// Instanciamos
		JPanelFlowLayout p = new JPanelFlowLayout();
		p.setTitle("Pruebas Paneles");
		p.setSize(500, 250);
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setVisible(true);

	}

}
