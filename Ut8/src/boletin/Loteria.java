package boletin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Loteria extends JFrame implements ActionListener {

	/**
	 * Declaración de los componentes
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Constructor
	 */
	public Loteria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Barra de menú
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Menú
		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		// Item para la información
		mntmNewMenuItem = new JMenuItem("Info");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(this);

		// Item para salir
		mntmNewMenuItem_1 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(this);

		// Paneles
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Campos de texto para mostrar los números aleatorios generados
		textField = new JTextField();
		textField.setBounds(50, 94, 36, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(108, 94, 36, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(166, 94, 36, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 94, 36, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(283, 94, 36, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(350, 94, 36, 20);
		contentPane.add(textField_5);

		// Botón para generar números aleatorios
		btnNewButton = new JButton("Generar números");
		btnNewButton.setBounds(50, 157, 336, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);

		// Etiquetas
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(57, 60, 36, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setBounds(115, 60, 36, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setBounds(176, 60, 36, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setBounds(232, 60, 36, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setBounds(291, 60, 36, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("6");
		lblNewLabel_5.setBounds(360, 60, 36, 14);
		contentPane.add(lblNewLabel_5);

	}

	// Métodos primitiva
	
	// Constante para el tamaño de los arrays
	public static final int TAM = 6;

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

		// Array para los números ganadores generados aleatoriamente
		int[] ganadores = new int[TAM];

		if (e.getSource() == btnNewButton) {

			// Generamos los aleatorios
			aleatorio(ganadores);

			// Ordenamos
			bubblesort(ganadores);

			String num = String.valueOf(ganadores[0]);
			textField.setText(num);
			String num1 = String.valueOf(ganadores[1]);
			textField_1.setText(num1);
			String num2 = String.valueOf(ganadores[2]);
			textField_2.setText(num2);
			String num3 = String.valueOf(ganadores[3]);
			textField_3.setText(num3);
			String num4 = String.valueOf(ganadores[4]);
			textField_4.setText(num4);
			String num5 = String.valueOf(ganadores[5]);
			textField_5.setText(num5);
		}

		if (e.getSource() == mntmNewMenuItem) {
			JOptionPane.showMessageDialog(null, "Generador de números de LA LOTERÍA PRIMITIVA", "Examen de Programación", JOptionPane.PLAIN_MESSAGE);
		}

		if (e.getSource() == mntmNewMenuItem_1) {
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
					Loteria frame = new Loteria();
					frame.setTitle("Lotería Primitiva");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
