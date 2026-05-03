package GUIs.listener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerAnchoAlto extends JFrame implements ChangeListener {

	/**
	 * Componentes de la ventana
	 */
	private JRadioButton radio1, radio2, radio3;
	private ButtonGroup grupo;
	
	/**
	 * Creamos la ventana con los tres botones con JRadioButton
	 */
	public ChangeListenerAnchoAlto() {
		
		// Posicionamiento absoluto
		setLayout(null);
		
		// Creamos el grupo de botones
		grupo = new ButtonGroup();
		
		// Añadimos los radioButton con su ChangeListener
		radio1 = new JRadioButton("640x480");
		radio1.setBounds(50, 50, 100, 25);
		grupo.add(radio1);
		add(radio1);
		radio1.addChangeListener(this);
		
		radio2 = new JRadioButton("800x600");
		radio2.setBounds(50, 100, 100, 25);
		grupo.add(radio2);
		add(radio2);
		radio2.addChangeListener(this);
		
		radio3 = new JRadioButton("1024x780");
		radio3.setBounds(50, 150, 100, 25);
		grupo.add(radio3);
		add(radio3);
		radio3.addChangeListener(this);
	}
	
	/**
	 * Establece el tamaño de la ventana y la centra
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (radio1.isSelected()) {
			// Establece el tamaño de la ventana
			setSize(640,480);
			// La posiciona al centro
			setLocationRelativeTo(null);
		}
		if (radio2.isSelected()) {
			setSize(800,600);
			setLocationRelativeTo(null);
		}
		if (radio3.isSelected()) {
			setSize(1024,780);
			setLocationRelativeTo(null);
		}
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		ChangeListenerAnchoAlto v = new ChangeListenerAnchoAlto();
		v.setTitle("Elige una resolución: ");
		v.setBounds(0, 0, 300, 250);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}
