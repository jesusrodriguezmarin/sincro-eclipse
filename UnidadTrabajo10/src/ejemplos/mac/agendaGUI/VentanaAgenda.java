package ejemplos.mac.agendaGUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class VentanaAgenda extends JFrame {

	// Componentes de la interfaz
	private JTextField txtNombre, txtTelefono;
	private JButton btnNuevo, btnMostrar, btnEliminar, btnLimpiar; // Añadido btnLimpiar
	private JButton btnSiguiente, btnAnterior;
	
	// Componentes para el Scroll Pane con la lista de contactos
	private JList<String> listaVisual;
	private DefaultListModel<String> modeloLista;

	// --- LÓGICA DE LA AGENDA ---
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/contacto.dat";
	private ArrayList<Contacto> agenda;
	private int posicionActual = -1; 

	public VentanaAgenda() {
		// 1. Inicializar la lista y cargar los datos guardados en el disco duro
		agenda = new ArrayList<>();
		leerLista();

		// 2. Configuración básica de la ventana principal
		setTitle("Agenda Telefónica");
		setSize(480, 400); // Ensanchamos un poco a 480 para que los 4 botones quepan perfectos en línea
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setLayout(new BorderLayout(10, 10)); 

		// --- ZONA SUPERIOR (Campos de texto) ---
		JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 20, 0));
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

		JPanel panelIzquierda = new JPanel(new BorderLayout(0, 5));
		JLabel lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField();
		panelIzquierda.add(lblNombre, BorderLayout.NORTH);
		panelIzquierda.add(txtNombre, BorderLayout.CENTER);

		JPanel panelDerecha = new JPanel(new BorderLayout(0, 5));
		JLabel lblTelefono = new JLabel("Teléfono:");
		txtTelefono = new JTextField();
		panelDerecha.add(lblTelefono, BorderLayout.NORTH);
		panelDerecha.add(txtTelefono, BorderLayout.CENTER);

		panelSuperior.add(panelIzquierda);
		panelSuperior.add(panelDerecha);

		// --- ZONA CENTRAL (Botones de acción + SCROLL PANE) ---
		JPanel contenedorCentro = new JPanel(new BorderLayout(5, 5));
		
		JPanel panelBotonesAccion = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		btnNuevo = new JButton("Nuevo");
		btnMostrar = new JButton("Mostrar");
		btnEliminar = new JButton("Eliminar");
		btnLimpiar = new JButton("Limpiar"); // Instanciamos el botón limpiar

		panelBotonesAccion.add(btnNuevo);
		panelBotonesAccion.add(btnMostrar);
		panelBotonesAccion.add(btnEliminar);
		panelBotonesAccion.add(btnLimpiar); // Lo añadimos a la derecha de eliminar
		
		// CONFIGURACIÓN DEL SCROLL PANE CON LA LISTA
		modeloLista = new DefaultListModel<>();
		listaVisual = new JList<>(modeloLista);
		listaVisual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		JScrollPane scrollPane = new JScrollPane(listaVisual);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Contactos"));

		contenedorCentro.add(panelBotonesAccion, BorderLayout.NORTH);
		contenedorCentro.add(scrollPane, BorderLayout.CENTER);

		// --- ZONA INFERIOR (Botones de navegación) ---
		JPanel panelInferior = new JPanel(new BorderLayout());
		panelInferior.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		
		btnSiguiente = new JButton("Siguiente contacto");
		btnAnterior = new JButton("Anterior contacto");

		panelInferior.add(btnAnterior, BorderLayout.WEST); 
		panelInferior.add(btnSiguiente, BorderLayout.EAST); 

		// Agregar paneles principales a la ventana
		add(panelSuperior, BorderLayout.NORTH);
		add(contenedorCentro, BorderLayout.CENTER); 
		add(panelInferior, BorderLayout.SOUTH);

		// Rellenar el ScrollPane con los contactos cargados
		actualizarScroll();

		// Mostrar el primer contacto si la lista tiene datos acumulados al arrancar
		if (!agenda.isEmpty()) {
			posicionActual = 0;
			mostrarContactoActual();
		}

		// ==========================================
		//          ACCIONES DE LOS BOTONES
		// ==========================================

		// DETECTOR DE CLIC EN EL SCROLL PANEL
		listaVisual.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int seleccionado = listaVisual.getSelectedIndex();
					if (seleccionado != -1 && seleccionado != posicionActual) {
						posicionActual = seleccionado;
						mostrarContactoActual();
					}
				}
			}
		});

		// BOTÓN NUEVO
		btnNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText().trim();
				String telefonoRaw = txtTelefono.getText().trim();

				if (nombre.isEmpty() || telefonoRaw.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, rellena ambos campos.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (buscarContacto(nombre) != -1) {
					JOptionPane.showMessageDialog(null, "El contacto '" + nombre + "' ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						int telefono = Integer.parseInt(telefonoRaw);
						agenda.add(new Contacto(nombre, telefono));
						guardarLista();
						
						actualizarScroll(); 
						posicionActual = agenda.size() - 1; 
						mostrarContactoActual();
						
						JOptionPane.showMessageDialog(null, "Contacto añadido con éxito.");
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "El teléfono debe contener solo números enteros.", "Error de formato", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// BOTÓN MOSTRAR
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreABuscar = txtNombre.getText().trim();
				if (nombreABuscar.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Escribe un nombre en el cuadro para buscarlo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				int indiceEncontrado = buscarContacto(nombreABuscar);
				if (indiceEncontrado == -1) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado a '" + nombreABuscar + "'.", "No encontrado", JOptionPane.ERROR_MESSAGE);
				} else {
					posicionActual = indiceEncontrado;
					mostrarContactoActual();
				}
			}
		});

		// BOTÓN ELIMINAR
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (posicionActual == -1 || agenda.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay ningún contacto seleccionado para eliminar.");
					return;
				}

				agenda.remove(posicionActual);
				guardarLista();
				actualizarScroll(); 

				if (agenda.isEmpty()) {
					posicionActual = -1;
					txtNombre.setText("");
					txtTelefono.setText("");
				} else {
					if (posicionActual >= agenda.size()) {
						posicionActual = agenda.size() - 1; 
					}
					mostrarContactoActual();
				}
				JOptionPane.showMessageDialog(null, "Contacto eliminado.");
			}
		});

		// BOTÓN LIMPIAR ACCIÓN (Vacía los inputs y deselecciona la lista)
		btnLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtTelefono.setText("");
				listaVisual.clearSelection(); // Quita el color azul de selección visual
				posicionActual = -1;          // Reiniciamos el puntero de navegación
			}
		});

		// BOTÓN SIGUIENTE
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!agenda.isEmpty() && posicionActual < agenda.size() - 1) {
					posicionActual++;
					mostrarContactoActual();
				} else {
					JOptionPane.showMessageDialog(null, "Estás en el último contacto de la agenda.");
				}
			}
		});

		// BOTÓN ANTERIOR
		btnAnterior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!agenda.isEmpty() && posicionActual > 0) {
					posicionActual--;
					mostrarContactoActual();
				} else {
					JOptionPane.showMessageDialog(null, "Estás en el primer contacto de la agenda.");
				}
			}
		});
	}

	// ==========================================
	//          MÉTODOS AUXILIARES
	// ==========================================

	/**
	 * Sincroniza y rellena el Scroll Pane con los contactos del ArrayList
	 */
	private void actualizarScroll() {
		modeloLista.clear(); 
		for (Contacto c : agenda) {
			modeloLista.addElement(c.getNombre() + "      (Tel: " + c.getTelefono() + ")");
		}
	}

	/**
	 * Pinta en los JTextField el contacto de la posición actual y selecciona su fila
	 */
	private void mostrarContactoActual() {
		if (posicionActual >= 0 && posicionActual < agenda.size()) {
			Contacto c = agenda.get(posicionActual);
			txtNombre.setText(c.getNombre());
			txtTelefono.setText("" + c.getTelefono());
			
			listaVisual.setSelectedIndex(posicionActual);
			listaVisual.ensureIndexIsVisible(posicionActual); 
		}
	}

	/**
	 * Busca un contacto por nombre ignorando mayúsculas y minúsculas
	 */
	private int buscarContacto(String nombre) {
		for (int i = 0; i < agenda.size(); i++) {
			if (agenda.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Carga el archivo binario desde el disco duro (.dat)
	 */
	@SuppressWarnings("unchecked")
	private void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			agenda = (ArrayList<Contacto>) entrada.readObject();
			entrada.close();
		} catch (Exception e) {
			agenda = new ArrayList<>();
		}
	}

	/**
	 * Guarda los cambios actuales de la lista en el archivo binario
	 */
	private void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			salida.reset();
			salida.writeObject(agenda);
			salida.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error crítico al guardar el archivo en disco.");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				VentanaAgenda ventana = new VentanaAgenda();
				ventana.setVisible(true);
			}
		});
	}
}