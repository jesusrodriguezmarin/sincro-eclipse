package ejemplos.apuntes.condicionales;

public class MayorDeTres {

	public static void main(String[] arg) {
		// Declaración e inicialización
		int a = 20, b = 30, c = 10;
		
		System.out.println("Valores: "+a+", "+b+" y "+c);
		
		// Comparación y muestra por pantalla
		if (a > b) {
			if (a > c)
			System.out.println(a+" es el mayor");
			else 
			System.out.println(c+" es el mayor");
		} else if (b > c) {
			System.out.println(b+" es el mayor");
		} else {
			System.out.println(c+" es el mayor");
		}
	}

}
