package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccesoTeclado extends JFrame implements ActionListener {

	// declaracion de los elementos para la interfaz de password
	private JPanel panelEntrada, panelEstado, panelTeclado, contenedorTeclado;
	private JPasswordField campoPassword;
	private JLabel etiquetaEstado;
	private JButton botonValidar, botonBorrar;

	// definimos la contraseña correcta para la validacion
	private static final String CLAVE_SECRETA = "JAVA";

	public AccesoTeclado() {
		// utilizamos borderlayout para organizar la ventana por zonas
		setLayout(new BorderLayout(10, 10));
		// margen de separacion interna para que los componentes no peguen al borde
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- bloque superior (north): entrada de la clave ---
		panelEntrada = new JPanel(new GridLayout(0, 1, 0, 5));
		// usamos jpasswordfield para que no se vean las letras al escribir
		campoPassword = new JPasswordField();
		// centramos el texto dentro del campo de password
		campoPassword.setHorizontalAlignment(JTextField.CENTER);
		// fuente mas grande para que los puntos se vean claros
		campoPassword.setFont(new Font("Arial", Font.BOLD, 18));

		// añadimos etiqueta, campo de clave y el boton de validar
		panelEntrada.add(new JLabel("introduzca su contraseña:"));
		panelEntrada.add(campoPassword);
		
		// boton para comprobar si la clave es correcta
		botonValidar = new JButton("validar acceso");
		JPanel pBotonV = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBotonV.add(botonValidar);
		panelEntrada.add(pBotonV);

		// situamos el bloque de entrada en el norte de la ventana
		add(panelEntrada, BorderLayout.NORTH);

		// --- bloque central (center): mensaje de resultado ---
		panelEstado = new JPanel(new GridBagLayout());
		etiquetaEstado = new JLabel("esperando contraseña...");
		// ponemos la etiqueta en negrita y un poco mas grande
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 14));
		
		// añadimos la etiqueta al panel central
		panelEstado.add(etiquetaEstado);
		add(panelEstado, BorderLayout.CENTER);

		// --- bloque inferior (south): teclado virtual ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen para separar el teclado del resto de elementos
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		// rejilla de 3 filas y 9 columnas para las letras
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		panelTeclado.setPreferredSize(new Dimension(600, 160)); 
		
		// generamos los botones del abecedario para introducir la clave
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// añadimos un boton de borrar especifico dentro del panel del teclado
		botonBorrar = new JButton("limpiar");
		botonBorrar.addActionListener(this);
		
		// añadimos el teclado al panel centralizador y este al sur
		contenedorTeclado.add(panelTeclado);
		// el boton de borrar ira justo debajo del teclado
		contenedorTeclado.add(botonBorrar);
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos el evento para el boton de validar
		botonValidar.addActionListener(this);

		// configuracion de la ventana
		setTitle("acceso de seguridad");
		// ventana estrecha y compacta para un login
		setSize(650, 600); 
		setMinimumSize(new Dimension(600, 550));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// si pulsamos un boton comprobamos si es una letra del teclado
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();

			// si es una letra individual del abecedario virtual
			if (textoBoton.length() == 1 && e.getSource() != botonValidar && e.getSource() != botonBorrar) {
				// obtenemos el texto actual (usando getpassword) y añadimos la letra
				String actual = new String(campoPassword.getPassword());
				campoPassword.setText(actual + textoBoton);
			}
		}

		// logica para validar la contraseña introducida
		if (e.getSource() == botonValidar) {
			// convertimos el array de caracteres del passwordfield a string
			String passwordIngresada = new String(campoPassword.getPassword());
			
			// comparamos la clave introducida con la clave secreta
			if (passwordIngresada.equals(CLAVE_SECRETA)) {
				etiquetaEstado.setText("acceso concedido");
				etiquetaEstado.setForeground(new Color(0, 150, 0)); // color verde
			} else {
				etiquetaEstado.setText("contraseña incorrecta");
				etiquetaEstado.setForeground(Color.RED); // color rojo
				// limpiamos el campo para que lo intente de nuevo
				campoPassword.setText("");
			}
		}

		// logica para el boton de borrar
		if (e.getSource() == botonBorrar) {
			campoPassword.setText("");
			etiquetaEstado.setText("esperando contraseña...");
			etiquetaEstado.setForeground(Color.BLACK);
		}
	}

	// metodo principal para ejecutar la ventana
	public static void main(String[] args) {
		new AccesoTeclado();
	}
}