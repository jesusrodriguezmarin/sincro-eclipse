// Función que recorra una cadena String y nos devuelva 
// la posición del primer espacio

package strings.expicacionClase;

public class ejercicioRepaso_v2 {

	/**
	 * Devuelve la posición del primer espacio en blanco que contiene un String
	 * pasado como parámetro
	 * @param s - String
	 * @return Posición (int) del primer espacio en blanco dentro del String
	 * -1 si no hay blancos
	 */
	public static int primerBlanco(String s) {
		for (int i=0; i<s.length(); i++)
			if (s.charAt(i)==' ') 
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		
		// Creamos un objeto String
		String nombre  = "Harry potter";
		String nombre2 = "Ronald";
	
		// Utilizamos la función que devuelve un int
		System.out.println(primerBlanco(nombre));
		System.out.println(primerBlanco(nombre2));
		
		// Almacenamos el int de la función como una variable
		int pos = primerBlanco(nombre);
		int pos2 = primerBlanco(nombre2);
		
		// Para nombre
		if (pos>=0) {
			// Utilizamos .substring() para mostrar nombre
			System.out.println("Nombre: "+nombre.substring(0, pos));
			// Utilizamos substring para mostrar apellido a partir del mismo String
			System.out.println("Apellido: "+nombre.substring(pos+1));
		} else {
			System.out.println("Nombre: "+nombre);
		}
		// Para nombre2
		if (pos2>=0) {
			System.out.println("Nombre: "+nombre);
		} else {
			// Utilizamos .charAt para mostrar inicial
			System.out.println("Inicial: "+nombre2.charAt(0));
		}

	}

}
