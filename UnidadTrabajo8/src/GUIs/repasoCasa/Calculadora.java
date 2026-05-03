package GUIs.repasoCasa;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Calculadora extends JFrame implements ChangeListener {

	/**
	 * Componentes de la ventana
	 */
	private JPanel panel1, panel2;
	private JLabel label1, label2, label3;
	private JTextField op1, op2, res;
	private JRadioButton suma, resta, division, multiplicacion, resto;
	private ButtonGroup grupoBotones;
	
	/**
	 * Constructor
	 */
	public Calculadora() {
		
		// Creamos el panel de la izquierda
		panel1 = new JPanel();
		
		// Distribuimos los componentes en una columna uno debajo del otro
		panel1.setLayout(new GridLayout(0, 1, 15, 15));
		
		// Creamos los componentes y añadimos al panel
		// Etiqueta de operandos
		label1 = new JLabel("Operandos: ");
		panel1.add(label1);
		
		// Campo de texto para introducir el primer operando
		op1 = new JTextField();
		panel1.add(op1);
		
		// Campo de texto para el segundo operando
		op2 = new JTextField();
		panel1.add(op2);
		
		// Etiqueta de resultado
		label2 = new JLabel("Resultado: ");
		panel1.add(label2);
		
		// Campo de texto donde se mostrará el resultado
		res = new JTextField();
		panel1.add(res);
		
		// Creamos el panel de la derecha
		panel2 = new JPanel();
		
		// Sus componentes en una sola columna uno debajo del otro
		panel2.setLayout(new GridLayout(0,1,5,5));
		
		// Creamos los componentes y los añadimos al panel
		// Etiqueta de resutado
		label3 = new JLabel("Operaciones: ");
		panel2.add(label3);
		
		// Grupo de botones
		grupoBotones = new ButtonGroup();
		
		// Añadimos los radioButton con sus ChangeListener
		suma = new JRadioButton("Suma");
		grupoBotones.add(suma);
		panel2.add(suma);
		suma.addChangeListener(this);
		
		resta = new JRadioButton("Resta");
		grupoBotones.add(resta);
		panel2.add(resta);
		resta.addChangeListener(this);
		
		multiplicacion = new JRadioButton("Multiplicación");
		grupoBotones.add(multiplicacion);
		panel2.add(multiplicacion);
		multiplicacion.addChangeListener(this);
		
		division = new JRadioButton("División");
		grupoBotones.add(division);
		panel2.add(division);
		division.addChangeListener(this);
		
		resto = new JRadioButton("Resto");
		grupoBotones.add(resto);
		panel2.add(resto);
		resto.addChangeListener(this);
		
		// Añadimos los paneles a la ventana en distribución de izquierda a derecha
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(panel1);
		add(panel2);
	}
	
	/**
	 * Método para verificar cual JRadioButton está seleccionado
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		
		// Variable para concatenar el resultado
		String resultado = "";
		
		// Control de errores
		try {
			// Parseamos los String para operar
			int x1 = Integer.parseInt(op1.getText());
			int x2 = Integer.parseInt(op2.getText());
			
			// Operamos
			if (suma.isSelected()) {
				resultado = String.valueOf(x1+x2);
			}
			if (resta.isSelected()) {
				resultado = String.valueOf(x1-x2);
			}
			if (multiplicacion.isSelected()) {
				resultado = String.valueOf(x1*x2);
			}
			if (division.isSelected()) {
				if (x2 != 0)
					resultado = String.valueOf(x1/x2);
				else
					resultado = "ERROR";
			}
			if (resto.isSelected()) {
				if (x2 != 0)
					resultado = String.valueOf(x1%x2);
				else
					resultado = "ERROR";
			}
			
			// Establecemos resultado como texto en el campo res
			res.setText(resultado);
			// Eliminamos el título de la barra superior
			setTitle("");
			
		} catch (Exception e2) {
			res.setText("");
			setTitle("Introduce operandos");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Instanciamos una ventana
		Calculadora c = new Calculadora();
		
		// Configuramos
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
