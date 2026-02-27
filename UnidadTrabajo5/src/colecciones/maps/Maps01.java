package colecciones.maps;

import java.util.HashMap;
import java.util.Map;

public class Maps01 {

	public static void main(String[] args) {
		
		// Creamos un Map
		Map<Integer, String> ciudades = new HashMap<Integer, String>();
		
		// Insertamos elementos
		ciudades.put(30500, "Molina de segura");
		ciudades.put(30560, "Alguazas");
		ciudades.put(30565, "Las Torres");
		ciudades.put(30600, "Archena");
		ciudades.put(30820, "Alcantarilla");
		
		// Obtenemos el valor de una clave
		int codpostal = 30560;
		System.out.println("La ciudad con codigo postal "+codpostal+" es: "+ciudades.get(codpostal));
		
		// Imprimimos el mapa diccionario
		System.out.println("Ciudades: "+ciudades);
		
		// Eliminamos el valor de la clave codpostal
		String nombre = ciudades.remove(codpostal);
		if (nombre!=null) {
			System.out.println("La ciudad ha sido eliminada.");
		} else {
			System.out.println("La ciudad no existe,no ha sido eliminada");
		}
		
	}

}
