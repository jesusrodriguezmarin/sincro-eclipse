package strings.expicacionClase;

public class ejp03StringTest {

	public static void main(String[] args) {
		
		// Los String no se guardan, solo los devuelve, 
		// Para guardarlos hay que declarar una variable y entonces aplicarle el método
		
		// trim()
		String nombre=new String("   Harry Potter   ");
		System.out.println(nombre.trim());
		System.out.println(nombre);
		nombre=nombre.trim();
		
		// replace()
		System.out.println(nombre.replace('e', 'X'));
		System.out.println(nombre.replace('t', 'T'));
		
		// substring (*ESTA SE UTILIZA MUCHO)
		System.out.println(nombre.substring(0, 5));
		System.out.println(nombre.substring(6));
		
		// indexOff 
		System.out.println("Posición de la H:"+nombre.indexOf('H'));
		System.out.println("Posición de la h:"+nombre.indexOf('h'));
		System.out.println("Posición de la t:"+nombre.indexOf('t'));
		
		System.out.println("Posición de la h:"+nombre.substring(0).indexOf(' '));
		
		// starsWith
		System.out.println(nombre.startsWith("Harry"));		
		System.out.println(nombre.startsWith("Hary"));
		
		if (nombre.startsWith("harry")) {
			System.out.println("No es correcto");
		} else if (nombre.startsWith("Harry")) {
			System.out.println("Si lo es");
		}
	}

}
