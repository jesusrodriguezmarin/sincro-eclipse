// Función que recorra una cadena String y nos devuelva 
// la posición del primer espacio

package strings.expicacionClase;

public class ejercicioRepaso_v3 {

	/**
	 * Devuelve la posición del primer espacio en blanco que contiene un String
	 * pasado como parámetro
	 * @param s - String
	 * @return Posición (int) del primer espacio en blanco dentro del String
	 * -1 si no hay blancos
	 */
	public static int primerBlanco(String s) {
		return s.indexOf(' ');
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos un objeto String
		String nombre  = "HarryPotter";
	
		System.out.println(primerBlanco(nombre));
		
		int pos = primerBlanco(nombre);
		if (pos>=0) {
			System.out.println("Nombre: "+nombre.substring(0, pos));
			System.out.println("Apellido: "+nombre.substring(pos+1));
		} else {
			System.out.println("Nombre: "+nombre);
			System.out.println("Iniciales: "+nombre.charAt(0)+"."+nombre.charAt(5));
			System.out.println("Primera inicial: "+nombre.substring(0, 1));
			System.out.println("Segunda inicial: "+nombre.substring(5, 6));
		}

	}

}
