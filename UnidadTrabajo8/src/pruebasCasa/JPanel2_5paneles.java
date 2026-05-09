package pruebasCasa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JPanel2_5paneles extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel izquierdo, derecho, iNorte, iSur, dNorte, dCentro, dSur;
	private JLabel comentarios;
	private JTextField tnombre, tapellido1, tapellido2, tedad;
	private JTextArea area;
	private JScrollPane scrollArea;
	private JButton enviar, borrar, salir;
	
	public JPanel2_5paneles() {
		
		// 1. Configuración de la ventana y margen general
		((JPanel)getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));
		setLayout(new GridLayout(1, 2, 15, 15));
		
		// --- PANEL IZQUIERDO (Datos) ---
		izquierdo = new JPanel(new BorderLayout(5, 10));
		
		iNorte = new JPanel(new GridLayout(8, 1, 2, 2));
		iNorte.setBorder(new TitledBorder("Datos Personales"));
		
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
		
		iSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		enviar = new JButton("ENVIAR");
		iSur.add(enviar);
		izquierdo.add(iSur, BorderLayout.SOUTH);

		// --- PANEL DERECHO (Comentarios y acciones) ---
		derecho = new JPanel(new BorderLayout(5, 10));
		
		dNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		comentarios = new JLabel("Comentarios:");
		dNorte.add(comentarios);
		derecho.add(dNorte, BorderLayout.NORTH);
		
		area = new JTextArea();
		area.setLineWrap(true);
		area.setWrapStyleWord(true); 
		scrollArea = new JScrollPane(area);
		derecho.add(scrollArea, BorderLayout.CENTER); 

		JPanel panelInferiorDerecho = new JPanel(new GridLayout(2, 1, 5, 5));
		
		dCentro = new JPanel(new FlowLayout(FlowLayout.CENTER));
		borrar = new JButton("BORRAR");
		dCentro.add(borrar);
		
		dSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
		salir = new JButton("SALIR");
		dSur.add(salir);
		
		panelInferiorDerecho.add(dCentro);
		panelInferiorDerecho.add(dSur);
		
		derecho.add(panelInferiorDerecho, BorderLayout.SOUTH);
		
		add(izquierdo);
		add(derecho);
		
		// Listeners
		borrar.addActionListener(this);
		enviar.addActionListener(this);
		salir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == borrar) {
			JOptionPane.showMessageDialog(this, "Datos eliminados", "BORRAR", JOptionPane.WARNING_MESSAGE);
			tnombre.setText("");
			tapellido1.setText("");
			tapellido2.setText("");
			tedad.setText("");
			area.setText("");
			
		} else if (e.getSource() == salir) {
			System.exit(0);
			
		} else if (e.getSource() == enviar) {
			if (tnombre.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			PrintWriter escritor = null;
			try {
				escritor = new PrintWriter("registro_" + tnombre.getText() + ".txt");
				
				escritor.println("--- REGISTRO USUARIO ---");
				escritor.println("Nombre: " + tnombre.getText());
				// IMPORTANTE: Añadido .getText() a los campos de apellido
				escritor.println("Apellidos: " + tapellido1.getText() + " " + tapellido2.getText());
				escritor.println("Edad: " + tedad.getText());
				escritor.println("-------------------------");
				escritor.println("Comentarios: ");
				escritor.println(area.getText());
				
				escritor.flush(); // Asegura que todo se escriba al disco
				JOptionPane.showMessageDialog(this, "Archivo guardado con éxito.", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Error: " + e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			} finally {
				// El cierre debe estar aquí, dentro del bloque del botón enviar
				if (escritor != null) {
					escritor.close();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		JPanel2_5paneles p = new JPanel2_5paneles();
		p.setTitle("REGISTRO DE USUARIOS");
		p.setSize(750, 500);
		p.setLocationRelativeTo(null);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setVisible(true);
	}
}