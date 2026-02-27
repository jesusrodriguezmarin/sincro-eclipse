package estudioCasa;

public class MetodosString {

	public static void main(String[] args) {
		// Creamos un String para pasarle los diferentes métodos
		String cad1 = "Jesus";

		// .length

		// Mostramos la longitud de un objeto String
		System.out.println(cad1.length());

		// .concat(String s)

		// Concatenamos una nueva cadena al objeto String que toma como nuevo valor
		cad1 = cad1.concat(" ");
		cad1 = cad1.concat("Rodriguez");
		System.out.println(cad1);

		// .toString

		// Concatenamos otra cadena nueva con + toString
		String cad2 = " Marin";
		cad1 = cad1.toString() + cad2.toString();
		System.out.println(cad1);

		// compareTo(String s)

		// Comparamos un String escrito como parámetro y un String objeto
		String cad3 = "Rodriguez";
		int num1 = cad1.compareTo(cad3);
		System.out.println(num1);
		int num2 = cad1.compareToIgnoreCase("Marin");
		System.out.println(num2);
		System.out.println(cad1.compareTo("Jesus Rodriguez Marin"));
		System.out.println(cad1.compareToIgnoreCase("Jesus Rodriguez Marin"));
		if (cad1.compareTo("Jesus Rodriguez") == 0)
			System.out.println("Son iguales según la cuenta");
		else if (cad1.compareTo("Pablo Sanchez Lopez") < 0)
			System.out.println("cad1 va antes que Pablo Sanchez Lopez");

		// .equals()

		// Comparamos el contenido de dos elementos tipo String
		if (cad1.equals("Jesus Rodriguez Marin"))
			System.out.println("Iguales según String");
		else
			System.out.println("Para nada");

		// .trim()

		// Limpiamos los espacios anteriores y posteriores
		cad1 = "       Jesus Rodriguez Marin       ";
		System.out.println(cad1);
		cad1 = cad1.trim();
		System.out.println(cad1);

		// .toLoweCase()/.toUpperCase()

		// Convertimos a minúsculas/mayúsculas y almacenamos en nuevos String
		String cad4 = cad1.toLowerCase();
		System.out.println(cad4);
		String cad5 = cad1.toUpperCase();
		System.out.println(cad5);
		System.out.println(cad1);

		// .replace(char car, char newcar)

		// Reemplazamos varios caracteres de un String por otros y almacenamos
		String cad6 = cad1.replace('e', 'o');
		System.out.println(cad6);
		System.out.println(cad1);

		// .substring(int i, int f)

		// Generamos una subcadena y almacenamos en otro String
		String nombre = cad1.substring(0, 5);
		System.out.println(nombre);
		String ap1 = cad1.substring(6, 16);
		System.out.println(ap1);
		String ap2 = cad1.substring(16);
		System.out.println(ap2);
		System.out.println(cad1);
		int esp1 = cad1.indexOf(" ");
		int esp2 = cad1.lastIndexOf(" ");
		String apellido = cad1.substring(esp1 + 1, esp2);
		String apellido2 = cad1.substring(esp2 + 1);
		System.out.println("apellido: "+apellido);
		System.out.println("apellido2: "+apellido2);

		// .startsWith/endsWith(String cad)

		// Mostramos true o false según empiece o termine la cadena
		System.out.println(cad1.startsWith("Jesus"));
		System.out.println(cad1.startsWith("jesus"));
		if (cad1.endsWith("Marin"))
			System.out.println("Yes");
		if (cad1.endsWith(ap2))
			System.out.println("Yesss");
		if (!cad1.endsWith("Rodriguez"))
			System.out.println("Nou");

		// .charAt(int pos)

		// Almacenamos los caracteres según posición en el String en un char
		char c1 = cad1.charAt(0);
		char c2 = cad1.charAt(6);
		char c3 = cad1.charAt(16);
		System.out.println(c1 + "." + c2 + "." + c3);

		// pasamos a String usando toString de la clase Character
		String iniciales = Character.toString(c1) + Character.toString(c2) + Character.toString(c3);
		System.out.println(iniciales);

		// .indexOf(int c)/(String s)
		// .lastIndexOf(int c)/(String s)

		// Buscamos en un caracter o subcadena
		System.out.println(cad1.indexOf("Marin"));
		int num3 = cad1.indexOf('J');
		int num4 = cad1.indexOf('R');
		int num5 = cad1.indexOf('M');
		System.out.print("Las iniciales del nombre se encuentran en ");
		System.out.println("las posiciones: " + num3 + "-" + num4 + "-" + num5);
		int num6 = cad1.indexOf('v');
		if (num6 <= -1)
			System.out.println("'v' no se encuetra en el nombre");

		// .toCharArray()

		// Generamos un array de caracteres de un String
		char[] array = cad1.toCharArray();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		int nume = array.length - 1;
		System.out.println(nume);

		// .valueOf(int dato)

		// Convertimos los números a String y almacenamos
		String numeS = String.valueOf(nume);
		System.out.println(numeS);
		System.out.println(numeS + nume);
		System.out.println(nume + numeS);
		System.out.println(Integer.parseInt(numeS) + nume);
		System.out.println(numeS + nume);
		int numeI = Integer.parseInt(numeS);
		System.out.println(numeI + nume);
		
		
		// Nombre completo
		System.out.println(cad1);
		
		// Sacar correo de empresa
		char inicial = cad1.toLowerCase().charAt(0);
		System.out.println(inicial);
		int blanco1 = cad1.indexOf(" ");
		int blanco2 = cad1.lastIndexOf(" ");
		String apellido1 = cad1.substring(blanco1+1, blanco2);
		apellido1 = apellido1.toLowerCase();
		System.out.println(apellido1);
		char apell2 = cad1.toLowerCase().charAt(blanco2+1);
		System.out.println(apell2);
		String parte1 = String.valueOf(inicial)+apellido1+String.valueOf(apell2);
		System.out.println(parte1);
		String total = parte1.concat("@empresa.com");
		System.out.println(total);
	}

}
