package strings.expicacionClase;

public class ejp01Comparaciones {

	public static void main(String[] args) {
		
		// Declaramos objetos de la clase String de dos formas posibles
		String s1 = "ANTONIO";
		String s2 = new String("Antonio");
		
		// 1. Métodos compareTo y compareToIgnore
		// Para oredenar algabeticamente
		if (s1.compareTo(s2)==0)
			System.out.println(s1+" y "+s2+" son iguales");
		else
			System.out.println(s1+" y "+s2+" son distintos");
		
		if (s1.compareToIgnoreCase(s2)==0)
			System.out.println(s1+" y "+s2+" son iguales");
		else
			System.out.println(s1+" y "+s2+" son distintos");
		
		// 2. Método equals.
		// Para ver si son iguales o distintos
		if (s1.equals(s2)==true)
			System.out.println(s1+" y "+s2+" son iguales");
		else
			System.out.println(s1+" y "+s2+" son distintos");
		
		// 3. Con la igualdad
		if (s1==s2)
			System.out.println(s1+" y "+s2+" son iguales");
		else
			System.out.println(s1+" y "+s2+" son distintos");
		
	}
}
