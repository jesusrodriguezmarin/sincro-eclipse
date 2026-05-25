package ejemplos.mac;

import java.util.ArrayList;

public class AddAlumnoCREATE03 {

	public static void main(String[] args) {
		
		// Recuperamos la lista almacenada
		ArrayList<AlumnoObjetoBASE01> alumnos = GestionAlumnosMOTOR02.leerLista();
		
		// Añadimos un nuevo alumno
		alumnos.add(new AlumnoObjetoBASE01("Jesules", 9.95f));
		alumnos.add(new AlumnoObjetoBASE01("PepaPig", (float)4.55));
		
		// Guardamos la lista actualizada
		GestionAlumnosMOTOR02.guardarLista(alumnos);
		
		// Mostramos la lista actualizada
		GestionAlumnosMOTOR02.mostrar(alumnos);

	}

}
