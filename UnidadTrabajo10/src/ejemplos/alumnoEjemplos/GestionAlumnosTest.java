package ejemplos.alumnoEjemplos;

import java.util.ArrayList;

public class GestionAlumnosTest {

	public static void main(String[] args) {

		ArrayList<Alumno> alumnos = new ArrayList<>();
		alumnos.add(new Alumno("Juan", 5.75f));
		alumnos.add(new Alumno("Sara", 8.25f));
		alumnos.add(new Alumno("Eva",7.5f));

		GestionAlumnos.guardarLista(alumnos);
		
		ArrayList<Alumno> recuperados = GestionAlumnos.leerLista();
		for (int i = 0; i < recuperados.size(); i++) {
			System.out.println(recuperados.get(i));
		}
	}

}
