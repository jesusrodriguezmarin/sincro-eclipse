package GUIs.posibles;

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

		// --- panel inferior: teclado virtual numérico ---
		contenedorTeclado = new JPanel(new FlowLayout(FlowLayout.CENTER));
		// margen superior para separar el teclado de los campos de texto
		contenedorTeclado.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// CAMBIO 1: Malla de 4 filas y 3 columnas para el teclado numérico
		panelTeclado = new JPanel(new GridLayout(4, 3, 5, 5));
		// CAMBIO 2: Tamaño estilizado y compacto para que mantenga proporciones numéricas (250x180)
		panelTeclado.setPreferredSize(new Dimension(250, 180)); 
		
		// CAMBIO 3: Bucle del 1 al 9 para rellenar las tres primeras filas
		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton("" + i);
			btn.setFont(new Font("Arial", Font.BOLD, 14));
			btn.setFocusable(false);
			btn.addActionListener(this);
			panelTeclado.add(btn);
		}
		
		// Última fila: paneles vacíos en los lados para dejar el 0 centrado solo
		panelTeclado.add(new JPanel()); // Hueco izquierdo
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.BOLD, 14));
		btn0.setFocusable(false);
		btn0.addActionListener(this);
		panelTeclado.add(btn0); // Botón central
		
		panelTeclado.add(new JPanel()); // Hueco derecho
		
		// metemos la malla de botones en el panel centralizador
		contenedorTeclado.add(panelTeclado);
		// situamos el teclado en la base de la ventana
		add(contenedorTeclado, BorderLayout.SOUTH);

		// activamos los eventos para los botones de añadir y limpiar
		botonAñadir.addActionListener(this);
		botonLimpiar.addActionListener(this);

		// configuracion de las propiedades de la ventana
		setTitle("AgendaTeclado");
		setSize(700, 600); 
		setMinimumSize(new Dimension(650, 550));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// comprobamos si el evento viene de un boton de la interfaz
		if (e.getSource() instanceof JButton) {
			JButton boton = (JButton) e.getSource();
			String textoBoton = boton.getText();

			// CAMBIO 4: Filtramos para que solo capture dígitos del 0 al 9 de longitud 1
			if (textoBoton.length() == 1 && Character.isDigit(textoBoton.charAt(0))) {
				// ¡Escribimos en el campo de teléfono, que es lo lógico!
				campoTelefono.setText(campoTelefono.getText() + textoBoton);
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