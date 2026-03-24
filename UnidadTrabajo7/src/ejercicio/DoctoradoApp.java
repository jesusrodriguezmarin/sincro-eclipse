package ejercicio;

import java.util.Scanner;

public class DoctoradoApp {

	public static void main(String[] args) {
		
		// Pedimos valores a usuario
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce los datos del alumno de doctorado...");
		System.out.print("Nombre del alumno: ");
		String nombre = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		System.out.print("Nota del curso: ");
		double nota = Double.parseDouble(sc.nextLine());
		System.out.print("Nombre de la tesis: ");
		String nombretesis = sc.nextLine();
		System.out.print("Nota de la tesis: ");
		double notatesis = Double.parseDouble(sc.nextLine());
		sc.close();
		
		Doctorado d = new Doctorado(nombre, nota, curso, notatesis, nombretesis);
		
		double htotal = d.notaFinal();
		
		System.out.println("\nLos datos introducidos son: \n"+d.toString());
		System.out.print("Nota final: "+htotal);
	}

}
