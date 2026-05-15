package boletin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AhorcadoBoletin2 extends JFrame implements ActionListener {

	/**
	 * Componentes
	 */
	private AhorcadoPOO juego; 
	private JLabel ePalabra, eIntentos, eMensaje, eImagen; 
	private JPanel panelTeclado; 
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem;
	private ImageIcon[] imagenesAhorcado = new ImageIcon[7]; 

	/**
	 * Constructor
	 */
	public AhorcadoBoletin2() {
		
		// Menús
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Instrucciones");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);
		
		mntmNewMenuItem_1 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(this);
		

		// Instanciamos la clase
		juego = new AhorcadoPOO(); 

		// Cargamos las imagens
		String rutaBase = "C:/proyectos/";
		for (int i = 0; i < imagenesAhorcado.length; i++) {
			ImageIcon original = new ImageIcon(rutaBase +"img" + i + ".png");
			Image imgEscalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			imagenesAhorcado[i] = new ImageIcon(imgEscalada);
		}

		// Configuración de la ventana
		setTitle("Juego del Ahorcado");
		setSize(650, 750); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		// Imagen centro
		eImagen = new JLabel(imagenesAhorcado[0], SwingConstants.CENTER);

		// Marcador norte
		JPanel panelCentral = new JPanel(new GridLayout(4, 1));
		eMensaje = new JLabel("Adivina la palabra pulsando letras en el teclado", SwingConstants.CENTER);
		eMensaje.setFont(new Font("Arial", Font.ITALIC, 15));
		
		ePalabra = new JLabel(juego.getPalabraMostrar(), SwingConstants.CENTER);
		ePalabra.setFont(new Font("Monospaced", Font.BOLD, 30));
		
		eIntentos = new JLabel("Errores: 0 / " + juego.TOTAL_INTENTOS, SwingConstants.CENTER);
		eIntentos.setFont(new Font("Arial", Font.PLAIN, 18));
		
		panelCentral.add(eMensaje);
		panelCentral.add(ePalabra);
		panelCentral.add(eImagen);
		panelCentral.add(eIntentos);
		add(panelCentral, BorderLayout.NORTH);
		
	
		// Panel sur
		JPanel contenedorSur = new JPanel(new BorderLayout(5, 5));

		// Panel Teclado sur
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		for (int i = 0; i < abc.length(); i++) {
			char c = abc.charAt(i);
			
				JButton b = new JButton("" + c);
				b.addActionListener(this);
				panelTeclado.add(b);
			
		}

		// Añadimos el panel del teclado
		contenedorSur.add(panelTeclado, BorderLayout.CENTER); 
		add(contenedorSur, BorderLayout.SOUTH);
		setVisible(true);
	}

	/**
	 * Método para accionar el teclado y el menú
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Lógica para las letras del teclado virtual
		if (e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().length() == 1) {
			JButton b = (JButton) e.getSource();
			char letra = b.getText().charAt(0);
			
			if (juego.intentar(letra)) {
				eMensaje.setText("¡Bien! La letra '" + letra+"' está en la palabra");
			} else {
				eMensaje.setText("Fallaste. La letra '" + letra +"' no se encuentra en la palabra");
			}
			b.setEnabled(false);
		} else if (e.getSource() == mntmNewMenuItem_1) {
			System.exit(0);
		} else if (e.getSource()== mntmNewMenuItem) {
			JOptionPane.showMessageDialog(this, "OBJETIVO DEL JUEGO \n\n Debes adivinar la palabra oculta pulsando las letras del teclado \n\n Cada vez que pulses una letra: \n -Si la letra pertenece a la palabra, se mostrará en su posición. \n -Si la letra no pertenece a la palabra, sumarás un error. \n\n El juego termina cuando: \n -Adivinas completamente la palabra. \n -Alcanzas el número máximo de errores. \n\n ¡Buena suerte!", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		actualizarPantalla();
	}

	/**
	 * Método para actualizar la pantalla
	 */
	private void actualizarPantalla() {
		ePalabra.setText(juego.getPalabraMostrar());
		if (juego.isAcertada()) {
			eIntentos.setText("Errores: " + (juego.getIntentos()-1) + "/" + juego.TOTAL_INTENTOS);
			
		} else {
			eIntentos.setText("Errores: " + juego.getIntentos() + "/" + juego.TOTAL_INTENTOS);

		}

		int fallos = juego.getIntentos();
		if (fallos < imagenesAhorcado.length) {
			eImagen.setIcon(imagenesAhorcado[fallos]);
		}

		if (juego.isAcertada() || juego.getIntentos() >= juego.TOTAL_INTENTOS) {
			if (juego.isAcertada()) {
				eMensaje.setText("¡Has ganado! la palabra era: ");
				JOptionPane.showMessageDialog(this, "¡Has ganado! la palabra era: "+juego.getAcertar(), "¡Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
				
			}
			else {
				eMensaje.setText("Has perdido. La palabra era: ");
				ePalabra.setText(juego.getAcertar());
				JOptionPane.showMessageDialog(this, "Has perdido. La palabra era: "+juego.getAcertar(), "¡Ohhh!", JOptionPane.WARNING_MESSAGE);
			}
			bloquearTodo();
		}
	}

	/**
	 * Método para bloquear el teclado
	 */
	private void bloquearTodo() {
		for (Component c : panelTeclado.getComponents()) {
			if (c instanceof JButton) c.setEnabled(false);
		}
	} 

	// Programa principal
	public static void main(String[] args) {
		new AhorcadoBoletin2();
	}
}