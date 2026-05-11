package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordTeclado extends JFrame implements ActionListener {

	// declaracion de los elementos de la interfaz grafica
	private JPanel panelEntrada, panelEstado, panelTeclado, contenedorTeclado;
	private JPasswordField campoPassword;
	private JLabel etiquetaEstado;
	private JButton botonValidar, botonGenerar, botonBorrar, botonMostrar;
	
	// variable booleana para controlar si la clave se ve o no
	private boolean oculto = true;
	
	// objeto de tu clase logica para gestionar las claves
	private SuperPasswordPOO objetoPass;

	public PasswordTeclado() {
		// inicializamos tu clase logica
		objetoPass = new SuperPasswordPOO();
		
		// configuracion del layout principal de la ventana
		setLayout(new BorderLayout(10, 10));
		// margen para que los componentes no toquen los bordes de la ventana
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- bloque norte: entrada y botones de control ---
		panelEntrada = new JPanel(new GridLayout(0, 1, 0, 5));
		campoPassword = new JPasswordField();
		// centramos los caracteres ocultos en la caja de texto
		campoPassword.setHorizontalAlignment(JTextField.CENTER);
		campoPassword.setFont(new Font("Arial", Font.BOLD, 18));
		
		// añadimos la etiqueta y la caja de password al panel superior
		panelEntrada.add(new JLabel("panel de seguridad - introduzca clave:"));
		panelEntrada.add(campoPassword);
		
		// panel para agrupar los botones de accion de forma horizontal
		JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botonValidar = new JButton("comprobar");
		botonGenerar = new JButton("generar");
		botonMostrar = new JButton("mostrar"); // boton para ver la clave
		botonBorrar = new JButton("borrar");
		
		// añadimos los botones al panel de control
		pBotones.add(botonValidar);
		pBotones.add(botonGenerar);
		pBotones.add(botonMostrar);
		pBotones.add(botonBorrar);
		panelEntrada.add(pBotones);

		// fijamos el panel de entrada en la zona norte
		add(panelEntrada, BorderLayout.NORTH);

		// --- bloque centro: etiquetas de estado y mensajes ---
		panelEstado = new JPanel(new GridBagLayout());
		etiquetaEstado = new JLabel("estado: sistema activo");
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 13));
		panelEstado.add(etiquetaEstado);
		// situamos el estado en el centro de la ventana
		add(panelEstado, BorderLayout.CENTER);

		// --- bloque sur: teclado virtual del abecedario ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para separar el teclado de los mensajes
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		// rejilla de 3 por 9 para colocar las 27 letras
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		panelTeclado.setPreferredSize(new Dimension(600, 150)); 
		
		// creamos los botones de letras mediante un bucle
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			btn.setFont(new Font("Arial", Font.BOLD, 12));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// añadimos el teclado al contenedor y este al sur de la ventana
		contenedorTeclado.add(panelTeclado);
		add(contenedorTeclado, BorderLayout.SOUTH);

		// registramos los escuchadores para que los botones funcionen
		botonValidar.addActionListener(this);
		botonGenerar.addActionListener(this);
		botonMostrar.addActionListener(this);
		botonBorrar.addActionListener(this);

		// configuracion final de la ventana grafica
		setTitle("PasswordTeclado");
		setSize(650, 600); 
		setMinimumSize(new Dimension(600, 550));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// detectamos si se ha pulsado una tecla del abecedario
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String texto = boton.getText();

			// si es una letra, la añadimos al campo de la contraseña
			if (texto.length() == 1 && e.getSource() != botonValidar && e.getSource() != botonGenerar && e.getSource() != botonBorrar && e.getSource() != botonMostrar) {
				String actual = new String(campoPassword.getPassword());
				campoPassword.setText(actual + texto);
			}
		}

		// logica para el boton de mostrar / ocultar la clave
		if (e.getSource() == botonMostrar) {
			if (oculto) {
				// al poner el echochar en 0 se muestra el texto real
				campoPassword.setEchoChar((char) 0);
				botonMostrar.setText("ocultar");
				oculto = false;
			} else {
				// volvemos a poner el punto de seguridad por defecto
				campoPassword.setEchoChar('•');
				botonMostrar.setText("mostrar");
				oculto = true;
			}
		}

		// logica para el boton de generar contraseña aleatoria
		if (e.getSource() == botonGenerar) {
			String nuevaPass = objetoPass.generarPassword();
			campoPassword.setText(nuevaPass);
			etiquetaEstado.setText("contraseña aleatoria generada");
			etiquetaEstado.setForeground(Color.BLUE);
		}

		// logica para validar la fortaleza de la clave escrita
		if (e.getSource() == botonValidar) {
			String passIntroducida = new String(campoPassword.getPassword());
			if (evaluarFortaleza(passIntroducida)) {
				etiquetaEstado.setText("fortaleza: ¡es una contraseña fuerte!");
				etiquetaEstado.setForeground(new Color(0, 150, 0));
			} else {
				etiquetaEstado.setText("fortaleza: débil (mínimo 2 mayus, 2 minus, 2 num)");
				etiquetaEstado.setForeground(Color.RED);
			}
		}

		// logica para el boton de borrar que limpia toda la interfaz
		if (e.getSource() == botonBorrar) {
			campoPassword.setText("");
			etiquetaEstado.setText("esperando entrada...");
			etiquetaEstado.setForeground(Color.BLACK);
		}
	}

	// funcion interna que replica tu metodo esfuerte() para la validacion
	private boolean evaluarFortaleza(String p) {
		int may = 0, min = 0, num = 0;
		if (p.length() < 8) return false;
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (c >= 'a' && c <= 'z') min++;
			else if (c >= 'A' && c <= 'Z') may++;
			else if (c >= '0' && c <= '9') num++;
		}
		return (may >= 2 && min >= 2 && num >= 2);
	}

	// metodo principal para arrancar el programa
	public static void main(String[] args) {
		new PasswordTeclado();
	}
}