package colecciones.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps02 {

	public static void main(String[] args) {

		// Creamos un Map
		Map<Integer, String> ciudades = new HashMap<Integer, String>();

		// Insertamos elementos
		ciudades.put(30500, "Molina de segura");
		ciudades.put(30560, "Alguazas");
		ciudades.put(30565, "Las Torres");
		ciudades.put(30600, "Archena");
		ciudades.put(30820, "Alcantarilla");
		
		// Pedimos la introducción por teclado de un código postal
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Introduce un código postal: ");
			int codpostal = Integer.parseInt(sc.nextLine().trim());
			
			if (ciudades.containsKey(codpostal)) {
				System.out.println("> La ciudad con código postal "+codpostal+" es: "+ciudades.get(codpostal));
			} else {
				System.out.println("> La ciudad con código postal "+codpostal+" no existe en nuesto diccionario.");
			}
			
		} catch (Exception e) {
			System.err.println("> Error en la introducción de datos.");
		} 
		
		// Pedimos la introducción por teclado del nombre de la ciudad
		System.out.print("Introduce el nombre de un pueblo: ");
		String nombre = sc.nextLine();
		
		sc.close();
	}

}
