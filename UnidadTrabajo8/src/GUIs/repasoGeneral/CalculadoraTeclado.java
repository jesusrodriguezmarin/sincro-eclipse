package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculadoraTeclado extends JFrame implements ActionListener {

	private JTextField pantalla;
	private JPanel panelBotones;
	private String[] etiquetas = {
		"7", "8", "9", "/",
		"4", "5", "6", "*",
		"1", "2", "3", "-",
		"C", "0", "=", "+"
	};
	private JButton[] botones = new JButton[etiquetas.length];
	private double num1 = 0;
	private String operador = "";
	private boolean nuevaOperacion = true;

	// inicio del constructor de la ventana
	public CalculadoraTeclado() {
		// establecemos una disposicion de bordes con separacion entre componentes
		setLayout(new BorderLayout(10, 10));
		// aplicamos un margen de seguridad de 15 pixeles en los bordes de la ventana
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// instanciamos el campo de texto que actua como pantalla
		pantalla = new JTextField("0");
		// bloqueamos la edicion por teclado fisico para evitar errores de formato
		pantalla.setEditable(false);
		// alineamos los numeros a la derecha como en las calculadoras reales
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		// definimos una tipografia monospaciada, en negrita y de gran tamaño
		pantalla.setFont(new Font("Monospaced", Font.BOLD, 28));
		// asignamos el color gris claro solicitado al fondo de la pantalla
		pantalla.setBackground(Color.LIGHT_GRAY);
		// el color del texto sera negro para mejorar el contraste
		pantalla.setForeground(Color.BLACK);
		// colocamos la pantalla en la zona superior del layout
		add(pantalla, BorderLayout.NORTH);

		// creamos el panel que contendra los botones en una rejilla de 4x4
		panelBotones = new JPanel(new GridLayout(4, 4, 8, 8));
		// recorremos el array de etiquetas para crear cada boton individualmente
		for (int i = 0; i < etiquetas.length; i++) {
			// inicializamos el boton con su texto correspondiente
			botones[i] = new JButton(etiquetas[i]);
			// aplicamos una fuente clara y legible a los botones
			botones[i].setFont(new Font("Arial", Font.BOLD, 22));
			// desactivamos el foco visual del boton tras ser pulsado
			botones[i].setFocusable(false);
			
			// filtramos si el boton es un simbolo de operacion o control
			if ("/*-+=C".contains(etiquetas[i])) {
				// asignamos un tono azul oscuro para diferenciar visualmente los operadores
				botones[i].setForeground(new Color(0, 51, 153));
			}
			
			// vinculamos el boton al escuchador de eventos de esta misma clase
			botones[i].addActionListener(this);
			// añadimos el boton configurado al panel central
			panelBotones.add(botones[i]);
		}
		// insertamos el panel de botones en el espacio central de la ventana
		add(panelBotones, BorderLayout.CENTER);

		// definimos el titulo que aparecera en la barra superior
		setTitle("CalculadoraTeclado");
		// establecemos el tamaño inicial de la interfaz
		setSize(380, 480);
		// centramos la aplicacion en mitad de la pantalla del usuario
		setLocationRelativeTo(null);
		// configuramos que el programa finalice al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// activamos la visibilidad de todos los componentes graficos
		setVisible(true);
	}

	// metodo que captura y gestiona los clics en los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		// recuperamos el texto contenido en el boton que ha disparado el evento
		String botonPulsado = e.getActionCommand();

		// verificamos si la tecla pulsada es un caracter numerico
		if ("0123456789".contains(botonPulsado)) {
			// si es el inicio de una cuenta, sustituimos el cero por el numero
			if (nuevaOperacion) {
				pantalla.setText(botonPulsado);
				// cambiamos el estado para permitir añadir mas digitos
				nuevaOperacion = false;
			} else {
				// si no es nuevo, concatenamos el digito al texto existente
				pantalla.setText(pantalla.getText() + botonPulsado);
			}
		} 
		// gestionamos la pulsacion del boton de limpieza (C)
		else if (botonPulsado.equals("C")) {
			// reseteamos la pantalla al valor inicial
			pantalla.setText("0");
			// ponemos a cero las variables de control y memoria
			num1 = 0;
			operador = "";
			nuevaOperacion = true;
		} 
		// gestionamos la pulsacion del boton de ejecucion (=)
		else if (botonPulsado.equals("=")) {
			// comprobamos que exista una operacion pendiente de resolver
			if (!operador.equals("")) {
				try {
					// obtenemos el contenido actual de la pantalla
					String textoPantalla = pantalla.getText();
					// buscamos la posicion del signo y extraemos el numero que viene detras
					String parte2 = textoPantalla.substring(textoPantalla.lastIndexOf(operador) + 1).trim();
					// convertimos ese fragmento de texto en un valor numerico real
					double num2 = Double.parseDouble(parte2);
					// llamamos al metodo que realiza la operacion matematica
					realizarCalculo(num2);
				} catch (Exception ex) {
					// capturamos posibles errores de formato en la extraccion
				}
				// vaciamos el operador tras finalizar la cuenta
				operador = "";
				// preparamos la calculadora para una entrada nueva
				nuevaOperacion = true;
			}
		} 
		// bloque para gestionar los botones de operacion (+, -, *, /)
		else {
			// si el usuario pulsa un signo sin haber dado al igual, resolvemos el parcial
			if (!operador.equals("") && !nuevaOperacion) {
				try {
					String texto = pantalla.getText();
					String parte2 = texto.substring(texto.lastIndexOf(operador) + 1).trim();
					realizarCalculo(Double.parseDouble(parte2));
				} catch (Exception ex) {}
			}
			
			// almacenamos el numero actual en la memoria de la calculadora
			num1 = Double.parseDouble(pantalla.getText());
			// registramos cual es el operador que se va a aplicar
			operador = botonPulsado;
			// actualizamos la pantalla mostrando el numero seguido del signo elegido
			pantalla.setText(pantalla.getText() + " " + operador + " ");
			// indicamos que el proximo numero no debe borrar lo anterior
			nuevaOperacion = false; 
		}
	}

	// metodo encargado de procesar la operacion matematica final
	private void realizarCalculo(double num2) {
		// variable temporal para guardar el resultado del computo
		double resultado = 0;
		// seleccionamos la operacion segun el simbolo almacenado en memoria
		switch (operador) {
			case "+": resultado = num1 + num2; break;
			case "-": resultado = num1 - num2; break;
			case "*": resultado = num1 * num2; break;
			case "/": 
				// controlamos la excepcion matematica de la division por cero
				if (num2 != 0) resultado = num1 / num2;
				else {
					// informamos al usuario del error mediante un dialogo grafico
					JOptionPane.showMessageDialog(this, "no se puede dividir por cero");
					pantalla.setText("0");
					return;
				}
				break;
		}

		// comprobamos si el resultado carece de decimales significativos
		if (resultado == (long) resultado) {
			// lo mostramos como entero para que se vea mas limpio
			pantalla.setText(String.valueOf((long) resultado));
		} else {
			// lo mostramos con decimales si es necesario
			pantalla.setText(String.valueOf(resultado));
		}
		// guardamos el resultado como base para una posible operacion futura
		num1 = resultado;
	}

	// punto de arranque de la aplicacion
	public static void main(String[] args) {
		// inicializamos la clase para desplegar la interfaz
		new CalculadoraTeclado();
	}
}