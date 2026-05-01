package GUIs.componentes.repaso;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AhorcadoFrame extends JFrame implements ActionListener {
	
	/*
	 * Atributos de lógica y componentes
	 */
	private AhorcadoPOO juego;
	private JLabel ePalabra, eIntentos, eMensaje;
	private JTextField texto;
	private JButton botIntentar, botResolver;
	
	/**
	 * Constructor
	 */
	public AhorcadoFrame() {
		
		// Inicializamos el objeto AhorcadoPOO
		juego = new AhorcadoPOO();
		
		// Configuramos la ventana principal
		setTitle("Juego del ahorcado");
		setSize(450, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(5, 1, 10, 10));
		
		/**
		 * Componentes
		 */
		ePalabra = new JLabel(juego.getPalabraMostrar(), SwingConstants.CENTER);
		ePalabra.setFont(new Font("Monospaced", Font.BOLD, 35));
		
		eIntentos = new JLabel("Intentos: 0 / "+juego.TOTAL_INTENTOS, SwingConstants.CENTER);
		eIntentos.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JPanel panelControl = new JPanel(new FlowLayout());
		texto = new JTextField(10);
		
		botIntentar = new JButton("Letra");
		botResolver = new JButton("Resolver");
		
		panelControl.add(new JLabel("Entrada: "));
		panelControl.add(texto);
		panelControl.add(botIntentar);
		panelControl.add(botResolver);
		
		eMensaje = new JLabel("Bienvenido! Introduce una letra o intenta resolver.", SwingConstants.CENTER);
		eMensaje.setForeground(Color.DARK_GRAY);
		
		botIntentar.addActionListener(this);
		botResolver.addActionListener(this);
		
		add(ePalabra);
		add(eIntentos);
		add(panelControl);
		add(eMensaje);
		
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		

	}


}
