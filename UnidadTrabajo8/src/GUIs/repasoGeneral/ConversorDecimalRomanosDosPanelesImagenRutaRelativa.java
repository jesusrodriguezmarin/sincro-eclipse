package GUIs.repasoGeneral;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConversorDecimalRomanosDosPanelesImagenRutaRelativa extends JFrame implements ActionListener {

	/**
	 * Declaración de componentes de la ventana
	 */
	private JButton boton;
	private JTextField campo1, campo2;
	private JPanel panel1, panel2;
	
	/**
	 * Constructor
	 */
	public ConversorDecimalRomanosDosPanelesImagenRutaRelativa() {
		
		// Inicializamos el primer contenedor de componentes
		panel1 = new JPanel();
		
		// Establecemos una rejilla de una columna con 10 píxeles de separación vertical
		panel1.setLayout(new GridLayout(0, 1, 0, 10));
		// Añadimos una etiqueta centrada para indicar la entrada de datos
		panel1.add(new JLabel("Nº decimal", JLabel.CENTER));
		// Creamos el campo de texto con un ancho de 10
		campo1 = new JTextField(10);
		// Vinculamos el campo al listner
		campo1.addActionListener(this);
		// Añadimos el campo de entrada al primer panel
		panel1.add(campo1);
		
		// Inicializamos el segundo contenedor para el resultado
		panel2 = new JPanel();
		
		// Aplicamos el mismo diseño de rejilla que en el panel anterior
		panel2.setLayout(new GridLayout(0, 1, 0, 10));
		// Añadimos la etiqueta informativa para el número romano
		panel2.add(new JLabel("Nº romano", JLabel.CENTER));
		// Creamos el campo de salida con un ancho de 10 columnas
		campo2 = new JTextField(10);
		// Deshabilitamos la edición manual en el campo de resultado
		campo2.setEditable(false);
		// Cambiamos el fondo a gris claro para indicar que es un campo de salida
		campo2.setBackground(Color.LIGHT_GRAY);
		// Añadimos el campo de salida al segundo panel
		panel2.add(campo2);
		
	
		// Creamos el botón cargando una imagen desde la ruta relativa del proyecto
		boton = new JButton(new ImageIcon(getClass().getResource("flecha.png")));
		// Desactivamos el relleno del área del botón para que solo se vea la imagen
		boton.setContentAreaFilled(false);
		// Eliminamos el borde predeterminado del botón
		boton.setBorder(null);
		// Vinculamos el botón al escuchador de eventos de esta clase
		boton.addActionListener(this);
		
		// Definimos un diseño de flow centrado con 50 píxeles de separación entre elementos
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		// Insertamos el panel de entrada en la ventana
		add(panel1);
		// Insertamos el botón de conversión entre los dos paneles
		add(boton);
		// Insertamos el panel de salida en la ventana
		add(panel2);
	}
		
		// Método encargado de gestionar la pulsación del botón o la tecla Enter
		@Override
		public void actionPerformed(ActionEvent e) {
			// Comprobamos si el evento ha sido disparado por el botón de la flecha
			if (e.getSource()==boton) {
				// Iniciamos un bloque de control de errores para la entrada de texto
				try {
					// Intentamos convertir el texto del campo de entrada en un número entero
					int a = Integer.parseInt(campo1.getText());		
					// Llamamos a la función de conversión y mostramos el resultado en el segundo campo
					campo2.setText(decimalToRomano(a));
				} catch (Exception e2) {
					// Si el usuario introduce texto no numérico, mostramos un mensaje de error
					campo2.setText("ERROR");
				}
			}
		
	}
	
	/**
	 * Procedimiento que devuelve un nº en su forma romana
	 * @param N - nº entero
	 * @return un nº en su equivalencia romana
	 */
	private static String decimalToRomano (int N) {
		// Variable para ir acumulando las letras del número romano
		String res = "";
		// Trabajamos con el valor absoluto del número para procesar la cifra
		int num = Math.abs(N);
		// Bucle para procesar las unidades de millar
		while (num >= 1000) {
			num-=1000;
			res+="M";
		}
		// Bucle para procesar el caso especial de 900
		while (num >= 900) {
			num-=900;
			res+="CM";
		}
		// Bucle para procesar las centenas de 500
		while (num >= 500) {
			num-=500;
			res+="D";
		}
		// Bucle para procesar el caso especial de 400
		while (num >= 400) {
			num-=400;
			res+="CD";
		}
		// Bucle para procesar las centenas simples
		while (num >= 100) {
			num-=100;
			res+="C";
		}
		// Bucle para procesar el caso especial de 90
		while (num >= 90) {
			num-=90;
			res+="XC";
		}
		// Bucle para procesar las decenas de 50
		while (num >= 50) {
			num-=50;
			res+="L";
		}
		// Bucle para procesar el caso especial de 40
		while (num >= 40) {
			num-=40;
			res+="XL";
		}
		// Bucle para procesar las decenas simples
		while (num >= 10) {
			num-=10;
			res+="X";
		}
		// Bucle para procesar el caso especial de 9
		while (num >= 9) {
			num-=9;
			res+="IX";
		}
		// Bucle para procesar las unidades de 5
		while (num >= 5) {
			num-=5;
			res+="V";
		}
		// Bucle para procesar el caso especial de 4
		while (num >= 4) {
			num-=4;
			res+="IV";
		}
		// Bucle para procesar las unidades simples
		while (num >= 1) {
			num-=1;
			res+="I";
		}
		// Si el número original era negativo, añadimos la indicación cronológica
		if (N < 0) {
			return res+=" a.C";
		} else {
			// Si es positivo, devolvemos solo la cadena de caracteres romanos
			return res;
		}
	}
			
	// Punto de arranque del programa
	public static void main(String[] args) {
		// Creamos una nueva instancia de la clase conversor
		ConversorDecimalRomanosDosPanelesImagenRutaRelativa c = new ConversorDecimalRomanosDosPanelesImagenRutaRelativa();
		// Definimos el título que se verá en la barra de la ventana
		c.setTitle("Conversor Decimal > Romano");
		// Ajustamos el tamaño de la ventana automáticamente según sus componentes
		c.pack();
		// Centramos la ventana en la pantalla del ordenador
		c.setLocationRelativeTo(null);
		// Configuramos la salida del programa al cerrar la ventana gráfica
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Hacemos que la interfaz sea visible para el usuario
		c.setVisible(true);

	}


}