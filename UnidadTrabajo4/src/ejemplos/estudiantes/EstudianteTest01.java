package ejemplos.estudiantes;

public class EstudianteTest01 {

	public static void main(String[] args) {
		// creamos a un objeto estudiante
		Estudiante e = new 	Estudiante("Harry Potter", 7, 6, 8);
		
		// modificamos las notas usando los setters
		e.setNota1(9);					// asignamos una nota concreta
		e.setNota2(e.getNota2()+1);		// subimos un punto
		e.setNota3(e.getNota3()-1);		// bajamos un punto
		
		// mostramos la información referente al estudiante
		e.mostrarEstudiante();

	}

}
