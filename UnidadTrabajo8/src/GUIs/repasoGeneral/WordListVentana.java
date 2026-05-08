package GUIs.repasoGeneral;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class WordListVentana extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private JLabel etiqueta;
	private JTextField campo;
	private JButton boton;
	private JPanel panel;

	/**
	 * Constructor
	 */
	public WordListVentana() {

		
		// Inicializamos el panel
		panel = new JPanel(new BorderLayout(0,15));

		
		// Inicializamos la etiqueta
		etiqueta = new JLabel("Enter a word to search:");
		etiqueta.setBounds(20, 40, 100, 25);
		panel.add(etiqueta, BorderLayout.NORTH);


		// Inicializamos el campo de texto
		campo = new JTextField(30);
		campo.setBounds(80, 40, 175, 25);
		panel.add(campo, BorderLayout.CENTER);

		// Inicializamos el botón
		boton = new JButton(new ImageIcon("C:/proyectos/lupa01.png"));
		panel.add(boton, BorderLayout.EAST);
		boton.addActionListener(this);
		
		
		// Establecemos disposición
		setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		// Añadimos el panel
		add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == boton) {
			String palabra = campo.getText();
			
			// 2. Buscamos la palabra en el archivo que tenemos
			File f = new File("C:/BD/wordlist.txt");
			
			// Declaramos una variable para encontrar
			boolean encontrado = false;
			
			try {
				// Creamos otro scanner
				Scanner s = new Scanner(f);
				String linea;
				
				while (s.hasNextLine() && !encontrado) {
					linea = s.nextLine();
					
					// Comprobamos con compareTo que nos da 0 si son iguales o -1 si no lo son
					if (linea.compareToIgnoreCase(palabra) == 0) {
						encontrado = true;
					}
				}
				s.close();
				
				// 3. Indicamos si se ha encontrado la palabra o no
				if (encontrado) {
					JOptionPane.showMessageDialog(null, "The word is found in our wordlist", campo.getText(), JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "The word is not found in our wordlist", campo.getText(), JOptionPane.WARNING_MESSAGE);

				}
				
			} catch (FileNotFoundException e1) {
				System.err.println("> Error en el archivo, no existe.");
			}
			
		}

	}




	/**
	 * Programa principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		WordListVentana v = new WordListVentana();
		v.setTitle("Wordlist");
		v.pack();
		v.setLocationRelativeTo(null);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
		v.setVisible(true);

	}

}
