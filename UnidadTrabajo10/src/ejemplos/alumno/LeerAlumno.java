package ejemplos.alumno;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LeerAlumno {

	public static void main(String[] args) {

		// Control de errores
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("C:/PG/alumnos.dat"));
			
			Alumno a = (Alumno) entrada.readObject();
			
			entrada.close();
			
			System.out.println(a);
			
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: "+e.getMessage());
		}

	}

}
