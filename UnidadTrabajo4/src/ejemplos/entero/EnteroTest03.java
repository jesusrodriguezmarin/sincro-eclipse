package ejemplos.entero;

public class EnteroTest03 {

	public static void main(String[] args) {
		// Creamos el objeto con parámetro 5
		Entero n = new Entero(5);
		
		// Generamos un número aleatorio entre 1 y 10
		int aleatorio =  (int)(Math.random()*10+1);
		
		// Comparamos los números llamando al método esMayor y mostramos por consola
		if (n.esMayor(aleatorio))
			System.out.println(n.getEntero()+" es mayor que "+aleatorio);
		else
			System.out.println(n.getEntero()+" no es mayor que "+aleatorio);
	}

}
