package pruebasCasa;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanel2_5panelesWindowBuilder extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem cerrar, info;
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public JPanel2_5panelesWindowBuilder() {
		// Configuración de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450); // Aumentado el ancho para que quepa el teclado
		setLocationRelativeTo(null);

		// BARRA DE MENÚ
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Nosotros");
		menuBar.add(menu1);

		info = new JMenuItem("info");
		info.addActionListener(this);
		menu1.add(info);

		menu1.add(new JMenuItem("contacto"));

		JMenu menu2 = new JMenu("Loggin");
		menuBar.add(menu2);

		JMenu submenu1 = new JMenu("entrar");
		menu2.add(submenu1);
		submenu1.add(new JMenuItem("socio"));
		submenu1.add(new JMenuItem("invitado"));

		JMenu salirMenu = new JMenu("salir");
		menu2.add(salirMenu);

		cerrar = new JMenuItem("cerrar");
		cerrar.addActionListener(this);
		salirMenu.add(cerrar);

		// PANEL PRINCIPAL
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// PANEL 1: Nombre y Apellidos
		JPanel p1 = new JPanel();
		p1.setBounds(17, 29, 102, 143);
		p1.setLayout(null);
		contentPane.add(p1);

		JLabel nb = new JLabel("Nombre: ");
		nb.setBounds(6, 6, 80, 16);
		p1.add(nb);

		JLabel ap = new JLabel("Apellidos: ");
		ap.setBounds(6, 73, 80, 16);
		p1.add(ap);
		
		textField = new JTextField();
		textField.setBounds(0, 34, 96, 26);
		p1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 101, 96, 26);
		p1.add(textField_1);

		// PANEL 2: Edad y Sexo
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(131, 29, 88, 143);
		contentPane.add(p2);

		JLabel edad = new JLabel("Edad: ");
		edad.setBounds(6, 6, 61, 16);
		p2.add(edad);

		JLabel x = new JLabel("Sexo: ");
		x.setBounds(6, 75, 61, 16);
		p2.add(x);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(6, 34, 43, 26);
		p2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(6, 103, 61, 26);
		p2.add(textField_3);

		// PANEL 3: Comentarios
		JPanel p3 = new JPanel();
		p3.setBounds(17, 204, 202, 125);
		p3.setLayout(null);
		contentPane.add(p3);

		JLabel lblComentarios = new JLabel("Comentarios: ");
		lblComentarios.setBounds(6, 6, 110, 16);
		p3.add(lblComentarios);

		textArea = new JTextArea();
		textArea.setBounds(6, 36, 190, 80);
		p3.add(textArea);

		// PANEL 4: Contenedor del Teclado (Agrandado)
		JPanel p4 = new JPanel();
		p4.setBounds(239, 29, 530, 336); // Espacio suficiente para p5
		p4.setLayout(null);
		contentPane.add(p4);

		// PANEL 5: EL TECLADO (Aquí es donde se dibujan los botones)
		JPanel p5 = new JPanel();
		p5.setBounds(6, 192, 520, 138); 
		p4.add(p5);
		
		// LLAMADA AL MÉTODO TECLADO pasándole el panel p5
		teclado(p5);

	}

	/**
	 * Procedimiento que genera el teclado dentro de un panel específico
	 */
	public void teclado(JPanel contenedor) {
		// Aplicamos GridLayout al panel contenedor
		contenedor.setLayout(new GridLayout(4, 7, 2, 2)); // 4 filas para que queden mejor

		String abc = "QWERTYUIOPASDFGHJKLÑ ZXCVBNM";
		JButton boton;

		for (int i = 0; i < abc.length(); i++) {
			if (abc.charAt(i) == ' ') {
				getContentPane().add(new JLabel());
			} else {
				boton = new JButton("" + abc.charAt(i));
				boton.setMargin(new Insets(1, 1, 1, 1)); // Quitar márgenes internos para que no se corten las letras
				boton.addActionListener(this);
				contenedor.add(boton);
			}
			
		}
		
		contenedor.revalidate();
		contenedor.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cerrar) {
			System.exit(0);
		} else if (e.getSource() == info) {
			JOptionPane.showMessageDialog(null, "Loggeate para jugar", "INFO", JOptionPane.WARNING_MESSAGE);
		} else if (e.getSource() instanceof JButton) {
			// Lógica para que al pulsar el teclado se escriba en el JTextArea
			String letra = ((JButton) e.getSource()).getText();
			textArea.append(letra);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPanel2_5panelesWindowBuilder frame = new JPanel2_5panelesWindowBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
