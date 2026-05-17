package GUIs.posibles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AgendaTop extends JFrame implements ActionListener {

    // Componentes para la gestión de datos y visualización
    private JTextField txtNombre, txtTelefono;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaContactos;
    private JButton btnAñadir, btnEliminar, btnGuardar;

    // Inicio del constructor de la ventana
    public AgendaTop() {
        // Establecemos el título que aparecerá en la barra superior
        setTitle("Mi Agenda de Contactos");
        // Definimos el tamaño inicial de la ventana
        setSize(400, 450);
        // Configuramos que el proceso finalice al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Centramos la ventana en la pantalla del usuario
        setLocationRelativeTo(null);
        // Aplicamos un diseño de bordes con una separación de 10 píxeles entre zonas
        setLayout(new BorderLayout(10, 10));

        // --- 1. PANEL SUPERIOR: ENTRADA DE DATOS ---
        // Creamos una rejilla de 2 filas y 2 columnas para etiquetas y campos
        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        // Añadimos un borde con título visual al panel
        panelInput.setBorder(BorderFactory.createTitledBorder("Nuevo Contacto"));
        
        // Añadimos la etiqueta y el campo para el nombre
        panelInput.add(new JLabel(" Nombre:"));
        txtNombre = new JTextField();
        panelInput.add(txtNombre);
        
        // Añadimos la etiqueta y el campo para el teléfono
        panelInput.add(new JLabel(" Teléfono:"));
        txtTelefono = new JTextField();
        panelInput.add(txtTelefono);
        
        // Colocamos el panel de entrada en la zona norte (arriba)
        add(panelInput, BorderLayout.NORTH);

        // --- 2. PANEL CENTRAL: LISTA DE CONTACTOS ---
        // Creamos el modelo que permitirá añadir y quitar elementos de la lista dinámicamente
        modeloLista = new DefaultListModel<>();
        // Inicializamos el componente gráfico de la lista vinculado al modelo
        listaContactos = new JList<>(modeloLista);
        // Creamos un panel de desplazamiento por si la lista es muy larga
        JScrollPane scroll = new JScrollPane(listaContactos);
        // Añadimos un título visual a la zona de la lista
        scroll.setBorder(BorderFactory.createTitledBorder("Lista de Contactos"));
        // Colocamos la lista en la zona central de la ventana
        add(scroll, BorderLayout.CENTER);

        // --- 3. PANEL INFERIOR: BOTONES DE ACCIÓN ---
        // Usamos un panel con FlowLayout para organizar los botones horizontalmente
        JPanel panelBotones = new JPanel();
        
        // Inicializamos y vinculamos el botón de añadir contacto
        btnAñadir = new JButton("Añadir");
        btnAñadir.addActionListener(this);
        
        // Inicializamos y vinculamos el botón para borrar contactos seleccionados
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        
        // Inicializamos y vinculamos el botón para escribir los datos en el disco
        btnGuardar = new JButton("Guardar en Fichero");
        btnGuardar.addActionListener(this);
        
        // Añadimos los tres botones al panel inferior
        panelBotones.add(btnAñadir);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnGuardar);
        // Colocamos el panel en la zona sur (abajo)
        add(panelBotones, BorderLayout.SOUTH);
        
        // Ejecutamos la carga de datos desde el archivo automáticamente al iniciar
        cargarDesdeFichero(); 
    }

    // Método que captura los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lógica para añadir un nuevo contacto a la lista
        if (e.getSource() == btnAñadir) {
            // Obtenemos los textos y eliminamos espacios vacíos innecesarios
            String nombre = txtNombre.getText().trim();
            String tlf = txtTelefono.getText().trim();
            
            // Validamos que ninguno de los dos campos esté vacío
            if (!nombre.isEmpty() && !tlf.isEmpty()) {
                // Añadimos la combinación al modelo de la lista
                modeloLista.addElement(nombre + " - " + tlf);
                // Limpiamos los cuadros de texto para la siguiente entrada
                txtNombre.setText("");
                txtTelefono.setText("");
                // Informamos al usuario del éxito
                JOptionPane.showMessageDialog(this, "Contacto añadido.");
            } else {
                // Mostramos un aviso si falta algún dato
                JOptionPane.showMessageDialog(this, "Rellena ambos campos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        // Lógica para eliminar el contacto que esté seleccionado en la lista
        if (e.getSource() == btnEliminar) {
            // Obtenemos el índice numérico del elemento elegido
            int index = listaContactos.getSelectedIndex();
            // Verificamos que realmente haya algo seleccionado (índice distinto de -1)
            if (index != -1) {
                // Borramos el elemento del modelo
                modeloLista.remove(index);
                JOptionPane.showMessageDialog(this, "Contacto eliminado.");
            } else {
                // Avisamos si el usuario intenta borrar sin haber marcado nada
                JOptionPane.showMessageDialog(this, "Selecciona un contacto de la lista.");
            }
        }

        // Lógica para guardar los cambios en el archivo físico
        if (e.getSource() == btnGuardar) {
            guardarEnFichero();
        }
    }

    // Método encargado de escribir la lista actual en un fichero de texto
    private void guardarEnFichero() {
        // Usamos un bloque try-with-resources para asegurar el cierre del flujo
        try (PrintWriter pw = new PrintWriter(new FileWriter("agenda.txt"))) {
            // Recorremos todos los elementos almacenados en el modelo de la lista
            for (int i = 0; i < modeloLista.size(); i++) {
                // Escribimos cada contacto en una línea nueva del archivo
                pw.println(modeloLista.getElementAt(i));
            }
            // Confirmamos al usuario que el archivo se ha creado/actualizado
            JOptionPane.showMessageDialog(this, "Agenda guardada en 'agenda.txt'");
        } catch (IOException e) {
            // Capturamos posibles errores de escritura en el disco
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    // Método encargado de leer los datos del fichero al abrir la aplicación
    private void cargarDesdeFichero() {
        // Creamos la referencia al archivo de la agenda
        File f = new File("agenda.txt");
        // Solo intentamos leer si el archivo ya existe previamente
        if (f.exists()) {
            // Abrimos el flujo de lectura línea a línea
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String linea;
                // Mientras el fichero tenga contenido, lo añadimos a nuestra lista visual
                while ((linea = br.readLine()) != null) {
                    modeloLista.addElement(linea);
                }
            } catch (IOException e) {
                // Mensaje informativo por consola en caso de fallo en la carga
                System.out.println("Error al cargar.");
            }
        }
    }

    // Punto de entrada de la aplicación
    public static void main(String[] args) {
        // Iniciamos la interfaz y la hacemos visible
        new AgendaTop().setVisible(true);
    }
}