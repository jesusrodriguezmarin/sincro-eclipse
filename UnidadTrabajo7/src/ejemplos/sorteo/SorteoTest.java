package ejemplos.sorteo;

public class SorteoTest {

	public static void main(String[] args) {
		
		// Creamos un objeto dado
		Dado d = new Dado();
		
		// Creamos un objeto moneda
		Moneda m = new Moneda();
		
		// Mostramos el resultado de lanzar el dado
		System.out.println("El resultado es: "+d.lanzar());
		
		
		// Mostramos el resultado de lanzar la moneda
		System.out.println("El resultado es: "+m.lanzar());

	}

}
