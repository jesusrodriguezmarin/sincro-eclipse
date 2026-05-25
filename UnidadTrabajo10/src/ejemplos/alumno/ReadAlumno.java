package ejemplos.alumno;

import java.util.ArrayList;

public class ReadAlumno {

	public static void main(String[] args) {
		
		// Recuperamos la lista almacenada en el fichero
		ArrayList<Alumno> alumnos = GestionAlumnos.leerLista();
		
		// Mostramos los objetos almacenados
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}
	}
}
