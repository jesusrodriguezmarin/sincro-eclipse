package ejemplos.condicionales;

public class Mayor_v2 {

	public static void main(String[] args) {
		// Declaramos e inicializamos las variables
		int a=(int)(Math.random()*5+1);
		int b=(int)(Math.random()*5+1);
		
		// Comparamos y mostramos el resultado en pantalla
		if (a>b) {
			System.out.println(a+" es mayor que "+b);
		} else if (a<b) {
			System.out.println(a+" es menor que "+b);
		} else {
			System.out.println(a+" es igual que "+b);
		}

	}

}
