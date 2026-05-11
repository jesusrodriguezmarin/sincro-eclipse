package GUIs.repasoGeneral;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditorTexto extends JFrame implements ActionListener {

	// Declaración de los componentes de la barra de menús
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem nuevo, abrir, guardar, salir;
	// Componentes para la edición de texto y desplazamiento
	private JTextArea area;
	private JScrollPane scpanel;
	
	// Inicio del constructor para configurar la interfaz del editor
	public EditorTexto () {
		// Inicializamos la barra de menú superior
		menubar = new JMenuBar();
		// Vinculamos la barra de menú a la estructura del JFrame
		setJMenuBar(menubar);
		
		// Creamos la pestaña principal llamada Archivo
		menu = new JMenu("Archivo");
		// Añadimos la pestaña a la barra de menú
		menubar.add(menu);
		
		// Inicializamos el ítem para limpiar el documento
		nuevo = new JMenuItem("Nuevo");
		// Registramos el escuchador para detectar clics en Nuevo
		nuevo.addActionListener(this);
		// Añadimos la opción al menú Archivo
		menu.add(nuevo);
		
		// Inicializamos el ítem para cargar archivos del disco
		abrir = new JMenuItem("Abrir");
		// Registramos el escuchador para detectar clics en Abrir
		abrir.addActionListener(this);
		// Añadimos la opción al menú Archivo
		menu.add(abrir);
		
		// Inicializamos el ítem para salvar el contenido actual
		guardar = new JMenuItem("Guardar");
		// Registramos el escuchador para detectar clics en Guardar
		guardar.addActionListener(this);
		// Añadimos la opción al menú Archivo
		menu.add(guardar);
		
		// Inicializamos el ítem para cerrar la aplicación
		salir = new JMenuItem("Salir");
		// Registramos el escuchador para detectar clics en Salir
		salir.addActionListener(this);
		// Añadimos la opción al menú Archivo
		menu.add(salir);
		
		// Inicializamos el área de edición de texto multilínea
		area = new JTextArea();
		// Activamos el ajuste de línea automático para que el texto no se salga lateralmente
		area.setLineWrap(true);		
		// Envolvemos el área de texto en un panel con barras de desplazamiento
		scpanel = new JScrollPane(area);	
			
		// Configuramos una rejilla simple para que el editor ocupe toda la ventana
		setLayout(new GridLayout(1,0));
		// Añadimos el panel de desplazamiento al contenedor principal
		add(scpanel);
	}
	
	// Método que gestiona las acciones de los ítems del menú
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si el usuario selecciona la opción de salir
		if (e.getSource() == salir)
			// Cerramos el proceso de la máquina virtual de Java
			System.exit(0);
		
		// Si el usuario selecciona la opción de nuevo
		if (e.getSource() == nuevo)
			// Vaciamos el contenido del área de texto
			area.setText("");
		
		// Si el usuario selecciona la opción de abrir
		if (e.getSource() == abrir)
			// Llamamos al método encargado de la lectura de ficheros
			abrir();
		
		// Si el usuario selecciona la opción de guardar
		if (e.getSource() == guardar) {
			// Llamamos al método encargado de la escritura de ficheros
			guardar();
		}
	}
	
	// Método para seleccionar y leer un archivo de texto
	public void abrir() {
		// Creamos el selector de archivos del sistema
		JFileChooser selector = new JFileChooser();
		// Mostramos la ventana de diálogo para abrir y capturamos la respuesta
		int opcion = selector.showOpenDialog(this);
		
		// Comprobamos si el usuario ha pulsado el botón de aceptar
		if (opcion == JFileChooser.APPROVE_OPTION) {
			// Obtenemos el archivo seleccionado por el usuario
			File archivo = selector.getSelectedFile();
			
			// Intentamos leer el archivo usando un flujo de lectura con búfer
			try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
				// Limpiamos el editor antes de volcar el nuevo contenido
				area.setText("");
				// Variable para leer el archivo línea por línea
				String linea;
				// Recorremos el fichero hasta que no queden líneas por leer
				while ((linea = br.readLine()) != null) {
					// Añadimos cada línea al editor seguida de un salto de línea
					area.append(linea + "\n");
				}
			} catch (Exception e) {
				// Mostramos mensaje en caso de error en la lectura
				JOptionPane.showMessageDialog(this, "Error al abrir el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Método para volcar el texto del editor a un archivo físico
	public void guardar() {
		// Inicializamos el selector de archivos apuntando a la carpeta actual
		JFileChooser f = new JFileChooser(".");
		// Mostramos la ventana de diálogo para guardar y capturamos la respuesta
		int seleccion = f.showSaveDialog(this);
		
		// Comprobamos si el usuario confirmó la acción de guardar
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			// Obtenemos la referencia al archivo de destino
			File archivo = f.getSelectedFile();
			
			// Intentamos escribir usando un flujo de escritura
			try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
				// Escribimos todo el bloque de texto del editor en el archivo
				pw.print(area.getText());
				
				// Confirmamos al usuario que la operación fue exitosa
				JOptionPane.showMessageDialog(this, "Archivo guardado con éxito", "Guardar", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {
				// Informamos si ocurre un error durante la creación o escritura del archivo
				JOptionPane.showMessageDialog(this, "Se ha producido un error en el archivo especificado", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Punto de entrada principal de la aplicación
	public static void main(String[] args) {
		// Instanciamos el editor de texto
		EditorTexto e = new EditorTexto();
		// Definimos el título de la ventana
		e.setTitle("Editor de textos");
		// Definimos un tamaño de ventana más grande y espacioso
		e.setSize(800, 600);
		// Centramos la ventana en el escritorio del usuario
		e.setLocationRelativeTo(null);
		// Configuramos el cierre completo al pulsar el botón X
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Hacemos que la interfaz gráfica sea visible
		e.setVisible(true);
	}
}