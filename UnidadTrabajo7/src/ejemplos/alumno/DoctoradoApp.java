package ejemplos.alumno;

import java.util.Scanner;

public class DoctoradoApp {

	public static void main(String[] args) {
		 
		// Abrimos lector para pedir datos a usuario
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce los datos del alumno de doctorado: ");
		System.out.print("Nombre del alumno: ");
		String nombre = sc.nextLine();
		System.out.print("Horas lectivas: ");
		int horas = Integer.parseInt(sc.nextLine());
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		System.out.print("Horas de dedicación a la tesis: ");
		int horas_tesis = Integer.parseInt(sc.nextLine());
		System.out.print("Nombre de la tesis: ");
		String nombre_tesis = sc.nextLine();
		sc.close();
		
		// Creamos un objeto doctorado
		Doctorado d = new Doctorado(nombre, horas, curso, horas_tesis, nombre_tesis);
		System.out.println(d.toString());
		
	}

}
