package GUIs.posibles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AgendaSimpleIzquierda extends JFrame implements ActionListener {

	// Declaración de los componentes esenciales
	private JPanel panelDatos, panelLista, contenedorSuperior;
	private JTextField campoNombre, campoTelefono;
	private JTextArea areaContactos;
	private JButton botonAñadir, botonLimpiar, botonSalir, botonBuscar; // Añadimos botonBuscar

	public AgendaSimpleIzquierda() {
		// Estructura principal
		setLayout(new BorderLayout(10, 10));
		((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Contenedor principal: 1 fila y 2 columnas simétricas para dividir la pantalla
		contenedorSuperior = new JPanel(new GridLayout(1, 2, 20, 0));

		// --- COLUMNA IZQUIERDA: Entrada de datos ---
		panelDatos = new JPanel(new GridLayout(0, 1, 0, 5));
		campoNombre = new JTextField();
		campoTelefono = new JTextField();

		panelDatos.add(new JLabel("Nombre del contacto:"));
		panelDatos.add(campoNombre);
		panelDatos.add(new JLabel("Teléfono:"));
		panelDatos.add(campoTelefono);
		
		// Inicializamos los botones de acción del formulario
		botonAñadir = new JButton("Añadir");
		botonBuscar = new JButton("Buscar..."); // Nuevo botón buscar
		
		// Panel horizontal para colocar ambos botones uno al lado del otro sin que se deformen
		JPanel pBotonesIzquierda = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		pBotonesIzquierda.add(botonAñadir);
		pBotonesIzquierda.add(botonBuscar);
		panelDatos.add(pBotonesIzquierda);

		// --- COLUMNA DERECHA: Visualización de lista ---
		panelLista = new JPanel(new BorderLayout(0, 5));
		areaContactos = new JTextArea();
		areaContactos.setEditable(false);
		areaContactos.setBackground(new Color(245, 245, 245));
		JScrollPane scroll = new JScrollPane(areaContactos);
		
		panelLista.add(new JLabel("Contactos guardados:"), BorderLayout.NORTH);
		panelLista.add(scroll, BorderLayout.CENTER);
		
		// Botón limpiar debajo del listado
		botonLimpiar = new JButton("Limpiar todo");
		JPanel pBotonL = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBotonL.add(botonLimpiar);
		panelLista.add(pBotonL, BorderLayout.SOUTH);

		// Juntamos las dos columnas en el contenedor y lo tiramos al CENTRO
		contenedorSuperior.add(panelDatos);
		contenedorSuperior.add(panelLista);
		add(contenedorSuperior, BorderLayout.CENTER);

		// --- BOTÓN DE ACCIÓN ABAJO: Botón de Salir en el SUR ---
		botonSalir = new JButton("Salir de la aplicación");
		JPanel pBotonS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pBotonS.add(botonSalir);
		add(pBotonS, BorderLayout.SOUTH);

		// Activamos los escuchadores para todos los botones
		botonAñadir.addActionListener(this);
		botonBuscar.addActionListener(this); // Escuchador de buscar
		botonLimpiar.addActionListener(this);
		botonSalir.addActionListener(this);

		// Configuración básica de la ventana
		setTitle("AgendaSimpleIzquierda");
		setSize(650, 350); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ACCIÓN: Añadir registro a la lista
		if (e.getSource() == botonAñadir) {
			String n = campoNombre.getText().trim();
			String t = campoTelefono.getText().trim();
			
			if (n.isEmpty() || t.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debes rellenar ambos campos.");
			} else {
				areaContactos.append("Nombre: " + n + " | Tlf: " + t + "\n");
				campoNombre.setText("");
				campoTelefono.setText("");
				campoNombre.requestFocus();
			}
		}

		// ACCIÓN: Buscar un contacto en el JTextArea
		if (e.getSource() == botonBuscar) {
			String nombreBuscar = JOptionPane.showInputDialog(this, "Introduce el nombre a buscar:", "Buscar Contacto", JOptionPane.QUESTION_MESSAGE);
			
			// Validamos que el usuario no haya cancelado o dejado el diálogo vacío
			if (nombreBuscar != null && !nombreBuscar.trim().isEmpty()) {
				nombreBuscar = nombreBuscar.trim().toLowerCase();
				
				// Obtenemos todo el texto del JTextArea y lo dividimos línea por línea
				String textoCompleto = areaContactos.getText();
				String[] lineas = textoCompleto.split("\n");
				
				boolean encontrado = false;
				String resultados = "";
				
				// Recorremos las líneas buscando coincidencias
				for (String linea : lineas) {
					if (linea.toLowerCase().contains("nombre: " + nombreBuscar + " ")) {
						resultados += linea + "\n";
						encontrado = true;
					}
				}
				
				// Mostramos los resultados obtenidos
				if (encontrado) {
					JOptionPane.showMessageDialog(this, "Contactos encontrados:\n\n" + resultados, "Búsqueda Exitosa", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "No se encontró ningún contacto con ese nombre.", "Sin resultados", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		// ACCIÓN: Resetear todo el contenido
		if (e.getSource() == botonLimpiar) {
			areaContactos.setText("");
			campoNombre.setText("");
			campoTelefono.setText("");
		}

		// ACCIÓN: Cerrar la aplicación por completo
		if (e.getSource() == botonSalir) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new AgendaSimpleIzquierda();
	}
}