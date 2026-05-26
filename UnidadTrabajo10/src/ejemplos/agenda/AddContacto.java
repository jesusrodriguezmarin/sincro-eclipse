package ejemplos.agenda;

import java.util.ArrayList;

public class AddContacto {

	public static void main(String[] args) {
		
		// Recuperamos la lista almacenada
		ArrayList<Contacto> alumnos = GestionAlumnos.leerLista();
		
		// Añadimos un nuevo alumno
		alumnos.add(new Alumno("Jesús", 1.0f));
		
		// Guardamos la lista actualizada
		GestionAlumnos.guardarLista(alumnos);
		
		// Mostramos la lista actualizada
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}
	}

}
