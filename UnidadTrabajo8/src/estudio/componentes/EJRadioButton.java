package estudio.componentes;

import javax.swing.*;

public class EJRadioButton extends JFrame {

	private JRadioButton rbFacil, rbDificil;
	private ButtonGroup grupoDificultad;
	private JButton btnComprobar;

	public EJRadioButton() {
		setTitle("Plantilla RadioButton");
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		rbFacil = new JRadioButton("Fácil", true); // true para que aparezca marcado
		rbFacil.setBounds(20, 20, 100, 30);
		getContentPane().add(rbFacil);

		rbDificil = new JRadioButton("Difícil");
		rbDificil.setBounds(20, 50, 100, 30);
		getContentPane().add(rbDificil);

		// IMPORTANTE: Agruparlos para que sean excluyentes
		grupoDificultad = new ButtonGroup();
		grupoDificultad.add(rbFacil);
		grupoDificultad.add(rbDificil);

		btnComprobar = new JButton("Ver selección");
		btnComprobar.setBounds(20, 100, 150, 30);
		btnComprobar.addActionListener(e -> {
			if (rbFacil.isSelected()) JOptionPane.showMessageDialog(this, "Elegiste Fácil");
			else if (rbDificil.isSelected()) JOptionPane.showMessageDialog(this, "Elegiste Difícil");
		});
		getContentPane().add(btnComprobar);
	}

	public static void main(String[] args) { new EJRadioButton().setVisible(true); }
}