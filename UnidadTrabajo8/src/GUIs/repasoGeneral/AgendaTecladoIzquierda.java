package GUIs.repasoGeneral;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AgendaTecladoIzquierda extends JFrame implements ActionListener {

	// declaracion de los elementos que componen la interfaz de la agenda
	private JPanel panelDatos, panelLista, panelTeclado, contenedorSuperior, contenedorTeclado;
	private JTextField campoNombre, campoTelefono;
	private JTextArea areaContactos;
	private JButton botonAñadir, botonLimpiar;

	public AgendaTecladoIzquierda() {
		// establecemos el layout principal para organizar las zonas de la ventana
		setLayout(new BorderLayout(10, 10));
		// añadimos un margen interno para que los bordes respiren
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// contenedor para la parte de arriba con dos columnas simetricas
		contenedorSuperior = new JPanel(new GridLayout(1, 2, 20, 0));

		// --- panel izquierdo: entrada de informacion ---
		panelDatos = new JPanel(new GridLayout(0, 1, 0, 5));
		campoNombre = new JTextField();
		campoTelefono = new JTextField();

		// añadimos etiquetas y cajas de texto para los datos del contacto
		panelDatos.add(new JLabel("nombre del contacto:"));
		panelDatos.add(campoNombre);
		panelDatos.add(new JLabel("teléfono:"));
		panelDatos.add(campoTelefono);
		
		// boton para agregar los datos a la lista de la derecha
		botonAñadir = new JButton("añadir a la agenda");
		// usamos flowlayout para que el boton no se estire a lo ancho
		JPanel pBotonA = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBotonA.add(botonAñadir);
		panelDatos.add(pBotonA);

		// --- panel derecho: visualizacion de los contactos guardados ---
		panelLista = new JPanel(new BorderLayout());
		areaContactos = new JTextArea();
		// el area de texto no debe permitir escritura directa por teclado fisico
		areaContactos.setEditable(false);
		// color de fondo suave para diferenciar la zona de lectura
		areaContactos.setBackground(new Color(245, 245, 245));
		// añadimos barras de desplazamiento por si hay muchos contactos
		JScrollPane scroll = new JScrollPane(areaContactos);
		
		// añadimos etiqueta y area de texto con scroll al panel derecho
		panelLista.add(new JLabel("contactos guardados:"), BorderLayout.NORTH);
		panelLista.add(scroll, BorderLayout.CENTER);
		
		// boton para vaciar el listado de contactos
		botonLimpiar = new JButton("limpiar todo");
		// panel para controlar el tamaño del boton limpiar
		JPanel pBotonL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBotonL.add(botonLimpiar);
		panelLista.add(pBotonL, BorderLayout.SOUTH);

		// juntamos los dos paneles principales en la zona norte
		contenedorSuperior.add(panelDatos);
		contenedorSuperior.add(panelLista);
		add(contenedorSuperior, BorderLayout.NORTH);

		// --- panel inferior: teclado virtual para escribir nombres ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para separar el teclado de los campos de texto
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// malla de 3 filas y 9 columnas para las 27 letras del abecedario
		panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
		// tamaño fijo para que el teclado se vea equilibrado y no deforme
		panelTeclado.setPreferredSize(new Dimension(600, 180)); 
		
		// cadena de texto para generar los botones mediante un bucle for
		String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		for (int i = 0; i < abc.length(); i++) {
			JButton btn = new JButton("" + abc.charAt(i));
			// fuente en negrita para facilitar la lectura de las teclas
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			// quitamos el foco para mejorar la estetica al pulsar
			btn.setFocusable(false);
			// asignamos el escuchador a cada tecla del abecedario
			btn.addActionListener(this);
			// insertamos el boton en el panel del teclado
			panelTeclado.add(btn);
		}
		
		// metemos la malla de botones en el panel centralizador
		contenedorTeclado.add(panelTeclado);
		// situamos el teclado en la base de la ventana
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos los eventos para los botones de añadir y limpiar
		botonAñadir.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// configuracion de las propiedades de la ventana
		setTitle("AgendaTeclado");
		// definimos un tamaño de ventana estrecho y funcional
		setSize(700, 600); 
		// tamaño minimo para evitar que se descoloquen los componentes
		setMinimumSize(new Dimension(650, 550));
		// centramos la ventana respecto a la pantalla del usuario
		setLocationRelativeTo(null);
		// finalizamos la ejecucion al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// hacemos visible la aplicacion completa
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// comprobamos si el evento viene de un boton de la interfaz
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();

			// si el boton es una letra individual del teclado virtual
			if (textoBoton.length() == 1 && e.getSource() != botonAñadir && e.getSource() != botonLimpiar) {
				// añadimos la letra seleccionada al campo de nombre
				campoNombre.setText(campoNombre.getText() + textoBoton);
			}
		}

		// logica para procesar el boton de añadir contacto
		if (e.getSource() == botonAñadir) {
			String n = campoNombre.getText();
			String t = campoTelefono.getText();
			
			// validamos que ambos campos tengan contenido escrito
			if (n.isEmpty() || t.isEmpty()) {
				JOptionPane.showMessageDialog(this, "debes rellenar ambos campos");
			} else {
				// concatenamos el nuevo contacto en el area de texto acumulativa
				areaContactos.append("nombre: " + n + " | tlf: " + t + "\n");
				// limpiamos las cajas de entrada para el siguiente registro
				campoNombre.setText("");
				campoTelefono.setText("");
			}
		}

		// logica para resetear el contenido de la agenda
		if (e.getSource() == botonLimpiar) {
			// vaciamos el area de texto de contactos y las cajas de entrada
			areaContactos.setText("");
			campoNombre.setText("");
			campoTelefono.setText("");
		}
	}

	// punto de entrada principal para arrancar la aplicacion
	public static void main(String[] args) {
		new AgendaTecladoIzquierda();
	}
}