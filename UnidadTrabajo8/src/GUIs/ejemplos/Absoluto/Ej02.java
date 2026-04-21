package GUIs.ejemplos.Absoluto;

// Importamos todo el javax.swing
import javax.swing.*;

// Añadimos el extends JFrame
public class Ej02 extends JFrame {

	// Botones
	JRadioButton radio1, radio2;
	
	// Grupo
	ButtonGroup grupoBotones;
	
	// Creamos la ventana con dos botones
	public Ej02() {
		
		setLayout(null);
		
		// Creamos el grupo de botones
		grupoBotones = new ButtonGroup();
		
		// Creamos los radioButton y añadimos al grupo
		radio1 = new JRadioButton("Mayor de edad", true);
		radio1.setBounds(20, 20, 150, 50);
		grupoBotones.add(radio1);
		
		radio2 = new JRadioButton("Menor de edad");
		radio2.setBounds(175, 20, 150, 50);
		grupoBotones.add(radio2);
		
		// Añadimos los botones a la ventana
		add(radio1);
		add(radio2);
	}
	
	// Programa principal
	public static void main(String[] args) {

		// Cramos objeto
		Ej02 v = new Ej02();
		
		v.setTitle("Edad");
		v.setBounds(10, 10, 330, 150);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
