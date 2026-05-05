package boletin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LoteriaWindowsBuilder extends JFrame implements ActionListener {

	/**
	 * Declaración de los componentes
	 */
	// Panel principal que contendrá todos los elementos
	private JPanel panelPrincipal;
	
	// Subpanel para los números
	private JPanel panelNumeros;
	
	// Subpanel para el botón
	private JPanel panelBoton;
	
	// Array de campos de texto para manejar de forma agrupada
	private JTextField[] camposNumeros;
	
	// Array de etiquetas para manejar de forma agurpada
	private JLabel[] labels;
	
	// Botón para la generación de números
	private JButton btnGenerar;
	
	// Barra de menú
	private JMenuBar menuBar;
	
	// Munú para la barra de menú
	private JMenu menuPrin;
	
	// Elementos del menú para mostrar la info o cerrar la app
	private JMenuItem mnInfo, mnSalir;
	
	
	// Constante para definir la cantidad de números de la combinación
	public static final int TAM = 6;
	
	

	/**
	 * Constructor
	 */
	public LoteriaWindowsBuilder() {
		
		// --- Configuramos la parte superior del Frame ---
		
		// Configuración de cierre para la X de  la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Establecemos título para la parte superior
		setTitle("Lotería Primitiva - Layout Verison");
		
		// --- Configuración de la barra de menú ---
		
		// Inicializamos la barra de menú
		menuBar = new JMenuBar();
		// Asociamos la barra a la ventana principal
		setJMenuBar(menuBar);
		
		// Inicializamos el menú
		menuPrin = new JMenu("Archivo");
		// Añadimos el menú a la barra
		menuBar.add(menuPrin);
		
		// Inicializamos el item info para dentro del menú
		mnInfo = new JMenuItem("Info");
		// Añadimos el item al menu
		menuPrin.add(mnInfo);
		// Conectamos el item con el método de acción
		mnInfo.addActionListener(this);
		
		// Inicializamos el item para salir en el menú
		mnSalir = new JMenuItem("Salir");
		// Añadimos el item al menú
		menuPrin.add(mnSalir);
		// Conectamos al método de acción
		mnSalir.addActionListener(this);
		
		// --- Configuración del panel principal ---
		
		// Inicializamos el panel principal
		// BordreLayout nos prepara un escenario con centro y puntos cardinales
		panelPrincipal = new JPanel(new BorderLayout(10,20));
		
		// Margen interno padding
		panelPrincipal.setBorder(new EmptyBorder(20,20,20,20));
		
		// Establecemos como panel principal de la ventana
		setContentPane(panelPrincipal);
		
		// --- Configuración del panel de números (centro) ---
		
		// Inicializamos el subpanel para los números
		// GridLayout(2,6,10,5) con 2 filas y 6 columnas
		panelNumeros = new JPanel(new GridLayout(2,6,10,5));
		
		// Añade un título descriptivo
		panelNumeros.setBorder(new TitledBorder("Combinación Ganadora"));
		
		// Inicializamos el array para albergar los 6 objetos JTextField
		camposNumeros = new JTextField[TAM];
		
		// Inicializamos el array para albergar los 6 onjetos JLabel
		labels = new JLabel[TAM];
		
		// Bucle para crear y mostrar las 6 etiquetas
		for (int i = 0; i < TAM; i++) {
			
			// Creamos una etiqueta con el número interior centrado según la iteración
			labels[i] = new JLabel("Bola "+(i+1), SwingConstants.CENTER);	
			// Cambiamos la fuente y el tamaño
			labels[i].setFont(new Font("Arial", Font.BOLD, 11));
			// Añadimos la etiqueta a la primera fila del GridLayout
			panelNumeros.add(labels[i]);
		}
		
		// Bucle para crear los campos de texto
		for (int i = 0; i < TAM; i++) {
			
			// Instanciamos el campo de texto según la iteración
			camposNumeros[i] = new JTextField();
			
			// Centramos el texto
			camposNumeros[i].setHorizontalAlignment(JTextField.CENTER);
			
			// Evitamos la edición de este cuadro por el usuario
			camposNumeros[i].setEditable(false);
			
			// Establecemos color
			camposNumeros[i].setBackground(Color.WHITE);
			
			// Cambiamos fuente y tamaño
			camposNumeros[i].setFont(new Font("Arial", Font.BOLD, 18));
			
			// Añadimos el cuadro a la segunda fila del GridLayout
			panelNumeros.add(camposNumeros[i]);
			
		}
		
		// Añadimos el panel en el centro del GridLayout del subpanel
		panelPrincipal.add(panelNumeros, BorderLayout.CENTER);
		
		// Creamos otro panel con el boton centrado con un FlowLayout
		panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// Inicializamos el botón
		btnGenerar = new JButton("GENERAR");
		// Añadimos el botón al subpanel inferior
		panelBoton.add(btnGenerar);
		// Concectamos el botón con el método
		btnGenerar.addActionListener(this);
		
		// Añadimos el panelBoton al panelPrincipal
		panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
		
		// Mostramos la ventana con el tamaño óptimo según componentes
		pack();
		// Evita encoger la ventana mas de lo preciso
		setMinimumSize(new Dimension(500, 300));
		
		
	}

	// Métodos primitiva

	/**
	 * Procedimiento que muestra todos los elementos de un array
	 * 
	 * @param a - array pasado por parámetro
	 */
	public static void mostrar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Función que determina si el número n se encuentra entre los elementos de un
	 * array
	 * 
	 * @param a - array de números enteros
	 * @param n - número a comprobar
	 * @return TRUE si el número se encuentra en el array, FALSE si no se encuentra
	 */
	public static boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve un número aleatorio para cada posición de un array pasado por
	 * parámetro
	 * 
	 * @param a - array para rellenar
	 * @return Array de números generados aleatoriamente
	 */
	public static int[] aleatorio(int[] a) {
		// Recorremos el array
		for (int i = 0; i < a.length; i++) {

			// Declaramos variable temporal
			int aux;

			// Generamos aleatorio para esta iteración
			do {
				aux = (int) (Math.random() * 49 + 1);

				// Si ya se encuentra en el array se genera de nuevo para la misma posición
			} while (encontrado(a, aux));

			// Cuando llega aquí es correcto y se almacena en la posición del vector
			a[i] = aux;
		}
		return a;
	}

	/**
	 * Procedimiento que ordena los elementos contenidos en un array Orden de menor
	 * a mayor
	 * 
	 * @param a - array de números enteros
	 */
	public static void bubblesort(int[] a) {
		// Recorremos el array descendentemente
		for (int i = a.length - 1; i >= 0; i--) {
			// Recorremos el array ascendentemente
			for (int j = 0; j < i; j++) {
				// Si nos encontramos que el anterior elemento es mayor que el siguinte
				if (a[j] > a[j + 1]) {
					// Intercambiamos los elementos
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}


	/**
	 * Método para accionar los botones
	 * Generar para aleatorios
	 * Items para mensaje iformativo y salir
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Para el botón principal
		if (e.getSource() == btnGenerar) {
			
			// Creamos un array de números para rellenar con aleatorio
			int[] ganadores = new int[TAM];
			
			// Generamos números aleatorios para cada posición
			aleatorio(ganadores);
			
			// Ordenamos de menor a mayor
			bubblesort(ganadores);
			
			// Recorremos el array de camposTexto y camposNuemeros a la vez
			for (int i = 0; i < TAM; i++) {
				// Actualizamos cada campo con su número
				camposNumeros[i].setText(String.valueOf(ganadores[i]));
			}
		}

		// Para los item del menú
		if (e.getSource() == mnInfo) {
			 VentanaSecundariaInfo v = new VentanaSecundariaInfo();
			 v.setLocationRelativeTo(this);
			 v.setVisible(true);
		}

		if (e.getSource() == mnSalir) {
			System.exit(0);
		}

	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoteriaWindowsBuilder frame = new LoteriaWindowsBuilder();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
