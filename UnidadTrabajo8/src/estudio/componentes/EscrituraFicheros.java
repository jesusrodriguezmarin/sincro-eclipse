package estudio.componentes;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EscrituraFicheros {

    /**
     * @param rutaArchivo Nombre o ruta del fichero.
     * @param texto El contenido que queremos validar y guardar.
     * @param añadir true para no borrar lo anterior, false para sobrescribir.
     */
    public void validarYEscritar(String rutaArchivo, String texto, boolean añadir) {
        
        // 1. VALIDACIÓN: Comprobamos si el texto es nulo o está vacío
        // .trim() elimina espacios en blanco al principio y final
        if (texto == null || texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Operación cancelada: El texto está vacío.", 
                "Validación", 
                JOptionPane.WARNING_MESSAGE);
            return; // Cortamos la ejecución aquí
        }

        // 2. ESCRITURA: Si pasó la validación, procedemos a guardar
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo, añadir))) {
            
            pw.println(texto.trim());
            
            // ÉXITO
            JOptionPane.showMessageDialog(null, 
                "Se ha guardado correctamente en: " + rutaArchivo, 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            // ERROR DE SISTEMA
            JOptionPane.showMessageDialog(null, 
                "No se pudo escribir en el archivo.\nDetalle: " + e.getMessage(), 
                "Error de E/S", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EscrituraFicheros escritor = new EscrituraFicheros();

        // EJEMPLO 1: Intento de guardar algo vacío (saltará el Warning)
        escritor.validarYEscritar("datos.txt", "   ", true);

        // EJEMPLO 2: Guardar un dato válido (saltará el Success)
        escritor.validarYEscritar("datos.txt", "Registro de prueba", true);
    }
}