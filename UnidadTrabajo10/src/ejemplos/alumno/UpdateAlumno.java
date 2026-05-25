package ejemplos.alumno;

import java.util.ArrayList;

public class UpdateAlumno {

	public static void main(String[] args) {

		// Recuperamos la lista almacenada
		ArrayList<Alumno> alumnos = GestionAlumnos.leerLista();
		
		// Recorremos la lista
		for (int i = 0; i < alumnos.size(); i++) {
			
			// Buscamos al alumno que queremos modificar
			if (alumnos.get(i).getNombre().equals("Juanjosele")) {
				
				// Modificamos su nota
				alumnos.get(i).setNota(3.0f);
				
				// Informamos
				System.out.println("Modificado por PATÁN");
			}
		}

		// Guardamos la lista actualizada
		GestionAlumnos.guardarLista(alumnos);
	}

}
