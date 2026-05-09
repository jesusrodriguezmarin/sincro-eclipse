package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutBorder extends JFrame {

	public LayoutBorder() {
		setTitle("Estructura BorderLayout");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// El BorderLayout se pone en el constructor del panel o con setLayout
		JPanel contentPane = new JPanel(new BorderLayout(5, 5)); // (hgap, vgap) para separación
		setContentPane(contentPane);

		// PANEL NORTE (Ideal para títulos)
		JPanel p1 = new JPanel();
		p1.setBackground(Color.RED);
		p1.add(new JLabel("PANEL NORTE (TÍTULO)"));
		contentPane.add(p1, BorderLayout.NORTH);

		// PANEL CENTRO (El que más espacio ocupa, ideal para juegos/tablas)
		JPanel p2 = new JPanel();
		p2.setBackground(Color.GREEN);
		p2.add(new JLabel("PANEL CENTRAL (CONTENIDO)"));
		contentPane.add(p2, BorderLayout.CENTER);

		// PANEL SUR (Ideal para botones de Cerrar/Limpiar)
		JPanel p3 = new JPanel();
		p3.setBackground(Color.BLUE);
		p3.add(new JLabel("PANEL SUR (BOTONES)"));
		contentPane.add(p3, BorderLayout.SOUTH);
	}

	public static void main(String[] args) { new LayoutBorder().setVisible(true); }
}