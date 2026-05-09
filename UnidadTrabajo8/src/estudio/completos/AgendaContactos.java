package estudio.completos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AgendaContactos extends JFrame implements ActionListener {

    // Componentes
    private JTextField txtNombre, txtTelefono;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaContactos;
    private JButton btnAñadir, btnEliminar, btnGuardar;

    public AgendaContactos() {
        setTitle("Mi Agenda de Contactos");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. PANEL SUPERIOR (Entrada de datos)
        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Nuevo Contacto"));
        
        panelInput.add(new JLabel(" Nombre:"));
        txtNombre = new JTextField();
        panelInput.add(txtNombre);
        
        panelInput.add(new JLabel(" Teléfono:"));
        txtTelefono = new JTextField();
        panelInput.add(txtTelefono);
        
        add(panelInput, BorderLayout.NORTH);

        // 2. PANEL CENTRAL (Lista de contactos)
        modeloLista = new DefaultListModel<>();
        listaContactos = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaContactos);
        scroll.setBorder(BorderFactory.createTitledBorder("Lista de Contactos"));
        add(scroll, BorderLayout.CENTER);

        // 3. PANEL INFERIOR (Botones)
        JPanel panelBotones = new JPanel();
        
        btnAñadir = new JButton("Añadir");
        btnAñadir.addActionListener(this);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        
        btnGuardar = new JButton("Guardar en Fichero");
        btnGuardar.addActionListener(this);
        
        panelBotones.add(btnAñadir);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnGuardar);
        add(panelBotones, BorderLayout.SOUTH);
        
        cargarDesdeFichero(); // Carga automática al abrir
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAñadir) {
            String nombre = txtNombre.getText().trim();
            String tlf = txtTelefono.getText().trim();
            
            if (!nombre.isEmpty() && !tlf.isEmpty()) {
                modeloLista.addElement(nombre + " - " + tlf);
                txtNombre.setText("");
                txtTelefono.setText("");
                JOptionPane.showMessageDialog(this, "Contacto añadido.");
            } else {
                JOptionPane.showMessageDialog(this, "Rellena ambos campos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == btnEliminar) {
            int index = listaContactos.getSelectedIndex();
            if (index != -1) {
                modeloLista.remove(index);
                JOptionPane.showMessageDialog(this, "Contacto eliminado.");
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un contacto de la lista.");
            }
        }

        if (e.getSource() == btnGuardar) {
            guardarEnFichero();
        }
    }

    private void guardarEnFichero() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("agenda.txt"))) {
            for (int i = 0; i < modeloLista.size(); i++) {
                pw.println(modeloLista.getElementAt(i));
            }
            JOptionPane.showMessageDialog(this, "Agenda guardada en 'agenda.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    private void cargarDesdeFichero() {
        File f = new File("agenda.txt");
        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    modeloLista.addElement(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al cargar.");
            }
        }
    }

    public static void main(String[] args) {
        new AgendaContactos().setVisible(true);
    }
}