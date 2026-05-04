package GUIs.listener;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ventana_EmergentePositivNegativo extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JPanel panel;
	private JLabel label;
	private JTextField campo;
	private JButton comprobar;
	
	/**
	 * Constructor
	 */
	public Ventana_EmergentePositivNegativo () {
		
		// Creamos los componentes de la ventana
		label = new JLabel("Introduce un valor entero: ");
		campo = new JTextField(10);
		comprobar = new JButton("Comprobar");
		comprobar.addActionListener(this);
		
		// Creamos el panel y añadimos los componentes
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1, 0, 20));
		panel.add(label);
		panel.add(campo);
		panel.add(comprobar);
		
		// Añadimos el panel a la ventana centrado y con margenes
		setLayout(new FlowLayout((FlowLayout.CENTER)));
		add(panel);
	}
	
	/**
	 * Método que implementa la acción de la ventana
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == comprobar) {
			try {
				if (campo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debes utilizar un valor", "AVISO", JOptionPane.WARNING_MESSAGE);

				} else {
					int valor = Integer.parseInt(campo.getText());
					
					if (valor > 0) {
						JOptionPane.showMessageDialog(null, "El valor introducido no POSITIVO", "ERROR", JOptionPane.PLAIN_MESSAGE);
					} else {
						if (valor < 0) {
							JOptionPane.showMessageDialog(null, "El valor introducido es NEGATIVO", "Resultado", JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Has introducido el valor CERO", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "El valor introducido no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Instanciamos y configuramos
		Ventana_EmergentePositivNegativo v = new Ventana_EmergentePositivNegativo();
		v.setTitle("Positivo-Negativo");
		v.pack();
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
