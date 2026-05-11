package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CifradoTecladoDerecha extends JFrame implements ActionListener {

	// declaracion de los paneles y elementos que forman la interfaz
	private JPanel panelOpciones, panelTexto, panelTeclado, contenedorSuperior, contenedorTeclado;
	private JRadioButton radio1, radio2, radio3;
	private ButtonGroup grupoBotones;
	private JButton cifrar, borrar;
	private JTextField campo1, campo2;

	// valores fijos para los desplazamientos del cifrado cesar
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	public CifradoTecladoDerecha() {
		// establecemos el layout principal de la ventana
		setLayout(new BorderLayout(10, 10));
		// margen de separacion interna para que los componentes no toquen los bordes
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// contenedor para la parte superior dividido en dos columnas
		contenedorSuperior = new JPanel(new GridLayout(1, 2, 20, 0));

		// --- panel de la izquierda: campos de texto ---
		panelTexto = new JPanel(new GridLayout(0, 1, 0, 5));
		campo1 = new JTextField();
		campo2 = new JTextField();
		// el campo de resultado solo sirve para lectura
		campo2.setEditable(false);
		// fondo de color gris para indicar que no se puede escribir
		campo2.setBackground(new Color(240, 240, 240));

		// añadimos las etiquetas y las cajas de texto al panel izquierdo
		panelTexto.add(new JLabel("texto original:"));
		panelTexto.add(campo1);
		panelTexto.add(new JLabel("texto cifrado:"));
		panelTexto.add(campo2);
		
		// panel para que el boton borrar no ocupe todo el espacio
		JPanel pBotonBorrar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		borrar = new JButton("borrar todo");
		pBotonBorrar.add(borrar);
		panelTexto.add(pBotonBorrar);

		// --- panel de la derecha: opciones de selección ---
		panelOpciones = new JPanel(new GridLayout(0, 1, 0, 5));
		radio1 = new JRadioButton("cifrado cesar3");
		radio2 = new JRadioButton("cifrado rot13");
		radio3 = new JRadioButton("cifrado riel");
		
		// agrupamos los botones para que solo se pueda marcar uno a la vez
		grupoBotones = new ButtonGroup();
		grupoBotones.add(radio1);
		grupoBotones.add(radio2);
		grupoBotones.add(radio3);

		// añadimos la etiqueta y los radios al panel derecho
		panelOpciones.add(new JLabel("elige una opción:"));
		panelOpciones.add(radio1);
		panelOpciones.add(radio2);
		panelOpciones.add(radio3);
		
		// panel para que el boton cifrar sea pequeño y este a la izquierda
		JPanel pBotonCifrar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cifrar = new JButton("cifrar mensaje");
		pBotonCifrar.add(cifrar);
		panelOpciones.add(pBotonCifrar);

		// aqui esta el cambio: añadimos primero texto (izq) y luego opciones (der)
		contenedorSuperior.add(panelTexto);
		contenedorSuperior.add(panelOpciones);
		// colocamos el conjunto arriba de la ventana
		add(contenedorSuperior, BorderLayout.NORTH);

		// panel para centrar el teclado en la ventana
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para que el teclado no este pegado a las cajas
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// creamos la malla para las 27 teclas del abecedario
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		// definimos el tamaño del teclado para que sea estetico
		panelTeclado.setPreferredSize(new Dimension(600, 180)); 
		
		// letras necesarias para rellenar los botones del teclado
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			// letra en negrita para que se vea mejor en el examen
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			// quitamos el foco para que no salga el cuadrado de puntos al pulsar
			btn.setFocusable(false);
			// registramos la accion de la tecla
			btn.addActionListener(this);
			// metemos el boton en la malla
			panelTeclado.add(btn);
		}
		
		// añadimos el teclado a su contenedor centrado
		contenedorTeclado.add(panelTeclado);
		// posicionamos el teclado abajo del todo de la ventana
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos los eventos para los botones de control
		cifrar.addActionListener(this);
		borrar.addActionListener(this);

		// titulo de la aplicacion
		setTitle("cifrador teclado derecha");
		// dimensiones de la ventana estrecha
		setSize(700, 580); 
		// evitamos que el usuario la achique mas de la cuenta
		setMinimumSize(new Dimension(650, 550));
		// centramos la ventana al abrirla
		setLocationRelativeTo(null);
		// detenemos el proceso al cerrar la interfaz
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// hacemos visible todo el conjunto
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// si el evento proviene de un boton
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String texto = boton.getText();

			// si es un boton de letra (longitud 1)
			if (texto.length() == 1 && e.getSource() != cifrar && e.getSource() != borrar) {
				// sumamos la letra a lo que ya hay en la caja original
				campo1.setText(campo1.getText() + texto);
			}
		}

		// si se pulsa cifrar realizamos las validaciones
		if (e.getSource() == cifrar) {
			String original = campo1.getText();
			if (original.isEmpty()) {
				JOptionPane.showMessageDialog(this, "escribe algo");
			} else if (grupoBotones.getSelection() == null) {
				JOptionPane.showMessageDialog(this, "elige un método");
			} else {
				// ejecutamos el algoritmo segun la seleccion
				if (radio1.isSelected()) campo2.setText(sustitucion(original, CESAR));
				else if (radio2.isSelected()) campo2.setText(sustitucion(original, ROT13));
				else if (radio3.isSelected()) campo2.setText(riel(original));
			}
		}

		// si se pulsa borrar limpiamos la pantalla
		if (e.getSource() == borrar) {
			campo1.setText("");
			campo2.setText("");
			grupoBotones.clearSelection();
		}
	}

	// funcion de cifrado por desplazamiento de caracteres
	private static String sustitucion(String m, int k) {
		String res = "";
		for (char c : m.toUpperCase().toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				int n = c + k;
				if (n > 'Z') n -= 26;
				res += (char) n;
			} else res += c;
		}
		return res;
	}

	// funcion de cifrado por separacion de letras pares e impares
	private static String riel(String m) {
		String c1 = "", c2 = "";
		for (int i = 0; i < m.length(); i++) {
			if (i % 2 == 0) c1 += m.charAt(i);
			else c2 += m.charAt(i);
		}
		return c1 + c2;
	}

	// programa principal para iniciar la aplicacion
	public static void main(String[] args) {
		new CifradoTecladoDerecha();
	}
}