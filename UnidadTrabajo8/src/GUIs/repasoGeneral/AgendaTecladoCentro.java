package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AgendaTecladoCentro extends JFrame implements ActionListener {

	// declaracion de los componentes de la interfaz de la agenda
	private JPanel panelDatos, panelLista, panelTeclado, contenedorTeclado;
	private JTextField campoNombre, campoTelefono;
	private JTextArea areaContactos;
	private JButton botonAñadir, botonLimpiar;

	public AgendaTecladoCentro() {
		// utilizamos borderlayout para organizar las zonas de arriba a abajo
		setLayout(new BorderLayout(10, 10));
		// margen de separacion interna para que los elementos no toquen el borde
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// --- bloque superior (north): entrada de datos ---
		panelDatos = new JPanel(new GridLayout(0, 1, 0, 5));
		campoNombre = new JTextField();
		campoTelefono = new JTextField();

		// añadimos etiquetas y cajas de texto una debajo de otra
		panelDatos.add(new JLabel("nombre del contacto:"));
		panelDatos.add(campoNombre);
		panelDatos.add(new JLabel("teléfono / móvil:"));
		panelDatos.add(campoTelefono);
		
		// boton añadir en un panel pequeño para que no se estire a lo ancho
		botonAñadir = new JButton("añadir a la agenda");
		JPanel pBotonA = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBotonA.add(botonAñadir);
		panelDatos.add(pBotonA);

		// colocamos el panel de datos en la parte superior (norte)
		add(panelDatos, BorderLayout.NORTH);

		// --- bloque central (center): area de contactos ---
		panelLista = new JPanel(new BorderLayout(0, 5));
		areaContactos = new JTextArea();
		// bloqueamos el area para que no se pueda escribir a mano
		areaContactos.setEditable(false);
		// color gris claro para el fondo del area de resultados
		areaContactos.setBackground(new Color(245, 245, 245));
		// barra de desplazamiento por si se llena la lista
		JScrollPane scroll = new JScrollPane(areaContactos);
		
		// añadimos etiqueta y area de texto al panel central
		panelLista.add(new JLabel("contactos guardados en el sistema:"), BorderLayout.NORTH);
		panelLista.add(scroll, BorderLayout.CENTER);
		
		// boton limpiar en la parte de abajo del area de lista
		botonLimpiar = new JButton("limpiar listado");
		JPanel pBotonL = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pBotonL.add(botonLimpiar);
		panelLista.add(pBotonL, BorderLayout.SOUTH);

		// colocamos la lista en el centro para que ocupe el espacio disponible
		add(panelLista, BorderLayout.CENTER);

		// --- bloque inferior (south): teclado virtual ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para separar el teclado del area de texto
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		// rejilla de 3 por 9 para las letras del abecedario
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		// tamaño fijo para que el teclado mantenga su forma equilibrada
		panelTeclado.setPreferredSize(new Dimension(600, 160)); 
		
		// cadena con todas las letras para crear los botones
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			// fuente en negrita para mejorar la visibilidad
			btn.setFont(new Font("Arial", Font.BOLD, 13));
			// quitamos el foco para mejorar el aspecto visual
			btn.setFocusable(false);
			// registramos cada boton en el escuchador de eventos
			btn.addActionListener(this);
			// añadimos el boton a la rejilla
			panelTeclado.add(btn);
		}
		
		// añadimos el teclado a su panel centralizador
		contenedorTeclado.add(panelTeclado);
		// situamos el teclado en la base de la ventana (sur)
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos los eventos para los botones principales
		botonAñadir.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// configuracion final de la ventana
		setTitle("AgendaTecladoCentro");
		// ventana estrecha (650) y mas alta (750) para el orden vertical
		setSize(650, 750); 
		// limite minimo de tamaño para que la interfaz sea usable
		setMinimumSize(new Dimension(600, 700));
		// centramos la ventana en el escritorio del usuario
		setLocationRelativeTo(null);
		// el programa se detiene al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// hacemos visible la aplicacion completa
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// capturamos el origen del evento de boton
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();

			// si pulsamos una tecla individual del abecedario virtual
			if (textoBoton.length() == 1 && e.getSource() != botonAñadir && e.getSource() != botonLimpiar) {
				// escribimos la letra en la caja del nombre
				campoNombre.setText(campoNombre.getText() + textoBoton);
			}
		}

		// logica para añadir un nuevo registro a la agenda
		if (e.getSource() == botonAñadir) {
			String n = campoNombre.getText();
			String t = campoTelefono.getText();
			
			// validamos que el usuario no haya dejado campos vacios
			if (n.isEmpty() || t.isEmpty()) {
				JOptionPane.showMessageDialog(this, "debes introducir nombre y teléfono");
			} else {
				// añadimos la linea de texto al area acumulativa
				areaContactos.append("contacto: " + n + " -> móvil: " + t + "\n");
				// limpiamos las cajas de entrada para el siguiente
				campoNombre.setText("");
				campoTelefono.setText("");
			}
		}

		// logica para vaciar el listado de contactos
		if (e.getSource() == botonLimpiar) {
			// borramos el area de texto y los campos de entrada
			areaContactos.setText("");
			campoNombre.setText("");
			campoTelefono.setText("");
		}
	}

	// punto de entrada para arrancar la aplicacion
	public static void main(String[] args) {
		new AgendaTecladoCentro();
	}
}