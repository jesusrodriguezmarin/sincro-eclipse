package GUIs.listener;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ItemListenerColores extends JFrame implements ItemListener {

	/**
	 * Componentes
	 */
	private JComboBox<String> combo;
	
	public ItemListenerColores() {
		
		// Posicionamiento absoluto
		setLayout(null);
		
		// Inicializamos combo
		combo = new JComboBox<String>();
		combo.setBounds(50, 20, 150, 25);
		
		// Creamos las opciones
		combo.addItem("");
		combo.addItem("rojo");
		combo.addItem("azul");
		combo.addItem("verde");
		combo.addItem("amarillo");
		
		// Añadimos las opciones
		add(combo);
		
		// Asociamos la clase al evento
		combo.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==combo) {
			
			// Transformamos a String
			String seleccionado = (String)combo.getSelectedItem();
			
			if (seleccionado.equals("rojo"))
				getContentPane().setBackground(Color.red);
			
			if (seleccionado.equals("azul"))
				getContentPane().setBackground(Color.blue);
			
			if (seleccionado.equals("verde"))
				getContentPane().setBackground(Color.green);
			
			if (seleccionado.equals("amarillo"))
				getContentPane().setBackground(Color.yellow);
		}
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		ItemListenerColores v = new ItemListenerColores();
		v.setTitle("Colores");
		v.setSize(280, 200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
