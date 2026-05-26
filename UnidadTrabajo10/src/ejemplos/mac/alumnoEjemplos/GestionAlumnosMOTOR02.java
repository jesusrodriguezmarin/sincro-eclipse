package ejemplos.mac.alumnoEjemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionAlumnosMOTOR02 {

	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/alumno.dat";
	
	/**
	 * Guarda en el fichero una lista de alumnos pasada por parámetro
	 * @param alumnos - ArrayList de Onjeto Alumno
	 */
	public static void guardarLista(ArrayList<AlumnoObjetoBASE01> alumnos) {
		
		// Control de errores
		try {
			// Creamos el objeto de salida para guardar el fichero
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			
			// Escribimos en el fichero un array de alumnos pasado por parámetro
			salida.writeObject(alumnos);
			
			// Cerramos el escritor
			salida.close();
			
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: "+e.getMessage());
		}
	}
	
	/**
	 * Recupera del fichero una lista de alumnos generando un ArrayList
	 * @return - ArrayList - lista de alumnos contenidos en el fichero
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<AlumnoObjetoBASE01> leerLista() {
		
		// Creamos un ArrayList de Alumno
		ArrayList<AlumnoObjetoBASE01> alumnos = new ArrayList<>();
		
		// Control de excepciones
		try {
			// Creamos el objeto de entrada para pasarle el fichero a leer
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			
			// Hacemos casting de ArrayList del objeto para leerlo con el lector creado
			alumnos = (ArrayList<AlumnoObjetoBASE01>) entrada.readObject();
			
			// Cerramos el lector
			entrada.close();
			
		} catch (Exception e) {
			System.out.println(">> Error: no se ha podido leer le fichero.");
		}
		
		return alumnos;
	}
	
	/**
	 * Muestra los alumnos por consola
	 * @param alumnos - ArrayList - alumnos contenidos en el array
	 */
	public static void mostrar(ArrayList<AlumnoObjetoBASE01> alumnos) {
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}
	}
}
