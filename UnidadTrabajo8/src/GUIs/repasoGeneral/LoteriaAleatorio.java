package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoteriaAleatorio extends JFrame implements ActionListener {

	public static final int TAM = 6;
	private int[] ganadores = new int[TAM];
	private int[] introducidos = new int[TAM];

	private JTextField[] camposUser = new JTextField[TAM];
	private JTextField[] camposPremio = new JTextField[TAM];
	
	private JLabel etiquetaEstado;
	private JButton botonSortear, botonLimpiar, botonGenerar;

	public LoteriaAleatorio() {
		setLayout(new BorderLayout(15, 15));
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- BLOQUE NORTE: PANELES DE VISUALIZACIÓN ---
		JPanel panelCentralizado = new JPanel(new GridLayout(0, 1, 0, 10));
		
		// CAMBIO EN ETIQUETA: Ahora avisamos de que es mixto
		panelCentralizado.add(new JLabel("TU APUESTA (AUTOMÁTICA O MANUAL [1-49]):", SwingConstants.CENTER));
		JPanel pUser = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// CLAVE: Ahora estos campos nacen EDITABLES para poder escribir a mano
			camposUser[i] = crearEstiloCampo(Color.WHITE, true);
			pUser.add(camposUser[i]);
		}
		panelCentralizado.add(pUser);

		panelCentralizado.add(new JLabel("COMBINACIÓN GANADORA:", SwingConstants.CENTER));
		JPanel pPremio = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// Los del premio siguen bloqueados siempre
			camposPremio[i] = crearEstiloCampo(new Color(255, 255, 210), false);
			pPremio.add(camposPremio[i]);
		}
		panelCentralizado.add(pPremio);
		
		add(panelCentralizado, BorderLayout.NORTH);

		// --- BLOQUE CENTRO: MENSAJES DE ESTADO ---
		etiquetaEstado = new JLabel("Escribe tus 6 números o pulsa 'Generar apuesta'", SwingConstants.CENTER);
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 14));
		add(etiquetaEstado, BorderLayout.CENTER);

		// --- BLOQUE SUR: BOTONES DE CONTROL ---
		JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		botonGenerar = new JButton("Generar apuesta");
		botonSortear = new JButton("Realizar sorteo");
		botonLimpiar = new JButton("Nuevo juego");
		
		// CLAVE EXTRA: Ahora el botón sortear arranca habilitado porque el usuario 
		// puede rellenar los cuadros directamente nada más abrir el programa.
		botonSortear.setEnabled(true); 
		
		panelInferior.add(botonGenerar);
		panelInferior.add(botonSortear);
		panelInferior.add(botonLimpiar);
		add(panelInferior, BorderLayout.SOUTH);

		botonGenerar.addActionListener(this);
		botonSortear.addActionListener(this);
		botonLimpiar.addActionListener(this);

		setTitle("Sorteo de Lotería - Modo Mixto");
		setSize(520, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método auxiliar modificado para admitir si es editable o no por parámetro
	 */
	private JTextField crearEstiloCampo(Color fondo, boolean editable) {
		JTextField tf = new JTextField(2);
		tf.setEditable(editable); // <--- Configuración dinámica
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setFont(new Font("Arial", Font.BOLD, 18));
		tf.setBackground(fondo);
		return tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// ACCIÓN: GENERAR AUTOMÁTICO
		if (e.getSource() == botonGenerar) {
			introducidos = aleatorio(new int[TAM]);
			bubblesort(introducidos);
			
			for (int i = 0; i < TAM; i++) {
				camposUser[i].setText(String.format("%02d", introducidos[i]));
				camposUser[i].setEditable(false); // Bloqueamos para que no altere el autogenerado
			}
			
			etiquetaEstado.setText("Apuesta automática lista. ¡Mucha suerte!");
			botonGenerar.setEnabled(false);
		}

		// ACCIÓN: REALIZAR SORTEO (Gestión inteligente mixta)
		if (e.getSource() == botonSortear) {
			
			// Si los campos siguen editables, significa que el usuario ha escrito a mano.
			// ¡Hay que validar que lo que ha puesto sea correcto antes de jugar!
			if (camposUser[0].isEditable()) {
				if (!validarCamposManuales()) {
					return; // Si la validación falla, frena el evento aquí mismo.
				}
				// Si pasa el filtro, bloqueamos los campos para el sorteo
				for (int i = 0; i < TAM; i++) {
					camposUser[i].setEditable(false);
				}
			}
			
			// A partir de aquí la lógica del bombo es exactamente la tuya
			ganadores = aleatorio(new int[TAM]);
			bubblesort(ganadores);
			
			for (int i = 0; i < TAM; i++) {
				camposPremio[i].setText(String.format("%02d", ganadores[i]));
			}
			
			int numAciertos = aciertos(ganadores, introducidos);
			etiquetaEstado.setText("Resultado: " + numAciertos + " aciertos");
			
			if (numAciertos >= 3) {
				etiquetaEstado.setForeground(new Color(0, 150, 0));
			} else {
				etiquetaEstado.setForeground(Color.RED);
			}
			
			JOptionPane.showMessageDialog(this, "Has tenido " + numAciertos + " aciertos");
			botonGenerar.setEnabled(false);
			botonSortear.setEnabled(false);
		}

		// ACCIÓN: NUEVO JUEGO
		if (e.getSource() == botonLimpiar) {
			introducidos = new int[TAM];
			ganadores = new int[TAM];
			for (int i = 0; i < TAM; i++) {
				camposUser[i].setText("");
				camposPremio[i].setText("");
				camposUser[i].setEditable(true); // Volvemos a permitir la escritura manual
			}
			etiquetaEstado.setText("Escribe tus 6 números o pulsa 'Generar apuesta'");
			etiquetaEstado.setForeground(Color.BLACK);
			botonGenerar.setEnabled(true);
			botonSortear.setEnabled(true); // Re-habilitamos sorteo
		}
	}

	/**
	 * MÉTODO DE CONTROL EXCLUSIVO PARA EXAMEN:
	 * Valida que los números escritos a mano sean correctos, no se repitan y estén entre 1 y 49.
	 */
	private boolean validarCamposManuales() {
		int[] temporales = new int[TAM];
		
		try {
			for (int i = 0; i < TAM; i++) {
				String texto = camposUser[i].getText().trim();
				
				// Validación 1: ¿Vacío?
				if (texto.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, rellena todos los cuadros de tu apuesta.");
					return false;
				}
				
				// Validación 2: ¿Es un número válido? (Salta al catch si meten letras)
				int num = Integer.parseInt(texto);
				
				// Validación 3: ¿Rango entre 1 y 49?
				if (num < 1 || num > 49) {
					JOptionPane.showMessageDialog(this, "Los números deben estar entre 1 y 49.");
					return false;
				}
				
				// Validación 4: ¿Repetido en su propia jugada manual?
				if (encontrado(temporales, num)) {
					JOptionPane.showMessageDialog(this, "No puedes repetir números en tu apuesta (" + num + ").");
					return false;
				}
				
				temporales[i] = num;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Introduce solo números válidos y enteros.");
			return false;
		}
		
		// Si todo ha ido bien, pasamos los números del chequeo al array oficial e introducidos ordenados
		bubblesort(temporales);
		introducidos = temporales;
		
		// Refrescamos visualmente los cuadros para que salgan bonitos con su formato "05" si metió un solo dígito
		for (int i = 0; i < TAM; i++) {
			camposUser[i].setText(String.format("%02d", introducidos[i]));
		}
		
		return true;
	}

	public boolean encontrar(int[] a, int n) { // Mantenemos tu apoyo
		return encontrado(a, n);
	}

	public boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) return true;
		}
		return false;
	}

	public int[] aleatorio(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int aux;
			do {
				aux = (int) (Math.random() * 49 + 1);
			} while (encontrado(a, aux));
			a[i] = aux;
		}
		return a;
	}

	public void bubblesort(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}

	public int aciertos(int[] a, int[] b) {
		int conta = 0;
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				if (a[i] == b[j]) conta++;
			}
		}
		return conta;
	}

	public static void main(String[] args) {
		new LoteriaAleatorio();
	}
}