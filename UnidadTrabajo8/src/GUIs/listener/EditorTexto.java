package GUIs.listener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	/**
	 * Componenetes
	 */
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem nuevo, abrir, guardar, salir;
	private JTextArea area;
	private JScrollPane scpanel;
	
	/**
	 * Constructor
	 */
	public EditorTexto () {
		
		// Creamos el JMenubar y lo asociamos a Frame
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu = new JMenu("Archivo");
		menubar.add(menu);
		
		nuevo = new JMenuItem("Nuevo");
		menu.add(nuevo);
		
		abrir = new JMenuItem("Abrir");
		menu.add(abrir);
		
		guardar = new JMenuItem("Guardar");
		menu.add(guardar);
		
		salir = new JMenuItem("Salir");
		menu.add(salir);
		
		// Creamos el area de texto
		area = new JTextArea();
		area.setLineWrap(true);		// Salto de línea al final del ancho
		scpanel = new JScrollPane(area);	// Creamos el ScrollPane y metemos el area dentro
			
		// Damos formato y añadomos el panel a la ventana
		setLayout(new GridLayout(1,0));
		add(scpanel);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Opción salir
		if (e.getSource() == salir)
			System.exit(0);
		
		// Opción nuevo
		if (e.getSource() == nuevo)
			area.setText("");
		
		// Opción abrir
		if (e.getSource() == abrir)
			abrir();
		
		// Opción guardar
		if (e.getSource() == guardar) {
			guardar();
		}
	}
	
	public void abrir() {
		
	}
	
	public void guardar() {
		// Abre la carpeta que le pasemos por parámetro
		JFileChooser f = new JFileChooser("");
		// Muestra el contenido
		f.showSaveDialog(f);
		
		// Declaramos la apertura del escritor
		FileWriter fw = null;
		// Declaramos el escritor
		PrintWriter pw = null;
		
		// Control de errores
		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error en el archivo especificado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Instanciamos
		EditorTexto e = new EditorTexto();
		e.setTitle("Editor de textos");
		e.setLocationRelativeTo(null);
		e.setSize(500, 300);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		e.setVisible(true);

	}

}
