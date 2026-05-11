package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CifradoTecladoIzquierda extends JFrame implements ActionListener {

	// declaracion de paneles y elementos de la interfaz
	private JPanel panelOpciones, panelTexto, panelTeclado, contenedorSuperior, contenedorTeclado;
	private JRadioButton radio1, radio2, radio3;
	private ButtonGroup grupoBotones;
	private JButton cifrar, borrar;
	private JTextField campo1, campo2;

	// constantes para los desplazamientos del cifrado
	private static final int CESAR = 3;
	private static final int ROT13 = 13;

	public CifradoTecladoIzquierda() {
		// usamos borderlayout para organizar las piezas de la ventana
		setLayout(new BorderLayout(10, 10));
		// margen interno general para que nada toque los bordes
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// contenedor superior con dos columnas
		contenedorSuperior = new JPanel(new GridLayout(1, 2, 20, 0));

		// panel izquierdo para las opciones de cifrado
		panelOpciones = new JPanel(new GridLayout(0, 1, 0, 5));
		radio1 = new JRadioButton("cifrado cesar3");
		radio2 = new JRadioButton("cifrado rot13");
		radio3 = new JRadioButton("cifrado riel");
		
		// grupo para que los radio buttons sean excluyentes
		grupoBotones = new ButtonGroup();
		grupoBotones.add(radio1);
		grupoBotones.add(radio2);
		grupoBotones.add(radio3);

		// añadimos etiquetas y radios al panel izquierdo
		panelOpciones.add(new JLabel("elige una opción:"));
		panelOpciones.add(radio1);
		panelOpciones.add(radio2);
		panelOpciones.add(radio3);
		
		// creamos un panel pequeño para que el boton de cifrar no se estire
		JPanel pBotonCifrar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cifrar = new JButton("cifrar mensaje");
		pBotonCifrar.add(cifrar);
		panelOpciones.add(pBotonCifrar);

		// panel derecho para las cajas de texto
		panelTexto = new JPanel(new GridLayout(0, 1, 0, 5));
		campo1 = new JTextField();
		campo2 = new JTextField();
		// bloqueamos la edicion manual del resultado
		campo2.setEditable(false);
		// color de fondo gris claro para el campo bloqueado
		campo2.setBackground(new Color(240, 240, 240));

		// añadimos etiquetas y campos al panel derecho
		panelTexto.add(new JLabel("texto original:"));
		panelTexto.add(campo1);
		panelTexto.add(new JLabel("texto cifrado:"));
		panelTexto.add(campo2);
		
		// creamos un panel pequeño para que el boton borrar no se estire
		JPanel pBotonBorrar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		borrar = new JButton("borrar todo");
		pBotonBorrar.add(borrar);
		panelTexto.add(pBotonBorrar);

		// juntamos los dos paneles en la parte superior
		contenedorSuperior.add(panelOpciones);
		contenedorSuperior.add(panelTexto);
		add(contenedorSuperior, BorderLayout.NORTH);

		// contenedor para centrar el teclado
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para separar el teclado de los campos de texto
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// rejilla de 3 por 9 para las letras
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		// tamaño del teclado adaptado a la nueva anchura de ventana
		panelTeclado.setPreferredSize(new Dimension(600, 180)); 
		
		// bucle para crear los botones del abecedario
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			// fuente de las teclas un poco mas pequeña para ahorrar espacio
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// añadimos el teclado al contenedor y este al sur de la ventana
		contenedorTeclado.add(panelTeclado);
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos los escuchadores de los botones principales
		cifrar.addActionListener(this);
		borrar.addActionListener(this);

		// titulo de la ventana
		setTitle("cifrador teclado");
		// ventana mas estrecha (700) y con altura ajustada (580)
		setSize(700, 580); 
		// evitamos que la ventana se deforme demasiado
		setMinimumSize(new Dimension(650, 550));
		// centramos la ventana en pantalla
		setLocationRelativeTo(null);
		// cerramos programa al cerrar ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// mostramos la aplicacion
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// gestion de las pulsaciones en los botones
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String texto = boton.getText();

			// si es una letra del teclado virtual
			if (texto.length() == 1 && e.getSource() != cifrar && e.getSource() != borrar) {
				campo1.setText(campo1.getText() + texto);
			}
		}

		// logica del boton cifrar
		if (e.getSource() == cifrar) {
			String original = campo1.getText();
			if (original.isEmpty()) {
				JOptionPane.showMessageDialog(this, "escribe algo");
			} else if (grupoBotones.getSelection() == null) {
				JOptionPane.showMessageDialog(this, "elige un método");
			} else {
				if (radio1.isSelected()) campo2.setText(sustitucion(original, CESAR));
				else if (radio2.isSelected()) campo2.setText(sustitucion(original, ROT13));
				else if (radio3.isSelected()) campo2.setText(riel(original));
			}
		}

		// logica del boton borrar
		if (e.getSource() == borrar) {
			campo1.setText("");
			campo2.setText("");
			grupoBotones.clearSelection();
		}
	}

	// metodo para cifrado por sustitucion alfabetica
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

	// metodo para cifrado por transposicion de indices
	private static String riel(String m) {
		String c1 = "", c2 = "";
		for (int i = 0; i < m.length(); i++) {
			if (i % 2 == 0) c1 += m.charAt(i);
			else c2 += m.charAt(i);
		}
		return c1 + c2;
	}

	// arranque del programa
	public static void main(String[] args) {
		new CifradoTecladoIzquierda();
	}
}