package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutFlow extends JFrame {

	public LayoutFlow() {
		setTitle("Estructura FlowLayout");
		setSize(500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Alineación a la izquierda con 20px de separación
		JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
		setContentPane(contentPane);

		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(100, 100)); // En FlowLayout hay que dar Dimension
		p1.setBackground(Color.CYAN);
		contentPane.add(p1);

		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(100, 100));
		p2.setBackground(Color.YELLOW);
		contentPane.add(p2);

		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(100, 100));
		p3.setBackground(Color.LIGHT_GRAY);
		contentPane.add(p3);
	}

	public static void main(String[] args) { new LayoutFlow().setVisible(true); }
}