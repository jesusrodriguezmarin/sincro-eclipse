package GUIs.ejemplos.Absoluto;

import javax.swing.*;

public class ComboBoxBasico extends JFrame {

	// Componentes
	JComboBox<String> combo;
	JLabel mensaje;
	JLabel mensaje1;
	JTextField campotexto;

	// Creamos ventana
	public ComboBoxBasico() {
		setLayout(null);

		// Creamos una etiqueta
		mensaje = new JLabel("Nombre y apellidos:");
		// Damos tamaño
		mensaje.setBounds(10, 10, 200, 25);
		// Añadimos
		add(mensaje);

		// Creamos campo de texto
		campotexto = new JTextField();
		// Damos tamaño
		campotexto.setBounds(10, 40, 175, 25);
		// Añadimos
		add(campotexto);

		// Creamos una etiqueta
		mensaje1 = new JLabel("Indica tu país de origen:");
		// Damos tamaño
		mensaje1.setBounds(10, 75, 300, 25);
		// Añadimos
		add(mensaje1);

		// Creamos el combo y sus items y añadimos
		combo = new JComboBox<String>();
		combo.setBounds(10, 105, 120, 20);
		combo.addItem("España");
		combo.addItem("Francia");
		combo.addItem("Italia");
		combo.addItem("Alemania");
		add(combo);
	}

	// Programa principal
	public static void main(String[] args) {

		// Creamos objeto
		ComboBoxBasico v = new ComboBoxBasico();

		// Configuramos
		v.setSize(350, 400);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		v.setTitle("País");
		v.setVisible(true);

	}

}
