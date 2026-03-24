package ejemplos.estudiantes;

import java.util.Scanner;

public class EstudianteTest02 {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// control de excepciones
		try {
			// pedimos por teclado la info del estudiante
			System.out.print("Dime el nombre del estudiante: ");
			String name = sc.nextLine();	// leemos String, nextLine
			System.out.print("Dime la nota de la primera evaluación: ");
			int n1 = sc.nextInt();
			System.out.print("Dime la nota de la segunda evaluación: ");
			int n2 = sc.nextInt();
			System.out.print("Dime la nota de la tercera evaluación: ");
			int n3 = sc.nextInt();
			
			// creamos el estudiante con los datos introducidos
			Estudiante e = new Estudiante(name, n1, n2, n3);
			
			// salto de linea
			System.out.println();
			// mostramos la informacion sobre el estudiante
			e.mostrarEstudiante();
			
			System.out.println("Estado: ");
			if (e.aprueba())
				System.out.println("Aprueba módulo");
			else
				System.out.println("Suspende");
			
		} catch (Exception e) {
			System.err.println(">> ERROR. Tipo de datos introducidos no válido.");
		} finally {
			sc.close();
		}
		
	}

}
