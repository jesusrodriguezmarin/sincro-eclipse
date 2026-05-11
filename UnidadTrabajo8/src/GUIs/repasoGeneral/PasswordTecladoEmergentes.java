package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordTecladoEmergentes extends JFrame implements ActionListener {

	// declaracion de los componentes de la interfaz grafica
	private JPanel panelEntrada, panelTeclado, contenedorTeclado;
	private JPasswordField campoPassword;
	private JButton botonValidar, botonGenerar, botonBorrar, botonMostrar;
	
	// booleano para controlar el estado de visibilidad de la clave
	private boolean oculto = true;
	
	// objeto de tu clase logica para las operaciones de password
	private SuperPasswordPOO objetoPass;

	public PasswordTecladoEmergentes() {
		// inicializamos tu clase logica superpasswordpoo
		objetoPass = new SuperPasswordPOO();
		
		// configuracion del layout principal de la ventana
		setLayout(new BorderLayout(10, 10));
		// margen interno para separar los elementos de los bordes
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- bloque norte: entrada y botones de control ---
		panelEntrada = new JPanel(new GridLayout(0, 1, 0, 5));
		campoPassword = new JPasswordField();
		// alineacion central para los asteriscos de la clave
		campoPassword.setHorizontalAlignment(JTextField.CENTER);
		campoPassword.setFont(new Font("Arial", Font.BOLD, 18));
		
		// añadimos etiqueta y caja de password al panel superior
		panelEntrada.add(new JLabel("seguridad avanzada - use el teclado virtual:"));
		panelEntrada.add(campoPassword);
		
		// panel horizontal para los botones de accion
		JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botonValidar = new JButton("comprobar");
		botonGenerar = new JButton("generar");
		botonMostrar = new JButton("mostrar"); 
		botonBorrar = new JButton("borrar");
		
		// añadimos los botones al panel de control superior
		pBotones.add(botonValidar);
		pBotones.add(botonGenerar);
		pBotones.add(botonMostrar);
		pBotones.add(botonBorrar);
		panelEntrada.add(pBotones);

		// situamos todo el bloque de control en el norte
		add(panelEntrada, BorderLayout.NORTH);

		// --- bloque sur: teclado virtual del abecedario ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen para separar el teclado de la parte superior
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		// rejilla de 3 por 9 para las teclas de letras
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		panelTeclado.setPreferredSize(new Dimension(600, 150)); 
		
		// creamos el abecedario mediante un bucle for
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			btn.setFont(new Font("Arial", Font.BOLD, 12));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// añadimos el teclado a su contenedor y al sur de la ventana
		contenedorTeclado.add(panelTeclado);
		add(contenedorTeclado, BorderLayout.SOUTH);

		// registramos los escuchadores para todos los botones
		botonValidar.addActionListener(this);
		botonGenerar.addActionListener(this);
		botonMostrar.addActionListener(this);
		botonBorrar.addActionListener(this);

		// configuracion de la ventana principal
		setTitle("PasswordTecladoEmergentes");
		// ventana estrecha para que el teclado ocupe el ancho justo
		setSize(650, 500); 
		setMinimumSize(new Dimension(600, 450));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// gestion de las pulsaciones en las teclas del abecedario
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String texto = boton.getText();

			// si es una letra, la añadimos al campo de password
			if (texto.length() == 1 && e.getSource() != botonValidar && e.getSource() != botonGenerar && e.getSource() != botonBorrar && e.getSource() != botonMostrar) {
				String actual = new String(campoPassword.getPassword());
				campoPassword.setText(actual + texto);
			}
		}

		// logica para mostrar u ocultar los caracteres
		if (e.getSource() == botonMostrar) {
			if (oculto) {
				// el valor 0 hace que el texto sea visible
				campoPassword.setEchoChar((char) 0);
				botonMostrar.setText("ocultar");
				oculto = false;
			} else {
				// volvemos a poner el caracter de ocultacion
				campoPassword.setEchoChar('•');
				botonMostrar.setText("mostrar");
				oculto = true;
			}
		}

		// logica para generar una contraseña aleatoria con tu metodo
		if (e.getSource() == botonGenerar) {
			String nuevaPass = objetoPass.generarPassword();
			campoPassword.setText(nuevaPass);
			// ventana emergente informativa
			JOptionPane.showMessageDialog(this, "nueva contraseña aleatoria generada");
		}

		// logica para validar la fortaleza mediante ventana emergente
		if (e.getSource() == botonValidar) {
			String passIntroducida = new String(campoPassword.getPassword());
			if (evaluarFortaleza(passIntroducida)) {
				// ventana emergente de exito (tipo informacion)
				JOptionPane.showMessageDialog(this, "la contraseña es fuerte", "resultado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				// ventana emergente de fallo (tipo error)
				JOptionPane.showMessageDialog(this, "la contraseña es débil\nnecesita 2 mayús, 2 minús y 2 números", "resultado", JOptionPane.ERROR_MESSAGE);
			}
		}

		// logica para limpiar los datos y avisar al usuario
		if (e.getSource() == botonBorrar) {
			campoPassword.setText("");
			JOptionPane.showMessageDialog(this, "datos borrados");
		}
	}

	// funcion que aplica las reglas de tu clase superpasswordpoo
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

	// ejecucion de la aplicacion
	public static void main(String[] args) {
		new PasswordTecladoEmergentes();
	}
}