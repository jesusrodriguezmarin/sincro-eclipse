// Función que recorra una cadena String y nos devuelva 
// la posición del primer espacio

package strings.expicacionClase;

public class ejercicioRepaso_v1 {

	/**
	 * Devuelve la posición del primer espacio en blanco que contiene un String
	 * pasado como parámetro
	 * @param s - String
	 * @return Posición (int) del primer espacio en blanco dentro del String
	 * -1 si no hay espacios en blanco
	 */
	public static int primerBlanco(String s) {
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)==' ')
				return i;
		}
		return -1;
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un objeto String
		String nombre  = "Harry potter";
		String nombre2 = "Ronald";
	
		// Mostramos el int con la posición llamando a la función
		System.out.println(primerBlanco(nombre));
		System.out.println(primerBlanco(nombre2));
		
		// Declaramos una variable y le asignamos la función
		int pos = primerBlanco(nombre);	// Contiene la posición (int)
		int pos2 = primerBlanco(nombre2);
	
		// Utilizamos la nueva variable para condicionar (int)
		if (pos>=0) {
			System.out.println("El nombre "+nombre+" tiene espacios en blanco");
		} else {
			System.out.println(nombre+" No tiene espacios en blanco");
		}
		if (pos2>=0) {
			System.out.println("El nombre "+nombre2+" tiene espacios en blanco");
		} else {
			System.out.println(nombre2+" No tiene espacios en blanco");
		}

	}

}
