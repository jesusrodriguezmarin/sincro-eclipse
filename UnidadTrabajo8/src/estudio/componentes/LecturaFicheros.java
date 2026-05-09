package estudio.componentes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LecturaFicheros {

    /**
     * Lee el archivo y muestra todo su contenido en una ventana emergente.
     * @param rutaEspecifica Nombre o ruta del archivo (ej: "datos.txt")
     */
    public void leerArchivo(String rutaEspecifica) {
        File archivo = new File(rutaEspecifica);
        
        // StringBuilder es más eficiente para acumular mucho texto que un String normal
        StringBuilder contenidoCompleto = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Vamos guardando cada línea en nuestro acumulador
                contenidoCompleto.append(linea).append("\n");
            }

            // SI EL ARCHIVO ESTÁ VACÍO O NO TIENE LÍNEAS
            if (contenidoCompleto.length() == 0) {
                JOptionPane.showMessageDialog(null, "El archivo está vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                // MOSTRAR RESULTADO EN VENTANA EMERGENTE
                // Truco: Usamos un JTextArea dentro del mensaje por si el texto es muy largo
                JTextArea textArea = new JTextArea(contenidoCompleto.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(350, 250));

                JOptionPane.showMessageDialog(null, scrollPane, "Contenido de: " + rutaEspecifica, JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer: " + e.getMessage(), "Error de Fichero", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
    	LecturaFicheros lector = new LecturaFicheros();
        
        // Llamada simple con el nombre del archivo
        lector.leerArchivo("datos.txt"); 
    }
}