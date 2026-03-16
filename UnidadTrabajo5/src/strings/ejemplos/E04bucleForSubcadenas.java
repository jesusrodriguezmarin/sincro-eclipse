package strings.ejemplos;

public class E04bucleForSubcadenas {

	/**
	 * Función que recorre y devuelve la posición (int) de la cadena String
	 * en la que se encuentra el primer espacio en blanco
	 * @param s - String para recorrer y comparar
	 * @return un int posición del espacio
	 * si no la encuentra devuelve -1
	 */
	public static int primerBlanco(String s) {
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)==' ')
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		// Creamos objeto
		String nombre = "Harry Potter";
		
		// Creamos una variable para almacenar el int resultante de la función
		int pos = primerBlanco(nombre);
		
		if (pos>=0) {
			System.out.println("Nombre: "+nombre.substring(0, pos));
			System.out.println("Apellido: "+nombre.substring(pos+1));
		} else {
			System.out.println("Nombre: "+nombre);
		}
		
	}

}
