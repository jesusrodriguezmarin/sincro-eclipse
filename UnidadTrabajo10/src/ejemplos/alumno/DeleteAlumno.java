package ejemplos.alumno;

import java.util.ArrayList;

public class DeleteAlumno {

	public static void main(String[] args) {
		
		// Recuperamos la lista almacenada
		ArrayList<Alumno> alumnos = GestionAlumnos.leerLista();
		
		// Recorrenos la lista
		for (int i = 0; i < alumnos.size(); i++) {
			
			// Buscamos el alumno que queremos borrar
			if (alumnos.get(i).getNombre().equals("Jesús")) {
				
				// Eliminamos al alumno
				alumnos.remove(i);
				
				// Informamos
				System.out.println("Alumno eliminado");
				
				// Una vez encontrado y eliminado finalizamos el bucle
				break;
			}
		}
		
		// Guardamos de nuevo la lista con la actualización
		GestionAlumnos.guardarLista(alumnos);

	}

}
