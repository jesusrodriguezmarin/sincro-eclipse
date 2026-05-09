package estudio.componentes;

import javax.swing.*;
import java.io.File;

public class FileChooser extends JFrame {

    public FileChooser() {
        setTitle("Selector de Archivos");
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnAbrir = new JButton("Seleccionar Archivo");
        getContentPane().add(btnAbrir);

        btnAbrir.addActionListener(e -> {
            JFileChooser selector = new JFileChooser();
            // Abrir el diálogo y guardar la respuesta (Aceptar o Cancelar)
            int resultado = selector.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = selector.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Has elegido: " + archivoSeleccionado.getName());
                // Aquí podrías usar el archivo para leerlo
            }
        });
    }

    public static void main(String[] args) { new FileChooser().setVisible(true); }
}