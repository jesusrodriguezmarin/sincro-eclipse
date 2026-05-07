package pruebasCasa;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JPanel2_5paneles extends JFrame {

	private JPanel izquierdo, derecho, iNorte, iSur, dNorte, dCentro, dSur;
	private JLabel nombre, apellido1, apellido2, edad, comentarios;
	private JTextField tnombre, tapellido1, tapellido2, tedad;
	private JTextArea area;
	private JButton enviar, borrar, entrar, salir;
	
	public JPanel2_5paneles() {
		
		// Un margen general para que los componentes no toquen los bordes de la ventana
		((JPanel)getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(1, 2, 10, 10));
		
		// --- PANEL IZQUIERDO ---
		izquierdo = new JPanel(new BorderLayout(5, 5));
		
		// iNorte: Cambiamos a (8, 1) para asegurar una sola columna
		iNorte = new JPanel(new GridLayout(8, 1, 5, 5));
		iNorte.setBorder(new TitledBorder("Datos Personales")); // Queda muy profesional
		
		iNorte.add(new JLabel("Nombre:"));
		tnombre = new JTextField();
		iNorte.add(tnombre);
		
		iNorte.add(new JLabel("Primer apellido:"));
		tapellido1 = new JTextField();
		iNorte.add(tapellido1);
		
		iNorte.add(new JLabel("Segundo apellido:"));
		tapellido2 = new JTextField();
		iNorte.add(tapellido2);
		
		iNorte.add(new JLabel("Edad:"));
		tedad = new JTextField();
		iNorte.add(tedad);
		
		izquierdo.add(iNorte, BorderLayout.CENTER);
		
		// iSur: Panel para el botón enviar
		iSur = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Botón a la derecha
		enviar = new JButton("ENVIAR DATOS");
		iSur.add(enviar);
		izquierdo.add(iSur, BorderLayout.SOUTH);

		// --- PANEL DERECHO ---
		derecho = new JPanel(new BorderLayout(5, 10));
		
		// dNorte: Para el área de comentarios
		dNorte = new JPanel(new BorderLayout(5, 5));
		dNorte.add(new JLabel("Comentarios:"), BorderLayout.NORTH);
		
		area = new JTextArea();
		area.setLineWrap(true); // Para que el texto salte de línea solo
		// IMPORTANTE: El JTextArea siempre debe ir dentro de un JScrollPane
		JScrollPane scrollArea = new JScrollPane(area);
		dNorte.add(scrollArea, BorderLayout.CENTER);
		
		derecho.add(dNorte, BorderLayout.CENTER);

		// Panel para botones del lado derecho (Centro y Sur)
		JPanel panelBotonesDerecha = new JPanel(new GridLayout(2, 1, 5, 5));
		
		borrar = new JButton("BORRAR FORMULARIO");
		panelBotonesDerecha.add(borrar);
		
		salir = new JButton("SALIR DEL PROGRAMA");
		panelBotonesDerecha.add(salir);
		
		derecho.add(panelBotonesDerecha, BorderLayout.SOUTH);
		
		// Añadimos los troncales al Frame
		add(izquierdo);
		add(derecho);
	}

	public static void main(String[] args) {
		JPanel2_5paneles p = new JPanel2_5paneles();
		p.setTitle("REGISTRO DE USUARIOS");
		p.setSize(800, 500); // Tamaño algo más ajustado
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setVisible(true);
	}
}