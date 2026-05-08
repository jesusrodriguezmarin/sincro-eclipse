package GUIs.repasoGeneral;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AhorcadoFrame extends JFrame implements ActionListener {

	/*
	 * Atributos de lógica y componentes
	 */
	private AhorcadoPOO juego; // Objeto que tiene la palabra secreta y los intentos
	private JLabel ePalabra, eIntentos, eMensaje; // Etiquetas
	private JTextField texto; // Cuadro de escritura
	private JButton botIntentar, botResolver; // Botones

	/**
	 * Constructor Método que se ejecuta al crear la ventana
	 */
	public AhorcadoFrame() {

		// Inicializamos el objeto AhorcadoPOO
		juego = new AhorcadoPOO(); // Crea la partida

		// Configuramos la ventana principal
		setTitle("Juego del ahorcado"); // Título
		setSize(450, 350); // Ancho y alto
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Detención completa en el cierre
		setLocationRelativeTo(null); // Centra la ventana
		setLayout(new GridLayout(5, 1, 10, 10)); // división en 5 partes 10 de separción

		/**
		 * Componentes
		 */
		// Crea la palabra con asteriscos y la centra
		ePalabra = new JLabel(juego.getPalabraMostrar(), SwingConstants.CENTER);
		// Todas las letras miden lo mismmo y asigna un tamaño grande 35
		ePalabra.setFont(new Font("Monospaced", Font.BOLD, 35));

		// Crea una etiqueta para el contador de intentos y la centra
		eIntentos = new JLabel("Intentos: 0 / " + juego.TOTAL_INTENTOS, SwingConstants.CENTER);
		// Asigna un estilo sencillo y pequeño 16
		eIntentos.setFont(new Font("Arial", Font.PLAIN, 16));

		// Crea subcontenedor para poner varios elementos en una sola fila
		JPanel panelControl = new JPanel(new FlowLayout());
		// Crea un cuadro de entrada con ancho para 10 caracteres
		texto = new JTextField(10);

		// Botón para probar letras individuales
		botIntentar = new JButton("Letra");
		// Botón para resolver palabra completa
		botResolver = new JButton("Resolver");

		// Mete la etiqueta entrada en el panel pequeño
		panelControl.add(new JLabel("Entrada: "));
		// Mete el cuadro de texto en el panel pequeño
		panelControl.add(texto);
		// Mete los botones en el panel pequeño
		panelControl.add(botIntentar);
		panelControl.add(botResolver);

		// Crea la etiqueta guía para el usuario
		eMensaje = new JLabel("Bienvenido! Introduce una letra o intenta resolver.", SwingConstants.CENTER);
		// Da color al texto
		eMensaje.setForeground(Color.DARK_GRAY);

		// Enlaza los botones con esta clase
		botIntentar.addActionListener(this);
		botResolver.addActionListener(this);

		// Añade todos los componentes a la ventana siguiendo el GridLayout
		add(ePalabra);
		add(eIntentos);
		add(panelControl);
		add(eMensaje);

		// Muestra la ventana en pantalla
		setVisible(true);

	}

	/**
	 * Método que se ejecuta tras pulsar un botón (this)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Variable String para capturar el texto del TextField
		String text = texto.getText().trim().toUpperCase();

		// Validación básica por si no se escribe nada avisar
		if (text.isEmpty()) {
			eMensaje.setText("Debes escribir algo...");
			eMensaje.setForeground(Color.ORANGE);
			return; // Detiene la ejecución del clic
		}

		// Acción para el botón intentar, ¿Se ha pulsado el botón de la letra?
		if (e.getSource() == botIntentar) {

			// Capturamos el primer carácter del String introducido
			char letra = text.charAt(0);

			// Aplicamos el método .intentar en juego
			if (juego.intentar(letra)) {
				// Conirma acierto
				eMensaje.setText("Correcto! la letra " + letra + " existe.");
				// Pone mensaje en verde
				eMensaje.setForeground(Color.GREEN);
			} else {
				// Confirma fallo
				eMensaje.setText("Fallaste, la letra " + letra + " no existe");
				// Pone mensaje en rojo
				eMensaje.setForeground(Color.RED);
			}

			// Acción para el botón de resolver, ¿Se ha pulsado el botón resolver?
		} else if (e.getSource() == botResolver) {

			// Aplicamos el método .resolver en juego
			if (juego.resolver(text)) {
				// Acierto y color verde
				eMensaje.setText("INCREIBLE! Has acertado la palabra.");
				eMensaje.setForeground(Color.GREEN);

			} else {
				// Fallo y color rojo
				eMensaje.setText("Esa no es la palabra correcta...");
				eMensaje.setForeground(Color.RED);
			}
		}

		// Preparamos de nuevo el escenario
		actualizarPantalla(); // Llama al método para refrescar asteriscos e intentos
		texto.setText(""); // Borra lo escrito en el campo de texto
		texto.requestFocus(); // Pone el cursor de nuevo en el cuadro de texto
	}

	/**
	 * Procedimiento que actualiza la pantalla para seguir jugando
	 */
	private void actualizarPantalla() {

		// Refrescamos los datos del objeto juego
		ePalabra.setText(juego.getPalabraMostrar()); // Actualiza los asteriscos
		// Actualiza el contador
		eIntentos.setText("Intentos: " + juego.getIntentos() + "/" + juego.TOTAL_INTENTOS);

		// Comprobamos victoria con el método del objeto
		if (juego.isAcertada()) {
			// Avisa de la victoria
			eMensaje.setText("GANASTE! La palabra era: " + juego.getAcertar());
			// Bloquea botones
			bloquearControles();

			// Comprobamos derrota con los métodos del objeto
		} else if (juego.getIntentos() >= juego.TOTAL_INTENTOS) {
			// Avisa de la perdida
			eMensaje.setText("PERDISTE! La palabra era: " + juego.getAcertar());
			// Muestra la palabra real
			ePalabra.setText(juego.getAcertar());
			// Bloquea botones
			bloquearControles();
		}
	}

	/**
	 * Procedimiento que deshabilita los botones y el campo de texto
	 */
	public void bloquearControles() {
		// Deshabilita el cuadro de texto y los botones
		texto.setEnabled(false);
		botIntentar.setEnabled(false);
		botResolver.setEnabled(false);
	}

	// Programa principal
	public static void main(String[] args) {

		// Ejecutamos la interfaz llamando al constructor
		new AhorcadoFrame();
	}

}
