package stringBuffer.ejemplos;

public class StringBufferTest {

	public static void main(String[] args) {
		
		// Ejemplo con String
		String nombre1="Harry Potter";
			
		nombre1.toUpperCase();
		
		// No cambia
		System.out.println(nombre1);
		System.out.println(nombre1.toUpperCase());
		System.out.println(nombre1);
		
		// Si cambia
		nombre1=nombre1.toUpperCase();
		System.out.println(nombre1);

		// Con StringBuffer si se guarda directamente
		StringBuffer nombre2 = new StringBuffer("Hermione Granger");
		System.out.println(nombre2);
		nombre2.reverse();
		System.out.println(nombre2);
		
		// Con toString convierto el StrigBuffer.reverse() en un String
		String nombre3 = nombre2.reverse().toString();
		System.out.println(nombre3);
		
		// Creo un StringBuffer con un String y uso métodos:
		// .substring(), .toUpperCase
		// para el StringBuffer uso método .reverse
		StringBuffer nombre4=new StringBuffer(nombre3.substring(0, 8).toUpperCase());
		nombre4.reverse();
		System.out.println(nombre4);
	}

}
