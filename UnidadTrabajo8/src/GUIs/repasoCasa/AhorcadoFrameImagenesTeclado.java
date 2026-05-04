package GUIs.repasoCasa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AhorcadoFrameImagenesTeclado extends JFrame implements ActionListener {

	private AhorcadoPOO juego; 
	private JLabel ePalabra, eIntentos, eMensaje, eImagen; 
	private JTextField texto; 
	private JButton botResolver;
	private JPanel panelTeclado; 

	private ImageIcon[] imagenesAhorcado = new ImageIcon[5]; 

	public AhorcadoFrameImagenesTeclado() {

		juego = new AhorcadoPOO(); 

		// 1. CARGA DE IMÁGENES
		String rutaBase = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/ahorcado/";
		for (int i = 0; i < imagenesAhorcado.length; i++) {
			ImageIcon original = new ImageIcon(rutaBase + i + ".png");
			Image imgEscalada = original.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
			imagenesAhorcado[i] = new ImageIcon(imgEscalada);
		}

		// 2. CONFIGURACIÓN VENTANA
		setTitle("Ahorcado");
		setSize(550, 850); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		// --- NORTE: IMAGEN ---
		eImagen = new JLabel(imagenesAhorcado[0], SwingConstants.CENTER);
		add(eImagen, BorderLayout.NORTH);

		// --- CENTRO: MARCADOR ---
		JPanel panelCentral = new JPanel(new GridLayout(3, 1));
		ePalabra = new JLabel(juego.getPalabraMostrar(), SwingConstants.CENTER);
		ePalabra.setFont(new Font("Monospaced", Font.BOLD, 45));
		
		eIntentos = new JLabel("Intentos: 0 / " + juego.TOTAL_INTENTOS, SwingConstants.CENTER);
		eIntentos.setFont(new Font("Arial", Font.PLAIN, 18));
		
		eMensaje = new JLabel("¡Bienvenido!", SwingConstants.CENTER);
		eMensaje.setFont(new Font("Arial", Font.ITALIC, 15));
		
		panelCentral.add(ePalabra);
		panelCentral.add(eIntentos);
		panelCentral.add(eMensaje);
		add(panelCentral, BorderLayout.CENTER);

		// --- SUR: TECLADO AL FINAL ---
		JPanel contenedorSur = new JPanel(new BorderLayout(5, 5));

		// Panel Resolver (Ahora arriba del teclado)
		JPanel panelResolver = new JPanel(new FlowLayout());
		texto = new JTextField(12);
		botResolver = new JButton("Resolver");
		botResolver.addActionListener(this);
		panelResolver.add(new JLabel("Palabra: "));
		panelResolver.add(texto);
		panelResolver.add(botResolver);

		// Panel Teclado (Ahora en el centro/abajo del bloque sur)
		panelTeclado = new JPanel(new GridLayout(0, 10, 3, 3));
		String qwerty = "QWERTYUIOPASDFGHJKLÑ ZXCVBNM";
		for (int i = 0; i < qwerty.length(); i++) {
			char c = qwerty.charAt(i);
			if (c == ' ') {
				panelTeclado.add(new JLabel(""));
			} else {
				JButton b = new JButton("" + c);
				b.addActionListener(this);
				panelTeclado.add(b);
			}
		}

		// Colocación estratégica:
		contenedorSur.add(panelResolver, BorderLayout.NORTH); // El cuadro de texto arriba
		contenedorSur.add(panelTeclado, BorderLayout.CENTER); // El teclado debajo pegado al borde
		
		add(contenedorSur, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Lógica para las letras del teclado virtual
		if (e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().length() == 1) {
			JButton b = (JButton) e.getSource();
			char letra = b.getText().charAt(0);
			
			if (juego.intentar(letra)) {
				eMensaje.setText("Acierto: " + letra);
				eMensaje.setForeground(new Color(0, 120, 0));
			} else {
				eMensaje.setText("Fallo: " + letra);
				eMensaje.setForeground(Color.RED);
			}
			b.setEnabled(false);
		} 
		// Lógica para el botón resolver
		else if (e.getSource() == botResolver) {
			String pal = texto.getText().trim().toUpperCase();
			if (!pal.isEmpty()) {
				if (juego.resolver(pal)) {
					eMensaje.setText("¡GANASTE!");
				} else {
					eMensaje.setText("Palabra incorrecta");
				}
				texto.setText("");
			}
		}
		actualizarPantalla();
	}

	private void actualizarPantalla() {
		ePalabra.setText(juego.getPalabraMostrar());
		eIntentos.setText("Intentos: " + juego.getIntentos() + "/" + juego.TOTAL_INTENTOS);

		int fallos = juego.getIntentos();
		if (fallos < imagenesAhorcado.length) {
			eImagen.setIcon(imagenesAhorcado[fallos]);
		}

		if (juego.isAcertada() || juego.getIntentos() >= juego.TOTAL_INTENTOS) {
			if (juego.isAcertada()) eMensaje.setText("¡VICTORIA!");
			else {
				eMensaje.setText("DERROTA");
				ePalabra.setText(juego.getAcertar());
			}
			bloquearTodo();
		}
	}

	private void bloquearTodo() {
		texto.setEnabled(false);
		botResolver.setEnabled(false);
		for (Component c : panelTeclado.getComponents()) {
			if (c instanceof JButton) c.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new AhorcadoFrameImagenesTeclado();
	}
}