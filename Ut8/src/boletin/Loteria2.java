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

public class Loteria2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;

	/**
	 * Constructor
	 */
	public Loteria2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		JMenu mnInfo = new JMenu("Info");
		mnNewMenu.add(mnInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenu mnInfo1 = new JMenu("Salir");
		mnNewMenu.add(mnInfo1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(44, 94, 36, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(102, 94, 36, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 94, 36, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(217, 94, 36, 20);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(277, 94, 36, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(344, 94, 36, 20);
		contentPane.add(textField_5);

		// Botón para generar números aleatorios
		btnNewButton = new JButton("Generar números");
		btnNewButton.setBounds(65, 157, 315, 39);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);

		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(44, 60, 36, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setBounds(102, 60, 36, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setBounds(160, 60, 36, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setBounds(217, 60, 36, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setBounds(277, 60, 36, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("6");
		lblNewLabel_5.setBounds(344, 60, 36, 14);
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
	 * Función que devuelve el número de elementos comunes entre dos arrays
	 * 
	 * @param a - array de números enteros pasado por parámetro
	 * @param b - array de números enteros pasado por parámetro
	 * @return int cantidad de elementos repetidos
	 */
	public static int aciertos(int[] a, int[] b) {
		int conta = 0;
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				if (a[i] == b[j]) {
					conta++;
				}
			}
		}
		return conta;
	}
	
	/**
	 * Método para accionar el botón y generar los números aleatorios
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
			
			String num = String.valueOf(ganadores[0]); textField.setText(num);
			String num1 = String.valueOf(ganadores[1]); textField_1.setText(num1);
			String num2 = String.valueOf(ganadores[2]); textField_2.setText(num2);
			String num3 = String.valueOf(ganadores[3]); textField_3.setText(num3);
			String num4 = String.valueOf(ganadores[4]); textField_4.setText(num4);
			String num5 = String.valueOf(ganadores[5]); textField_5.setText(num5);
		}

	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loteria2 frame = new Loteria2();
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
