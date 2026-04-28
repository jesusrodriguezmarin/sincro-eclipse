package GUIs.listener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerIdiomas extends JFrame implements ChangeListener {

	/**
	 * Declaramos los componentes de la ventana
	 */
	private JLabel label;
	private JCheckBox check1, check2, check3;
	
	public ChangeListenerIdiomas() {
		
		// Posicionamiento absoluto
		setLayout(null);
		
		label = new JLabel();
		label.setText("Selecciona uno o varios idiomas: ");
		label.setBounds(40, 20, 300, 30);
		add(label);
		
		check1 = new JCheckBox("Inglés");
		check1.setBounds(40, 70, 100, 30);
		add(check1);
		
		check2 = new JCheckBox("Francés");
		check2.setBounds(140, 70, 100, 30);
		add(check2);
		
		check3 = new JCheckBox("Italiano");
		check3.setBounds(240, 70, 100, 30);
		add(check3);
		
		// Llamamos al método 
		check1.addChangeListener(this);
		check2.addChangeListener(this);
		check3.addChangeListener(this);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		String cad = "Idiomas: ";
		
		if (check1.isSelected()==true) {
			cad = cad + "Inglés, ";
		}
		if (check2.isSelected()==true) {
			cad = cad + "Francés, ";
		}
		if (check3.isSelected()==true) {
			cad = cad + "Italiano, ";
		}
		
		// Quitamos el último espacio y coma
		cad = cad.substring(0, cad.length()-2);
		label.setText(cad);
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		ChangeListenerIdiomas v = new ChangeListenerIdiomas();
		v.setSize(400,200);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
