package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoteriaTeclado extends JFrame implements ActionListener {

	// Definimos el tamaño de la combinación de lotería
	public static final int TAM = 6;
	// Array para almacenar los números premiados
	private int[] ganadores = new int[TAM];
	// Array para los números que el usuario elige manualmente
	private int[] introducidos = new int[TAM];
	// Contador para saber cuántos números ha pulsado el usuario
	private int contadorManual = 0;

	// Arrays de componentes para mostrar la jugada y el premio en cuadros individuales
	private JTextField[] camposUser = new JTextField[TAM];
	private JTextField[] camposPremio = new JTextField[TAM];
	
	// Paneles para organizar las distintas zonas de la ventana
	private JPanel panelSuperior, panelInferior, panelTeclado;
	// Etiquetas y botones de control
	private JLabel etiquetaEstado;
	private JButton botonSortear, botonLimpiar, botonBorrar;
	// Array para los 49 botones del teclado numérico
	private JButton[] botonesNumericos = new JButton[50]; 

	// Constructor de la aplicación
	public LoteriaTeclado() {
		// Establecemos el diseño de bordes con separación de 10 píxeles
		setLayout(new BorderLayout(10, 10));
		// Aplicamos un margen de 15 píxeles alrededor del contenido
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// --- BLOQUE NORTE: VISUALIZACIÓN DE CUADROS INDEPENDIENTES ---
		// Panel vertical para organizar las etiquetas y los grupos de cuadros
		panelSuperior = new JPanel(new GridLayout(0, 1, 0, 5));
		
		// Título para la zona de apuesta del usuario
		panelSuperior.add(new JLabel("Tus números para el sorteo:", SwingConstants.CENTER));
		// Panel para alinear horizontalmente los 6 cuadros de la apuesta
		JPanel pUser = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// Creamos el cuadro con fondo blanco
			camposUser[i] = crearEstiloCampo(Color.WHITE);
			pUser.add(camposUser[i]);
		}
		panelSuperior.add(pUser);

		// Título para la zona del resultado del sorteo
		panelSuperior.add(new JLabel("Resultado de la combinación ganadora:", SwingConstants.CENTER));
		// Panel para alinear horizontalmente los 6 cuadros del premio
		JPanel pPremio = new JPanel(new FlowLayout());
		for (int i = 0; i < TAM; i++) {
			// Creamos el cuadro con fondo amarillento
			camposPremio[i] = crearEstiloCampo(new Color(255, 255, 210));
			pPremio.add(camposPremio[i]);
		}
		panelSuperior.add(pPremio);
		
		// Añadimos toda la parte visual al norte
		add(panelSuperior, BorderLayout.NORTH);

		// --- BLOQUE CENTRO: MENSAJES DE ESTADO ---
		// Etiqueta para guiar al usuario durante el proceso
		etiquetaEstado = new JLabel("Selecciona 6 números en el teclado", SwingConstants.CENTER);
		etiquetaEstado.setFont(new Font("Arial", Font.BOLD, 13));
		add(etiquetaEstado, BorderLayout.CENTER);

		// --- BLOQUE SUR: TECLADO Y BOTONES DE ACCIÓN ---
		// Contenedor para el teclado numérico y los botones de control
		panelInferior = new JPanel(new BorderLayout(5, 10));
		// Cuadrícula de 7x7 para alojar los 49 números
		panelTeclado = new JPanel(new GridLayout(7, 7, 3, 3));
		
		// Bucle para crear y configurar cada botón del 1 al 49
		for (int i = 1; i <= 49; i++) {
			botonesNumericos[i] = new JButton(String.valueOf(i));
			botonesNumericos[i].setFont(new Font("Arial", Font.PLAIN, 10));
			// Quitamos el foco para que no se marque el borde al pulsar
			botonesNumericos[i].setFocusable(false);
			// Registramos cada botón en el escuchador de eventos
			botonesNumericos[i].addActionListener(this);
			panelTeclado.add(botonesNumericos[i]);
		}

		// Panel para los botones de operaciones principales
		JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botonSortear = new JButton("Comprobar suerte");
		botonBorrar = new JButton("Borrar último"); 
		botonLimpiar = new JButton("Nuevo sorteo");
		
		// Deshabilitamos el sorteo hasta que se elijan los 6 números
		botonSortear.setEnabled(false); 
		
		// Añadimos los botones al panel de acciones
		panelAcciones.add(botonSortear);
		panelAcciones.add(botonBorrar);
		panelAcciones.add(panelAcciones.add(botonLimpiar));

		// Colocamos el teclado en el centro y las acciones abajo del panel inferior
		panelInferior.add(panelTeclado, BorderLayout.CENTER);
		panelInferior.add(panelAcciones, BorderLayout.SOUTH);
		// Añadimos el bloque completo al sur de la ventana principal
		add(panelInferior, BorderLayout.SOUTH);

		// Registramos los botones de control en el escuchador
		botonSortear.addActionListener(this);
		botonBorrar.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// Configuración básica de la ventana
		setTitle("Lotería con Teclado Virtual");
		setSize(550, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Método auxiliar para estandarizar el diseño de los cuadros de texto
	 */
	private JTextField crearEstiloCampo(Color fondo) {
		JTextField tf = new JTextField(2);
		// Bloqueamos la escritura por teclado físico
		tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setFont(new Font("Arial", Font.BOLD, 18));
		tf.setBackground(fondo);
		return tf;
	}

	// Gestión de todos los eventos de la interfaz
	@Override
	public void actionPerformed(ActionEvent e) {
		// Bucle para detectar si se ha pulsado algún número del 1 al 49
		for (int i = 1; i <= 49; i++) {
			if (e.getSource() == botonesNumericos[i]) {
				// Comprobamos si aún queda espacio en la apuesta (máximo 6)
				if (contadorManual < TAM) {
					// Deshabilitamos el botón pulsado para no repetir número
					botonesNumericos[i].setEnabled(false);
					// Guardamos el número en el array lógico
					introducidos[contadorManual] = i;
					// Mostramos el número en el cuadro visual correspondiente
					camposUser[contadorManual].setText(String.format("%02d", i));
					// Incrementamos el contador de números seleccionados
					contadorManual++;
					
					// Si ya se han seleccionado los 6 números
					if (contadorManual == TAM) {
						// Habilitamos el botón para realizar el sorteo
						botonSortear.setEnabled(true);
						etiquetaEstado.setText("¡Combinación lista!");
						// Bloqueamos el resto del teclado para evitar errores
						bloquearTeclado(true);
					}
				}
			}
		}

		// Lógica para el botón Borrar Último
		if (e.getSource() == botonBorrar) {
			// Solo borramos si hay al menos un número seleccionado
			if (contadorManual > 0) {
				// Retrocedemos el contador
				contadorManual--;
				// Recuperamos el valor del último número introducido
				int ultimoNum = introducidos[contadorManual];
				// Volvemos a habilitar ese botón en el teclado virtual
				botonesNumericos[ultimoNum].setEnabled(true);
				// Reseteamos el valor en el array lógico
				introducidos[contadorManual] = 0;
				// Limpiamos el cuadro visual
				camposUser[contadorManual].setText(""); 
				
				// Si al borrar bajamos de 6, desbloqueamos el teclado para elegir otro
				if (contadorManual < TAM) {
					bloquearTeclado(false);
				}
				
				// Deshabilitamos el sorteo ya que la apuesta está incompleta
				botonSortear.setEnabled(false);
				etiquetaEstado.setText("Número " + ultimoNum + " eliminado.");
			}
		}

		// Lógica para realizar el sorteo y comprobar aciertos
		if (e.getSource() == botonSortear) {
			// Generamos la combinación ganadora aleatoria
			ganadores = aleatorio(new int[TAM]);
			// Ordenamos la combinación ganadora de menor a mayor
			bubblesort(ganadores);
			// Ordenamos la apuesta del usuario para facilitar la lectura visual
			bubblesort(introducidos);
			
			// Actualizamos los cuadros visuales con los resultados ordenados
			for (int i = 0; i < TAM; i++) {
				camposUser[i].setText(String.format("%02d", introducidos[i]));
				camposPremio[i].setText(String.format("%02d", ganadores[i]));
			}
			
			// Comparamos arrays para contar las coincidencias
			int totalAciertos = aciertos(ganadores, introducidos);
			etiquetaEstado.setText("Aciertos totales: " + totalAciertos);
			
			// Cambiamos el color de la etiqueta según el éxito (3 o más para verde)
			if (totalAciertos >= 3) etiquetaEstado.setForeground(new Color(0, 150, 0));
			else etiquetaEstado.setForeground(Color.RED);
			
			// Mostramos un mensaje emergente informativo
			JOptionPane.showMessageDialog(this, "Has obtenido " + totalAciertos + " aciertos");
			// Deshabilitamos el botón de sorteo tras finalizar
			botonSortear.setEnabled(false);
		}

		// Lógica para resetear todo el juego
		if (e.getSource() == botonLimpiar) {
			// Reiniciamos arrays y contador
			introducidos = new int[TAM];
			ganadores = new int[TAM];
			contadorManual = 0;
			// Limpiamos todos los campos de texto visuales
			for (int i = 0; i < TAM; i++) {
				camposUser[i].setText("");
				camposPremio[i].setText("");
			}
			// Restauramos el mensaje inicial y el color de fuente
			etiquetaEstado.setText("Selecciona 6 números");
			etiquetaEstado.setForeground(Color.BLACK);
			botonSortear.setEnabled(false);
			// Rehabilitamos todos los botones del teclado virtual
			for (int i = 1; i <= 49; i++) {
				botonesNumericos[i].setEnabled(true);
			}
		}
	}

	/**
	 * Método para habilitar o deshabilitar los botones que no han sido pulsados
	 */
	private void bloquearTeclado(boolean bloquear) {
		for (int i = 1; i <= 49; i++) {
			// Solo actuamos sobre los botones que el usuario no ha elegido todavía
			if (!encontrado(introducidos, i)) {
				botonesNumericos[i].setEnabled(!bloquear);
			}
		}
	}

	/**
	 * Función para buscar si un número ya existe en un array
	 */
	public boolean encontrado(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) return true;
		}
		return false;
	}

	/**
	 * Rellena un array con 6 números aleatorios únicos entre 1 y 49
	 */
	public int[] aleatorio(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int aux;
			do { aux = (int) (Math.random() * 49 + 1); } while (encontrado(a, aux));
			a[i] = aux;
		}
		return a;
	}

	/**
	 * Ordena un array numérico de menor a mayor (Burbuja)
	 */
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

	/**
	 * Compara dos combinaciones y devuelve el total de coincidencias
	 */
	public int aciertos(int[] a, int[] b) {
		int conta = 0;
		for (int i = 0; i < TAM; i++) {
			for (int j = 0; j < TAM; j++) {
				if (a[i] == b[j]) conta++;
			}
		}
		return conta;
	}

	// Punto de entrada de la aplicación
	public static void main(String[] args) {
		new LoteriaTeclado();
	}
}