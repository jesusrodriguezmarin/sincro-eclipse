package ejemplos.alumnoEjemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionAlumnos {
	
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/alumno.dat";
;
	
	/**
	 * Guarda el fichero en una lista de alumnos
	 * @param alumnos - array del objeto Alumno
	 */
	public static void guardarLista(ArrayList<Alumno> alumnos) {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			salida.writeObject(alumnos);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: "+e.getMessage());
		}
	}
	
	/**
	 * Recupera del fichero una lista de alumnos
	 * @return - Array - lista de alumnos
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Alumno> leerLista() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			alumnos = (ArrayList<Alumno>) entrada.readObject();
			entrada.close();
		
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: "+e.getMessage());
		}
		return alumnos;
	}

}
