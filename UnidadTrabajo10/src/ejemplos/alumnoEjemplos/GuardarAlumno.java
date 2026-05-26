package ejemplos.alumnoEjemplos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GuardarAlumno {

	public static void main(String[] args) {

		// Instanciamos el objeto Alumno
		Alumno a = new Alumno("Marta", (float)9.25);
		
		// Control de errores
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("/Users/jesusrodriguezmarin/Documents/BDeclipse/alumno.dat"));
			
			salida.writeObject(a);
			
			salida.close();
			
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: "+e.getMessage());
		}

	}

}
