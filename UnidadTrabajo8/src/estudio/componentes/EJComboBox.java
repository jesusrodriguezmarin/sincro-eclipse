package estudio.componentes;

import javax.swing.*;

public class EJComboBox extends JFrame {

	private JComboBox<String> comboOpciones;

	public EJComboBox() {
		setTitle("Plantilla JComboBox");
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		String[] items = { "Fácil", "Medio", "Difícil" };
		comboOpciones = new JComboBox<>(items);
		comboOpciones.setBounds(50, 50, 150, 30);
		
		// Saber qué selecciona al momento del clic
		comboOpciones.addActionListener(e -> {
			String seleccion = (String) comboOpciones.getSelectedItem();
			System.out.println("Seleccionado: " + seleccion);
		});

		getContentPane().add(comboOpciones);
	}

	public static void main(String[] args) { new EJComboBox().setVisible(true); }
}
