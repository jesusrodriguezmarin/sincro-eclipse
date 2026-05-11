package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.util.Scanner;

public class DiccionarioVentana extends JFrame implements ActionListener {

	// Componentes para la gestión de texto y visualización
	private JTextField campoPalabra, campoTraduccion;
	private JLabel etiquetaEstado;
	private JButton botonBuscar, botonLimpiar;

	// Ruta del archivo dictionary.txt extraída de la lógica original
	private final String RUTA_ARCHIVO = "/Users/jesusrodriguezmarin/Documents/ficherosEclipse/dictionary.txt";

	// Inicio del constructor de la interfaz gráfica
	public DiccionarioVentana() {
		// Establecemos un diseño de bordes con márgenes generosos
		setLayout(new BorderLayout(15, 15));
		// Aplicamos un borde vacío de 25 píxeles para que los componentes no toquen los bordes
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

		// --- BLOQUE SUPERIOR: ENTRADA Y SALIDA ---
		// Panel organizado en una columna para las etiquetas y los campos
		JPanel panelCampos = new JPanel(new GridLayout(0, 1, 0, 10));
		
		// Inicializamos el campo de búsqueda (editable para teclado físico)
		campoPalabra = new JTextField();
		campoPalabra.setHorizontalAlignment(JTextField.CENTER);
		campoPalabra.setFont(new Font("Arial", Font.BOLD, 18));
		
		// Inicializamos el campo donde se mostrará la traducción (solo lectura)
		campoTraduccion = new JTextField();
		campoTraduccion.setEditable(false);
		campoTraduccion.setHorizontalAlignment(JTextField.CENTER);
		campoTraduccion.setFont(new Font("Arial", Font.BOLD, 18));
		campoTraduccion.setBackground(new Color(240, 240, 240));

		// Añadimos las instrucciones y los campos al panel
		panelCampos.add(new JLabel("Escribe la palabra a traducir:", SwingConstants.CENTER));
		panelCampos.add(campoPalabra);
		panelCampos.add(new JLabel("Traducción obtenida:", SwingConstants.CENTER));
		panelCampos.add(campoTraduccion);
		
		add(panelCampos, BorderLayout.NORTH);

		// --- BLOQUE CENTRAL: ESTADO ---
		// Etiqueta informativa sobre el estado de la búsqueda
		etiquetaEstado = new JLabel("Introduce un término y pulsa buscar", SwingConstants.CENTER);
		etiquetaEstado.setFont(new Font("Arial", Font.ITALIC, 13));
		add(etiquetaEstado, BorderLayout.CENTER);

		// --- BLOQUE INFERIOR: CONTROL ---
		// Panel para los botones de acción principal
		JPanel panelBotones = new JPanel(new FlowLayout());
		botonBuscar = new JButton("Buscar Traducción");
		botonLimpiar = new JButton("Limpiar campos");
		
		panelBotones.add(botonBuscar);
		panelBotones.add(botonLimpiar);
		add(panelBotones, BorderLayout.SOUTH);

		// Vinculamos los botones al escuchador de eventos
		botonBuscar.addActionListener(this);
		botonLimpiar.addActionListener(this);
		// Permitimos que al pulsar "Enter" en el teclado se ejecute la búsqueda
		campoPalabra.addActionListener(this);

		// Configuración de las propiedades de la ventana
		setTitle("DiccionarioVentana");
		setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Gestión de las acciones del usuario
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Si el usuario pulsa el botón de limpiar
		if (e.getSource() == botonLimpiar) {
			campoPalabra.setText("");
			campoTraduccion.setText("");
			etiquetaEstado.setText("Campos listos para nueva búsqueda");
			etiquetaEstado.setForeground(Color.BLACK);
		}

		// Si se pulsa Buscar o la tecla Enter en el campo de texto
		if (e.getSource() == botonBuscar || e.getSource() == campoPalabra) {
			// Obtenemos el texto introducido quitando espacios vacíos
			String palabraBuscada = campoPalabra.getText().trim();
			
			// Validamos que el campo no esté vacío
			if (palabraBuscada.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debes introducir una palabra para buscar.");
				return;
			}

			// Creamos el objeto para acceder al fichero
			File f = new File(RUTA_ARCHIVO);
			boolean encontrado = false;

			// Bloque try-with-resources para cerrar el Scanner automáticamente
			try (Scanner s = new Scanner(f)) {
				// Recorremos el fichero línea a línea mientras no lo encontremos
				while (s.hasNextLine() && !encontrado) {
					String linea = s.nextLine();
					
					// Verificamos el formato de la línea con el separador '='
					if (linea.contains("=")) {
						// Extraemos la palabra original (parte izquierda)
						String p1 = linea.substring(0, linea.indexOf('=')).trim();
						
						// Comparamos la palabra del fichero con la del usuario
						if (p1.equalsIgnoreCase(palabraBuscada)) {
							// Extraemos la traducción (parte derecha)
							String traduccion = linea.substring(linea.indexOf('=') + 1).trim();
							campoTraduccion.setText(traduccion);
							etiquetaEstado.setText("¡Palabra localizada!");
							etiquetaEstado.setForeground(new Color(0, 120, 0));
							encontrado = true;
						}
					}
				}

				// SI NO SE ENCUENTRA: Mostramos ventana emergente de error
				if (!encontrado) {
					campoTraduccion.setText("");
					etiquetaEstado.setText("Palabra no encontrada.");
					etiquetaEstado.setForeground(Color.RED);
					// Diálogo emergente para informar del fallo
					JOptionPane.showMessageDialog(this, 
						"La palabra '" + palabraBuscada + "' no existe en el archivo dictionary.txt.", 
						"Búsqueda sin éxito", 
						JOptionPane.WARNING_MESSAGE);
				}

			} catch (FileNotFoundException ex) {
				// Aviso en caso de que la ruta del archivo sea incorrecta
				JOptionPane.showMessageDialog(this, "Error: No se encuentra el archivo en la ruta especificada.", "Fallo de Sistema", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Método principal para arrancar la ventana
	public static void main(String[] args) {
		new DiccionarioVentana();
	}
}