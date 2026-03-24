package stringBuffer.ejemplos;

public class StringBufferPruebas {

	public static void main(String[] args) {

		// Creamos instancia/objeto de StringBuffer
		StringBuffer nombre1 = new StringBuffer("Walter");
		System.out.println("1) "+nombre1);
		
		// Concatenamos con .append
		nombre1.append(" White");
		System.out.println("2) "+nombre1);
		
		// .reverse
		nombre1.reverse();
		System.out.println("3) "+nombre1);
		
		// .insert
		nombre1.insert(0, "Big");
		System.out.println("4) "+nombre1);
		
		// .insert
		nombre1.insert(3, " ");
		System.out.println("5) "+nombre1);
		
		// .delete
		nombre1.delete(9, 16);
		System.out.println("6) "+nombre1);

		// .replace
		nombre1.replace(4, nombre1.length(), "Ben");
		System.out.println("7) "+nombre1);
		
		// .substring
		nombre1.substring(0, 3);
		System.out.println("8) "+nombre1);
		String nombre2 = nombre1.substring(0, 3);
		System.out.println("9) "+nombre2);
		
		// .setCharAt
		nombre1.setCharAt(4, 'T');
		System.out.println("10) "+nombre1);
		
	}

}
