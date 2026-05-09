package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutGrid extends JFrame {

	public LayoutGrid() {
		setTitle("Estructura GridLayout");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 3 filas y 1 columna (o viceversa)
		JPanel contentPane = new JPanel(new GridLayout(3, 1, 10, 10)); 
		setContentPane(contentPane);

		JPanel p1 = new JPanel();
		p1.setBackground(Color.ORANGE);
		p1.add(new JLabel("FILA 1"));
		contentPane.add(p1);

		JPanel p2 = new JPanel();
		p2.setBackground(Color.PINK);
		p2.add(new JLabel("FILA 2"));
		contentPane.add(p2);

		JPanel p3 = new JPanel();
		p3.setBackground(Color.MAGENTA);
		p3.add(new JLabel("FILA 3"));
		contentPane.add(p3);
	}

	public static void main(String[] args) { new LayoutGrid().setVisible(true); }
}