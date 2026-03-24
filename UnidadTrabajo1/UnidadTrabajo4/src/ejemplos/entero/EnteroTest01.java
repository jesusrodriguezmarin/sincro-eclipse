package ejemplos.entero;

public class EnteroTest01 {

	public static void main(String[] args) {
		
		// creamos el objeto 'e'
		Entero e = new Entero();
		
		// mostramos el objto con su valor inicial sin modificar
		System.out.println("Nº entero inicial: "+e.getEntero());
		
		// actualizamos el valor con setter
		e.setEntero(10);
		System.out.println("Nº entero actualizado con setter: "+e.getEntero());
		
		// llamamos al método para el objeto e.esPositivo y mostramos según condición
		if (e.esPositivo())
			System.out.println(e.getEntero()+" es positivo.");
		else
			System.out.println(e.getEntero()+" no es positivo.");
		
		// actualizaos de nuevo el objeto
		e.setEntero(-10);
		System.out.println("Nº actualizado por segunda vez: "+e.getEntero());
		
		// llamamos a otro método de la clase para el objeto e.
		if (e.esPositivo())
			System.out.println(e.getEntero()+" es positivo.");
		else
			System.out.println(e.getEntero()+" es negativo o cero.");
		
		// llamamos a otro método de la clase para e.
		if (e.esCero())
			System.out.println(e.getEntero()+" es cero.");
		else
			System.out.println(e.getEntero()+" no es cero.");
		
		// llamamos al tercer método de la clase y le pasamos un parámetro
		if (e.esMayor(-15))
			System.out.println(e.getEntero()+" es mayor.");
		else
			System.out.println(e.getEntero()+" no es mayor");
		
		// última modificación del objeto e.
		e.setEntero(0);
		System.out.println("Ultima actualización: "+e.getEntero());
		
		// llamamos al método de la clase y mostramos según la condición
		if (e.esCero())
			System.out.println(e.getEntero()+" es cero.");
		else
			System.out.println(e.getEntero()+" no es cero.");

	}

}
