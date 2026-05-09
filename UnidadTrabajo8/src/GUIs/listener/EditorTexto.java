package GUIs.listener;

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

	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem nuevo, abrir, guardar, salir;
	private JTextArea area;
	private JScrollPane scpanel;
	
	public EditorTexto () {
		// Creamos el JMenubar y lo asociamos a Frame
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu = new JMenu("Archivo");
		menubar.add(menu);
		
		nuevo = new JMenuItem("Nuevo");
		nuevo.addActionListener(this); // IMPORTANTE: Registrar listener
		menu.add(nuevo);
		
		abrir = new JMenuItem("Abrir");
		abrir.addActionListener(this); // IMPORTANTE: Registrar listener
		menu.add(abrir);
		
		guardar = new JMenuItem("Guardar");
		guardar.addActionListener(this); // IMPORTANTE: Registrar listener
		menu.add(guardar);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this); // IMPORTANTE: Registrar listener
		menu.add(salir);
		
		// Creamos el area de texto
		area = new JTextArea();
		area.setLineWrap(true);		
		scpanel = new JScrollPane(area);	
			
		// Damos formato y añadimos el panel a la ventana
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
		JFileChooser selector = new JFileChooser();
		int opcion = selector.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION) {
			File archivo = selector.getSelectedFile();
			
			// Usamos try-with-resources para leer el archivo
			try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
				area.setText(""); // Limpiamos el área antes de cargar
				String linea;
				while ((linea = br.readLine()) != null) {
					area.append(linea + "\n");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error al abrir el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void guardar() {
		// Abre el selector en la carpeta del proyecto
		JFileChooser f = new JFileChooser(".");
		int seleccion = f.showSaveDialog(this);
		
		// Si el usuario pulsa en "Guardar"
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File archivo = f.getSelectedFile();
			
			// Usamos try-with-resources para el PrintWriter
			try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
				// Escribimos el contenido del JTextArea en el archivo
				pw.print(area.getText());
				
				JOptionPane.showMessageDialog(this, "Archivo guardado con éxito", "Guardar", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Se ha producido un error en el archivo especificado", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		EditorTexto e = new EditorTexto();
		e.setTitle("Editor de textos");
		e.setLocationRelativeTo(null);
		e.setSize(500, 300);
		e.setDefaultCloseOperation(EXIT_ON_CLOSE);
		e.setVisible(true);
	}
}