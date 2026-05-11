package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoteriaAleatorio extends JFrame implements ActionListener {

	// Definimos el tamaño de la combinación (6 números)
	public static final int TAM = 6;
	// Array para almacenar los números de la combinación ganadora
	private int[] ganadores = new int[TAM];
	// Array para almacenar los números de la apuesta del usuario
	private int[] introducidos = new int[TAM];

	// Arrays de componentes gráficos para mostrar cada número por separado
	private JTextField[] camposUser = new JTextField[TAM];
	private JTextField[] camposPremio = new JTextField[TAM];
	
	// Componentes de texto y control de la interfaz
	private JLabel etiquetaEstado;
	private JButton botonSortear, botonLimpiar, botonGenerar;

	// Constructor para montar la interfaz gráfica
	public LoteriaAleatorio() {
		// Establecemos el diseño de bordes con separación de 15 píxeles
		setLayout(new BorderLayout(15, 15));
		// Aplicamos un margen interno a la ventana de 20 píxeles por cada lado
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// --- BLOQUE NORTE: PANELES DE VISUALIZACIÓN ---
		// Creamos un contenedor vertical para agrupar los dos paneles de números
		JPanel panelCentralizado = new JPanel(new GridLayout(0, 1, 0, 10));
		
		// Añadimos el título para la sección de la apuesta del usuario
		panelCentralizado.add(new JLabel("TU APUESTA AUTOMÁTICA:", SwingConstants.CENTER));
		// Panel horizontal para alinear los 6 cuadros de la apuesta
		JPanel pUser = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// Creamos el campo con fondo blanco llamando al método auxiliar
			camposUser[i] = crearEstiloCampo(Color.WHITE);
			// Añadimos el campo individual al panel del usuario
			pUser.add(camposUser[i]);
		}
		// Insertamos el panel del usuario en el contenedor centralizado
		panelCentralizado.add(pUser);

		// Añadimos el título para la sección del resultado del sorteo
		panelCentralizado.add(new JLabel("COMBINACIÓN GANADORA:", SwingConstants.CENTER));
		// Panel horizontal para los 6 cuadros del premio
		JPanel pPremio = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// Creamos el campo con un tono amarillento para diferenciarlo
			camposPremio[i] = crearEstiloCampo(new Color(255, 255, 210));
			// Añadimos el campo al panel de premios
			pPremio.add(camposPremio[i]);
		}
		// Insertamos el panel de premios en el contenedor centralizado
		panelCentralizado.add(pPremio);
		
		// Añadimos todo el conjunto de paneles a la parte superior de la ventana
		add(panelCentralizado, BorderLayout.NORTH);

		// --- BLOQUE CENTRO: MENSAJES DE ESTADO ---
		// Inicializamos la etiqueta que informa sobre el progreso del juego
		etiquetaEstado = new JLabel("Pulsa el botón para generar tu jugada", SwingConstants.CENTER);
		// Aplicamos una fuente en negrita para resaltar los mensajes
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 14));
		// Colocamos la etiqueta en el centro de la ventana
		add(etiquetaEstado, BorderLayout.CENTER);

		// --- BLOQUE SUR: BOTONES DE CONTROL ---
		// Contenedor para los botones con alineación centrada
		JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		// Creamos los tres botones principales de la lógica
		botonGenerar = new JButton("Generar apuesta");
		botonSortear = new JButton("Realizar sorteo");
		botonLimpiar = new JButton("Nuevo juego");
		
		// Deshabilitamos el botón de sortear hasta que exista una apuesta generada
		botonSortear.setEnabled(false); 
		
		// Insertamos los botones en el panel inferior
		panelInferior.add(botonGenerar);
		panelInferior.add(botonSortear);
		panelInferior.add(botonLimpiar);
		// Situamos los controles en la base de la ventana
		add(panelInferior, BorderLayout.SOUTH);

		// Registramos los botones en el escuchador de eventos
		botonGenerar.addActionListener(this);
		botonSortear.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// Definimos las propiedades básicas del JFrame
		setTitle("Sorteo de Lotería - 6 de 49");
		setSize(500, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método auxiliar para configurar el aspecto visual de los cuadros de números
	 */
	private JTextField crearEstiloCampo(Color fondo) {
		// Creamos el campo con un ancho de 2 columnas
		JTextField tf = new JTextField(2);
		// Evitamos que el usuario pueda escribir manualmente en el cuadro
		tf.setEditable(false);
		// Centramos el número dentro del cuadro
		tf.setHorizontalAlignment(JTextField.CENTER);
		// Definimos una fuente grande y clara
		tf.setFont(new Font("Arial", Font.BOLD, 18));
		// Aplicamos el color de fondo recibido por parámetro
		tf.setBackground(fondo);
		return tf;
	}

	// Gestión de los eventos de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Acción al pulsar el botón de Generar Apuesta
		if (e.getSource() == botonGenerar) {
			// Generamos 6 números aleatorios sin repetir
			introducidos = aleatorio(new int[TAM]);
			// Ordenamos los números de menor a mayor
			bubblesort(introducidos);
			
			// Recorremos los cuadros de texto para mostrar la apuesta formateada
			for (int i = 0; i < TAM; i++) {
				// Mostramos el número con dos dígitos (ej: 05)
				camposUser[i].setText(String.format("%02d", introducidos[i]));
			}
			
			// Actualizamos el estado y gestionamos la disponibilidad de botones
			etiquetaEstado.setText("Apuesta lista. ¡Mucha suerte!");
			botonGenerar.setEnabled(false);
			botonSortear.setEnabled(true);
		}

		// Acción al pulsar el botón de Realizar Sorteo
		if (e.getSource() == botonSortear) {
			// Generamos la combinación ganadora aleatoria
			ganadores = aleatorio(new int[TAM]);
			// Ordenamos la combinación ganadora
			bubblesort(ganadores);
			
			// Mostramos los números ganadores en sus cuadros correspondientes
			for (int i = 0; i < TAM; i++) {
				camposPremio[i].setText(String.format("%02d", ganadores[i]));
			}
			
			// Calculamos cuántos números coinciden entre apuesta y premio
			int numAciertos = aciertos(ganadores, introducidos);
			// Mostramos el número de aciertos en la etiqueta
			etiquetaEstado.setText("Resultado: " + numAciertos + " aciertos");
			
			// Si hay 3 o más aciertos, ponemos el mensaje en verde (premio)
			if (numAciertos >= 3) {
				etiquetaEstado.setForeground(new Color(0, 150, 0));
			} else {
				// Si hay pocos aciertos, lo mostramos en rojo
				etiquetaEstado.setForeground(Color.RED);
			}
			
			// Mostramos una ventana emergente con el resumen del resultado
			JOptionPane.showMessageDialog(this, "Has tenido " + numAciertos + " aciertos");
			// Deshabilitamos el botón de sorteo hasta que se inicie un nuevo juego
			botonSortear.setEnabled(false);
		}

		// Acción al pulsar el botón de Nuevo Juego
		if (e.getSource() == botonLimpiar) {
			// Reiniciamos los arrays de lógica
			introducidos = new int[TAM];
			ganadores = new int[TAM];
			// Limpiamos visualmente todos los cuadros de texto
			for (int i = 0; i < TAM; i++) {
				camposUser[i].setText("");
				camposPremio[i].setText("");
			}
			// Restauramos el mensaje inicial y el color predeterminado
			etiquetaEstado.setText("Pulsa el botón para generar tu jugada");
			etiquetaEstado.setForeground(Color.BLACK);
			// Habilitamos el botón de apuesta y bloqueamos el de sorteo
			botonGenerar.setEnabled(true);
			botonSortear.setEnabled(false);
		}
	}

	/**
	 * Busca si un número ya existe dentro de un array para evitar duplicados
	 */
	public boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) return true;
		}
		return false;
	}

	/**
	 * Rellena un array con números aleatorios únicos entre 1 y 49
	 */
	public int[] aleatorio(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int aux;
			// Repetimos la generación si el número ya ha salido antes
			do {
				aux = (int) (Math.random() * 49 + 1);
			} while (encontrado(a, aux));
			a[i] = aux;
		}
		return a;
	}

	/**
	 * Ordena los números del array de menor a mayor (Método Burbuja)
	 */
	public void bubblesort(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				// Intercambiamos si el número actual es mayor que el siguiente
				if (a[j] > a[j + 1]) {
					int aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
	}

	/**
	 * Compara dos arrays y devuelve el número total de coincidencias
	 */
	public int aciertos(int[] a, int[] b) {
		int conta = 0;
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				// Si encontramos el número en ambos arrays, sumamos un acierto
				if (a[i] == b[j]) conta++;
			}
		}
		return conta;
	}

	// Método principal para arrancar la aplicación
	public static void main(String[] args) {
		// Instanciamos e iniciamos la ventana de lotería
		new LoteriaAleatorio();
	}
}