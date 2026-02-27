package estudioCasa;

public class MetodosStringBuffer {

	public static void main(String[] args) {

		// Creamos un StringBuffer para trabajar con los diferentes métodos
		StringBuffer cad = new StringBuffer("Jesus");

		
		// .length()

		// Mostramos el largo del SB
		System.out.println(cad.length());

		
		// .reverse()

		// Revertimos la cadena
		cad.reverse();
		System.out.println(cad);
		cad.reverse();
		System.out.println(cad);

		
		// .append(argumento)

		// Añadimos string a la cadena de dos formas
		String apellido1 = " Rodriguez";
		cad.append(apellido1);
		System.out.println(cad);
		cad.append(" Marin");
		System.out.println(cad);
		cad.append(" " + 36);
		System.out.println(cad);
		
		
		// .insert(int pos, arg)
		
		// Insertamos en una posición concreta
		cad.insert(cad.length()-3, " tiene");
		cad.append(" años");
		System.out.println(cad);
		
		
		// .delete(int x, int y)
		
		// Borramos información concreta del SB
		cad.delete(21, cad.length());
		System.out.println(cad);
		
		
		// .replace(int x, int y, String s)
		
		// Reemplazamos entre unas posiciones concretas
		int espacio1 = cad.indexOf(" ");
		int espacio2 = cad.lastIndexOf(" ");
		cad.replace(espacio1+1, espacio2, "Garcia");
		System.out.println(cad);
		
		
		// .substring
		
		// Generamos una nueva cadena
		String cad2 = cad.substring(espacio1+1, espacio2-2);
		System.out.println(cad2);
		System.out.println(cad);
		cad.replace(espacio1+1, espacio2-2, "Rodriguez ");
		System.out.println(cad);
		
		
		// .toString
		
		// Devolvemos una copia de SB en String
		String copia = cad.toString();
		System.out.println(copia);
		cad.append(" new");
		System.out.println(cad);
		System.out.println(copia.concat(String.valueOf(cad)));
		System.out.println(copia);
		String copia2 = copia.concat(String.valueOf(cad));
		System.out.println(copia2);
		
		
		// .charAt(int x)
		
		// Mostramos las iniciales señalando la posición en la cadena SB
		System.out.println(cad.charAt(0)+"."+cad.charAt(espacio1+1)+"."+cad.charAt(espacio2+1));
		System.out.println(cad);
		

		// .setCharAt(int x, char c)
		
		// Reemplazamos un caracter en una posición
		cad.setCharAt(cad.length()-3, 'N');
		System.out.println(cad);
	}

}
