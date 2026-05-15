package pruebasCasa;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pruebas_borrar extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JLabel label1, label2;
	private JTextField campo1, campo2;
	private JButton traducir, borrar;
	private JPanel panel, panelBotones;
	
	
	/**
	 * Constructor
	 */
	public Pruebas_borrar() {
		
		// Establecemos una estructura general de Grid
		
		
		// Añadimos panel
		panel = new JPanel(new GridLayout(2,2,5,5));
		
		
		
		label1 = new JLabel("Introduce palabra:");
		panel.add(label1);
		
		
		label2 = new JLabel("Traducción:");
		panel.add(label2);
		
		campo1 = new JTextField(10);
		panel.add(campo1);
		
		campo2 = new JTextField(10);
		panel.add(campo2);
		
		// Añadimos panel para los botones
		panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		
		traducir = new JButton("TRADUCIR");
		panelBotones.add(traducir);
		
		borrar = new JButton("BORRAR");
		panelBotones.add(borrar);
		
		add(panel);
		add(panelBotones);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Instanciamos
		Pruebas_borrar v = new Pruebas_borrar();

		v.setSize(600,400);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


}
