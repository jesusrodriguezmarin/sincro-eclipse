package ejercicios2;

import java.util.Scanner;

public class PersonaTest {

	public static void main(String[] args) {
		
		// Abrimos lector para pedir los datos de una persona y crear una instancia con ello
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		
		System.out.print("Introduce tu edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		
		System.out.print("Introduce tu sexo: ");
		String sexo = sc.nextLine();
		
		System.out.print("Introduce tu peso: ");
		double peso = Double.parseDouble(sc.nextLine().replace(",", "."));
		
		System.out.print("Introduce tu altura: ");
		double altura = Double.parseDouble(sc.nextLine().replace(",", "."));
	
		
		// Creamos la instancia con los datos almacenados
		Persona p = new Persona(nombre, edad, sexo, peso, altura);
		
		if (p.esMayor()) {
			System.out.println("Eres mayor de edad.");
		} else {
			System.out.println("No eres mayor de edad");
		}
		
		if (p.calcularIMC()==-1) {
			System.out.println("Estás en tu peso idóneo.");
		} else if (p.calcularIMC()==0) {
			System.out.println("Estás por debajo del peso ideal.");
		} else if (p.calcularIMC()==1) {
			System.out.println("Sobrepeso.");
		}
		
		System.out.println(p.toString());
		sc.close();
	}

}
