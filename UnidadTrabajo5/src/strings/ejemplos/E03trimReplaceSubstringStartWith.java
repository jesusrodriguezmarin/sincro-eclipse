package strings.ejemplos;

public class E03trimReplaceSubstringStartWith {

	public static void main(String[] args) {
	
		// Creamos objeto
		String nombre = "     Harry Potter     ";
		String nombre1 = "Ron";		
		
		// toString
		System.out.println(nombre.toString());
		
		// trim()
		System.out.println("Nombre sin espacios innecesarios: "+nombre.trim());
		
		// Asignamos a nombre, nombre sin espacios
		nombre=nombre.trim();
		
		// replace()
		System.out.println("Sustituimos: "+nombre.replace('H', 'J'));
		System.out.println("Sustituimos: "+nombre.replace(nombre, nombre1));

		// substring()
		System.out.println("Apellido: "+nombre.substring(6));
		System.out.println("Parte: "+nombre.substring(1, 4));
		
		// startWith()
		System.out.println(nombre.startsWith("Ha"));
		System.out.println(nombre.startsWith("ha"));
		if (nombre1.startsWith("Ha")) {
			System.out.println("El nombre es: "+nombre);
		} else if (nombre1.startsWith("R")) {
			System.out.println("El nombre es: "+nombre1);
		}
	}

}
