package ejemplos.agenda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GuardarContacto {

	// Nombre del archivo. Al no poner "C:\\...", se creará solo en la raíz de tu proyecto de Eclipse
	private static final String FICHERO = "agenda.dat";
	
	/**
	 * Método para GUARDAR la lista completa de contactos en el archivo.
	 * Borra el caché interno para que los cambios y modificaciones se guarden de verdad.
	 */
	public static void guardarLista(ArrayList<Contacto> contactos) {
		try {
			FileOutputStream fos = new FileOutputStream(FICHERO);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// ¡Línea clave! Limpia el caché para que Java guarde los datos reales actualizados
			oos.reset(); 
			
			oos.writeObject(contactos);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(">> Error al guardar los datos en el fichero: " + e.getMessage());
		}
	}
	
	/**
	 * Método para LEER la lista de contactos desde el archivo.
	 * Si el archivo no existe todavía (primera ejecución), captura el error y 
	 * devuelve una lista vacía pero perfectamente lista para usar.
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Contacto> leerLista() {
		ArrayList<Contacto> contactos = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(FICHERO);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// Leemos el bloque completo del ArrayList y hacemos el casting a nuestra clase
			contactos = (ArrayList<Contacto>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (Exception e) {
			// Si el archivo no existe, no hacemos nada; devolvemos la lista 'contactos' vacía.
			// Esto evita que el programa falle con un NullPointerException la primera vez.
		}
		return contactos;
	}
}