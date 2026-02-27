// Controlar si el valor fuera 0 con el .size al meter los valores por teclado

package colecciones.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Maps03 {

	public static void main(String[] args) {

		// Declaramos el Map
		// Clave --> Nombre del alumno (String)
		// Valor --> Notal final (Double)
		Map<String, Double> notas = new HashMap<String, Double>();
		
		// Añadimos alumnos y notas
		notas.put("Miguel", 7.25);
		notas.put("Jesus", 10.0);
		notas.put("Alba", 5.8);
		notas.put("Luis", 9.1);
		notas.put("Juan", 4.6);
		
		// Mostramos todas las notas
		System.out.println("=== LISTADO DE NOTAS ===");
		
		// a) Obtenemos el conjunto de entradas del map (Clave-valor)
		Set<Map.Entry<String, Double>> conjunto = notas.entrySet();
		
		// b) Creamos el Iterator
		Iterator<Map.Entry<String, Double>> i = conjunto.iterator();
		
		// c) Recorremos con while
		while (i.hasNext()==true) {
			Map.Entry<String, Double> entrada = i.next();
			System.out.println("Alumno: "+entrada.getKey()+" | Nota: "+entrada.getValue());
		}
		
		// 2. Calculamos la nota media de la clase
		double suma = 0;
		
		// Tenemos que recorrer los values del mapa
		Iterator<Double> j = notas.values().iterator();
		
		// Pasamos el while por el Iteraror para recorrerlo
		while (j.hasNext()) {
			suma+=j.next();
		}
		// Ralizamos la operación
		double media = suma/ notas.size();
		System.out.println("\nNota media del grupo: "+media);
		
		// 3. Buscamos el alumno con la mayor nota
		// a) Obtenemos el Iterator sobre las entradas del Map
		Iterator<Map.Entry<String, Double>> k = notas.entrySet().iterator();
	
		// Inicializamos mejor nota al primer alumno
		Map.Entry<String, Double> primerAlumno = k.next();
		double mejorNota = primerAlumno.getValue();
		String mejorAlumno = primerAlumno.getKey();
		
		// b) Recorremos con while
		while (k.hasNext()) {
			Map.Entry<String, Double> siguienteAlumno = k.next();
			if (siguienteAlumno.getValue()>mejorNota) {
				mejorNota = siguienteAlumno.getValue();
				mejorAlumno = siguienteAlumno.getKey();
			}
		}
		
		System.out.println("\nAlumno con mayor nota: "+mejorAlumno+" con un "+mejorNota);
		
		// 4) Modificamos la nota de Lola y la subimos un punto
		String nombre = "Maria";
		System.out.println("\nActualizando la nota de "+nombre+"...");
		
		// Controlamos la impresión solo si existe el nombre
		if (notas.containsKey(nombre)) {
			notas.put(nombre, notas.get(nombre)+1);
			System.out.println("Nueva nota de "+nombre+": "+notas.get(nombre));
			
		} else {
			System.out.println(nombre+" no existe");
		}
	}

}
